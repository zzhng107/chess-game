package gameboard;

import main.chesspieces.Chessman;
import main.chesspieces.Pawn;
import main.game.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TileTest {

    @Test
    void resetDangerous() {
        Game.updateBannedTile(0);
        assertEquals(true, Game.board.getTile(new int[]{0, 5}).isDangerous(Game.side.WHITE));
        Game.board.getTile(new int[]{0, 5}).resetDangerous(Game.side.WHITE);
        assertEquals(false, Game.board.getTile(new int[]{0, 5}).isDangerous(Game.side.WHITE));

    }

    @Test
    void setDangerous() {
        Game.board.getTile(new int[]{0, 5}).setDangerous(Game.side.BLACK);
        assertEquals(true, Game.board.getTile(new int[]{0, 5}).isDangerous(Game.side.WHITE));
    }

    @Test
    void isDangerous() {
        Game.updateBannedTile(0);
        assertEquals(true, Game.board.getTile(new int[]{0, 5}).isDangerous(Game.side.WHITE));
    }

    @Test
    void occupy() {
        Chessman pawn = new Pawn(Game.side.WHITE, new int[]{3, 3});
        Game.board.getTile(new int[]{3, 3}).occupy(pawn);
        assertEquals(pawn, Game.board.getTile(new int[]{3, 3}).getChessman());
    }

    @Test
    void getChessman() {
        Chessman pawn = new Pawn(Game.side.WHITE, new int[]{3, 3});
        Game.board.getTile(new int[]{3, 3}).occupy(pawn);
        assertEquals(pawn, Game.board.getTile(new int[]{3, 3}).getChessman());
    }
}