package ia_chess;

import java.util.Scanner;

public class IA_Chess {

    public static void main(String[] args)
    {
        Board a = new Board();
        Chess ajedrez = new Chess();
        ajedrez.generarMovimiento();
        ajedrez.realizarMovimiento(new Position(1,1),new Position(1,1));

        Scanner teclado = new Scanner(System.in);
        String xyTo;
        String xyFrom;
        while(true)
        {
            ajedrez.print();
            System.out.println("Ingrese de ficha a mover: ");
            xyTo = teclado.next();
            System.out.println("Ingrese coordenadas de nueva posicion: ");
            xyFrom = teclado.next();
            ajedrez.realizarMovimiento(new Position(1,1),new Position(1,1));
            ajedrez.generarMovimiento();
        }       
        /*
        Board b = new Board();
        Evaluacion e = new Evaluacion();
        System.out.println(e.evaluar(b, false));
        */
    }
}
