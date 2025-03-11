package view;

import java.util.Scanner;

public class Vista {
    private Scanner scanner = new Scanner(System.in);

    public String obtenirEntrada(String missatge) {
        System.out.println(missatge);
        return scanner.nextLine();
    }

    public void mostrarMissatge(String missatge) {
        System.out.println(missatge);
    }
}