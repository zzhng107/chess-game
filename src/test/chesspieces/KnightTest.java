package chesspieces;

import main.chesspieces.Chessman;
import main.chesspieces.Pawn;
import main.game.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KnightTest {

    @Test
    void validTrack() {
        Chessman knight = Game.board.getTile(new int[]{1, 0}).getChessman();

        //not valid empty
        knight.move(new int[]{1, 2});
        assertArrayEquals(new int[]{1, 0}, knight.position);

        //not valid enemy
        knight.move(new int[]{7, 7});
        assertArrayEquals(new int[]{1, 0}, knight.position);

        //valid empty
        knight.move(new int[]{2, 2});
        assertArrayEquals(new int[]{2, 2}, knight.position);

        //valid enemy
        Chessman blackPawn = new Pawn(Game.side.BLACK, new int[]{1, 0});
        Game.board.getTile(new int[]{1, 0}).occupy(blackPawn);
        knight.move(new int[]{1, 0});
        assertArrayEquals(new int[]{1, 0}, knight.position);
        assertEquals(false, blackPawn.live);
    }
}