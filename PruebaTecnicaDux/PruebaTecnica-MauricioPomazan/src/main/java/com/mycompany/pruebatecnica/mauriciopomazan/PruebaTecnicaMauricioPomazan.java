/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.pruebatecnica.mauriciopomazan;

import java.util.Scanner;

/**
 *
 * @author Mauricio Pomazan
 */

    // Creacion de la clase MAIN
public class PruebaTecnicaMauricioPomazan {

    public static void main(String[] args) {
       int jugar = 1;
       Scanner sc = new Scanner(System.in);
       
       //Se imprimen los datos del partido por consola
       while(jugar == 1)
       {
        
        System.out.println("---------------------------------------------");
        System.out.println("Ingrese Nombre del Torneo: ");
        String nomTorneo = sc.nextLine();
        System.out.println("---------------------------------------------");
        System.out.println("Ingrese nombre Jugador #1");
        String nombre = sc.nextLine();
        System.out.println("Ingrese Probabilidad de Victoria:");
        String probabilidad = sc.nextLine();
        System.out.println("---------------------------------------------");
        while(caracter(probabilidad)== true){
            System.out.println("Vuelva a introducir una Probabilidad valida entre 0% y 100%");
            probabilidad = sc.nextLine();
            System.out.println("---------------------------------------------");
        }
        Float prob = Float.valueOf(probabilidad);
                while(rango(prob)== false){
            System.out.println("Vuelva a introducir una Probabilidad valida: Entre 0% y 100%");
            prob = sc.nextFloat();
            System.out.println("---------------------------------------------");
        }
        Jugador j1 = new Jugador(nombre, prob);
        System.out.println("Ingrese nombre jugador #2:");
        String nombre2 = sc.nextLine();
        System.out.println("Ingrese Probabilidad de Victoria:");
        probabilidad = sc.nextLine();
        while(caracter(probabilidad)== true){
            System.out.println("Vuelva a introducir una Probabilidad valida: Entre 0% y 100%");
            probabilidad = sc.nextLine();
        }
        prob = Float.valueOf(probabilidad);
        while(rango(prob)== false){
            System.out.println("Vuelva a introducir una Probabilidad valida: Entre 0% y 100%");
            prob = sc.nextFloat();
        }
        Jugador j2 = new Jugador(nombre2, prob);
        System.out.println("Ingrese cantidad de Games a jugar:");
        String cant = sc.nextLine();
        while(caracter(cant)== true){
            System.out.println("Vuelva a Introducir una cantidad Games valida debe ser 3 o 5");
            cant = sc.nextLine();
        }
        int cantidad = Integer.valueOf(cant);
        while(validarGame(cantidad)== false){
            System.out.println("Vuelva a Introducir una cantidad Games valida debe ser 3 o 5");
            cantidad = sc.nextInt();
        }
        Partido p1 = new Partido(j1,j2,cantidad);
        
        while(j1.getGanador()== false  && j2.getGanador() == false)
        {
            p1.imprimirResultados();
            p1.ganoPunto();
            p1.ganSet();
            p1.ganPartido();
        }
        
        if(j1.getGanador() == true){
            System.out.println("-----------------------------------------");
            System.out.println("Torneo: " + nomTorneo);
            System.out.println("-----------------------------------------");
            System.out.println("Ganador del Torneo: " + j1.getNombre());
            System.out.println("-----------------------------------------");
        }else{
            System.out.println("-----------------------------------------");
            System.out.println("Torneo: " + nomTorneo);
            System.out.println("-----------------------------------------");
            System.out.println("Ganador del Torneo: " + j2.getNombre());
            System.out.println("-----------------------------------------");
        }
        System.out.println("");
        System.out.println("---------------------------------------------");
        System.out.println("");
        System.out.println("¿Quiere jugar revancha?");
        System.out.println("Presione 1 para jugar revancha, 0 para salir");
        jugar = sc.nextInt();
        sc.nextLine();
        System.out.println("---------------------------------------------");
       }
        
    }
    
    static boolean caracter(String cadena){
        
        for(int i = 0; i < cadena.length(); i++){
            char caracter = cadena.toUpperCase().charAt(i);
            int valor = (int)caracter;
        if(valor != 165 && (valor < 65 || valor > 90) && (valor < 32 || valor > 44 )){
         return false;
        }
        }
        return true;
    }
    
    static boolean rango(float valor){
    if(valor < 0 || valor > 100){
        return false;
    }
        return true;
    }
    
    static boolean validarGame(int valor){
        if(valor != 3 && valor != 5){
            return false;
        }
        return true;
    }
    
    
}
