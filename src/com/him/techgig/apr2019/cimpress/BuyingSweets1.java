package com.him.techgig.apr2019.cimpress;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BuyingSweets1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int totalShops = Integer.parseInt(scanner.nextLine().trim());
		List<Integer> inList = new ArrayList<>();
		IntStream.range(0, totalShops).forEach((i) -> inList.add(Integer.parseInt(scanner.nextLine().trim())));
		scanner.close();
		List<List<Integer>> combinationifElems = combinationInOrder(inList);
		System.out.println(getTotalCost(combinationifElems));
	}

	private static int getTotalCost(List<List<Integer>> combinationifElems) {
		int totalCost = 0;
		for (List<Integer> list : combinationifElems) {
			totalCost = totalCost + getCostOfEachList(list);
		}
		return totalCost;
	}

	private static int getCostOfEachList(List<Integer> list) {
		int cost = 0;
		int price = list.get(list.size() - 1);
		for (int elem : list) {
			cost = cost + elem * price;
		}
		return cost;
	}

	private static List<List<Integer>> combinationInOrder(List<Integer> inList) {
		List<List<Integer>> combinationifElems = new ArrayList<>();
		for (int startIndex = 0; startIndex < inList.size(); startIndex++) {
			for (int noOfElems = 0; noOfElems <= inList.size() - startIndex; noOfElems++) {
				int toIndex = startIndex + noOfElems;
				// System.out.println("startIndex:"+startIndex+",toInedx:"+toIndex);
				// System.out.println(inList.subList(startIndex, toIndex));
				List<Integer> elems = inList.subList(startIndex, toIndex);
				if (elems != null && elems.size() > 0) {
					combinationifElems.add(elems);
				}
			}
		}
		return combinationifElems;

	}
}
