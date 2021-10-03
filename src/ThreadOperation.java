public class ThreadOperation extends Thread {

  protected int[][] arrayOne;
  protected int[][] arrayTwo;
  protected int[][] arrayC;

  public ThreadOperation(int[][] arrayOne, int[][] arrayTwo, int[][] arrayC){
    this.arrayOne = arrayOne;
    this.arrayTwo = arrayTwo;
    this.arrayC = arrayC;
  }

  @Override
  public void run() {
    for (int i = 0; i < arrayOne.length/2; i++) {
      for (int j = 0; j < arrayOne[0].length/2; j++) {
        arrayC[i][j] = arrayOne[i][j] + arrayTwo[i][j];
      }
    }
  }

  public void run(int startInner, int endInner) {
    for (int i = 0; i < arrayOne.length/2; i++) {
      for (int j = startInner; j < endInner; j++) {
        arrayC[i][j] = arrayOne[i][j] + arrayTwo[i][j];
      }
    }
  }

  public void run(int start, int end, int startInner, int endInner) {
    for (int i = start; i < end; i++) {
      for (int j = startInner; j < endInner; j++) {
        arrayC[i][j] = arrayOne[i][j] + arrayTwo[i][j];
      }
    }
  }


}
