package ia_chess;

import java.util.ArrayList;

public class Chess {
    Board board;

    public Chess(Board board) {
        this.board = board;
    }
    public void generateTree(){
        ArrayList<Position> moves = new ArrayList<Position>();
        Position temp = board.getBRey();
        if(temp!=null)
            King.getMoves(board, temp, moves);
        
        temp = board.getBReyna();
        if(temp!=null)
            Queen.getMoves(board, temp, moves);
        
        temp = board.getBTorre_I();
        if(temp!=null)
            Torre.getMoves(board, temp, moves);
        
        temp = board.getBTorre_D();
        if(temp!=null)
            Torre.getMoves(board, temp, moves);
    }
}
