package gameboard;

import main.game.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {

    @Test
    void getTile() {
        assertEquals(Game.board.board[1][1], Game.board.getTile(new int[]{1, 1}));
    }

    @Test
    void resetCheck() {
        Game.updateBannedTile(0);
        assertEquals(true, Game.board.getTile(new int[]{0, 5}).isDangerous(Game.side.WHITE));
        Game.board.resetCheck(Game.side.WHITE);
        assertEquals(false, Game.board.getTile(new int[]{0, 5}).isDangerous(Game.side.WHITE));

    }

    @Test
    void getList() {
        assertEquals(16, Game.player[0].pieces.size());
        assertEquals(16, Game.player[1].pieces.size());
    }
}