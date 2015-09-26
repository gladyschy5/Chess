package ia_chess;

import java.util.ArrayList;

public class Torre {
    private Position pos;
    private ArrayList<Position> moves;
    private Board board;
    
    public Torre() {
        this.pos = null;
        this.moves = new ArrayList<Position>();
        this.board = null;
    }
    public void getMoves(Board board, Position pos, ArrayList<Position> moves){ 
        this.pos = pos;
        this.moves = moves;
        this.board = board;
        
        isMove(pos.x, pos.y,  1,  0);
        isMove(pos.x, pos.y,  0, -1);
        isMove(pos.x, pos.y, -1,  0);
        isMove(pos.x, pos.y,  0,  1);
    }
    public void isMove(int x, int y, int varx, int vary){
        int xx = x + varx;
        int yy = y + vary;
        while(board.isEmpty(xx, yy)){
            moves.add(new Position(xx,yy)); 
            xx+=varx;
            yy+=vary;
        }
        if(board.isNotOut(xx, yy))
            moves.add(new Position(xx,yy));
    }
    
}
