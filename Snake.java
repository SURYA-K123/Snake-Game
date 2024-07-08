import java.util.LinkedList;
import java.util.Queue;

public class Snake {
    private static Queue<Integer> snake = new LinkedList<>();

    public static void grow(int num){
        snake.add(num);
    }
    public static boolean moveRight(){
        int arr[] = Board.getSnakeHeadLocation();
        if(arr[1]+1 > 9 || Board.getLocationValue(arr[0], arr[1]+1) == 'X'){
            System.out.println("Game Over");
            return false;
        }
        if(Board.getLocationValue(arr[0], arr[1]+1) == 'E'){
            GameManager.incrementScore();
            Board.deletePosition(arr[0],arr[1]+1);
            GameManager.findNewEggPosition();
            Board.setSnakeBody(arr[0],arr[1]);
            Board.setSnakeHead(arr[0], arr[1]+1);
            snake.add(arr[0]*10+(arr[1]+1));
            return true;
        }
        int pos = snake.poll();
        Board.deletePosition(pos/10, pos%10);
        if(snake.size() > 0){
            Board.setSnakeBody(arr[0],arr[1]);
        }
        Board.setSnakeHead(arr[0], arr[1]+1);
        snake.add(arr[0]*10+(arr[1]+1));
        return true;
    }
    public static boolean moveLeft(){
        int arr[] = Board.getSnakeHeadLocation();
        if(arr[1]-1 < 0 || Board.getLocationValue(arr[0], arr[1]-1) == 'X'){
            System.out.println("Game Over");
            return false;
        }
        if(Board.getLocationValue(arr[0], arr[1]-1) == 'E'){
            GameManager.incrementScore();
            Board.deletePosition(arr[0],arr[1]-1);
            GameManager.findNewEggPosition();
            Board.setSnakeBody(arr[0],arr[1]);
            Board.setSnakeHead(arr[0], arr[1]-1);
            snake.add(arr[0]*10+(arr[1]-1));
            return true;
        }
        int pos = snake.poll();
        Board.deletePosition(pos/10, pos%10);
        if(snake.size() > 0){
            Board.setSnakeBody(arr[0],arr[1]);
        }
        Board.setSnakeHead(arr[0], arr[1]-1);
        snake.add(arr[0]*10+(arr[1]-1));
        return true;
    }

    public static boolean moveUp(){
        int arr[] = Board.getSnakeHeadLocation();
        if(arr[0]-1 < 0 || Board.getLocationValue(arr[0]-1, arr[1]) == 'X'){
            System.out.println("Game Over");
            return false;
        }
        if(Board.getLocationValue(arr[0]-1, arr[1]) == 'E'){
            GameManager.incrementScore();
            Board.deletePosition(arr[0]-1,arr[1]);
            GameManager.findNewEggPosition();
            Board.setSnakeBody(arr[0],arr[1]);
            Board.setSnakeHead(arr[0]-1, arr[1]);
            snake.add((arr[0]-1)*10+(arr[1]));
            return true;
        }
        int pos = snake.poll();
        Board.deletePosition(pos/10, pos%10);
        if(snake.size() > 0){
            Board.setSnakeBody(arr[0],arr[1]);
        }
        Board.setSnakeHead(arr[0]-1, arr[1]);
        snake.add((arr[0]-1)*10+(arr[1]));
        return true;
    }
    public static boolean moveDown(){
        int arr[] = Board.getSnakeHeadLocation();
        if(arr[0]+1 < 0 || Board.getLocationValue(arr[0]+1, arr[1]) == 'X'){
            System.out.println("Game Over");
            return false;
        }
        if(Board.getLocationValue(arr[0]+1, arr[1]) == 'E'){
            GameManager.incrementScore();
            Board.deletePosition(arr[0]+1,arr[1]);
            GameManager.findNewEggPosition();
            Board.setSnakeBody(arr[0],arr[1]);
            Board.setSnakeHead(arr[0]+1, arr[1]);
            snake.add((arr[0]+1)*10+(arr[1]));
            return true;
        }
        int pos = snake.poll();
        Board.deletePosition(pos/10, pos%10);
        if(snake.size() > 0){
            Board.setSnakeBody(arr[0],arr[1]);
        }
        Board.setSnakeHead(arr[0]+1, arr[1]);
        snake.add((arr[0]+1)*10+(arr[1]));
        return true;
    }

}
