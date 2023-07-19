import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {

    Board board;
    Dice dice;
    Queue<Player> players;
    Player winner;

    public Game(){
        initializeGame();
    }

    private void initializeGame() {
        board = new Board(10,0,5);
        dice = new Dice(1,1,15);
        winner = null;
        addPlayers();
    }

    private void addPlayers() {
        Player player1 = new Player(1,"Priyanshu",0);
        Player player2 = new Player(2,"Aman",0);
        players = new LinkedList<>();
        players.add(player1);
        players.add(player2);
    }

    public void startGame(){

        while(winner == null){

            Player player = players.poll();
            Scanner scanner = new Scanner(System.in);
            System.out.println(player.getName()+"'s turn Pos is : "+player.getPosition());
            String c = scanner.nextLine();
            int value = dice.roll();
            value = getValidPosition(value,player.getPosition());
            player.setPosition(value);

            if(player.getPosition() >= board.getBorardLastPosition()){
                winner = player;
            }
            players.add(player);
        }
        System.out.println("WINNER IS : "+winner.getName());
    }

    private int getValidPosition(int value, int position) {

        if(value + position <= board.getBorardLastPosition()) {
            Cell cell = board.getCell(value + position);
            if (cell.hasSnakeOrLadder()) {
                return cell.getEndPosition();
            } else
                return position + value;
        }
        return position;
    }

}
