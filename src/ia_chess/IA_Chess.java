package ia_chess;

public class IA_Chess {

    public static void main(String[] args) {
        Board a = new Board();
        Chess ajedrez = new Chess();
        ajedrez.generarMovimiento();
        ajedrez.realizarMovimiento(new Position(1,1),new Position(1,1));
    }
}
