// Historial.java
package com.example.historialmedicopersonal.navigation;

public class Historial {
    private String nombrePrueba;
    private String fecha;
    private String resultado;

    public Historial() {
        // Constructor sin argumentos necesario para Firebase
    }

    public Historial(String nombrePrueba, String fecha, String resultado) {
        this.nombrePrueba = nombrePrueba;
        this.fecha = fecha;
        this.resultado = resultado;
    }

    public String getNombrePrueba() {
        return nombrePrueba;
    }

    public String getFecha() {
        return fecha;
    }

    public String getResultado() {
        return resultado;
    }
}
