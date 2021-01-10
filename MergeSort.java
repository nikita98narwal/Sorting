package sorting;

import java.util.Scanner;

public class MergeSort {
	void merge(int arr[], int left, int mid, int right) {
		//Size of two sub arrays
		int n1 = mid-left+1;
		int n2 = right-mid;
		
		//create temp arratys
		int leftArr[] = new int[n1];
		int rightArr[] = new int[n2];
		
		//copy data into subarrays
		for(int i = 0; i < n1; i++)
			leftArr[i] = arr[left+i];
		for(int j = 0; j < n2; j++)
			rightArr[j] = arr[mid+j+1];
		
		//merge temp arrays
		int i = 0, j = 0, k = left;
		while(i < n1 && j < n2) {
			if(leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
				k++;
			}
			else {
				arr[i] = rightArr[j];
				j++;
				k++;
			}
		}
		
		//copy remaining elemnts if any
		while(i < n1) {
			arr[k++] = leftArr[i++];
		}
		while(j < n2) {
			arr[k++] = rightArr[j++];
		}
	}
	
	 void mergeSort(int arr[], int left, int right) {
		if(left>=right)
			return;
		if(left<right) {
			int mid = left+(right-left)/2;
			mergeSort(arr,left,mid);
			mergeSort(arr,mid+1,right);
			merge(arr,left,mid,right);
		}
	}
	static void printArray(int arr[]) {
	    int n = arr.length;
	    for (int i = 0; i < n; i++)
	      System.out.print(arr[i] + " ");
	    System.out.println();
	  }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			MergeSort ob = new MergeSort();
		    ob.mergeSort(arr, 0, arr.length-1);
		    printArray(arr);
		}
	}
}
