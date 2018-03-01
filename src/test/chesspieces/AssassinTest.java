package chesspieces;

import main.chesspieces.Assassin;
import main.chesspieces.Chessman;
import main.chesspieces.Rook;
import main.game.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AssassinTest {
    @Test
    void validTrack(){

        Game.updateBannedTile(0);
        Chessman assassin = new Assassin(Game.side.BLACK, new int[]{4, 4});
        Chessman rook = new Rook(Game.side.WHITE, new int[]{0, 5});
        rook.occupy(rook.position);

        assassin.move(new int[]{1, 4});
        assertArrayEquals(new int[]{1, 4}, assassin.position);

        assassin.move(new int[]{3, 5});
        assertArrayEquals(new int[]{1, 4}, assassin.position);

        assassin.move(new int[]{0, 5});
        assertArrayEquals(new int[]{0, 5}, assassin.position);
    }
}
