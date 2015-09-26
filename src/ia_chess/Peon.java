package ia_chess;

import java.util.ArrayList;

public class Peon {
    public static void getMoves(Board board, Position pos, ArrayList<Position> moves, boolean white){      
        
        
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
        
        
        if(white){
            if(pos.x == 6){
                nX = pos.x-1;
                nY = pos.y;
                if(board.isEmpty(nX, nY))
                    moves.add(new Position(nX,nY));
                
                nX = pos.x-2;
                nY = pos.y;
                if(board.isEmpty(nX, nY))
                    moves.add(new Position(nX,nY));
            }else{
                nX = pos.x-1;
                nY = pos.y;
                if(board.isEmpty(nX, nY))
                    moves.add(new Position(nX,nY));
            }
            nX = pos.x-1;
            nY = pos.y-1;
            if(board.isNotOut(nX, nY))
                moves.add(new Position(nX,nY));
            
            nX = pos.x-1;
            nY = pos.y+1;
            if(board.isNotOut(nX, nY))
                moves.add(new Position(nX,nY));
        }else{
            if(pos.x == 1){
                nX = pos.x+1;
                nY = pos.y;
                if(board.isEmpty(nX, nY))
                    moves.add(new Position(nX,nY));
                
                nX = pos.x+2;
                nY = pos.y;
                if(board.isEmpty(nX, nY))
                    moves.add(new Position(nX,nY));
            }else{
                nX = pos.x+1;
                nY = pos.y;
                if(board.isEmpty(nX, nY))
                    moves.add(new Position(nX,nY));
            }
            nX = pos.x+1;
            nY = pos.y+1;
            if(board.isNotOut(nX, nY))
                moves.add(new Position(nX,nY));
            
            nX = pos.x+1;
            nY = pos.y+1;
            if(board.isNotOut(nX, nY))
                moves.add(new Position(nX,nY));
        }
    }
}
