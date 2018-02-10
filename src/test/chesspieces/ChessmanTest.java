package chesspieces;

import main.chesspieces.Chessman;
import main.chesspieces.Rook;
import main.game.Game;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ChessmanTest {

    @org.junit.jupiter.api.Test
    void power() {
        assertEquals(9, Chessman.power(3));
        assertEquals(9, Chessman.power(-3));
    }

    @org.junit.jupiter.api.Test
    void checkEmpty() {
        Chessman chessman = Game.board.getTile(new int[]{0, 0}).getChessman();
        assertEquals(false, chessman.checkEmpty(new int[]{0, 0}));
        assertEquals(true, chessman.checkEmpty(new int[]{3, 3}));
    }


    @org.junit.jupiter.api.Test
    void checkAlly(){
        Chessman chessman = Game.board.getTile(new int[]{0, 0}).getChessman();
        assertEquals(true, chessman.checkAlly(new int[]{0, 0}));
        assertEquals(false, chessman.checkAlly(new int[]{7, 7}));
        assertEquals(false, chessman.checkAlly(new int[]{3, 3}));
    }

    @org.junit.jupiter.api.Test
    void inBoard(){
        assertEquals(true, Chessman.inBoard(new int[]{0, 0}));
        assertEquals(false, Chessman.inBoard(new int[]{8, 8}));
        assertEquals(false, Chessman.inBoard(new int[]{-1, -1}));
    }


    @org.junit.jupiter.api.Test
    void occupy() {
        Chessman rook = Game.board.getTile(new int[]{0, 0}).getChessman();
        Chessman rook2 = Game.board.getTile(new int[]{7, 0}).getChessman();
        rook.occupy(rook2.position);
        assertEquals(rook.position, rook2.position);
        assertEquals(rook, Game.board.getTile(new int[]{7, 0}).getChessman());
    }

    @org.junit.jupiter.api.Test
    void validCheck() {
        Chessman rook = new Rook(Game.side.WHITE, new int[]{3, 3});
        assertEquals(false, rook.validMove(new int[]{0, 0}));
        assertEquals(false, rook.validMove(new int[]{3, 1}));
        assertEquals(true, rook.validMove(new int[]{3, 4}));
        assertEquals(true, rook.validMove(new int[]{4, 3}));
        assertEquals(true, rook.validMove(new int[]{3, 6}));
        assertEquals(false, rook.validMove(new int[]{3, 7}));
        assertEquals(false, rook.validMove(new int[]{8, 8}));
    }

    @org.junit.jupiter.api.Test
    void side() {
        Chessman rook = new Rook(Game.side.WHITE, new int[]{3, 3});
        assertEquals(true, Game.side.WHITE == rook.side);
        assertEquals(false, Game.side.BLACK == rook.side);
    }

    @org.junit.jupiter.api.Test
    void live() {
        Chessman rook = new Rook(Game.side.WHITE, new int[]{0, 5});
        Game.board.getTile(rook.position).occupy(rook);
        assertEquals(true, rook.live);
        Game.board.getTile(new int[]{1, 6}).getChessman().move(rook.position);
        assertEquals(false, rook.live);

    }

    @org.junit.jupiter.api.Test
    void validMove() {
        //reuse of function with just different name in Chessman
        validCheck();
    }

    @org.junit.jupiter.api.Test
    void checkEnemy() {
        Chessman chessman = Game.board.getTile(new int[]{0, 0}).getChessman();
        assertEquals(false, chessman.checkEnemy(new int[]{0, 0}));
        assertEquals(true, chessman.checkEnemy(new int[]{7, 7}));
        assertEquals(false, chessman.checkEnemy(new int[]{3, 3}));
    }

    @org.junit.jupiter.api.Test
    void eat() {
        Chessman pawn = Game.board.getTile(new int[]{0, 0}).getChessman();
        Chessman whiteKing = Game.board.getTile(new int[]{4, 0}).getChessman();
        pawn.eat(new int[]{4, 0});
        assertEquals(false, whiteKing.live);
        assertArrayEquals(new int[]{4, 0}, pawn.position);
        assertEquals(pawn, Game.board.getTile(new int[]{4, 0}).getChessman());
    }

    @org.junit.jupiter.api.Test
    void move() {
        Chessman rook = new Rook(Game.side.WHITE, new int[]{3, 3});
        rook.move(new int[]{8, 8});
        assertArrayEquals(new int[]{3, 3}, rook.position);
        assertEquals(false, Arrays.equals(rook.position, new int[]{8, 8}));
        rook.move(new int[]{0, 0});
        assertArrayEquals(new int[]{3, 3}, rook.position);
        assertEquals(true, rook != Game.board.getTile(new int[]{0, 0}).getChessman());
        rook.move(new int[]{3, 4});
        assertArrayEquals(new int[]{3, 4}, rook.position);
        assertEquals(rook, Game.board.getTile(new int[]{3, 4}).getChessman());
        Chessman blackPawn = Game.board.getTile(new int[]{3, 6}).getChessman();
        rook.move(new int[]{3, 6});
        assertArrayEquals(new int[]{3, 6}, rook.position);
        assertEquals(false, blackPawn.live);
    }

    @org.junit.jupiter.api.Test
    void checkMate(){
        Chessman king = Game.board.getTile(new int[]{4, 0}).getChessman();
        assertEquals(false, king.checkMate());

        Chessman blackRook0 = new Rook(Game.side.BLACK, new int[]{4, 1});
        Game.board.getTile(new int[]{4, 1}).occupy(blackRook0);
        Game.player[1].pieces.add(blackRook0);
        Chessman blackRook1 = new Rook(Game.side.BLACK, new int[]{5, 0});
        Game.board.getTile(new int[]{5, 0}).occupy(blackRook1);
        Game.player[1].pieces.add(blackRook1);
        Chessman blackRook2 = new Rook(Game.side.BLACK, new int[]{3, 0});
        Game.board.getTile(new int[]{3, 0}).occupy(blackRook2);
        Game.player[1].pieces.add(blackRook2);
        Chessman blackRook3 = new Rook(Game.side.BLACK, new int[]{4, 2});
        Game.board.getTile(new int[]{4, 2}).occupy(blackRook3);
        Game.player[1].pieces.add(blackRook3);

        Game.updateBannedTile(0);
        assertEquals(true, king.checkMate());
    }

    @org.junit.jupiter.api.Test
    void validTrack() {
        //abstract function to be tested in each subclass
    }
}