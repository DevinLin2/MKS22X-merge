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
    System.out.println(Arrays.toString(data));
  }
  public static void mergesort(int[] data) {
    if (data.length == 1) {
      return;
    }
    mergesortH(data, 0, data.length - 1);
  }
  private static void mergesortH(int[] data, int start, int end) {
    if (start >= end) {
      return; // means that the size of the array covered by start and end is one
    }
    mergesortH(data, start, (start+end)/2);
    mergesortH(data, (start+end)/2 + 1, end);
    // merge
    merge(data, start, (start + end)/2, end);
  }

  private static void merge(int[] data, int start, int middle, int end) {
    int leftSize = middle - start + 1;
    int rightSize = end - middle;
    int leftIndex = 0;
    int rightIndex = 0;
    int Index = start;
    // temporary arrays to hold the data to sort
    int[] left = new int[leftSize];
    int[] right = new int[rightSize];

    for (int i = 0; i < leftSize; i++) {
      left[i] = data[start + i];
    }
    for (int x = 0; x < rightSize; x++) {
      right[x] = data[middle + x + 1];
    }
    // System.out.println(leftSize);
    // System.out.println(rightSize);
    // System.out.println("left: " + Arrays.toString(left));
    // System.out.println("right: " + Arrays.toString(right));
    // this is to copy the left and right arrays into data
    while (rightIndex < rightSize && leftIndex < leftSize) {
      if (left[leftIndex] <= right[rightIndex]) {
        data[Index] = left[leftIndex];
        leftIndex++;
      } else {
        data[Index] = right[rightIndex];
        rightIndex++;
      }
      Index++;
    } // have to sopy leftover if one array still has values left
    //System.out.println(Arrays.toString(data));
    while (leftIndex < leftSize) {
      data[Index] = left[leftIndex];
      leftIndex++;
      Index++;
    }

    while (rightIndex < rightSize) {
      data[Index] = right[rightIndex];
      rightIndex++;
      Index++;
    }
  }
}
