package Outils;
import java.util.Scanner;
import java.lang.Math;

public class TermInput {

    private static Scanner  scanner  = new Scanner(System.in);
    private static boolean  done     = false;
    private static String[] def      = {"un booléen (true/false)",
                                        "un nombre entier relatif (-1, 0, 1, 2, 3...)",
                                        "un entier signé sur 4 bytes (int dans [-"+   (int)(Math.pow(2, 32)-1) +"; "+ (int)Math.pow(2, 32) +"])",
                                        "un réel signé sur 8 bytes (double dans [-"+  (int)(Math.pow(2, 64)-1) +"; "+ (int)Math.pow(2, 64) +"])",
                                        "une lettre (a-z/A-Z)",
                                        "une chaîne de caractères"};

    public static boolean getBoolean(String ask, String errString) {
        String input     = new String();

        while (!done) {
            System.out.print(ask);
            input = scanner.nextLine();

            if (input.equals("true")) {
                done = true;
                return true;
            }
            else if (input.equals("false")) {
                done = false;
                return false;
            }
            else
                System.out.println(errString);
        }
        return false;                                   // normalement jamais atteint
    }

    public static boolean getBoolean(String ask) {
        return getBoolean(ask, "Erreur: entrez "+ def[0] +"." );
    }

    public static boolean getBoolean() {
        return getBoolean("Entrez "+ def[0] +": ", "Erreur !");
    }


    public static int getInt(int inf, int sup, String ask) {
        int i              = 0;
        int input          = 0;
        int[] inter        = {};
        String errorString = new String();

        if (inf >= sup)
            throw new java.lang.NegativeArraySizeException();
        for (i=0; i<(sup-inf); i++) {
            inter[i] = inf;
            inf++;
        }

        while (!done) {
            System.out.print(ask);
            try {
                input = scanner.nextInt();
            } catch (java.util.InputMismatchException error) {
                errorString = "" + error;
                if (errorString.equals("java.util.InputMismatchException"))
                    System.out.println("Erreur: entrez "+ def[1]);
                else
                    System.out.println("Erreur: entrez "+ def[2]);
                scanner.next();
                continue;
            }
            for (int ele : inter) {
                if (ele == input)
                    done = true;
            }
            if (!done)
                System.out.println(input +" n'est pas compris dans ["+ inf +"; "+ sup);
        }
        return input;
    }

    public static int getInt(int inf, int sup) {
        return getInt(inf, sup, "Entrez "+ def[1] +" compris entre "+ inf +" et "+ sup +": ");
    }


    public static int getInt(String infNotDefined, int sup, String ask) {
        int input          = 0;
        String errorString = new String();

        while (!done) {
            System.out.print(ask);
            try {
                input = scanner.nextInt();
            } catch (java.util.InputMismatchException error) {
                errorString = "" + error;
                if (errorString.equals("java.util.InputMismatchException"))
                    System.out.println("Erreur: entrez "+ def[1]);
                else
                    System.out.println("Erreur: entrez "+ def[2]);
                scanner.next();
                continue;
            }
            if (input <= sup) {
                done = true;
            //    scanner.next();
            }
            else
                System.out.println("Erreur:"+ input +" est strictement supérieur à "+ sup);
        }
        return input;
    }

    public static int getInt(String infNotDefined, int sup) {
        return getInt("None", sup, "Entrez "+ def[1] +" inférieur à "+ sup +": ");
    }


    public static int getInt(int inf, String supNotDefined, String ask) {
        int input          = 0;
        String errorString = new String();

        while (!done) {
            System.out.print(ask);
            try {
                input = scanner.nextInt();
            } catch (java.util.InputMismatchException error) {
                errorString = "" + error;
                if (errorString.equals("java.util.InputMismatchException"))
                    System.out.println("Erreur: entrez "+ def[1]);
                else
                    System.out.println("Erreur: entrez "+ def[2]);
                scanner.next();
                continue;
            }
            if (input >= inf)
                done = true;
            else
                System.out.println("Erreur: "+ input +" est strictement inférieur à "+ inf);
        }
        return input;
    }

    public static int getInt(int inf, String supNotDefined) {
        return getInt(inf, "None", "Entrez "+ def[1] +" supérieur à "+ inf +": ");
    }


    public static String getString() {
        System.out.print(def[5]);
        String input = scanner.nextLine();
        return input;
    }
}