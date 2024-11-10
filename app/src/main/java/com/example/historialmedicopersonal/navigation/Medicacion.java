package com.example.historialmedicopersonal.navigation;

public class Medicacion {
    private String nombreMedicamento;
    private String dosis;
    private String frecuencia;

    public Medicacion() {
        // Constructor sin argumentos necesario para Firebase
    }

    public Medicacion(String nombreMedicamento, String dosis, String frecuencia) {
        this.nombreMedicamento = nombreMedicamento;
        this.dosis = dosis;
        this.frecuencia = frecuencia;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public String getFrecuencia() {
        return frecuencia;
    }
}
