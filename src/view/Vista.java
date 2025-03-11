package view;

import java.util.Scanner;

public class Vista {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMissatge(String missatge) {
        System.out.println(missatge);
    }

    public String obtenirEntrada(String missatge) {
        mostrarMissatge(missatge);
        return scanner.nextLine();
    }
}