package pra;

import java.util.Scanner;

public class MainHundirLaFlota {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HundirLaFLota p2 = new HundirLaFLota();
        HundirLaFLota p1 = new HundirLaFLota();
        HundirLaFLota jugador = p1;
        

        p1.mostrarBarcos();
        p2.mostrarBarcos();
        //jugador.getT();
        boolean salir = true;
        System.out.println("jugador 1");
        while (salir) {

            if (!(jugador.noVictoria())) { 
                
                if (jugador == p1) {
                    System.out.println("gana jugador 1");
                } else {
                    System.out.println("gana jugador 2");
                }
                break;
               
            }
            System.out.println("*   0  1  2  3  4  5  6  7  8  9*");
            System.out.println("_________________________________");
            jugador.getTablaAmostrar();
            System.out.println("_________________________________");

            System.out.println("posicion columna");
            int x = (sc.nextInt());
            System.out.println("posicion fila");
            int i = (sc.nextInt());

            if (jugador.disparo(i, x)) {

                System.out.println("vuelve a disparar");
                
                System.out.println("*   0  1  2  3  4  5  6  7  8  9*");
                System.out.println("_________________________________");
                jugador.getTablaAmostrar();
                System.out.println("_________________________________");
                
            } else {
                
                System.out.println("*   0  1  2  3  4  5  6  7  8  9*");
                System.out.println("_________________________________");
                jugador.getTablaAmostrar();
                System.out.println("_________________________________");
                
                System.out.println("cambio de turno");

                if (jugador == p2) {
                    System.out.println("jugador 1");
                    jugador = p1;

                } else {
                    System.out.println("jugador 2");
                    jugador = p2;
                }

            }

        }

    }

}
