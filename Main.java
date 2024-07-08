import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("The snake is facing right initially");
        System.out.println("Enter r - right l - left d - down u - up");
        GameManager.initialize();
        Board.print();
        while (true)
        {
            char ch = in.next().charAt(0);
            boolean isValidMove = GameManager.moveSnakeTo(ch);
            if (!isValidMove){
                break;
            }
        }
        GameManager.printScore();
    }
}