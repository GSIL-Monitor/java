package com.algorithm;

/**
 *
 */
public class Sort {
	int[] arr = {6, 3, 8, 2, 9, 1};
	int[] arrSorted = {};

	public static void main(String[] args) {
		Sort sort = new Sort();
		sort.before();

		//sort.bubbleSort();
		sort.selectionSort();
		sort.result();
	}

	public void before() {
		System.out.println("before sort: ");
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}

	public void result() {
		System.out.println();
		System.out.println("after sort: ");
		for (int num : arr) {
			System.out.print(num+ " ");

		}
	}

	/**
	 * 冒泡
	 */
	public int[] bubbleSort() {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

				}
			}
		}
		arrSorted = arr;
		return arrSorted;
	}


	/**
	 * 选择
	 */
	public int[] selectionSort() {

		for (int i = 0; i < arr.length; i++) {
			int k = i;
			for (int j = k+1; j <arr.length; j++) {
				if (arr[k] > arr[j]) {
					k = j;
				}
			}

			int	temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
		}

		arrSorted = arr;
		return arrSorted;
	}

	/**
	 * 插入排序Insertion Sort
	 */

//	public int[] insertionSort() {
//
//	}
}
