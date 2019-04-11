package com.him.techgig.expedia.march2019;

import java.util.Scanner;

public class FindSum {
	
	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		
		String[] firstLine=scanner.nextLine().split(" ");
		
		int n=Integer.parseInt(firstLine[0]);//2;
		int k=Integer.parseInt(firstLine[1]);//4;
		int[] arr=new int[n];
		
		for(int i=0;i<n;i++) {
			
			arr[i]=scanner.nextInt();
		}
		
		
		mergeSort(arr,0,n-1);
		scanner.close();
		//int[] arr= {8,9};
		
		System.out.println(findSum(n,k,arr));
	}
	
    static void merge(int[] array,int low,int mid,int high){
        int i,j,k;
        int[] c= new int[high-low+1];
        k = 0;
        i=low;
        j=mid+1;
        while(i<=mid && j<=high){
            if(array[i]<=array[j]){
                c[k++] = array[i++];
            }
            else{
                c[k++] = array[j++];
            }
        }
        while(i<=mid){
            c[k++] = array[i++];
        }
        while(j<=high){
            c[k++] = array[j++];
        }
        k=0;
        for(i = low; i<=high; i++){
            array[i] = c[k++];
        }
    }

    static void mergeSort(int[] array,int low, int high){
        if(high-low+1>1){
            int mid = (low+high)/2;
            mergeSort(array,low,mid);
            mergeSort(array,mid+1,high);
            merge(array,low,mid,high);
        }
    }

	private static int findSum(int noOfElems, int noOfIterations, int[] sorthedArr) {
		
		int ans=0;
		for(int i=0;i<noOfIterations;i++) {
			int max=getMax(sorthedArr,noOfElems);
			ans=ans+max;
//			System.out.println("ans:"+ans);
			int floor=(int)Math.floor(max/2);
			insertElem(sorthedArr,floor, noOfElems);
	//		System.out.println(Arrays.toString(sorthedArr));
		}
		return ans;
		
	}

	private static void insertElem(int[] sorthedArr, int floor, int noOfElems) {
		int expectedLocations=findLocation(sorthedArr, floor, noOfElems);
		moveElems(sorthedArr, expectedLocations, noOfElems);
		sorthedArr[expectedLocations]=floor;
		
	}

	private static void moveElems(int[] sorthedArr, int expectedLocations, int noOfElems) {
		for(int i=noOfElems-1;i>expectedLocations;i--) {
			sorthedArr[i]=sorthedArr[i-1];
		}
	}


	private static int findLocation(int[] sorthedArr, int floor, int noOfElems) {
		return binarySearch(sorthedArr,0,noOfElems-1,floor);
	}
	
	
	static int binarySearch(int arr[], int l, int r, int x) 
    { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
            if(mid==0) {
            	return mid;
            }
            if (mid>0 && arr[mid-1] < x && arr[mid]>=x) 
                return mid; 
            if (arr[mid] > x) 
                return binarySearch(arr, l, mid - 1, x); 
            return binarySearch(arr, mid + 1, r, x); 
        } 
        return -1; 
    } 

	private static int getMax(int[] arr,int noOfElems) {
		return arr[noOfElems-1];
	}
}
