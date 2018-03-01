package main.chesspieces;

import main.game.Game;

public class Assassin extends Chessman{

    public Assassin(Game.side side, int[] position) {
        super(side, position);
    }

    private boolean enemyAround(int[] position){
        int x = position[0];
        int y = position[1];
        return this.checkEnemy(new int[]{x+1, y}) ||
                this.checkEnemy(new int[]{x+1, y+1}) ||
                this.checkEnemy(new int[]{x+1, y-1}) ||
                this.checkEnemy(new int[]{x-1, y}) ||
                this.checkEnemy(new int[]{x-1, y+1}) ||
                this.checkEnemy(new int[]{x-1, y-1}) ||
                this.checkEnemy(new int[]{x, y-1}) ||
                this.checkEnemy(new int[]{x, y+1});
    }

    @Override
    boolean validTrack(int[] position){
        return Game.board.getTile(position).getChessman() == null && !Game.board.getTile(position).isDangerous(this.side) && this.enemyAround(position) || ((Math.abs(position[0]-this.position[0])==1 || Math.abs(position[0]-this.position[0])==0) && (Math.abs(position[1]-this.position[1])==1 || Math.abs(position[1]-this.position[1])==0) && this.checkEnemy(position));
    }
}
