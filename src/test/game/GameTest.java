package game;

import main.chesspieces.Chessman;
import main.chesspieces.King;
import main.chesspieces.Pawn;
import main.game.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    @Test
    void updateBannedTile() {
        Chessman king = new King(Game.side.WHITE, new int[]{3, 3});
        Chessman blackPawn = new Pawn(Game.side.BLACK, new int[]{3, 4});
        Game.board.getTile(new int[]{3, 4}).occupy(blackPawn);
        Game.player[1].pieces.add(blackPawn);
        Game.updateBannedTile(0);//White first
        king.move(new int[]{2, 3});
        assertArrayEquals(new int[]{3, 3}, king.position);
        assertEquals(true, king != Game.board.getTile(new int[]{0, 0}).getChessman());
    }
}