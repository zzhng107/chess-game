package main.chesspieces;

import main.game.Game;

//subclass for a rook
public class Rook extends Chessman{
    //super class constructor
    public Rook(Game.side side, int[] position){
        super(side, position);
    }

    @Override
    boolean validTrack(int[] position) {
        if(position[0] == this.position[0]){
            if(position[1] > this.position[1]){
                for(int i=this.position[1]+1; i<position[1]; i++){
                    if(!checkEmpty(new int[]{position[0], i}))return false;
                }
            }else{
                for(int i=position[1]+1; i<this.position[1]; i++){
                    if(!checkEmpty(new int[]{position[0], i}))return false;
                }
            }
            return true;
        }else if(position[1] == this.position[1]){
            if(position[0] > this.position[0]){
                for(int i=this.position[0]+1; i<position[0]; i++){
                    if(!checkEmpty(new int[]{i, position[1]}))return false;
                }
            }else{
                for(int i=position[0]+1; i<this.position[0]; i++){
                    if(!checkEmpty(new int[]{i, position[1]}))return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }


}
