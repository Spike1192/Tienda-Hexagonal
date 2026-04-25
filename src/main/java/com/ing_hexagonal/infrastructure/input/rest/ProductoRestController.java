package com.ing_hexagonal.infrastructure.input.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ing_hexagonal.application.dto.request.ProductoRequestDto;
import com.ing_hexagonal.application.dto.response.ProductoResponseDto;
import com.ing_hexagonal.application.mapper.ProductoMapper;
import com.ing_hexagonal.domain.api.IProductoServicePort;
import com.ing_hexagonal.domain.model.ProductoModel;

@RestController
@RequestMapping("/productos")
public class ProductoRestController {

    private final IProductoServicePort productoServicePort;

    public ProductoRestController(IProductoServicePort productoServicePort) {
        this.productoServicePort = productoServicePort;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ProductoRequestDto request) {
        ProductoModel model = ProductoMapper.toModel(request);
        productoServicePort.save(model);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ProductoResponseDto>> getAll() {
        List<ProductoResponseDto> response = productoServicePort.getAll()
                .stream()
                .map(ProductoMapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponseDto> getById(@PathVariable Integer id) {
        ProductoModel model = productoServicePort.getById(id);
        return ResponseEntity.ok(ProductoMapper.toResponse(model));
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id,
                                       @RequestBody ProductoRequestDto request) {
        ProductoModel model = ProductoMapper.toModel(request);
        model.setId(id);
        productoServicePort.update(model);
        return ResponseEntity.ok().build();
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        productoServicePort.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}