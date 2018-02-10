//x (position[0]), y (position[1]) oriented

package main.game;

import main.chesspieces.Chessman;
import main.chesspieces.Pawn;
import main.gameboard.Board;

public class Game {
    public static final String invalidMove = "You cannot move here";
    public enum side {WHITE, BLACK};
    public static final int boardWidth = 8;
    public static final int boardHeight = 8;
    public static Board board = new Board();
    private static int turn = 0;
    public static Player[] player = new Player[2];

    static{
        player[0] = new Player(side.WHITE);
        player[1] = new Player(side.BLACK);
        player[0].pieces = board.getList(player[0].side);
        player[1].pieces = board.getList(player[1].side);
    }

//    public static void main(String args[]) throws IOException {
//
//        Scanner scanner = new Scanner(System.in);
//        Chessman[] kings = new King[2];
//        kings[0] = board.getTile(new int[]{4, 0}).getChessman();
//        kings[1] = board.getTile(new int[]{4, 7}).getChessman();
//        int x, y, to_x, to_y;
//        while(true){
//            int thisTurn = turn%2;
//            do{
//                System.out.print("Enter x value of the piece you want to move: ");
//                x = scanner.nextInt();
//                System.out.print("Enter y value of the piece you want to move: ");
//                y = scanner.nextInt();
//                System.out.print("Enter x value of the tile you want to move: ");
//                to_x = scanner.nextInt();
//                System.out.print("Enter y value of the tile you want to move: ");
//                to_y = scanner.nextInt();
//            }while(!Game.board.getTile(new int[]{x, y}).getChessman().move(new int[]{to_x, to_y}));
//
//            board.resetCheck(player[thisTurn].side);
//            updateBannedTile(thisTurn);
//            turn++;
//
//            if(kings[thisTurn].checkMate()){
//                System.out.println(format("%s loses", kings[thisTurn].side.toString()));
//                break;
//            }
//        }
//
//    }

    //update the banned tile for a king to move to
    public static void updateBannedTile(int turn){
        int thisTurn = (turn+1)%2;
        for(Chessman piece:player[thisTurn].pieces){
            if(piece.live){
                if(piece instanceof Pawn){
                    int x = piece.position[0];
                    int y = piece.position[1];

                    if(player[thisTurn].side == side.WHITE){
                        if(y+1<=7 && x+1<=7) board.getTile(new int[]{x+1, y+1}).setDangerous(side.WHITE);
                        if(y+1<=7 && x-1>=0) board.getTile(new int[]{x-1, y+1}).setDangerous(side.WHITE);
                    }else{
                        if(y-1>=0 && x+1<=7) board.getTile(new int[]{x+1, y-1}).setDangerous(side.BLACK);
                        if(y-1>=0 && x-1>=0) board.getTile(new int[]{x-1, y-1}).setDangerous(side.BLACK);
                    }
                }else{
                    for(int x=0; x<boardWidth; x++){
                        for(int y=0; y<boardHeight; y++){
                            if(piece.validCheck(new int[]{x, y})){
                                board.getTile(new int[]{x, y}).setDangerous(player[thisTurn].side);
                            }
                        }
                    }
                }
            }
        }
    }


}
