package ia_chess;

public class Board {
        public static final char B_REY = 'k';
        public static final char B_REYNA = 'q';
        public static final char B_TORRE_D = 't';
        public static final char B_TORRE_I = 'w';
        public static final char B_CABALLO_D = 'o';
        public static final char B_CABALLO_I = 's';
        public static final char B_ALFIL_D = 'l';
        public static final char B_ALFIL_I = 'p';
        
        public static final char B_PEON1 = 'a';
        public static final char B_PEON2 = 'b';
        public static final char B_PEON3 = 'c';
        public static final char B_PEON4 = 'd';
        public static final char B_PEON5 = 'f';
        public static final char B_PEON6 = 'g';
        public static final char B_PEON7 = 'h';
        public static final char B_PEON8 = 'i';
        
        public static final char N_REY = 'K';
        public static final char N_REYNA = 'Q';
        public static final char N_TORRE_D = 'T';
        public static final char N_TORRE_I = 'W';
        public static final char N_CABALLO_D = 'O';
        public static final char N_CABALLO_I = 'S';
        public static final char N_ALFIL_D = 'L';
        public static final char N_ALFIL_I = 'P';
        
        public static final char N_PEON1 = 'A';
        public static final char N_PEON2 = 'B';
        public static final char N_PEON3 = 'C';
        public static final char N_PEON4 = 'D';
        public static final char N_PEON5 = 'F';
        public static final char N_PEON6 = 'G';
        public static final char N_PEON7 = 'H';
        public static final char N_PEON8 = 'I';
        
        public static final char VACIO = '_';

        
	char board[][] = {{N_TORRE_D, N_CABALLO_D, N_ALFIL_D, N_REY,    N_REYNA,  N_ALFIL_I, N_CABALLO_I, N_TORRE_I},
                          {N_PEON8,   N_PEON7,     N_PEON6,   N_PEON5,  N_PEON4,  N_PEON3,   N_PEON2,     N_PEON1 },
                          {VACIO,     VACIO,       VACIO,     VACIO,    VACIO,    VACIO,     VACIO,       VACIO },
                          {VACIO,     VACIO,       VACIO,     VACIO,    VACIO,    VACIO,     VACIO,       VACIO },
                          {VACIO,     VACIO,       VACIO,     VACIO,    VACIO,    VACIO,     VACIO,       VACIO },
                          {VACIO,     VACIO,       VACIO,     VACIO,    VACIO,    VACIO,     VACIO,       VACIO },
                          {B_PEON1,   B_PEON2,     B_PEON3,   B_PEON4,  B_PEON5,  B_PEON6,   B_PEON7,     B_PEON8 },
                          {B_TORRE_I, B_CABALLO_I, B_ALFIL_I, B_REYNA,  B_REY,    B_ALFIL_D, B_CABALLO_D, B_TORRE_D}
                        };
    
    public Board() {
    }
    public Board(char[][]board) {
        this.board = board;
    }
    public char[][] getBoard(){
        char nuevo[][] = new char[8][8];
        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++)
                nuevo[i][j] = board[i][j];
        
        return nuevo;
    }
    public char getXY(int x, int y){
        return board[x][y];
    }
    public void move(int ax, int ay, int bx, int by){
        board[bx][by] = board[ax][ay];
        board[ax][ay] = VACIO;
    }
    public void move(Position start, Position end){
        board[end.x][end.y] = board[start.x][start.y];
        board[start.x][start.y] = VACIO;
    }
    public void remove(int x, int y){
        board[x][y] = VACIO;
    }
    public boolean isEmpty(int x, int y){
        return (isNotOut(x,y)&&(getXY(x,y) == VACIO));
    }
    public boolean isNotOut(int x, int y){
        return (x>=0 && x <8 && y>=0 && y<8);
    } 
    public Position getPosition(char el){
        for(int i=0; i < 8; i++)
            for(int j=0; j < 8; j++){
                if(board[i][j]==el){
                    return new Position(i,j);
                }
            }
        return null;
    }
    public Position getBRey(){
        return getPosition(B_REY);
    }
    public Position getBReyna(){
        return getPosition(B_REYNA);
    }
    public Position getBTorre_D(){
        return getPosition(B_TORRE_D);
    }
    public Position getBTorre_I(){
        return getPosition(B_TORRE_I);
    }
    public Position getBCaballo_D(){
        return getPosition(B_CABALLO_D);
    }
    public Position getBCaballo_I(){
        return getPosition(B_CABALLO_I);
    }
    public Position getBAlfil_D(){
        return getPosition(B_ALFIL_D);
    }
    public Position getBAlfil_I(){
        return getPosition(B_ALFIL_I);
    }
    public Position getBPeon1(){
        return getPosition(B_PEON1);
    }
    public Position getBPeon2(){
        return getPosition(B_PEON2);
    }
    public Position getBPeon3(){
        return getPosition(B_PEON3);
    }
    public Position getBPeon4(){
        return getPosition(B_PEON4);
    }
    public Position getBPeon5(){
        return getPosition(B_PEON5);
    }
    public Position getBPeon6(){
        return getPosition(B_PEON6);
    }
    public Position getBPeon7(){
        return getPosition(B_PEON7);
    }
    public Position getBPeon8(){
        return getPosition(B_PEON8);
    }
    
    
    
    public Position getNRey(){
        return getPosition(N_REY);
    }
    public Position getNReyna(){
        return getPosition(N_REYNA);
    }
    public Position getNTorre_D(){
        return getPosition(N_TORRE_D);
    }
    public Position getNTorre_I(){
        return getPosition(N_TORRE_I);
    }
    public Position getNCaballo_D(){
        return getPosition(N_CABALLO_D);
    }
    public Position getNCaballo_I(){
        return getPosition(N_CABALLO_I);
    }
    public Position getNAlfil_D(){
        return getPosition(N_ALFIL_D);
    }
    public Position getNAlfil_I(){
        return getPosition(N_ALFIL_I);
    }
    public Position getNPeon1(){
        return getPosition(N_PEON1);
    }
    public Position getNPeon2(){
        return getPosition(N_PEON2);
    }
    public Position getNPeon3(){
        return getPosition(N_PEON3);
    }
    public Position getNPeon4(){
        return getPosition(N_PEON4);
    }
    public Position getNPeon5(){
        return getPosition(N_PEON5);
    }
    public Position getNPeon6(){
        return getPosition(N_PEON6);
    }
    public Position getNPeon7(){
        return getPosition(N_PEON7);
    }
    public Position getNPeon8(){
        return getPosition(N_PEON8);
    }
    
    public boolean isWhite(Position pos){
        char temp = board[pos.x][pos.y];
        if(temp == 'k' || temp == 'q' || 
           temp == 't' || temp == 'w' ||
           temp == 'o' || temp == 's' ||
           temp == 'l' || temp == 'p' || 
           temp == 'a' || temp == 'b' ||
           temp == 'c' || temp == 'd' ||
           temp == 'f' || temp == 'g' ||
           temp == 'h' || temp == 'i')
            return true;
        return false;
    }
    public boolean isBlack(Position pos){
        char temp = board[pos.x][pos.y];
        if(temp == 'K' || temp == 'Q' || 
           temp == 'T' || temp == 'W' ||
           temp == 'O' || temp == 'S' ||
           temp == 'L' || temp == 'P' || 
           temp == 'A' || temp == 'B' ||
           temp == 'C' || temp == 'D' ||
           temp == 'F' || temp == 'G' ||
           temp == 'H' || temp == 'I')
            return true;
        return false;
    }
}
