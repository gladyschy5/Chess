package ia_chess;

import java.util.ArrayList;

public class Caballo {
    private Position pos;
    private ArrayList<Position> moves;
    private Board board;
    
    public Caballo() {
        this.pos = null;
        this.moves = new ArrayList<Position>();
        this.board = null;
    }
    public void getMoves(Board board, Position pos, ArrayList<Position> moves, boolean white){      
        this.pos = pos;
        this.moves = moves;
        this.board = board;
        
        isMove(pos.x-1, pos.y-2, white);
        isMove(pos.x-2, pos.y-1, white);
        isMove(pos.x+1, pos.y-2, white);
        isMove(pos.x+2, pos.y-1, white);
        isMove(pos.x-1, pos.y+2, white);
        isMove(pos.x-2, pos.y+1, white);
        isMove(pos.x+1, pos.y+2, white);
        isMove(pos.x+2, pos.y+1, white);
    }
    public void isMove(int x, int y, boolean white){
        if(white){
            if(board.isNotOut(x, y) && !board.isWhite(new Position(x,y)))
                moves.add(new Position(x,y)); 
        }else{
            if(board.isNotOut(x, y) && !board.isBlack(new Position(x,y)))
                moves.add(new Position(x,y)); 
        }  
    }
}
