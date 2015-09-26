package ia_chess;

public class IA_Chess {

    public static void main(String[] args) {
        Board a = new Board();
        System.out.println(a.getXY(0, 7));
        System.out.println(a.isEmpty(5, 7));
    }
}
