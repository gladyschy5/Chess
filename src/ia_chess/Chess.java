package ia_chess;

import java.util.ArrayList;

public class Chess {
    Board board;
    King rey = new King();
    Queen reyna = new Queen();
    Torre torre = new Torre();
    Alfil alfil = new Alfil();
    Peon peon = new Peon();
        
    public Chess() {
        this.board = new Board();
    }
    public void start(){
        ArrayList<char[][]> boards = new ArrayList<char[][]>();    
        generateMoves(board, 2, boards, false);
        for(int i = 0; i < boards.size(); i++)
            print(boards.get(i));
    }
    public void generateMoves(Board board, int profundidad, ArrayList<char[][]> boards, boolean white){       
        System.out.println("generateMoves " + profundidad);
        if(white){
            Position temp = board.getBRey();
            /*if(temp!=null){
                rey.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
            temp = board.getBReyna();
            if(temp!=null){
                reyna.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
            temp = board.getBTorre_I();
            if(temp!=null){
                torre.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
            temp = board.getBTorre_D();
            if(temp!=null){
                torre.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
            temp = board.getBAlfil_I();
            if(temp!=null){
                alfil.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
            temp = board.getBAlfil_D();
            if(temp!=null){
                alfil.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }

            temp = board.getBPeon1();
            if(temp!=null){
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
            temp = board.getBPeon2();
            if(temp!=null){
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
            temp = board.getBPeon3();
            if(temp!=null){
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
            temp = board.getBPeon4();
            if(temp!=null){
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
            temp = board.getBPeon5();
            if(temp!=null){
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }*/
            temp = board.getBPeon6();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
            temp = board.getBPeon7();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
            temp = board.getBPeon8();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
        }else{
            Position temp = board.getNRey();
            /*if(temp!=null){
                rey.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
            temp = board.getNReyna();
            if(temp!=null){
                reyna.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
            temp = board.getNTorre_I();
            if(temp!=null){
                torre.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
            temp = board.getNTorre_D();
            if(temp!=null){
                torre.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
            temp = board.getNAlfil_I();
            if(temp!=null){
                alfil.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
            temp = board.getNAlfil_D();
            if(temp!=null){
                alfil.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }

            temp = board.getNPeon1();
            if(temp!=null){
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
            temp = board.getNPeon2();
            if(temp!=null){
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
            temp = board.getNPeon3();
            if(temp!=null){
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
            temp = board.getNPeon4();
            if(temp!=null){
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
            temp = board.getNPeon5();
            if(temp!=null){
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }*/
            temp = board.getNPeon6();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
            temp = board.getNPeon7();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
            temp = board.getNPeon8();
            if(temp!=null){
                ArrayList<Position> moves = new ArrayList<Position>();
                peon.getMoves(board, temp, moves, white);
                generarBoard(profundidad, temp, board, moves, boards, white);
            }
        } 
    }
    public void generarBoard(int profundidad, Position currentPosition, Board currentBoard, ArrayList<Position> moves, ArrayList<char[][]> boards, boolean white){       
        System.out.println("generarBoard " + profundidad);
        for(Position pos: moves){
            Board nuevoBoard = new Board(board.board);
            nuevoBoard.move(currentPosition, pos);
            if(profundidad == 0){
                boards.add(nuevoBoard.board);
            }else{
                if(white)
                    generateMoves(nuevoBoard,profundidad-1, boards, false);
                else
                    generateMoves(nuevoBoard,profundidad-1, boards, true);
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
