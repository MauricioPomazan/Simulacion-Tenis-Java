/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebatecnica.mauriciopomazan;

/**
 *
 * @author Mauricio Pomazan
 */

    // Creamos la Clase con sus atributos.
public class Partido {
    private Game numJuego;
    private Jugador jugador1;
    private int cantGame;
    private Jugador jugador2;
    private int condicionVic;
    private Boolean banderaJ1;
    private Boolean banderaJ2;
    boolean ventajaA= false;
    boolean ventajaB= false;
      
    // Creamos el Constructor de la clase
    public Partido(Jugador jugador1, Jugador jugador2, int condicionVic) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.condicionVic = condicionVic;
        this.banderaJ1 = false;
        this.banderaJ2 = false;
    }
        //Creamos las property
    public int getCondicionVic() {
        return condicionVic;
    }

    public void setCondicionVic(int condicionVic) {
        this.condicionVic = condicionVic;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public Game getNumJuego() {
        return numJuego;
    }

    public void setNumJuego(Game numJuego) {
        this.numJuego = numJuego;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public int getCantGame() {
        return cantGame;
    }

    public void setCantGame(int cantGame) {
        this.cantGame = cantGame;
    }
    
        //Se le asigna el saque al jugador #1
    public void elegirSaque(){
        if(jugador1.isSaque()== false && jugador2.isSaque()== false){
            jugador1.setSaque(true);
        }
    }
        /*Funcion para dar a conocer quien tiene la ventaja en caso 
          de empate de puntos*/
     public String printVentaja1(){
        if (this.ventajaA)
        {
            return "A";
        }
        else
        {
            return "";
        }
    }
    
    public String printVentaja2(){
        if (this.ventajaB)
        {
            return "A";
        }
        else
        {
            return "";
        }
    }
        //Funcion de distribucion de los puntos 
    public void ganoPunto(){
        int resultado;
        float puntoJ1 = this.ganarRonda(jugador1.getProb());
        float puntoJ2 = this.ganarRonda(jugador2.getProb());
        if(puntoJ1 == puntoJ2){
            puntoJ2 = this.ganarRonda(jugador2.getProb());
        }
      if(puntoJ1 > puntoJ2){
          if(jugador1.getpGanados() >= 30){
              if(jugador1.getpGanados() == 40)
              {
                  banderaJ1 = true;
              }
              else
              {
                resultado = jugador1.getpGanados()+ 10;
                jugador1.setpGanados(resultado);
                //banderaJ1 = true;
              }              
          }else {
              resultado = jugador1.getpGanados()+ 15;
              jugador1.setpGanados(resultado);
              //banderaJ1 = true;
          }
      }  else {
          if(jugador2.getpGanados() >= 30){
              if(jugador2.getpGanados() == 40)
              {
                  banderaJ2 = true;
              }
              else
              {
                resultado = jugador2.getpGanados()+ 10;
                jugador2.setpGanados(resultado);
                //banderaJ2 = true;
              }              
          }else {
              resultado = jugador2.getpGanados()+ 15;
              jugador2.setpGanados(resultado);
              //banderaJ2 = true;
          }   
      }
    }
    
    //Funcion de Probabilidad 
    public float ganarRonda(float prob){
        float resultado;
        resultado = (float)Math.random() * prob;
        return resultado;
    }
    
    //Ganador de cada Set ademas del cambio de Saque 
    public void ganSet(){
        
        if(jugador1.getSetGan()== 6 || jugador2.getSetGan()== 6)
        {
            if(jugador1.getSetGan()== 6){
            jugador1.setSetGan(0);
            jugador2.setSetGan(0);
            jugador1.setpGanados(0);
            jugador2.setpGanados(0);
            jugador1.setGameGan(jugador1.getGameGan()+1);
        } 
        if(jugador2.getSetGan()== 6){
            jugador2.setSetGan(0);
            jugador1.setSetGan(0);
            jugador1.setpGanados(0);
            jugador2.setpGanados(0);
            jugador2.setGameGan(jugador2.getGameGan()+1);
            } 
        }
        else
        {
           if(jugador1.getpGanados() >= 40 && jugador2.getpGanados() < 40 && banderaJ1 == true){
            jugador1.setSetGan(jugador1.getSetGan()+1);
            jugador1.setpGanados(0);
            jugador2.setpGanados(0);
            banderaJ1 = false;
            banderaJ2 = false;
            ventajaA = false;
            ventajaB = false;
            if(jugador1.isSaque()== true){
                jugador1.setSaque(false);
                jugador2.setSaque(true);
            }else{
                jugador2.setSaque(false);
                jugador1.setSaque(true);
            }
            }
            if(jugador2.getpGanados() >= 40 && jugador1.getpGanados() < 40 && banderaJ2 == true){
                jugador2.setSetGan(jugador2.getSetGan()+1);
                jugador1.setpGanados(0);
                jugador2.setpGanados(0);
                banderaJ1 = false;
                banderaJ2 = false;
                ventajaA = false;
                ventajaB = false;
                if(jugador1.isSaque()== true){
                jugador1.setSaque(false);
                jugador2.setSaque(true);
                }else{
                    jugador2.setSaque(false);
                    jugador1.setSaque(true);
                }
            }
            //Si existe un empate de puntos se muestra quien esta en ventaja por el momento
        if(ventajaA == true && banderaJ1 == true){
               jugador1.setSetGan(jugador1.getSetGan()+1);
                jugador1.setpGanados(0);
                jugador2.setpGanados(0);
                banderaJ1 = false;
                banderaJ2 = false;
                ventajaA = false;
                ventajaB = false;
                if(jugador1.isSaque()== true){
                    jugador1.setSaque(false);
                    jugador2.setSaque(true);
                }
           }
         if(ventajaA == true && banderaJ2 == true){
             ventajaA = false;
             banderaJ1 = false;
             banderaJ2 = false;
             //jugador1.setpGanados(jugador1.getpGanados()-10);
             
            }
         if(ventajaB == true && banderaJ1 == true){
             ventajaB = false;
             banderaJ1 = false;
             banderaJ2 = false;
             //jugador2.setpGanados(jugador2.getpGanados()-10);
         }
         
           if (ventajaB == true && banderaJ2 == true){
               jugador2.setSetGan(jugador2.getSetGan()+1);
                jugador1.setpGanados(0);
                jugador2.setpGanados(0);
                banderaJ1 = false;
                banderaJ2 = false;
                ventajaA = false;
                ventajaB = false;
                if(jugador1.isSaque()== true){
                    jugador1.setSaque(false);
                    jugador2.setSaque(true);
                }
            }
           if(jugador1.getpGanados()== 40 && jugador2.getpGanados() == 40){
               if(banderaJ1 == true){
                   ventajaA = true;
                   banderaJ1 = false;
                   banderaJ2 = false;
               } else if (banderaJ2 == true){
                   ventajaB = true;
                   banderaJ1 = false;
                   banderaJ2 = false;
               }
           } 
        }    
    }
    
    // Funcion de quien gano el partido dependiendo de la cantidad de set a jugar
    public void ganPartido(){
        if(condicionVic == 3){
            if(jugador1.getGameGan() == 2){
                jugador1.setGanador(true);
                imprimirResultados();
            }
            if(jugador2.getGameGan() == 2){
                jugador2.setGanador(true);
                imprimirResultados();
            }
        }
        if(condicionVic == 5){
            if(jugador1.getGameGan() == 3){
                jugador1.setGanador(true);
                imprimirResultados();
            }
            if(jugador2.getGameGan() == 3){
                jugador2.setGanador(true);
                imprimirResultados();
            }
        }
        
    }
    
    
    public void imprimirResultados()
    {
        int parcial1 = jugador1.getpGanados();
        int parcial2 = jugador2.getpGanados();
        System.out.println("---------------------------------------------");
        
        if (jugador1.isSaque())
        {
            System.out.println("---------------------------------------------");
            System.out.println("Saca el jugador: " + jugador1.getNombre());
            System.out.println("---------------------------------------------");
        }
        else
        {
            System.out.println("---------------------------------------------");
            System.out.println("Saca el jugador: " + jugador2.getNombre());
            System.out.println("---------------------------------------------");
        }
        
        System.out.println("---------------------------------------------");
        System.out.println("Puntos " + jugador1.getNombre() + " : " + parcial1 + " " + printVentaja1());
        System.out.println("Puntos "+ jugador2.getNombre() + " : " + parcial2 + " " + printVentaja2());
        System.out.println("---------------------------------------------");
        System.out.println("Sets ganados por: " + jugador1.getNombre() + " : " +jugador1.getSetGan());
        System.out.println("Sets ganados por: " + jugador2.getNombre() + " : "+jugador2.getSetGan());
        System.out.println("---------------------------------------------");
        System.out.println("Games ganados por: " + jugador1.getNombre() + " : " +jugador1.getGameGan());
        System.out.println("Games ganados por: " + jugador2.getNombre() + " : " +jugador2.getGameGan());
        System.out.println("---------------------------------------------");
        System.out.println("");
        
    }
}

