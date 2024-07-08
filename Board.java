import java.util.Random;

public class Board {
    static char arr[][] = new char[10][10];
    static int headRow, headCol;
    public static void setEggPosition(int row, int col){
        arr[row][col] = 'E';
    }
    public static void setSnakeHead(int row, int col){
        arr[row][col] = 'H';
        headRow = row;
        headCol = col;
    }
    public static void setSnakeBody(int row, int col){
        arr[row][col] = 'X';
    }

    public static void setInitialValues(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = '.';
            }
        }
    }
    public static int[] getSnakeHeadLocation(){
        return new int[]{headRow, headCol};
    }

    public static char getLocationValue(int row, int col){
        return arr[row][col];
    }

    public static void deletePosition(int row, int col){
        arr[row][col] = '.';
    }
    public static void print(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
