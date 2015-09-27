package ia_chess;

import java.util.Scanner;

public class IA_Chess {

    public static void main(String[] args)
    {
        /*
        Board a = new Board();
        Chess ajedrez = new Chess();
        ajedrez.start();
                */
        Board b = new Board();
        Evaluacion e = new Evaluacion();
        System.out.println(e.evaluar(b, false));
    }
}
