package chesspieces;

import main.chesspieces.Chessman;
import main.chesspieces.Pawn;
import main.game.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PawnTest {

    @Test
    void move() {
        Chessman pawn = Game.board.getTile(new int[]{0,1}).getChessman();

        //not valid empty
        pawn.move(new int[]{1, 2});
        assertArrayEquals(new int[]{0, 1}, pawn.position);

        //not valid enemy
        pawn.move(new int[]{7, 7});
        assertArrayEquals(new int[]{0, 1}, pawn.position);

        //valid empty
        pawn.move(new int[]{0, 2});
        assertArrayEquals(new int[]{0, 2}, pawn.position);

        //valid empty
        pawn.move(new int[]{0, 3});
        assertArrayEquals(new int[]{0, 3}, pawn.position);

        //valid enemy
        Chessman blackPawn = new Pawn(Game.side.BLACK, new int[]{1, 4});
        Game.board.getTile(new int[]{1, 4}).occupy(blackPawn);
        pawn.move(new int[]{1, 4});
        assertArrayEquals(new int[]{1, 4}, pawn.position);
        assertEquals(false, blackPawn.live);
    }

    @Test
    void validTrack() {
    }
}