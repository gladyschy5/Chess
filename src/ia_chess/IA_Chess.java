package ia_chess;

import java.util.Scanner;

public class IA_Chess {

    public static void main(String[] args)
    {
        Board a = new Board();
        Chess ajedrez = new Chess();

        Scanner teclado = new Scanner(System.in);
        String xyTo;
        int x1,x2;
        while(true)
        {
            ajedrez.print();
            System.out.println("Ingrese ficha a mover: ");
            xyTo = teclado.next();
            System.out.println("Ingrese coordenadas de nueva posicion: ");
            x1 = teclado.nextInt();
            x2 = teclado.nextInt();
            ajedrez.realizarMovimiento(xyTo.charAt(0), new Position(x1,x2), true);
            ajedrez.generarMovimiento();
        }       
    }
    
    public static Position getFichaPos(String s, Board b)
    {
        switch(s.charAt(0))
        {
            case Board.B_REY:
                return b.getBRey();

            case Board.B_REYNA:
                return b.getBReyna();

            case Board.B_ALFIL_D:
                return b.getBAlfil_D();
                
            case Board.B_ALFIL_I:
                return b.getBAlfil_I();

            case Board.B_CABALLO_D:
                return b.getBCaballo_D();
                
            case Board.B_CABALLO_I:
                return b.getBCaballo_I();

            case Board.B_TORRE_D:
                return b.getBTorre_D();
                
            case Board.B_TORRE_I:
                return b.getBTorre_I();
                
            case Board.B_PEON1:
                return b.getBPeon1();
                
            case Board.B_PEON2:
                return b.getBPeon1();
                
            case Board.B_PEON3:
                return b.getBPeon1();
                
            case Board.B_PEON4:
                return b.getBPeon1();
                
            case Board.B_PEON5:
                return b.getBPeon1();
                
            case Board.B_PEON6:
                return b.getBPeon1();
                
            case Board.B_PEON7:
                return b.getBPeon1();
                
            case Board.B_PEON8:
                return b.getBPeon1();
        }
        return null;
    }
}
