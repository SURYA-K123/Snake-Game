import javax.swing.border.Border;
import java.util.Random;

public class GameManager {
    static int score = 0;
    static char prev = 'r';
    static Random random = new Random();

    public static void initialize(){
        Board.setInitialValues();
        int eggRow = random.nextInt(0,9);
        int eggCol = random.nextInt(0,9);
        Board.setEggPosition(eggRow, eggCol);

        int snakeRow = random.nextInt(1,9);
        int snakeCol = random.nextInt(1,9);
        while (snakeRow!= eggRow && snakeCol!=eggCol){
            snakeRow = random.nextInt(1,9);
            snakeCol = random.nextInt(1,9);
        }
        Board.setSnakeHead(snakeRow, snakeCol);
        Snake.grow(snakeRow*10 + snakeCol);
    }

    public static void findNewEggPosition(){
        int eggRow = random.nextInt(0,9);
        int eggCol = random.nextInt(0,9);
        Board.setEggPosition(eggRow, eggCol);
    }

    public static boolean moveSnakeTo(char ch){
        if(ch == 'r'){
            if(prev == 'l'){
                System.out.println("Invalid move Because snake is facing left");
                return true;
            }
            else {
                boolean isValidMove = Snake.moveRight();
                if (!isValidMove) {
                    return false;
                }
            }
        } else if (ch == 'l') {
            if(prev == 'r'){
                System.out.println("Invalid move Because snake is facing right");
                return true;
            }
            else {
                boolean isValidMove = Snake.moveLeft();
                if (!isValidMove) {
                    return false;
                }
            }
        } else if (ch == 'u') {
            if(prev == 'd'){
                System.out.println("Invalid move Because snake is facing down");
                return true;
            }
            else {
                boolean isValidMove = Snake.moveUp();
                if (!isValidMove) {
                    return false;
                }
            }
        }else if (ch == 'd') {
            if(prev == 'u'){
                System.out.println("Invalid move Because snake is facing up");
                return true;
            }
            else {
                boolean isValidMove = Snake.moveDown();
                if (!isValidMove) {
                    return false;
                }
            }
        }
        Board.print();
        prev = ch;
        return true;
    }
    public static void incrementScore(){
        score++;
    }

    public static void printScore(){
        System.out.println("Your score is "+score);
    }
}
