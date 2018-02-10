package main.chesspieces;

import main.game.Game;

//superclass for a general chess piece
public abstract class Chessman {

    public Game.side side;
    public boolean live;
    public int[] position;

    Chessman(Game.side side, int[] position){
        this.side = side;
        this.position = position;
        this.live = true;
    }

    //check whether the position moving to is in board
    public static boolean inBoard(int[] position){
        return position[0] >= 0 && position[0] <= 7 && position[1] >= 0 && position[1] <= 7;
    }

    //mark captured piece
    void die(){
        this.live = false;
    }

    //check whether the position is ally
    public boolean checkAlly(int[] position){
        return Game.board.getTile(position).getChessman() != null && Game.board.getTile(position).getChessman().side == this.side;
    }

    //simply implement int power
    public static int power(int a){
        return a*a;
    }

    //check whether the tile is empty
    public boolean checkEmpty(int[] position){
        return !checkAlly(position) && !checkEnemy(position);
    }

    //occupy the tile
    public void occupy(int[] position){
        this.position = position;
        Game.board.getTile(position).occupy(this);
    }

    //check whether the tile is a valid check tile for opponent's next run
    public boolean validCheck(int[] position){
        return validTrack(position);
    }

    //check whether the move is valid overall
    public boolean validMove(int[] position){
        return inBoard(position) && !checkAlly(position) && validTrack(position);
    }

    //check whether the position is enemy
    public boolean checkEnemy(int[] position){
        return Game.board.getTile(position).getChessman() != null && Game.board.getTile(position).getChessman().side != this.side;
    }

    //capture piece function
    public void eat(int[] position){
        Game.board.getTile(position).getChessman().die();
        this.position = position;
        Game.board.getTile(position).occupy(this);
    }

    //move function for chess piece except pawn to call
    public boolean move(int[] position) {
        if(!validMove(position)) {
            System.out.println(Game.invalidMove);
            return false;
        }

        if(checkEnemy(position)){
            eat(position);
        }else {
            occupy(position);
        }

        return true;
    }

    //check mate
    public boolean checkMate(){
        int x=this.position[0];
        int y=this.position[1];

        return
        !this.validMove(new int[]{x+1, y}) &&
        !this.validMove(new int[]{x+1, y+1}) &&
        !this.validMove(new int[]{x+1, y-1}) &&
        !this.validMove(new int[]{x-1, y}) &&
        !this.validMove(new int[]{x-1, y+1}) &&
        !this.validMove(new int[]{x-1, y-1}) &&
        !this.validMove(new int[]{x, y+1}) &&
        !this.validMove(new int[]{x, y-1}) &&
        Game.board.getTile(this.position).isDangerous(this.side);
    }

    //abstract class to be overridden by all chessman subclass
    //check whether the destination is valid specific to the piece
    abstract boolean validTrack(int[] position);

}
