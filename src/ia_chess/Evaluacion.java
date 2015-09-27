package ia_chess;

import java.util.ArrayList;

public class Evaluacion
{
    King rey = new King();
    Queen reyna = new Queen();
    Torre torre = new Torre();
    Alfil alfil = new Alfil();
    Peon peon = new Peon();
    Caballo caballo = new Caballo();
    
    int reyValue = 10000;
    int reinaValue = 900;
    int alfilValue = 300;
    int caballoValue = 300;
    int torreValue = 500;
    int peonValue = 100;
    
    // Tabla de pesos por posiciones para el equipo blanco
    int peones[][] =
    {
        {0, 0, 0, 0, 0, 0, 0, 0},
        {50, 50, 50, 50, 50, 50, 50, 50},
        {10, 10, 20, 30, 30, 20, 10, 10},
        {5, 5, 10, 25, 25, 10, 5, 5},
        {0, 0, 0, 50, 50, 0, 0, 0},
        {5, -5, -10, 0, 0, -10, -5, 5},
        {5, 10, 10,-20,-20, 10, 10, 5},
        {0, 0, 0, 0, 0, 0, 0, 0}
    };

    int caballos [][] =
    {
        {-50,-40,-30,-30,-30,-30,-40,-50},
        {-40,-20,  0,  0,  0,  0,-20,-40},
        {-30,  0, 10, 15, 15, 10, 0,-30},
        {-30,  5, 15, 20, 20, 15,  5,-30},
        {-30,  0, 15, 20, 20, 15,  0,-30},
        {-30,  5, 50, 15, 15, 50,  5,-30},
        {-40,-20,  0,  5,  5,  0,-20,-40},
        {-50,-40,-30,-30,-30,-30,-40,-50}
    };

    int alfiles [][] =
    {
        {-20,-10,-10,-10,-10,-10,-10,-20},
        {-10,  0,  0,  0,  0,  0,  0,-10},
        {-10,  0,  5, 10, 10,  5,  0,-10},
        {-10,  5,  5, 10, 10,  5,  5,-10},
        {-10,  0, 10, 10, 10, 10,  0,-10},
        {-10, 10, 10, 10, 10, 10, 10,-10},
        {-10,  5,  0,  0,  0,  0,  5,-10},
        {-20,-10,-10,-10,-10,-10,-10,-20}
    };

    int torres [][] =
    {
        {0, 0, 0, 0, 0, 0, 0, 0},    
        {5, 10, 10, 10, 10, 10, 10, 5},
        {-5, 0, 0, 0, 0, 0, 0, -5},
        {-5, 0, 0, 0, 0, 0, 0, -5},
        {-5, 0, 0, 0, 0, 0, 0, -5},
        {-5, 0, 0, 0, 0, 0, 0, -5},
        {-5, 0, 0, 0, 0, 0, 0, -5},
        {0, 0, 0, 5, 5, 0, 0, 0}
    };

    int reinas [][] =
    {
        {-20,-10,-10, -5, -5,-10,-10,-20},
        {-10, 0, 0, 0, 0, 0, 0,-10},
        {-10, 0, 5, 5, 5, 5, 0,-10},
        {-5, 0, 5, 5, 5, 5, 0, -5},
        {0, 0, 5, 5, 5, 5, 0, -5},
        {-10, 5, 5, 5, 5, 5, 0,-10},
        {-10, 0, 5, 0, 0, 0, 0,-10},
        {-20,-10,-10, -5, -5,-10,-10,-20}
    };

    int midgameking[][] =
    { 
        {-30,-40,-40,-50,-50,-40,-40,-30},
        {-30,-40,-40,-50,-50,-40,-40,-30},
        {-30,-40,-40,-50,-50,-40,-40,-30},
        {-30,-40,-40,-50,-50,-40,-40,-30},
        {-20,-30,-30,-40,-40,-30,-30,-20},
        {-10,-20,-20,-20,-20,-20,-20,-10},
        {20, 20,  0,  0,  0,  0, 20, 20},
        {20, 30, 10,  0,  0, 10, 30, 20}
    };

