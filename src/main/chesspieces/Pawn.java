package main.chesspieces;
import main.game.Game;
//subclass for a pawn
public class Pawn extends Chessman{
    //super class constructor
    public Pawn(Game.side side, int[] position) {
        super(side, position);
    }
    //move forward 1 function to deal with all situation that pawn move forward 1 tile horizontally
    private boolean forward1(int[] position) {
        if(Math.abs(this.position[0] - position[0]) == 1
                && checkEnemy(position)){
            return true;
        }else if(this.position[0] == position[0]
                && checkEmpty(position)){
            return true;
        }
        System.out.println(Game.invalidMove);
        return false;
    }

    @Override
    boolean validTrack(int[] position){
        if (this.side == Game.side.WHITE) {
            if (this.position[1] - position[1] == -1) {
                return forward1(position);
            } else if (this.position[1] - position[1] == -2
                    && this.position[0] == position[0]
                    && this.position[1] == 1
                    && checkEmpty(new int[]{this.position[0], this.position[1] + 1})
                    && checkEmpty(new int[]{this.position[0], this.position[1] + 2})) {
                return true;
            }

        } else {
            if (this.position[1] - position[1] == 1) {
                return forward1(position);
            } else if (this.position[1] - position[1] == 2
                    && this.position[0] == position[0]
                    && this.position[1] == Game.boardHeight - 1 - 1
                    && checkEmpty(new int[]{this.position[0], this.position[1] - 1})
                    && checkEmpty(new int[]{this.position[0], this.position[1] - 2})) {
                return true;
            }
        }

        System.out.println(Game.invalidMove);
        return false;
    }


}
