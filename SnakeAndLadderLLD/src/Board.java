import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] board;
    public Board(int dimension,int noOfSnakes,int noOfLadders) {
        createBoard(dimension);
        addSnakeAndLadder(noOfLadders,noOfSnakes,dimension);
    }

    private void addSnakeAndLadder(int noOfLadders, int noOfSnakes,int dimension) {
        for (int i = 0 ;i  < noOfLadders ; i++){
            int ladderStart = ThreadLocalRandom.current().nextInt(0,getBorardLastPosition()-dimension);
            int ladderEnd = ThreadLocalRandom.current().nextInt(ladderStart,getBorardLastPosition());
            board[ladderStart/dimension][ladderStart%dimension].setStartPosition(ladderStart);
            board[ladderStart/dimension][ladderStart%dimension].setEndPosition(ladderEnd);
            board[ladderStart/dimension][ladderStart%dimension].setHasSnakeOrLadder(true);
            System.out.println(board[ladderStart/dimension][ladderStart%dimension].getStartPosition() +" "+board[ladderStart/dimension][ladderStart%dimension].getEndPosition());
        }
        for (int i = 0 ;i  < noOfSnakes ; i++){
            int snakeStart = ThreadLocalRandom.current().nextInt(1,getBorardLastPosition());
            int snakeEnd = ThreadLocalRandom.current().nextInt(0,snakeStart);
            board[snakeStart/dimension][snakeStart%dimension].setStartPosition(snakeStart);
            board[snakeStart/dimension][snakeStart%dimension].setEndPosition(snakeEnd);
            board[snakeStart/dimension][snakeStart%dimension].setHasSnakeOrLadder(true);
        }
    }

    private void createBoard(int dimension) {
        board = new Cell[dimension][dimension];
        for(int i = 0 ; i < dimension ; i++){
            for(int j = 0 ;j < dimension ;j++)
                board[i][j] = new Cell();
        }
    }

    public int getBorardLastPosition() {
        return board.length * board.length - 1;
    }

    public Cell getCell(int pos){
        return board[pos/board.length][pos%board.length];
    }
}
