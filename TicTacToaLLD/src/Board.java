import java.util.Objects;

public class Board {

    private int dimension;
    private Cell[][] board;

    public Board(int dimension) {
        this.dimension = dimension;
        initilizeBoard();
    }

    private void initilizeBoard() {
        board = new Cell[dimension][dimension];
        for(int i = 0 ; i < dimension ;i++){
            for(int j = 0; j < dimension ;j++){
                board[i][j] = new Cell(Type.A);
            }
        }
    }

    public boolean isValidMove(int row,int col){
        if(row > dimension - 1 || col > dimension -1)
            return false;

        return board[row][col].getType() == Type.A;
    }

    public void printBoard(){

        for(int i = 0 ; i < dimension; i++){
            for(int j = 0 ; j < dimension ;j++){
                if(board[i][j].getType() != Type.A)
                    System.out.print(board[i][j].getType().name() +" | ");
                else
                    System.out.print("  |  ");
            }
            System.out.println();
        }
    }

    public boolean makeMove(int row,int col,Player player){

        board[row][col].setType(player.getType());
        return checkForWinner(row,col,player.type);
    }

    private boolean checkForWinner(int row, int col,Type type) {

        boolean winner = true;
        for(int i = 0 ; i < dimension ; i++){
            if (!board[row][i].getType().equals(type)) {
                winner = false;
                break;
            }
        }
        if(winner)
            return winner;
        winner = true;
        for(int i = 0 ; i < dimension ; i++){
            if (!board[i][col].getType().equals(type)) {
                winner = false;
                break;
            }
        }
        if(winner)
            return winner;

        winner = true;

        for(int i = 0 ; i < dimension ; i++){
            if (!board[i][i].getType().equals(type)) {
                winner = false;
                break;
            }
        }
        if(winner)
            return winner;
        winner = true;
        for(int i = dimension -1 ; i >= 0 ; i--){
            if (!board[i][i].getType().equals(type)) {
                winner = false;
                break;
            }
        }
        return winner;
    }

}
