package main.chesspieces;

import main.game.Game;

//subclass for a knight
public class Knight extends Chessman{
    //super class constructor
    public Knight(Game.side side, int[] position){
        super(side, position);
    }


    @Override
    boolean validTrack(int[] position) {
        return power(position[0] - this.position[0]) + power(position[1] - this.position[1]) == 5;
    }
}