    int endgameking[][] =
    {
        {-50,-40,-30,-20,-20,-30,-40,-50},
        {-30,-20,-10,  0,  0,-10,-20,-30},
        {-30,-10, 20, 30, 30, 20,-10,-30},
        {-30,-10, 30, 40, 40, 30,-10,-30},
        {-30,-10, 30, 40, 40, 30,-10,-30},
        {-30,-10, 20, 30, 30, 20,-10,-30},
        {-30,-30,  0,  0,  0,  0,-30,-30},
        {-50,-30,-30,-30,-30,-30,-30,-50}
    };
    
    public int evaluar(Board b, boolean white)
    {
        int myScore = 0, opponentScore = 0;
        int estado = evaluarMaterial(b, white);
        int opponentEstado = evaluarMaterial(b, !white);
        
        myScore += estado;
        myScore += evaluarPosicion(b, estado, white);
        myScore += evaluarRey(b, white);
        myScore += evaluarAtaques(b, white);
        
        opponentScore += opponentEstado;
        opponentScore += evaluarPosicion(b, opponentEstado, !white);
        opponentScore += evaluarRey(b, !white);
        opponentScore += evaluarAtaques(b, !white);
        
        return myScore - opponentScore;
    }
    
    private boolean esSeguro(Position pos, Board b, boolean white)
    {
        ArrayList<Position> moves = new ArrayList<>();
        Position temp = null;
        if(white)
        {
            temp = b.getNRey();
            if(temp != null)
                rey.getMoves(b, temp, moves, white);
            
            temp = b.getNReyna();
            if(temp != null)
                reyna.getMoves(b, temp, moves, white);
            
            temp = b.getNAlfil_D();
            if(temp != null)
                alfil.getMoves(b, temp, moves, white);
            
            temp = b.getNAlfil_I();
            if(temp != null)
                alfil.getMoves(b, temp, moves, white);
            
            temp = b.getNCaballo_D();
            if(temp != null)
                caballo.getMoves(b, temp, moves, white);
            
            temp = b.getNCaballo_I();
            if(temp != null)
                caballo.getMoves(b, temp, moves, white);
            
            temp = b.getNTorre_D();
            if(temp != null)
                torre.getMoves(b, temp, moves, white);
            
            temp = b.getNTorre_I();
            if(temp != null)
                torre.getMoves(b, temp, moves, white);
            
            temp = b.getNPeon1();
            if(temp != null)
                peon.getMoves(b, temp, moves, white);
            
            temp = b.getNPeon2();
            if(temp != null)
                peon.getMoves(b, temp, moves, white);
            
            temp = b.getNPeon3();
            if(temp != null)
                peon.getMoves(b, temp, moves, white);
            
            temp = b.getNPeon4();
            if(temp != null)
                peon.getMoves(b, temp, moves, white);
            
            temp = b.getNPeon5();
            if(temp != null)
                peon.getMoves(b, temp, moves, white);
            
            temp = b.getNPeon6();
            if(temp != null)
                peon.getMoves(b, temp, moves, white);
            
            temp = b.getNPeon7();
            if(temp != null)
                peon.getMoves(b, temp, moves, white);
            
            temp = b.getNPeon8();
            if(temp != null)
                peon.getMoves(b, temp, moves, white);
        }
        else
        {
            temp = b.getBRey();
            if(temp != null)
                rey.getMoves(b, temp, moves, white);
            
            temp = b.getBReyna();
            if(temp != null)
                reyna.getMoves(b, temp, moves, white);
            
            temp = b.getBAlfil_D();
            if(temp != null)
                alfil.getMoves(b, temp, moves, white);
            
            temp = b.getBAlfil_I();
            if(temp != null)
                alfil.getMoves(b, temp, moves, white);
            
            temp = b.getBCaballo_D();
            if(temp != null)
                caballo.getMoves(b, temp, moves, white);
            
            temp = b.getBCaballo_I();
            if(temp != null)
                caballo.getMoves(b, temp, moves, white);
            
            temp = b.getBTorre_D();
            if(temp != null)
                torre.getMoves(b, temp, moves, white);
            
            temp = b.getBTorre_I();
            if(temp != null)
                torre.getMoves(b, temp, moves, white);
            
            temp = b.getBPeon1();
            if(temp != null)
                peon.getMoves(b, temp, moves, white);
            
            temp = b.getBPeon2();
            if(temp != null)
                peon.getMoves(b, temp, moves, white);
            
            temp = b.getBPeon3();
            if(temp != null)
                peon.getMoves(b, temp, moves, white);
            
            temp = b.getBPeon4();
            if(temp != null)
                peon.getMoves(b, temp, moves, white);
            
            temp = b.getBPeon5();
            if(temp != null)
                peon.getMoves(b, temp, moves, white);
            
            temp = b.getBPeon6();
            if(temp != null)
                peon.getMoves(b, temp, moves, white);
            
            temp = b.getBPeon7();
            if(temp != null)
                peon.getMoves(b, temp, moves, white);
            
            temp = b.getBPeon8();
            if(temp != null)
                peon.getMoves(b, temp, moves, white);
        }
        
        return !moves.contains(pos);
    }

