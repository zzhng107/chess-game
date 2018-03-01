package chesspieces;

import main.chesspieces.Chessman;
import main.chesspieces.Pawn;
import main.game.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PawnTest {

    @Test
    void validTrack() {
        Chessman pawn = Game.board.getTile(new int[]{0,1}).getChessman();

        //non-valid move
        pawn.move(new int[]{7, 7});
        assertArrayEquals(new int[]{0, 1}, pawn.position);
        //non-valid move
        pawn.move(new int[]{1, 2});
        assertArrayEquals(new int[]{0, 1}, pawn.position);
        //valid empty
        pawn.move(new int[]{0, 3});
        assertArrayEquals(new int[]{0, 3}, pawn.position);
        //valid empty
        pawn.move(new int[]{0, 4});
        assertArrayEquals(new int[]{0, 4}, pawn.position);
        //valid enemy
        Chessman blackPawn = new Pawn(Game.side.BLACK, new int[]{1, 5});
        Game.board.getTile(new int[]{1, 5}).occupy(blackPawn);
        pawn.move(new int[]{1, 5});
        assertArrayEquals(new int[]{1, 5}, pawn.position);
        assertEquals(false, blackPawn.live);


        Chessman pawn_b = Game.board.getTile(new int[]{2, 6}).getChessman();

        pawn_b.move(new int[]{2, 4});
        assertArrayEquals(new int[]{2, 4}, pawn_b.position);

        pawn_b.move(new int[]{1, 3});
        assertArrayEquals(new int[]{2, 4}, pawn_b.position);

        pawn_b.move(new int[]{2, 3});
        assertArrayEquals(new int[]{2, 3}, pawn_b.position);

        pawn_b.move(new int[]{2, 2});
        assertArrayEquals(new int[]{2, 2}, pawn_b.position);

        pawn_b.move(new int[]{2, 1});
        assertArrayEquals(new int[]{2, 2}, pawn_b.position);

        pawn_b.move(new int[]{1, 1});
        assertArrayEquals(new int[]{1, 1}, pawn_b.position);

    }
}