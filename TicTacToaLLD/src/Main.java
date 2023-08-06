import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Board board = new Board(3);
        Deque<Player> queue = new LinkedList<>();
        queue.add(new Player("Aman",Type.O));
        queue.add(new Player("Priyanshu",Type.X));
      //  board.printBoard();
        Scanner s = new Scanner(System.in);
        for (int i = 0 ; i < 3 * 3 ; i++){
            Player player = queue.poll();
            System.out.println(player.getName() +" 's Turn");
            board.printBoard();
            System.out.println("Enter Row");
            int row = s.nextInt();
            System.out.println("Enter Col");
            int col = s.nextInt();
            boolean isValid = board.isValidMove(row,col);
            if(!isValid){
                System.out.println("Wrong Position !!  Enter Again");
                i--;
                queue.addFirst(player);
            }
            else {
                boolean isWinner = board.makeMove(row,col,player);
                if(isWinner){
                    board.printBoard();
                    System.out.println(player.getName() +" Won The Game");
                    return;
                }
                queue.addLast(player);
            }
        }



    }
}