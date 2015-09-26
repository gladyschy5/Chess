package ia_chess;

import java.util.ArrayList;

public class Caballo {
    public static void getMoves(Board board, Position pos, ArrayList<Position> moves){      
        int nX = pos.x-1;
        int nY = pos.y-2;
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
        
        nX = pos.x-2;
        nY = pos.y-1;
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
        
        nX = pos.x+1;
        nY = pos.y-2; 
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
        
        nX = pos.x+2;
        nY = pos.y-1;
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
        
        nX = pos.x-1;
        nY = pos.y+2;
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
        
        nX = pos.x-2;
        nY = pos.y+1; 
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
        
        nX = pos.x+1;
        nY = pos.y+2;
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
        
        nX = pos.x+2;
        nY = pos.y+1;
        if(board.isNotOut(nX, nY))
            moves.add(new Position(nX,nY));
    }
    
    
    
}
