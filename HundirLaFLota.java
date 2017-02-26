package pra;

import java.util.Random;
import java.util.Scanner;

public class HundirLaFLota {

    public int[][] taula = new int[10][10];
    public int[][] taulaAmostrar = new int[10][10];
    Random r = new Random();
    Scanner sc = new Scanner(System.in);
    int y;
    int x;
    private int pose;

    void t() {
        for (int y = 0; y < 10; y++) {

            for (int x = 0; x < 10; x++) {
                taula[y][x] = 0;
            }
        }
    }

    void tAmostrar() {
        for (int y = 0; y < 10; y++) {

            for (int x = 0; x < 10; x++) {
                taulaAmostrar[y][x] = 0;
            }
        }
    }
    boolean p;

    boolean colision() {

        if (taula[y][x + 1] == 0 || taula[y][x - 1] == 0 || taula[y + 1][x] == 0 || taula[y - 1][x] == 0) {

            p = true;
        } else {
            p = false;
        }
        return p;
    }

    void espacio() {
        for (int i = 0; i < 10; i++) {
            System.out.println(" ");

        }
    }
// metodo para genrar barcos de 2
    void genera2() {
        int barco = 0;
        int y = 0;
        int x = 0;

        while (barco < 2) {

            y = r.nextInt(10);
            x = r.nextInt(10);
            if (taula[y][x] == 0 || taula[y][x - 1] == 0 || taula[y][x + 1] == 0) {
                if (x >= 2) {
                    taula[y][x] = 2;
                    for (int i = 0; i < 2; i++) {
                        taula[y][x - 1] = 2;
                    }
                } else if (x <= 2) {
                    taula[y][x] = 2;
                    for (int i = 0; i < 2; i++) {
                        taula[y][x + 1] = 2;
                    }

                }

                barco++;
            } else {
                System.out.println("error gen barco");
                barco--;
            }

        }
    }
// metodo para generar barcos de 1
    void genera1() {
        int barco = 0;
        int y = 0;
        int x = 0;
        int pose = 0;

        while (barco < 3) {
            pose = r.nextInt(10);
            y = r.nextInt(10);
            x = r.nextInt(10);

            if (taula[y][x] == 0) {
                taula[y][x] = 1;

            }

            barco++;

        }
    }
// metodo para generar barcos de 3
    void genera3() {
        int barco = 0;
        int y = 0;
        int x = 0;
        int pose;
        while (barco < 1) {
            pose = r.nextInt(10);
            y = r.nextInt(10);
            x = r.nextInt(10);
            if (pose < 5) {

                if (taula[y][x] == 0) {
                    if (x >= 3) {
                        taula[y][x] = 3;
                        for (int i = 0; i < 3; i++) {
                            taula[y][x - 1] = 3;
                            taula[y][x - 2] = 3;
                        }
                    } else if (x <= 3) {
                        taula[y][x] = 3;
                        for (int i = 0; i < 3; i++) {
                            taula[y][x + 1] = 3;
                            taula[y][x + 2] = 3;
                        }

                    }

                    barco++;

                }
            } else {

                if (taula[y][x] == 0) {
                    if (y >= 3) {
                        taula[y][x] = 3;
                        for (int i = 0; i < 3; i++) {
                            taula[y - 1][x] = 3;
                            taula[y - 2][x] = 3;
                        }
                    } else if (y <= 3) {
                        taula[y][x] = 3;
                        for (int i = 0; i < 3; i++) {
                            taula[y + 1][x] = 3;
                            taula[y + 2][x] = 3;
                        }

                    }

                    barco++;

                }

            }
        }
    }

    // obtener las tablas, (get t enseñala tabla con todo discubierto)
    void getT() {
        for (int y = 0; y < 10; y++) {

            for (int x = 0; x < 10; x++) {
                System.out.print(" ");
                System.out.print(taula[y][x]);

            }
            System.out.println(" ");
        }
    }

    void getTablaAmostrar() {
        for (int y = 0; y < 10; y++) {
            System.out.print("*" + y);

            for (int x = 0; x < 10; x++) {
                System.out.print("  ");
                System.out.print(taulaAmostrar[y][x]);

            }

            System.out.println("*");
        }
    }
// para no tener que generar barcos uno a uno

    void mostrarBarcos() {
        genera1();
        genera2();
        genera3();
    }

    // este metodo sirve para comprobar que nadie ha ganado y que se continue el juego
    public boolean noVictoria() {
        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {
                if (taula[j][i] > 0) {
                    return true;
                }

            }

        }
        System.out.println("victoria");
        return false;
    }

    // Metodo para disparar
    boolean disparo(int i, int x) {

        if (taula[i][x] == 1 || taula[i][x] == 2 || taula[i][x] == 3) {
            taula[i][x] = -1;

            taulaAmostrar[i][x] = -8;
            System.out.println("has dado a un barco");
            return true;

        } else {
            System.out.println("has fallado");
            taula[i][x] = -1;
            taulaAmostrar[i][x] = -1;
            return false;

        }

    }
}
