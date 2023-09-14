package com.zc.sort;

import java.util.Random;

/**
 * @author lizhecao 2021/3/20
 * @version 1.0
 */
public class QuickSort {
  public void sort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  public void quickSort(int[] arr, int i, int j) {
    if (i >= j) {
      return;
    }

    int pivot = randomPartition(arr, i, j);
    quickSort(arr, i, pivot - 1);
    quickSort(arr, pivot + 1, j);
  }

  /**
   * 加入一个randomPartition，避免最差到O(n2)
   */
  private int randomPartition(int[] arr, int i, int j) {
    int random = new Random().nextInt(j - i + 1) + i;
    int temp = arr[i];
    arr[i] = arr[random];
    arr[random] = temp;
    return partition(arr, i, j);
  }

  private int partition(int[] arr, int i, int j) {
    int pivot = arr[i];
    while (i < j) {
      while (i < j && arr[j] >= pivot) {
        j--;
      }
      arr[i] = arr[j];
      while (i < j && arr[i] <= pivot) {
        i++;
      }
      arr[j] = arr[i];
    }
    arr[i] = pivot;
    return i;
  }

  public static void main(String[] args) {
    QuickSort quickSort = new QuickSort();
    int []a = new int[]{
      9, 7, 8, 2, 10, 4, 3,19, 7, 8, 2, 10, 4, 3,19, 7, 8, 2, 10, 4, 3,19, 7, 8, 2, 10, 49, 7, 8, 2, 10, 4, 3,19, 7, 8, 2, 10, 4, 3,1, 3,1

//        1,1,1,1,1,1,1,2,1
    };
    quickSort.sort(a);
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + ",");
    }
  }
}
