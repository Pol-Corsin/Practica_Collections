import view.Vista;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //menu
        System.out.println("BENVINGUT AL SUPERMERCAT");
        System.out.println("------------");
        System.out.println("-- INICI --");
        System.out.println("------------");
        System.out.println("1) Introduir producte");
        System.out.println("2) Passar per caixa");
        System.out.println("3) Mostrar carret de compra");
        System.out.println("0) Acabar");

        Scanner scanner = new Scanner(System.in);
        String opcio = scanner.nextLine();

        try {

            switch (opcio) {
                case "1":
                    Vista.mostrarMissatge("--------------");
                    Vista.mostrarMissatge("-- PRODUCTE --");
                    Vista.mostrarMissatge("--------------");
                    Vista.mostrarMissatge("1) Alimentacio");
                    Vista.mostrarMissatge("2) Textil");
                    Vista.mostrarMissatge("3) Electrodònica");
                    Vista.mostrarMissatge("0) Tornar");
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

