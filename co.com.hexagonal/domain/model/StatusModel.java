package co.com.hexagonal.domain.model;

public class StatusModel {
    private int cods;
    private String dstatus;

    public StatusModel() {
    }

    public StatusModel(String dstatus) {
        this.dstatus = dstatus;
    }

    public StatusModel(int cods, String dstatus) {
        this.cods = cods;
        this.dstatus = dstatus;
    }

    public int getCods() {
        return cods;
    }

    public String getDstatus() {
        return dstatus;
    }

    public void setCods(int cods) {
        this.cods = cods;
    }

    public void setDstatus(String dstatus) {
        this.dstatus = dstatus;
    }
}