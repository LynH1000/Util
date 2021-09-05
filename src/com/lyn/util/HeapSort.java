package com.lyn.util;

import static com.lyn.util.Sort.swap;

public class HeapSort {
    public static void heapify(int arr[],int root,int heapSize){
        int left=root*2+1;
        while (left<heapSize){
            int largest=left+1<heapSize&&arr[left+1]>arr[left]?left+1:left;
            largest=arr[largest]>arr[root]?largest:root;
            if (largest == root) {
                break;
            }
            Swap.swap(left,root,arr);
            root=largest;
            left=root*2+1;
        }
    }
}
