package com.algorithm;

/**
 *	二分查找的基本思想是将n个元素分成大致相等的两部分，取a[n/2]与x做比较，如果x=a[n/2],
 *	则找到x,算法中止；如果x<a[n/2],则只要在数组a的左半部分继续搜索x,如果x>a[n/2],则只要在数组a的右半部搜索x.
 */
public class BinarySearch {

	public int binarySearch(int[] arr, int des) {
		int low = 0;
		int high = arr.length;

		while (low < high) {
			int middle = (low + high) / 2;
			if (des < arr[middle]) {
				high = middle;
			} else if (des > arr[middle]) {
				low = middle + 1;
			} else {
				return middle;
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.binarySearch(new int[]{1, 2, 10, 15, 100}, 15));
	}
}
