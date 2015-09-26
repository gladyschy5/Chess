package ia_chess;

import java.util.ArrayList;

public class Queen {
    private Position pos;
    private ArrayList<Position> moves;
    private Board board;
    
    public Queen() {
        this.pos = null;
        this.moves = new ArrayList<Position>();
        this.board = null;
    }
    public void getMoves(Board board, Position pos, ArrayList<Position> moves, boolean white){ 
        this.pos = pos;
        this.moves = moves;
        this.board = board;
        
        isMove(pos.x, pos.y,  1,  0, white);
        isMove(pos.x, pos.y,  1, -1, white);
        isMove(pos.x, pos.y,  0, -1, white);
        isMove(pos.x, pos.y, -1, -1, white);
        isMove(pos.x, pos.y, -1,  0, white);
        isMove(pos.x, pos.y, -1,  1, white);
        isMove(pos.x, pos.y,  0,  1, white);
        isMove(pos.x, pos.y,  1,  1, white);
    }
    public void isMove(int x, int y, int varx, int vary, boolean white){
        int xx = x + varx;
        int yy = y + vary;
        while(board.isEmpty(xx, yy)){
            moves.add(new Position(xx,yy)); 
            xx+=varx;
            yy+=vary;
        }
        if(white){   
            if(board.isNotOut(xx, yy) && !board.isWhite(new Position(xx,yy)))
                moves.add(new Position(xx,yy)); 
        }else{
            if(board.isNotOut(xx, yy) && !board.isBlack(new Position(xx,yy)))
                moves.add(new Position(xx,yy));
        }  
    }
}
