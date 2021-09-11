package com.lyn.util;

import static com.lyn.util.Sort.swap;

public class HeapSort {
    public static void heapSort(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            //生成堆结构
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        //将根节点和最后一个节点交换
        swap(arr, 0, --heapSize);

        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }

    }
    //如果当前数大于他的根节点，两者交换
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[index - 1] >> 1) {
            swap(arr, index, arr[index - 1] >> 1);
            index = (index - 1) >> 1;
        }
    }


    public static void heapify(int arr[], int root, int heapSize) {
        int left = root * 2 + 1;

        while (left < heapSize) {
            //返回左右节点之间最大值的索引
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            //返回叶子和根节点的最大值的索引
            largest = arr[largest] > arr[root] ? largest : root;
            //如果根节点是最大值则不动，否则交换叶子和根节点，并将交换前的叶子节点索引值 作为下轮的根节点
            if (largest == root) {
                break;
            }
            swap(arr, left, root);
            root = largest;
            left = root * 2 + 1;
        }
    }
}
