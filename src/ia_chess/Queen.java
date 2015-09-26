package ia_chess;

import java.util.ArrayList;

public class Queen {
    private int value=10;
    public static void getMoves(Board board, Position pos, ArrayList<Position> moves){
        int nX = pos.x;
        int nY = pos.y;
        
        while(board.isEmpty(nX++, nY)){
            moves.add(new Position(nX,nY));  
        }
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
        
        nX = pos.x;
        nY = pos.y;
        while(board.isEmpty(nX++, nY--)){
            moves.add(new Position(nX,nY));  
        }
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
        
        nX = pos.x;
        nY = pos.y;
        while(board.isEmpty(nX, nY--)){
            moves.add(new Position(nX,nY));  
        }
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
        
        nX = pos.x;
        nY = pos.y;
        while(board.isEmpty(nX--, nY--)){
            moves.add(new Position(nX,nY));  
        }
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
        
        nX = pos.x;
        nY = pos.y;
        while(board.isEmpty(nX--, nY)){
            moves.add(new Position(nX,nY));  
        }
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
        
        nX = pos.x;
        nY = pos.y;
        while(board.isEmpty(nX--, nY++)){
            moves.add(new Position(nX,nY));  
        }
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
        
        nX = pos.x;
        nY = pos.y;
        while(board.isEmpty(nX, nY++)){
            moves.add(new Position(nX,nY));  
        }
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
        
        nX = pos.x;
        nY = pos.y;
        while(board.isEmpty(nX++, nY++)){
            moves.add(new Position(nX,nY));  
        }
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
    }
}
