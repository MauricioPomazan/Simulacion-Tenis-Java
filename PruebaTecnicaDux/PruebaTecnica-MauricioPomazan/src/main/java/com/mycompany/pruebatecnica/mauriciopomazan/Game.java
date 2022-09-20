/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebatecnica.mauriciopomazan;

/**
 *
 * @author Mauricio Pomazan
 */
public class Game {
    private int numGame;
    private Jugador ganador;

    public Game(int numGame, Jugador ganador) {
        this.numGame = numGame;
        this.ganador = ganador;
    }

    public int getNumGame() {
        return numGame;
    }

    public void setNumGame(int numGame) {
        this.numGame = numGame;
    }

    public Jugador getGanador() {
        return ganador;
    }

    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }
    
    
}
