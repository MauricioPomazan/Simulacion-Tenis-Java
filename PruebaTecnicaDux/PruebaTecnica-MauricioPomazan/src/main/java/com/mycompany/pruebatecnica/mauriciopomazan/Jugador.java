/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebatecnica.mauriciopomazan;

/**
 *
 * @author Mauricio Pomazan
 */
public class Jugador {
    private String nombre;
    private Float prob;
    private Boolean ganador;
    private int pGanados;
    private boolean saque;
    private int setGan;
    private int gameGan;
    
    
  
    public Jugador(String nombre, Float prob) {
        this.nombre = nombre;
        this.prob = prob;
        this.ganador = false;
        this.pGanados = 0;
        this.saque = false;
        this.gameGan = 0;
        this.setGan = 0;
    }

    public int getGameGan() {
        return gameGan;
    }

    public void setGameGan(int gameGan) {
        this.gameGan = gameGan;
    }

    public int getSetGan() {
        return setGan;
    }

    public void setSetGan(int setGan) {
        this.setGan = setGan;
    }

    public boolean isSaque() {
        return saque;
    }

    public void setSaque(boolean saque) {
        this.saque = saque;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getProb() {
        return prob;
    }

    public void setProb(Float prob) {
        this.prob = prob;
    }

    public Boolean getGanador() {
        return ganador;
    }

    public void setGanador(Boolean ganador) {
        this.ganador = ganador;
    }

    public int getpGanados() {
        return pGanados;
    }

    public void setpGanados(int pGanados) {
        this.pGanados = pGanados;
    }
}