    private int evaluarMaterial(Board b, boolean white)
    {
        int materialScore = 0;
        
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(white)
                {
                    switch(b.board[i][j])
                    {
                        case Board.B_REY:
                            materialScore += reyValue;
                        break;
                            
                        case Board.B_REYNA:
                            materialScore += reinaValue;
                        break;
                            
                        case Board.B_ALFIL_D:
                        case Board.B_ALFIL_I:
                            materialScore += alfilValue;
                        break;
                            
                        case Board.B_CABALLO_D:
                        case Board.B_CABALLO_I:
                            materialScore += caballoValue;
                        break;
                            
                        case Board.B_TORRE_D:
                        case Board.B_TORRE_I:
                            materialScore += torreValue;
                        break;
                            
                        case Board.B_PEON1:
                        case Board.B_PEON2:
                        case Board.B_PEON3:
                        case Board.B_PEON4:
                        case Board.B_PEON5:
                        case Board.B_PEON6:
                        case Board.B_PEON7:
                        case Board.B_PEON8:
                            materialScore += peonValue;
                        break;
                    }
                }
                else
                {
                    switch(b.board[i][j])
                    {
                        case Board.N_REY:
                            materialScore += reyValue;
                        break;
                            
                        case Board.N_REYNA:
                            materialScore += reinaValue;
                        break;
                            
                        case Board.N_ALFIL_D:
                        case Board.N_ALFIL_I:
                            materialScore += alfilValue;
                        break;
                            
                        case Board.N_CABALLO_D:
                        case Board.N_CABALLO_I:
                            materialScore += caballoValue;
                        break;
                            
                        case Board.N_TORRE_D:
                        case Board.N_TORRE_I:
                            materialScore += torreValue;
                        break;
                            
                        case Board.N_PEON1:
                        case Board.N_PEON2:
                        case Board.N_PEON3:
                        case Board.N_PEON4:
                        case Board.N_PEON5:
                        case Board.N_PEON6:
                        case Board.N_PEON7:
                        case Board.N_PEON8:
                            materialScore += peonValue;
                        break;
                    }
                }
            }
        }
        return materialScore;
    }

    private int evaluarPosicion(Board b, int estadoJuego, boolean white)
    {
        int posicionScore = 0;
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(white)
                {
                    switch(b.board[i][j])
                    {
                        case Board.B_REY:
                            if(estadoJuego > 2000)
                                posicionScore += midgameking[i][j];
                            else
                                posicionScore += endgameking[i][j];
                        break;
                            
                        case Board.B_REYNA:
                            posicionScore += reinas[i][j];
                        break;
                            
                        case Board.B_ALFIL_D:
                        case Board.B_ALFIL_I:
                            posicionScore += alfiles[i][j];
                        break;
                            
                        case Board.B_CABALLO_D:
                        case Board.B_CABALLO_I:
                            posicionScore += caballos[i][j];
                        break;
                            
                        case Board.B_TORRE_D:
                        case Board.B_TORRE_I:
                            posicionScore += torres[i][j];
                        break;
                            
                        case Board.B_PEON1:
                        case Board.B_PEON2:
                        case Board.B_PEON3:
                        case Board.B_PEON4:
                        case Board.B_PEON5:
                        case Board.B_PEON6:
                        case Board.B_PEON7:
                        case Board.B_PEON8:
                            posicionScore += peones[i][j];
                        break;
                    }
                }
                else
                {
                    switch(b.board[i][j])
                    {
                        case Board.B_REY:
                            if(estadoJuego > 2000)
                                posicionScore += rotar(midgameking)[7 - i][7 - j];
                            else
                                posicionScore += rotar(endgameking)[7 - i][7 - j];
                        break;
                            
                        case Board.B_REYNA:
                            posicionScore += rotar(reinas)[7 - i][7 - j];
                        break;
                            
                        case Board.B_ALFIL_D:
                        case Board.B_ALFIL_I:
                            posicionScore += rotar(alfiles)[7 - i][7 - j];
                        break;
                            
                        case Board.B_CABALLO_D:
                        case Board.B_CABALLO_I:
                            posicionScore += rotar(caballos)[7 - i][7 - j];
                        break;
                            
                        case Board.B_TORRE_D:
                        case Board.B_TORRE_I:
                            posicionScore += rotar(torres)[7 - i][7 - j];
                        break;
                            
                        case Board.B_PEON1:
                        case Board.B_PEON2:
                        case Board.B_PEON3:
                        case Board.B_PEON4:
                        case Board.B_PEON5:
                        case Board.B_PEON6:
                        case Board.B_PEON7:
                        case Board.B_PEON8:
                            posicionScore += rotar(peones)[7 - i][7 - j];
                        break;
                    }
                }                
            }
        }
        return posicionScore;
    }

    private int evaluarRey(Board b, boolean white)
    {
        int movilidadScore = 0;
        Position p;
        if(white)
            p = b.getBRey();
        else
            p = b.getNRey();
        
        if(!esSeguro(p, b, white))
        {
            if(jaquemate(b, white))
                movilidadScore = -200000;
            else
                movilidadScore = -100000;
        }
        return movilidadScore;
    }
    
    public boolean jaquemate(Board b, boolean white)
    {
        ArrayList<Position> movesRey;
        Position p;
        if(white)
        {
            p = b.getBRey();
            movesRey = new ArrayList<>();
            rey.getMoves(b, p, movesRey, white);

            for(int i = 0; i < movesRey.size(); i++)
                if(esSeguro(movesRey.get(i), b, white))
                    return false;
            return true;
        }
        else
        {
            p = b.getNRey();
            movesRey = new ArrayList<>();
            rey.getMoves(b, p, movesRey, white);

            for(int i = 0; i < movesRey.size(); i++)
                if(esSeguro(movesRey.get(i), b, white))
                    return false;
            return true;
        }
    }

    private int evaluarAtaques(Board b, boolean white)
    {
        int attackScore = 0;
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(white)
                {
                    if(!esSeguro(new Position(i,j), b, white))
                    {
                        switch(b.board[i][j])
                        {
                            case Board.B_REYNA:
                                    attackScore -= 450;
                            break;

                            case Board.B_ALFIL_D:
                            case Board.B_ALFIL_I:
                                attackScore -= 150;
                            break;

                            case Board.B_CABALLO_D:
                            case Board.B_CABALLO_I:
                                attackScore -= 150;
                            break;

                            case Board.B_TORRE_D:
                            case Board.B_TORRE_I:
                                attackScore -= 250;
                            break;

                            case Board.B_PEON1:
                            case Board.B_PEON2:
                            case Board.B_PEON3:
                            case Board.B_PEON4:
                            case Board.B_PEON5:
                            case Board.B_PEON6:
                            case Board.B_PEON7:
                            case Board.B_PEON8:
                                attackScore -= 50;
                            break;
                        }
                    }
                }
                else
                {
                    if(!esSeguro(new Position(i,j), b, white))
                    {
                        switch(b.board[i][j])
                        {
                            case Board.N_REYNA:
                                    attackScore -= 450;
                            break;

                            case Board.N_ALFIL_D:
                            case Board.N_ALFIL_I:
                                attackScore -= 150;
                            break;

                            case Board.N_CABALLO_D:
                            case Board.N_CABALLO_I:
                                attackScore -= 150;
                            break;

                            case Board.N_TORRE_D:
                            case Board.N_TORRE_I:
                                attackScore -= 250;
                            break;

                            case Board.N_PEON1:
                            case Board.N_PEON2:
                            case Board.N_PEON3:
                            case Board.N_PEON4:
                            case Board.N_PEON5:
                            case Board.N_PEON6:
                            case Board.N_PEON7:
                            case Board.N_PEON8:
                                attackScore -= 50;
                            break;
                        }
                    }
                }
            }
        }
        return attackScore;
    }
      
    private int[][] rotar(int[][] tabla)
    {
        int[][] nuevo = new int[8][8];
        int[][] temp;
        temp = tabla.clone();
        
        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++)
                nuevo[i][j] = temp[7 - i][7 - j];
        return nuevo;
    }
}
