package ia_chess;

import java.util.ArrayList;

public class Queen {
    private int value=10;
    public ArrayList<Position> getMoves(Board board, Position pos){
        ArrayList<Position> moves = new ArrayList<Position>();
        int nX = pos.x;
        int nY = pos.y;
        while(board.isEmpty(nY--, nY--)){
            moves.add(new Position(nX,nY));  
        }
        if(board.isNotOut(nY, nY))
            moves.add(new Position(nX,nY));

        return moves;
    }
}
