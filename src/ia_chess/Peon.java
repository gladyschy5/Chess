package ia_chess;

import java.util.ArrayList;

public class Peon {
    private Position pos;
    private ArrayList<Position> moves;
    private Board board;
    
    public Peon() {
        this.pos = null;
        this.moves = new ArrayList<Position>();
        this.board = null;
    }
    public  void getMoves(Board board, Position pos, ArrayList<Position> moves, boolean white){      
        this.pos = pos;
        this.moves = moves;
        this.board = board;
       
        if(white){
            if(pos.x == 6){
                isMove(pos.x-1, pos.y);
                isMove(pos.x-2, pos.y);
            }else{
                isMove(pos.x-1, pos.y);
            }
            isMove(pos.x-1, pos.y-1);
            isMove(pos.x-1, pos.y+1);
        }else{
            if(pos.x == 1){
                isMove(pos.x+1, pos.y);
                isMove(pos.x+2, pos.y);
            }else{
                isMove(pos.x+1, pos.y);
            }
            isMove(pos.x+1, pos.y+1);
            isMove(pos.x+1, pos.y+1);
        }
    }
    public void isMove(int x, int y){
        if(board.isNotOut(x, y))
            moves.add(new Position(x,y));
    }
}
