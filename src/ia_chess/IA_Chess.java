package ia_chess;

public class IA_Chess {

    public static void main(String[] args)
    {
        /*
        Board a = new Board();
        System.out.println(a.getXY(1, 2));
        System.out.println(a.isEmpty(5, 7));
        
        Chess ajedrez = new Chess();
        ajedrez.start();
                */
        Board b = new Board();
        Evaluacion e = new Evaluacion();
        System.out.println(e.evaluar(b, false));
    }
}
