package chesspieces;

import main.chesspieces.Chessman;
import main.chesspieces.Rook;
import main.game.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RookTest {

    @Test
    void validTrack() {
        Chessman rook = new Rook(Game.side.WHITE, new int[]{3, 3});

        //not valid empty
        rook.move(new int[]{4, 4});
        assertArrayEquals(new int[]{3, 3}, rook.position);

        //not valid enemy
        rook.move(new int[]{7, 7});
        assertArrayEquals(new int[]{3, 3}, rook.position);

        //valid empty
        rook.move(new int[]{3, 4});
        assertArrayEquals(new int[]{3, 4}, rook.position);

        //valid enemy
        Chessman blackPawn = Game.board.getTile(new int[]{3, 6}).getChessman();
        rook.move(new int[]{3, 6});
        assertArrayEquals(new int[]{3, 6}, rook.position);
        assertEquals(false, blackPawn.live);
    
    }
}