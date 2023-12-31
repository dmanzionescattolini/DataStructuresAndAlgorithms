package com.donato.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSort {

    public static void main(String[] args) {

    }

    public static int[] mergeSortedArrays(int[] leftArray, int[] rightArray) {
        System.out.print("merge " + stringifyArr(leftArray) + " and " + stringifyArr(rightArray));
        int[] merged = new int[leftArray.length + rightArray.length];
        int leftEl = leftArray[0];
        leftArray = Arrays.copyOf(leftArray, 1);
        int rightEl = rightArray[0];
        rightArray = Arrays.copyOf(rightArray, 1);
        boolean leftEmpty = false;
        boolean rightEmpty = false;
        outer:
        while (!rightEmpty && !leftEmpty) {
            while (!rightEmpty && !leftEmpty) {
                while (rightEl <= leftEl) {
                    System.out.println(rightEl + " is smaller than or equal to " + leftEl);
                    int[] temp = merged;
                    merged = new int[merged.length + 1];
                    for (int i = 0; i < temp.length; i++) {
                        merged[i] = temp[i];
                    }
                    merged[merged.length - 1] = rightEl;
                    System.out.println("Add " + rightEl + " to merged array: [" + stringifyArr(merged) + "]");


                    if (rightArray.length > 0) {
                        rightEl = rightArray[0];
                        if (rightArray.length == 1) {
                            rightArray = new int[0];
                        } else {
                            rightArray = Arrays.copyOfRange(rightArray, 1, rightArray.length);
                        }
                    } else {
                        rightEmpty = true;
                        break outer;
                    }

                }

                while (leftEl <= rightEl) {
                    System.out.println(leftEl + " is smaller than or equal to " + rightEl);
                    int[] temp = merged;
                    merged = new int[merged.length + 1];
                    for (int i = 0; i < temp.length; i++) {
                        merged[i] = temp[i];
                    }
                    merged[merged.length - 1] = leftEl;
                    System.out.println("Add " + leftEl + " to merged array: [" + stringifyArr(merged) + "]");


                    if (leftArray.length > 0) {
                        leftEl = leftArray[0];
                        if (leftArray.length == 1) {
                            leftArray = new int[0];
                        } else {
                            leftArray = Arrays.copyOfRange(leftArray, 1, leftArray.length);
                        }
                    } else {
                        leftEmpty = true;
                        break outer;
                    }

                }


            }
        if(!leftEmpty) {
            merged = Arrays.copyOf(merged, leftArray.length + 1);
            merged[merged.length - 1] = leftEl;
        }
        if(!rightEmpty){
            Listt mergedList = new ArrayList<>(Arrays.asList(merged));
             mergedList.addAll(merged.length,Arrays.asList(rightArray))).;
        }
          return merged;
        }



    public static String stringifyArr(int[] arr){

        StringBuilder result = new StringBuilder("[");
        for (int i : arr) {
            result.append(String.valueOf(i)).append(" ");
        }
        result.append("]");
        return result.toString();
    }
}
