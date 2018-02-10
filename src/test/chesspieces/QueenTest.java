package chesspieces;

import main.chesspieces.Chessman;
import main.chesspieces.Queen;
import main.game.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class QueenTest {

    @Test
    void validTrack() {

        Chessman queen = new Queen(Game.side.WHITE, new int[]{3, 3});

        //not valid empty
        queen.move(new int[]{1, 2});
        assertArrayEquals(new int[]{3, 3}, queen.position);

        //not valid enemy
        queen.move(new int[]{7, 7});
        assertArrayEquals(new int[]{3, 3}, queen.position);

        //valid empty
        queen.move(new int[]{2, 2});
        assertArrayEquals(new int[]{2, 2}, queen.position);

        //valid enemy
        Chessman blackPawn = Game.board.getTile(new int[]{6, 6}).getChessman();
        queen.move(new int[]{6, 6});
        assertArrayEquals(new int[]{6, 6}, queen.position);
        assertEquals(false, blackPawn.live);
    }
}