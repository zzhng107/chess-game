package chesspieces;

import main.chesspieces.Chessman;
import main.chesspieces.Xiang;
import main.game.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class XiangTest {

    @Test
    void validTrack(){
        Chessman xiang = new Xiang(Game.side.WHITE, new int[]{3, 3});

        xiang.move(new int[]{6, 6});
        assertArrayEquals(new int[]{6, 6}, xiang.position);
    }

}
