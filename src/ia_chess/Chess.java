package ia_chess;

import java.util.ArrayList;

public class Chess {
    Board board;

    public Chess(Board board) {
        this.board = board;
    }
    public void generateTree(){
        King rey = new King();
        Queen reyna = new Queen();
        Torre torre = new Torre();
        Alfil alfil = new Alfil();
        Peon peon = new Peon();
        ArrayList<Position> moves = new ArrayList<Position>();
        
        Position temp = board.getBRey();
        if(temp!=null)
            rey.getMoves(board, temp, moves);
        
        temp = board.getBReyna();
        if(temp!=null)
            reyna.getMoves(board, temp, moves);
        
        temp = board.getBTorre_I();
        if(temp!=null)
            torre.getMoves(board, temp, moves);
        
        temp = board.getBTorre_D();
        if(temp!=null)
            torre.getMoves(board, temp, moves);
        
        temp = board.getBAlfil_I();
        if(temp!=null)
            alfil.getMoves(board, temp, moves);
        
        temp = board.getBAlfil_D();
        if(temp!=null)
            alfil.getMoves(board, temp, moves);
    }
}
