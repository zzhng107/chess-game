package main.chesspieces;

import main.game.Game;

//subclass for a king
public class King extends Chessman{

    //Super class constructor
    public King(Game.side side, int[] position){
        super(side, position);
    }

    @Override
    boolean validTrack(int[] position){
        //TODO check "check spot"
        return (Math.abs(position[0]-this.position[0])==1 || Math.abs(position[0]-this.position[0])==0) && (Math.abs(position[1]-this.position[1])==1 || Math.abs(position[1]-this.position[1])==0) && Math.abs(position[0]-this.position[0])+Math.abs(position[1]-this.position[1])>=1 && !Game.board.getTile(position).isDangerous(this.side);
    }

}
