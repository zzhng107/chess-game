package main.game;

import main.chesspieces.Chessman;

import java.util.List;

public class Player {

    public Game.side side;
    public List<Chessman> pieces;

    public Player(Game.side side){
        this.side = side;
    }


}
