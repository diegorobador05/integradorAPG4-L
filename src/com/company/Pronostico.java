package com.company;
import com.company.Equipo;
import com.company.Partido;
import com.company.ResultadoEnum;

public class Pronostico {
    //Atributos:
    private int numero;
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;

    // Constructor
    public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado) {
        //this.numero = numero;
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
    }

    public Pronostico() {
    }

    //Getters & Setters
    public Partido getPartido() {
            return partido;
        }

    public Equipo getEquipo() {
            return equipo;
        }

    public ResultadoEnum getResultado() {
            return resultado;
        }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public void setResultado(ResultadoEnum resultado) {
        this.resultado = resultado;
    }
}


