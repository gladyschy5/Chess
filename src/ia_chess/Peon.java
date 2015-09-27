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
                isMove(pos.x-1, pos.y, white);
                isMove(pos.x-2, pos.y, white);
            }else{
                isMove(pos.x-1, pos.y, white);
            }
            isMoveD(pos.x-1, pos.y-1, white);
            isMoveD(pos.x-1, pos.y+1, white);
        }else{
            if(pos.x == 1){
                isMove(pos.x+1, pos.y, white);
                isMove(pos.x+2, pos.y, white);
            }else{
                isMove(pos.x+1, pos.y, white);
            }
            isMoveD(pos.x+1, pos.y+1, white);
            isMoveD(pos.x+1, pos.y+1, white);
        }
    }
    public void isMove(int x, int y, boolean white){    
        if(white){
            if(board.isNotOut(x, y) && !board.isWhite(new Position(x,y))){
                System.out.println(white + " " + x + " " + y );
                moves.add(new Position(x,y)); 
            }
        }else{
            System.out.println(white + " " + x + " " + y );
            if(board.isNotOut(x, y) && !board.isBlack(new Position(x,y)))
                moves.add(new Position(x,y)); 
        }  
    }
    public void isMoveD(int x, int y, boolean white){    
        if(white){
            if(board.isNotOut(x, y) && board.isBlack(new Position(x,y))){
                moves.add(new Position(x,y)); 
            }
        }else{
            if(board.isNotOut(x, y) && board.isWhite(new Position(x,y)))
                moves.add(new Position(x,y)); 
        }
    }
}
