package chesspieces;

import main.chesspieces.Chessman;
import main.chesspieces.King;
import main.chesspieces.Pawn;
import main.game.Game;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KingTest {

    @Test
    void validTrack() {
        Chessman king = new King(Game.side.WHITE, new int[]{3, 3});
        Chessman blackPawn = new Pawn(Game.side.BLACK, new int[]{3, 4});
        Game.board.getTile(new int[]{3, 4}).occupy(blackPawn);
        Game.player[1].pieces.add(blackPawn);
        Game.updateBannedTile(0);//White first
        king.move(new int[]{2, 3});
        assertArrayEquals(new int[]{3, 3}, king.position);
        assertEquals(true, king != Game.board.getTile(new int[]{0, 0}).getChessman());

        king.move(new int[]{8, 8});
        assertArrayEquals(new int[]{3, 3}, king.position);
        assertEquals(false, Arrays.equals(king.position, new int[]{8, 8}));

        king.move(new int[]{0, 0});
        assertArrayEquals(new int[]{3, 3}, king.position);
        assertEquals(true, king != Game.board.getTile(new int[]{0, 0}).getChessman());

        king.move(new int[]{7, 7});
        assertArrayEquals(new int[]{3, 3}, king.position);
        assertEquals(true, king != Game.board.getTile(new int[]{7, 7}).getChessman());

        king.move(new int[]{3, 4});
        assertArrayEquals(new int[]{3, 4}, king.position);
        assertEquals(king, Game.board.getTile(new int[]{3, 4}).getChessman());
        assertEquals(false, blackPawn.live);

        king.move(new int[]{3, 3});
        assertArrayEquals(new int[]{3, 3}, king.position);
        assertEquals(king, Game.board.getTile(new int[]{3, 3}).getChessman());
    }
}