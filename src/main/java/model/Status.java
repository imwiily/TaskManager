package model;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;

public enum Status {
    PENDENTE ("Pendente"),
    EM_ANDAMENTO("Em andamento"),
    CONCLUIDO ("Concluido");

    private final String statusName;

    Status(String statusName) {
        this.statusName = statusName;
    }

    public String obterStatus() {
        return statusName;
    }
}


