package main.gameboard;

import main.chesspieces.*;
import main.game.Game;

import java.util.ArrayList;
import java.util.List;

import static main.game.Game.boardHeight;
import static main.game.Game.boardWidth;

public class Board {

    public Tile[][] board = new Tile[boardWidth][boardHeight];

    //constructor for the initial state of board
    public Board(){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                board[i][j] = new Tile();
            }
        }

        //for pawn
        for(int i=0; i<8; i++){
            board[i][1].occupy(new Pawn(Game.side.WHITE, new int[]{i, 1}));
            board[i][6].occupy(new Pawn(Game.side.BLACK, new int[]{i, 6}));
        }

        //White others
        board[0][0].occupy(new Rook(Game.side.WHITE, new int[]{0, 0}));
        board[7][0].occupy(new Rook(Game.side.WHITE, new int[]{7, 0}));

        board[1][0].occupy(new Knight(Game.side.WHITE, new int[]{1, 0}));
        board[6][0].occupy(new Knight(Game.side.WHITE, new int[]{6, 0}));

        board[2][0].occupy(new Bishop(Game.side.WHITE, new int[]{2, 0}));
        board[5][0].occupy(new Bishop(Game.side.WHITE, new int[]{5, 0}));

        board[3][0].occupy(new Queen(Game.side.WHITE, new int[]{3, 0}));
        board[4][0].occupy(new King(Game.side.WHITE, new int[]{4, 0}));

        //Black others
        board[7][7].occupy(new Rook(Game.side.BLACK, new int[]{7, 7}));
        board[0][7].occupy(new Rook(Game.side.BLACK, new int[]{0, 7}));

        board[1][7].occupy(new Knight(Game.side.BLACK, new int[]{1, 7}));
        board[6][7].occupy(new Knight(Game.side.BLACK, new int[]{6, 7}));

        board[2][7].occupy(new Bishop(Game.side.BLACK, new int[]{2, 7}));
        board[5][7].occupy(new Bishop(Game.side.BLACK, new int[]{5, 7}));

        board[3][7].occupy(new Queen(Game.side.BLACK, new int[]{3, 7}));
        board[4][7].occupy(new King(Game.side.BLACK, new int[]{4, 7}));

    }

    //return a specific tile on the board
    public Tile getTile(int[] position){
        return board[position[0]][position[1]];
    }

    //reset check tile for a specific side
    public void resetCheck(Game.side side){
        for(int x=0; x<boardWidth; x++){
            for(int y=0; y<boardHeight; y++){
                board[x][y].resetDangerous(side);
            }
        }
    }

    //get the list of chess pieces for a specific side currently on board
    public List<Chessman> getList(Game.side side){
        List<Chessman> out = new ArrayList<Chessman>();
        for(int x=0; x<boardWidth; x++){
            for(int y=0; y<boardHeight; y++){
                if(board[x][y].getChessman() != null && board[x][y].getChessman().side == side){
                    out.add(board[x][y].getChessman());
                }
            }
        }
        return out;
    }


}
