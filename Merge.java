import java.util.*;

public class Merge {
  public static void main(String[]args){
    // System.out.println("Size\t\tMax Value\tMerge/builtin ratio ");
    // int[]MAX_LIST = {1000000000,500,10};
    // for(int MAX : MAX_LIST){
    //   for(int size = 31250; size < 2000001; size*=2){
    //     long qtime=0;
    //     long btime=0;
    //     //average of 5 sorts.
    //     for(int trial = 0 ; trial <=5; trial++){
    //       int []data1 = new int[size];
    //       int []data2 = new int[size];
    //       for(int i = 0; i < data1.length; i++){
    //         data1[i] = (int)(Math.random()*MAX);
    //         data2[i] = data1[i];
    //       }
    //       long t1,t2;
    //       t1 = System.currentTimeMillis();
    //       Merge.mergesort(data2);
    //       t2 = System.currentTimeMillis();
    //       qtime += t2 - t1;
    //       t1 = System.currentTimeMillis();
    //       Arrays.sort(data1);
    //       t2 = System.currentTimeMillis();
    //       btime+= t2 - t1;
    //       if(!Arrays.equals(data1,data2)){
    //         System.out.println("FAIL TO SORT!");
    //         System.exit(0);
    //       }
    //     }
    //     System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    //   }
    //   System.out.println();
    // }
    int[] data = new int[] {4, 23, 234, 345, 1, 3 , 54, 234, 134, 3254, 13, 999, 28};
    mergesort(data);
  }
  public static void mergesort(int[] data) {
    if (data.length == 1) {
      return;
    }
    mergesortH(data, 0, data.length - 1);
  }
  private static void mergesortH(int[] data, int start, int end) {
    int[] left = new int[(start + end) / 2];
    int[] right = new int[data.length - ((start + end) / 2)];
    int index = 0;
    for (int i = 0; i < left.length; i++) {
      left[i] = data[i];
    }
    for (int x = (start + end) / 2; x < data.length; x++) {
      right[index] = data[x];
      index++;
    }
    System.out.println("left: " + Arrays.toString(left));
    System.out.println("right: " + Arrays.toString(right));
    if (start >= end) {
      return; // means that
    }
    mergesortH(data, start, (start+end)/2);
    mergesortH(data, (start+end)/2 + 1, end);
    // merge
  }
}
