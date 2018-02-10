package main.chesspieces;

import main.game.Game;

import java.util.Arrays;

//subclass for a pawn
public class Pawn extends Chessman{
    //super class constructor
    public Pawn(Game.side side, int[] position) {
        super(side, position);
    }

    //move forward 1 function to deal with all situation that pawn move forward 1 tile horizontally
    private void forward1(int[] position) {
        if(Math.abs(this.position[0] - position[0]) == 1
                && checkEnemy(position)){
            //TODO remove chessman from players piece list
            eat(position);
        }else if(this.position[0] == position[0]
                && checkEmpty(position)){
            occupy(position);
        }else{
            System.out.println(Game.invalidMove);
        }
    }

    //Override regular move cuz eat and occupy is different from other pieces
    @Override
     public boolean move(int[] position){
        if(!validMove(position) || Arrays.equals(this.position, position)) {
            System.out.println(Game.invalidMove);
            return false;
        }

        if (this.side == Game.side.WHITE) {
            if (this.position[1] - position[1] == -1) {
                forward1(position);
            } else if (this.position[1] - position[1] == -2
                    && this.position[0] == position[0]
                    && this.position[1] == 1
                    && checkEmpty(new int[]{this.position[0], this.position[1] + 1})
                    && checkEmpty(new int[]{this.position[0], this.position[1] + 2})) {
                occupy(position);
            } else {
                System.out.println(Game.invalidMove);
                return false;
            }

        } else {

            if (this.position[1] - position[1] == 1) {
                forward1(position);
            } else if (this.position[1] - position[1] == 2
                    && this.position[0] == position[0]
                    && this.position[1] == Game.boardHeight - 1 - 1
                    && checkEnemy(new int[]{this.position[0], this.position[1] - 1})
                    && checkEnemy(new int[]{this.position[0], this.position[1] - 2})) {
                occupy(position);
            } else {
                System.out.println(Game.invalidMove);
                return false;
            }
        }
        return true;
    }

    //not used actually
    @Override
    boolean validTrack(int[] position){
        return true;
    }


}
