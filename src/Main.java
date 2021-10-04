import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

  private static Path path;
  private static Scanner scanner;
  public static void main(String[] args) throws InterruptedException {

    path = Paths.get(args[0]);
    try { scanner = new Scanner(path);
    } catch (IOException e ){
      System.out.println("Invalid Input");
    }
    int row = scanner.nextInt();
    int collum = scanner.nextInt();
    int[][] arrayOne = new int[row][collum];
    int[][] arrayTwo = new int[row][collum];
    int[][] arrayC = new int[row][collum];
    System.out.println("Printing the matrix");
    initArray(arrayOne);
    initArray(arrayTwo);
    System.out.println();
    ThreadOperation t0 = new ThreadOperation(arrayOne, arrayTwo, arrayC, 0, arrayOne.length/2,0,arrayOne[0].length/2 );
    ThreadOperation t1 = new ThreadOperation(arrayOne, arrayTwo, arrayC, 0, arrayOne.length/2,arrayOne[0].length/2, arrayOne[0].length );
    ThreadOperation t2 = new ThreadOperation(arrayOne, arrayTwo, arrayC, arrayOne.length/2, arrayOne.length,0,arrayOne[0].length/2 );
    ThreadOperation t3 = new ThreadOperation(arrayOne, arrayTwo, arrayC, arrayOne.length/2, arrayOne.length,arrayOne[0].length/2,arrayOne[0].length );
    t0.start();
    t1.start();
    t2.start();
    t3.start();
    t0.join();
    t1.join();
    t2.join();
    t3.join();
    System.out.println("Printing Sum of two arrays");
    printArray(arrayC);
  }

  private static void initArray(int[][] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        array[i][j] = scanner.nextInt();
        System.out.printf("%-4d", array[i][j]);
      }
      System.out.println();
    }
  }


  private static void printArray(int[][] array) {
    for (int[] ints : array) {
      for (int anInt : ints) {
        System.out.printf("%-4d", anInt);
      }
      System.out.println();
    }
  }



}
