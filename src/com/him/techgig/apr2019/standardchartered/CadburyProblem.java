package com.him.techgig.apr2019.standardchartered;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadburyProblem {

	static CadburyProblem cadbProb = new CadburyProblem();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int m = Integer.parseInt(scanner.nextLine().trim());
		int n = Integer.parseInt(scanner.nextLine().trim());
		int p = Integer.parseInt(scanner.nextLine().trim());
		int q = Integer.parseInt(scanner.nextLine().trim());
		calculateNoOfChilderReceivedCadbury(m, n, p, q);
		scanner.close();
	}

	private static void calculateNoOfChilderReceivedCadbury(int m, int n, int p, int q) {
		List<Cadbury> cadburyList = new ArrayList<>();

		cadburyList.add(cadbProb.new Cadbury(m, p));
		cadburyList.add(cadbProb.new Cadbury(m, q));
		cadburyList.add(cadbProb.new Cadbury(n, p));
		cadburyList.add(cadbProb.new Cadbury(n, q));
		int totalNumOfStudents = 0;
		for (Cadbury cadbury : cadburyList) {
			totalNumOfStudents = totalNumOfStudents + distributeSingleCadbury(cadbury);
		}
		System.out.println(totalNumOfStudents);
	}

	private static int distributeSingleCadbury(Cadbury cadbury) {
		Cadbury remCadbSize = cadbury;
		int noOfStudents = 0;
		while (remCadbSize.length > 0 && remCadbSize.breadth > 0) {
			Cadbury maxCadbSize = getMaxSizeOfSquare(remCadbSize);
			remCadbSize = getRemainingSize(remCadbSize, maxCadbSize);
			noOfStudents++;
		}
		//System.out.println("-----"+cadbury.length+","+cadbury.breadth+":"+noOfStudents);
		return noOfStudents;
	}

	private static Cadbury getRemainingSize(Cadbury currCadbSize, Cadbury cadbSizeToBeReduced) {
		//System.out.println("currCadbSize:" + currCadbSize + ", cadbSizeToBeReduced:" + cadbSizeToBeReduced);
		Cadbury cadb = null;
		if (currCadbSize.length > currCadbSize.breadth) {
			cadb = cadbProb.new Cadbury(currCadbSize.length - cadbSizeToBeReduced.length, currCadbSize.breadth);
		} else {
			cadb = cadbProb.new Cadbury(currCadbSize.length, currCadbSize.breadth - cadbSizeToBeReduced.breadth);
		}
		//System.out.println("cadb:" + cadb);
		return cadb;
	}

	private static Cadbury getMaxSizeOfSquare(Cadbury remCadbSize) {
		int sqLen = remCadbSize.length < remCadbSize.breadth ? remCadbSize.length : remCadbSize.breadth;
		return cadbProb.new Cadbury(sqLen, sqLen);
	}

	class Cadbury {
		int length;
		int breadth;

		public Cadbury(int length, int breadth) {
			super();
			this.length = length;
			this.breadth = breadth;
		}

		@Override
		public String toString() {
			return "Cadbury [length=" + length + ", breadth=" + breadth + "]";
		}

	}
}
