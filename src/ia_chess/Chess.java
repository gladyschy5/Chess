package ia_chess;

import java.util.ArrayList;

public class Chess {
    Board board;
    King rey = new King();
    Queen reyna = new Queen();
    Torre torre = new Torre();
    Caballo caballo = new Caballo();
    Alfil alfil = new Alfil();
    Peon peon = new Peon();
    
    Node<Integer> root;
    public final int PROFUNDIDAD = 2;
    int VAL = -10;
    
    public Chess() {
        this.board = new Board();
    }
    public void realizarMovimiento(char s, Position to, boolean white){
        Position from = null;
        ArrayList<Position> moves = new ArrayList<Position>();
        if(white){
            switch(s)
            {
                case Board.B_REY:
                    from = board.getBRey();
                    rey.getMoves(board, from, moves, white);
                    break;
                case Board.B_REYNA:
                    from = board.getBReyna();
                    reyna.getMoves(board, from, moves, white);
                    break;
                case Board.B_ALFIL_D:
                    from = board.getBAlfil_D();
                    alfil.getMoves(board, from, moves, white);
                    break;
                case Board.B_ALFIL_I:
                    from = board.getBAlfil_I();
                    alfil.getMoves(board, from, moves, white);
                    break;
                case Board.B_CABALLO_D:
                    from = board.getBCaballo_D();
                    caballo.getMoves(board, from, moves, white);
                    break;
                case Board.B_CABALLO_I:
                    from = board.getBCaballo_I();
                    caballo.getMoves(board, from, moves, white);
                    break;
                case Board.B_TORRE_D:
                    from = board.getBTorre_D();
                    torre.getMoves(board, from, moves, white);
                    break;
                case Board.B_TORRE_I:
                    from = board.getBTorre_I();
                    torre.getMoves(board, from, moves, white);
                    break;
                case Board.B_PEON1:
                    from = board.getBPeon1();
                    peon.getMoves(board, from, moves, white);
                    break;
                case Board.B_PEON2:
                    from = board.getBPeon1();
                    peon.getMoves(board, from, moves, white);
                    break;
                case Board.B_PEON3:
                    from = board.getBPeon1();
                    peon.getMoves(board, from, moves, white);
                    break;
                case Board.B_PEON4:
                    from = board.getBPeon1();
                    peon.getMoves(board, from, moves, white);
                    break;
                case Board.B_PEON5:
                    from = board.getBPeon1();
                    peon.getMoves(board, from, moves, white);
                    break;
                case Board.B_PEON6:
                    from = board.getBPeon1();
                    peon.getMoves(board, from, moves, white);
                    break;
                case Board.B_PEON7:
                    from = board.getBPeon1();
                    peon.getMoves(board, from, moves, white);
                    break;
                case Board.B_PEON8:
                    from = board.getBPeon1();
                    peon.getMoves(board, from, moves, white);
                    break;
            }
        }else{
            switch(s)
            {
                case Board.N_REY:
                    from = board.getBRey();
                    rey.getMoves(board, from, moves, white);
                    break;
                case Board.N_REYNA:
                    from = board.getBReyna();
                    reyna.getMoves(board, from, moves, white);
                    break;
                case Board.N_ALFIL_D:
                    from = board.getBAlfil_D();
                    alfil.getMoves(board, from, moves, white);
                    break;
                case Board.N_ALFIL_I:
                    from = board.getBAlfil_I();
                    alfil.getMoves(board, from, moves, white);
                    break;
                case Board.N_CABALLO_D:
                    from = board.getBCaballo_D();
                    caballo.getMoves(board, from, moves, white);
                    break;
                case Board.N_CABALLO_I:
                    from = board.getBCaballo_I();
                    caballo.getMoves(board, from, moves, white);
                    break;
                case Board.N_TORRE_D:
                    from = board.getBTorre_D();
                    torre.getMoves(board, from, moves, white);
                    break;
                case Board.N_TORRE_I:
                    from = board.getBTorre_I();
                    torre.getMoves(board, from, moves, white);
                    break;
                case Board.N_PEON1:
                    from = board.getBPeon1();
                    peon.getMoves(board, from, moves, white);
                    break;
                case Board.N_PEON2:
                    from = board.getBPeon1();
                    peon.getMoves(board, from, moves, white);
                    break;
                case Board.N_PEON3:
                    from = board.getBPeon1();
                    peon.getMoves(board, from, moves, white);
                    break;
                case Board.N_PEON4:
                    from = board.getBPeon1();
                    peon.getMoves(board, from, moves, white);
                    break;
                case Board.N_PEON5:
                    from = board.getBPeon1();
                    peon.getMoves(board, from, moves, white);
                    break;
                case Board.N_PEON6:
                    from = board.getBPeon1();
                    peon.getMoves(board, from, moves, white);
                    break;
                case Board.N_PEON7:
                    from = board.getBPeon1();
                    peon.getMoves(board, from, moves, white);
                    break;
                case Board.N_PEON8:
                    from = board.getBPeon1();
                    peon.getMoves(board, from, moves, white);
                    break;
            }
        }
        
        verificarMovimiento(moves, from, to);
    }
    public boolean verificarMovimiento(ArrayList<Position> moves, Position actual, Position nueva){
        for(Position a: moves)
            if(a.equals(nueva)){
                board.move(actual, nueva);
                return true;
            }
        System.out.print("Nueva poscion no valida");
        return false;
    }
    public void generarMovimiento(){
        ArrayList<char[][]> boards = new ArrayList<char[][]>(); 
        root = new Node<Integer>(VAL);
        root.setPosition(new Position(VAL,VAL), new Position(VAL,VAL));
        generateMoves(board, PROFUNDIDAD, boards, false, root);
        Alphabeta ab = new Alphabeta();
        Node<Integer> mov = ab.alphaBeta(root);
        if(mov.to!=null){
            board.move(mov.from, mov.to);
        }
    }
    public void generateMoves(Board board, int profundidad, ArrayList<char[][]> boards, boolean white, Node<Integer> nodo){       
        if(white){
            Position temp = board.getBRey();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                rey.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getBReyna();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                reyna.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getBTorre_I();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                torre.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getBTorre_D();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                torre.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getBAlfil_I();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                alfil.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getBAlfil_D();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                alfil.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            
            temp = board.getBCaballo_I();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                caballo.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getBCaballo_D();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                caballo.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }

            temp = board.getBPeon1();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getBPeon2();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getBPeon3();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getBPeon4();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getBPeon5();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getBPeon6();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getBPeon7();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getBPeon8();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
        }else{
            Position temp = board.getNRey();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                rey.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getNReyna();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                reyna.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getNTorre_I();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                torre.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getNTorre_D();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                torre.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getNAlfil_I();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                alfil.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getNAlfil_D();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                alfil.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            
            temp = board.getNCaballo_I();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                caballo.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getNCaballo_D();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                caballo.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            
            temp = board.getNPeon1();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getNPeon2();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getNPeon3();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getNPeon4();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getNPeon5();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getNPeon6();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getNPeon7();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
            temp = board.getNPeon8();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white, nodo);
            }
        } 
    }
    public void generarBoard(int profundidad, Position currentPosition, Board currentBoard, ArrayList<Position> moves, ArrayList<char[][]> boards, boolean white, Node<Integer> nodo){       
        Evaluador e = new Evaluador();
        for(Position pos: moves){
            Board nuevoBoard = new Board(currentBoard.getBoard());
            nuevoBoard.move(currentPosition, pos);
            
            Node<Integer> nuevoNodo = new Node<Integer>(VAL);
            nuevoNodo.setPosition(currentPosition, pos);
            nodo.insertChild(nuevoNodo);
            
            if(profundidad == 0){
                boards.add(nuevoBoard.board);
                nuevoNodo.setData(e.evaluar(nuevoBoard, white));
            }else{
                if(white)
                    generateMoves(nuevoBoard,profundidad-1, boards, false, nuevoNodo);
                else
                    generateMoves(nuevoBoard,profundidad-1, boards, true, nuevoNodo);
            }
        }
    }
    public void print(){
        print(board.board); 
    }
    public void print(char[][] G){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j< 8; j++)
                System.out.print(G[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }
}
