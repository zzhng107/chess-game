package chesspieces;

import main.chesspieces.Bishop;
import main.chesspieces.Chessman;
import main.game.Game;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BishopTest {

    @Test
    void validTrack() {
        Chessman bishop = new Bishop(Game.side.WHITE, new int[]{3, 3});
        bishop.move(new int[]{8, 8});
        assertArrayEquals(new int[]{3, 3}, bishop.position);
        assertEquals(false, Arrays.equals(bishop.position, new int[]{8, 8}));
        bishop.move(new int[]{0, 0});
        assertArrayEquals(new int[]{3, 3}, bishop.position);
        assertEquals(true, bishop != Game.board.getTile(new int[]{0, 0}).getChessman());
        bishop.move(new int[]{7, 7});
        assertArrayEquals(new int[]{3, 3}, bishop.position);
        assertEquals(true, bishop != Game.board.getTile(new int[]{7, 7}).getChessman());
        bishop.move(new int[]{0, 1});
        assertArrayEquals(new int[]{3, 3}, bishop.position);

        bishop.move(new int[]{5, 5});
        assertArrayEquals(new int[]{5, 5}, bishop.position);
        bishop.move(new int[]{3, 3});
        assertArrayEquals(new int[]{3, 3}, bishop.position);
        bishop.move(new int[]{1, 5});
        assertArrayEquals(new int[]{1, 5}, bishop.position);
        bishop.move(new int[]{3, 3});
        assertArrayEquals(new int[]{3, 3}, bishop.position);

        Chessman blackPawn = Game.board.getTile(new int[]{6, 6}).getChessman();
        bishop.move(new int[]{6, 6});
        assertArrayEquals(new int[]{6, 6}, bishop.position);
        assertEquals(bishop, Game.board.getTile(new int[]{6, 6}).getChessman());
        assertEquals(false, blackPawn.live);
        bishop.move(new int[]{3, 3});
        assertArrayEquals(new int[]{3, 3}, bishop.position);
    }

}