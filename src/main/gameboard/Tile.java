package main.gameboard;

import main.chesspieces.Chessman;
import main.game.Game;

public class Tile {

    private Chessman chessman;
    private boolean dangerousWhite;
    private boolean dangerousBlack;

    //constructor
    Tile(){
        chessman = null;
        dangerousWhite = false;
        dangerousBlack = false;
    }

    //reset a tile's check status for a specific side
    public void resetDangerous(Game.side side){
        if(side == Game.side.WHITE){
            this.dangerousWhite = false;
        }else{
            this.dangerousBlack = false;
        }
    }

    //set a tile's check status to true for a specific side
    public void setDangerous(Game.side side){
        if(side == Game.side.WHITE){
            this.dangerousBlack = true;
        }else{
            this.dangerousWhite = true;
        }
    }

    //find whether a tile is dangerous for king's movement of one side
    public boolean isDangerous(Game.side side){
        if(side == Game.side.WHITE){
            return this.dangerousWhite;
        }else{
            return this.dangerousBlack;
        }
    }

    //set the chess piece that the tile is pointing to
    public void occupy(Chessman chessman){
        this.chessman = chessman;
    }

    //get the chess piece currently on the tile
    public Chessman getChessman() {
        return this.chessman;
    }



}
