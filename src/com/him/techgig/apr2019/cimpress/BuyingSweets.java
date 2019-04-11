package com.him.techgig.apr2019.cimpress;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuyingSweets {

	public static void main(String[] args) {
		/*
		 * Scanner scanner = new Scanner(System.in);
		 * 
		 * int arrSize = Integer.parseInt(scanner.nextLine().trim()); int[] inputArr =
		 * new int[arrSize]; for (int i = 0; i < arrSize; i++) { inputArr[i] =
		 * Integer.parseInt(scanner.nextLine().trim()); } for (int j = 1; j <= arrSize;
		 * j++) { for (int i = 0; i < j; i++) { int[] outputArr = new int[arrSize];
		 * 
		 * costOfAllPosWaysOfBuringSweet(inputArr, outputArr, 0 + i, arrSize - 1 - i); }
		 * } // permute(inputArr, 0);
		 * 
		 * scanner.close();
		 */
		List<Integer> inList = new ArrayList<>();
		inList.add(1);
		inList.add(2);
		inList.add(3);
		//inList.add(4);
		// inList.add(5);
		Set<List<Integer>> permutationList = new HashSet<>();
		permute(inList, 0, inList.size()-1, permutationList);
		Set<List<Integer>> combinationList=new HashSet<>();
		permutationList.add(inList);
		for(List<Integer> outList:permutationList) {
			
			for(int i=0;i<outList.size();i++) {
				combinationList.add(new ArrayList<>(outList.subList(0, i+1)));
			}
		}
		
		combinationList.forEach(System.out::println);
		System.out.println("size:" + combinationList.size());
	}

	private static void permute(List<Integer> inList, int startIndex, int n, Set<List<Integer>> outFinalList) {
		if (startIndex == n) {
			outFinalList.add(new ArrayList<>(inList));
		} else {
			for (int j = startIndex; j <= n; j++) {
				swap(inList, startIndex, j);
				permute(inList, startIndex + 1, n, outFinalList);
				swap(inList, startIndex, j);//this is backtracking and making in List back to original
			}
		}

	}
	

	private static void swap(List<Integer> inList, int i, int j) {
		int tmp = inList.get(i);
		inList.set(i, inList.get(j));
		inList.set(j, tmp);

	}

	
}
