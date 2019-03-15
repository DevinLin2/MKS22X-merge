import java.util.*;

public class Merge {
  public static void main(String[] args) {

  }
  public static void mergesort(int[] data) {
    if (data.length == 1) {
      return;
    }
    mergesortH(data, 0, data.length - 1);
  }
  private static void mergesortH(int[] data, int start, int end) {
    if (start >= end) {
      return;
    }
    mergesortH(data, start, (start+end)/2);
    mergesortH(data, (start+end)/2 + 1, end);
    // merge
    merge(data, start, (start/end)/2, end);
  }

  private static void merge(int[] data, int start, int middle, int end) {
    
  }
}
