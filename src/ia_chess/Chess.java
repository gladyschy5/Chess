package ia_chess;

import java.util.ArrayList;

public class Chess {
    Board board;
    King rey = new King();
    Queen reyna = new Queen();
    Torre torre = new Torre();
    Alfil alfil = new Alfil();
    Peon peon = new Peon();
    Node<Integer> root;
    
    int VAL = -10;
    
    public Chess() {
        this.board = new Board();
    }
    public void start(){
        ArrayList<char[][]> boards = new ArrayList<char[][]>(); 
        root = new Node<Integer>(VAL);
        generateMoves(board, 1, boards, false, root);
        /*for(int i = 0; i < boards.size(); i++)
            print(boards.get(i));
        root.print();
        */
        
    }
    public void generarMovimiento(){
        ArrayList<char[][]> boards = new ArrayList<char[][]>(); 
        root = new Node<Integer>(VAL);
        root.setPosition(new Position(VAL,VAL), new Position(VAL,VAL));
        generateMoves(board, 3, boards, false, root);
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
        for(Position pos: moves){
            Board nuevoBoard = new Board(currentBoard.getBoard());
            nuevoBoard.move(currentPosition, pos);
            
            Node<Integer> nuevoNodo = new Node<Integer>(VAL);
            nuevoNodo.setPosition(currentPosition, pos);
            nodo.insertChild(nuevoNodo);
            
            if(profundidad == 0){
                boards.add(nuevoBoard.board);
            }else{
                if(white)
                    generateMoves(nuevoBoard,profundidad-1, boards, false, nuevoNodo);
                else
                    generateMoves(nuevoBoard,profundidad-1, boards, true, nuevoNodo);
            }
        }
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
