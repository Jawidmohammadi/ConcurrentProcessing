public class ThreadOperation extends Thread {

  protected int[][] arrayOne;
  protected int[][] arrayTwo;
  protected int[][] arrayC;
  protected int start;
  protected int end;
  protected int innerStart;
  protected int innerEnd;

  public ThreadOperation(int[][] arrayOne, int[][] arrayTwo, int[][] arrayC, int start, int end, int innerStart, int innerEnd){
    this.arrayOne = arrayOne;
    this.arrayTwo = arrayTwo;
    this.arrayC = arrayC;
    this.start = start;
    this.end = end;
    this.innerEnd = innerEnd;
    this.innerStart = innerStart;
  }


  @Override
  public void run() {
    for (int i = start; i < end; i++) {
      for (int j = innerStart; j < innerEnd; j++) {
        arrayC[i][j] = arrayOne[i][j] + arrayTwo[i][j];
      }
    }
  }


}
