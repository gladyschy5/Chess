package ia_chess;

import java.util.ArrayList;

public class King {
    private int value=100000;
    
    public static void getMoves(Board board, Position pos, ArrayList<Position> moves){      
        int nX = pos.x+1;
        int nY = pos.y;
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
        nX = pos.x+1;
        nY = pos.y-1;
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
        nX = pos.x;
        nY = pos.y-1;
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
        nX = pos.x-1;
        nY = pos.y-1;
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
        nX = pos.x-1;
        nY = pos.y;
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
        nX = pos.x-1;
        nY = pos.y+1;
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
        nX = pos.x;
        nY = pos.y+1;
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
        nX = pos.x+1;
        nY = pos.y+1;
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
    }
    public static void getMoves(Board board, Position pos){
        ArrayList<Position> moves = new ArrayList<Position>();
        getMoves(board, pos, moves);
    }
}
