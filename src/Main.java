import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

  private static Path path = Paths.get("matrix1.txt");
  private static Scanner scanner;
  public static void main(String[] args) throws InterruptedException {

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

    // can you overload run method in Thread?
    Thread t1 = new ThreadOperation(arrayOne, arrayTwo, arrayC);
    t1.run();

    // Second Quadrant Thread
    ThreadOperation t2 = new ThreadOperation(arrayOne, arrayTwo, arrayC);
    t2.run(collum/2, collum);

    // Third Quadrant Thread
    ThreadOperation t3 = new ThreadOperation(arrayOne, arrayTwo, arrayC);
    t3.run(row/2, row, 0, collum/2 );

    // Fourth Quadrant Thread
    ThreadOperation t4 = new ThreadOperation(arrayOne, arrayTwo, arrayC);
    t4.run(row/2, row, collum/2, collum);
    System.out.println("Printing the Sum of two arrays");
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
