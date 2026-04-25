package com.ing_hexagonal.domain.usecase;

import com.ing_hexagonal.domain.exception.DomainException;
import com.ing_hexagonal.domain.model.ProductoModel;
import com.ing_hexagonal.domain.spi.IProductoPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductoUseCaseTest {

    private IProductoPersistencePort persistencePort;
    private ProductoUseCase useCase;

    @BeforeEach
    void setUp() {
        persistencePort = mock(IProductoPersistencePort.class);
        useCase = new ProductoUseCase(persistencePort);
    }

   
    @Test
    void constructor_null_port_debe_fallar() {
        DomainException ex = assertThrows(DomainException.class,
                () -> new ProductoUseCase(null));

        assertEquals("El puerto de persistencia no puede ser nulo", ex.getMessage());
    }

   
    @Test
    void save_ok() {
        ProductoModel producto = new ProductoModel("Laptop", 5, 2000, 1);

        useCase.save(producto);

        verify(persistencePort, times(1)).save(producto);
    }

    @Test
    void save_producto_null_debe_fallar() {
        DomainException ex = assertThrows(DomainException.class,
                () -> useCase.save(null));

        assertEquals("El producto no puede ser nulo", ex.getMessage());
        verify(persistencePort, never()).save(any());
    }

    @Test
    void save_nombre_vacio_debe_fallar() {
        ProductoModel producto = new ProductoModel("", 5, 2000, 1);

        DomainException ex = assertThrows(DomainException.class,
                () -> useCase.save(producto));

        assertEquals("El nombre es obligatorio", ex.getMessage());
        verify(persistencePort, never()).save(any());
    }

    @Test
    void save_cantidad_negativa_debe_fallar() {
        ProductoModel producto = new ProductoModel("Laptop", -1, 2000, 1);

        DomainException ex = assertThrows(DomainException.class,
                () -> useCase.save(producto));

        assertEquals("La cantidad no puede ser negativa", ex.getMessage());
        verify(persistencePort, never()).save(any());
    }

    @Test
    void save_precio_invalido_debe_fallar() {
        ProductoModel producto = new ProductoModel("Laptop", 5, 0, 1);

        DomainException ex = assertThrows(DomainException.class,
                () -> useCase.save(producto));

        assertEquals("El precio debe ser mayor a cero", ex.getMessage());
        verify(persistencePort, never()).save(any());
    }

    
    @Test
    void update_ok() {
        ProductoModel producto = new ProductoModel(1, "Laptop", 5, 2000, 1);

        useCase.update(producto);

        verify(persistencePort, times(1)).update(producto);
    }

    @Test
    void update_sin_id_debe_fallar() {
        ProductoModel producto = new ProductoModel("Laptop", 5, 2000, 1);

        DomainException ex = assertThrows(DomainException.class,
                () -> useCase.update(producto));

        assertEquals("El ID es obligatorio para actualizar", ex.getMessage());
        verify(persistencePort, never()).update(any());
    }

    
    @Test
    void delete_ok() {
        ProductoModel producto = new ProductoModel(1, "Laptop", 5, 2000, 1);

        useCase.delete(producto);

        verify(persistencePort).deleteById(1);
    }

    @Test
    void delete_producto_null_debe_fallar() {
        DomainException ex = assertThrows(DomainException.class,
                () -> useCase.delete(null));

        assertEquals("El producto o su ID no pueden ser nulos", ex.getMessage());
        verify(persistencePort, never()).deleteById(any());
    }

    @Test
    void delete_sin_id_debe_fallar() {
        ProductoModel producto = new ProductoModel("Laptop", 5, 2000, 1);

        DomainException ex = assertThrows(DomainException.class,
                () -> useCase.delete(producto));

        assertEquals("El producto o su ID no pueden ser nulos", ex.getMessage());
        verify(persistencePort, never()).deleteById(any());
    }

    
    @Test
    void deleteById_ok() {
        useCase.deleteById(1);

        verify(persistencePort).deleteById(1);
    }

    @Test
    void deleteById_null_debe_fallar() {
        DomainException ex = assertThrows(DomainException.class,
                () -> useCase.deleteById(null));

        assertEquals("El ID no puede ser nulo", ex.getMessage());
        verify(persistencePort, never()).deleteById(any());
    }

    
    @Test
    void getById_ok() {
        ProductoModel producto = new ProductoModel(1, "Laptop", 5, 2000, 1);

        when(persistencePort.getById(1)).thenReturn(producto);

        ProductoModel result = useCase.getById(1);

        assertNotNull(result);
        assertEquals("Laptop", result.getNombre());
    }

    @Test
    void getById_null_debe_fallar() {
        DomainException ex = assertThrows(DomainException.class,
                () -> useCase.getById(null));

        assertEquals("El ID no puede ser nulo", ex.getMessage());
    }

    
    @Test
    void getAll_ok() {
        List<ProductoModel> lista = List.of(
                new ProductoModel(1, "Laptop", 5, 2000, 1),
                new ProductoModel(2, "Mouse", 10, 50, 1)
        );

        when(persistencePort.getAll()).thenReturn(lista);

        List<ProductoModel> result = useCase.getAll();

        assertEquals(2, result.size());
        verify(persistencePort).getAll();
    }
}