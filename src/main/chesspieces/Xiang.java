package main.chesspieces;

import main.game.Game;

public class Xiang extends Chessman{
    //super class constructor
    public Xiang(Game.side side, int[] position){ super(side, position);}

    @Override
    boolean validTrack(int[] position){

        return Math.abs(position[0] - this.position[0]) == Math.abs(position[1]) - this.position[1]
                && Math.abs(position[0] - this.position[0]) == 3;

    }
}
