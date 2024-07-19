package org.tuc.tests;

import java.util.Random;
import org.tuc.Element;
import org.tuc.List;
import org.tuc.MyElement;
import org.tuc.first.DList;
import org.tuc.first.SDList;
import org.tuc.second.AAList;
import org.tuc.second.SAAList;
import org.tuc.third.AList;
import org.tuc.third.SAList;
import org.tuc.tests.MultiCounter;

public class Tester {

	public static void main(String[] args)  {

	    System.out.println("Starting tests...");
		int[] numberOfNumbers = { 30, 50, 100, 200, 500, 800, 1000, 5000, 10000, 100000 };
		java.util.Random randomGenerator = new java.util.Random();

		long totalTimeInsert,totalTimeDelete,totalTimeSearch;

		DList test_list = new DList();
		SDList test_list1 = new SDList();

		float[] counterResults = new float[numberOfNumbers.length];
		float[] counterResults1 = new float[numberOfNumbers.length];
		float[] counterResults2 = new float[numberOfNumbers.length];
		float[] counterResults3 = new float[numberOfNumbers.length];
		float[] counterResults4 = new float[numberOfNumbers.length];
		float[] counterResults5 = new float[numberOfNumbers.length];
		float[] counterResults6 = new float[numberOfNumbers.length];
		float[] counterResults7 = new float[numberOfNumbers.length];
		float[] counterResults8 = new float[numberOfNumbers.length];
		float[] counterResults9 = new float[numberOfNumbers.length];
		float[] counterResults10 = new float[numberOfNumbers.length];
		float[] counterResults11 = new float[numberOfNumbers.length];
		float[] counterResults12 = new float[numberOfNumbers.length];
		float[] counterResults13 = new float[numberOfNumbers.length];
		float[] counterResults14 = new float[numberOfNumbers.length];
		float[] counterResults15 = new float[numberOfNumbers.length];
		float[] counterResults16 = new float[numberOfNumbers.length];
		float[] counterResults17 = new float[numberOfNumbers.length];
		//float[] counterResults18 = new float[numberOfNumbers.length];
		float[] averageTime = new float[numberOfNumbers.length];
		float[] averageTime1 = new float[numberOfNumbers.length];
		float[] averageTime2 = new float[numberOfNumbers.length];
		float[] averageTime3 = new float[numberOfNumbers.length];
		float[] averageTime4 = new float[numberOfNumbers.length];
		float[] averageTime5 = new float[numberOfNumbers.length];
		float[] averageTime6 = new float[numberOfNumbers.length];
		float[] averageTime7 = new float[numberOfNumbers.length];
		float[] averageTime8 = new float[numberOfNumbers.length];
		float[] averageTime9 = new float[numberOfNumbers.length];
		float[] averageTime10 = new float[numberOfNumbers.length];
		float[] averageTime11 = new float[numberOfNumbers.length];
		float[] averageTime12 = new float[numberOfNumbers.length];
		float[] averageTime13 = new float[numberOfNumbers.length];
		float[] averageTime14 = new float[numberOfNumbers.length];
		float[] averageTime15 = new float[numberOfNumbers.length];
		float[] averageTime16 = new float[numberOfNumbers.length];
		float[] averageTime17 = new float[numberOfNumbers.length];


		/////////////////////////////////////////////////////////////////// DLIST CASE///////////////////////////////////////////////////

		for (int i = 0; i < numberOfNumbers.length; i++) { // numberOfNumbers.length

			test_list = new DList();

			int N = numberOfNumbers[i];
			totalTimeInsert = 0;
			totalTimeDelete=0;
			totalTimeSearch = 0;

			int[] randomInts = randomGenerator.ints(1, 2 * N).distinct().limit(N).toArray();
			

			for (int j = 0; j < randomInts.length; j++) {

				MyElement e = new MyElement(randomInts[j]);
				test_list.insert(e);

			}

			MultiCounter.resetCounter(1);
			MultiCounter.resetCounter(2);
			MultiCounter.resetCounter(3);

			if (N < 201) {

				int K = 10;
				int[] KrandomInts = randomGenerator.ints(1, 2 * N).distinct().limit(K).toArray();


					for (int j = 0; j < KrandomInts.length; j++) {
						long startTime = 0;
						long endTime = 0;
						MyElement e = new MyElement(KrandomInts[j]);
						startTime = System.nanoTime();
						test_list.insert(e);
						endTime = System.nanoTime();
						totalTimeInsert += (endTime - startTime);

					}
					
				
				averageTime[i] = (float) ((double) totalTimeInsert / K);
				counterResults[i] = (float) MultiCounter.getCounter(0) / K;

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list.search(e.getKey());
					endTime = System.nanoTime();
					totalTimeSearch += (endTime - startTime);

				}
				counterResults1[i] = (float) MultiCounter.getCounter(1) / K;
				averageTime1[i] = (float) ((double) totalTimeSearch / K);


				
				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list.delete(e.getKey());
					endTime = System.nanoTime();
					totalTimeDelete += (endTime - startTime);

				}
				
			
			averageTime2[i] = (float) ((double) totalTimeDelete / K);
			counterResults2[i] = (float) MultiCounter.getCounter(2) / K;

			} else if (N > 200 && N < 1001) {

				int K = 50;
				int[] KrandomInts = randomGenerator.ints(1, 2 * N).distinct().limit(K).toArray();

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list.insert(e);
					endTime = System.nanoTime();
					totalTimeInsert += (endTime - startTime);

				}

				counterResults[i] = (long) ((double) MultiCounter.getCounter(0) / K);
				averageTime[i] = (float) ((double) totalTimeInsert / K);


				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list.search(e.getKey());
					endTime = System.nanoTime();
					totalTimeSearch += (endTime - startTime);

				}
				counterResults1[i] = (float) MultiCounter.getCounter(1) / K;
				averageTime1[i] = (float) ((double) totalTimeSearch / K);

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list.delete(e.getKey());
					endTime = System.nanoTime();
					totalTimeDelete += (endTime - startTime);

				}
				
			
			averageTime2[i] = (float) ((double) totalTimeDelete / K);
			counterResults2[i] = (float) MultiCounter.getCounter(2) / K;
				

			} else {

				int K = 100;
				int[] KrandomInts = randomGenerator.ints(1, 2 * N).distinct().limit(K).toArray();

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list.insert(e);
					endTime = System.nanoTime();
					totalTimeInsert += (endTime - startTime);
				}

				counterResults[i] = (float) MultiCounter.getCounter(0) / K;
				averageTime[i] = (float) ((double) totalTimeInsert / K);


				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list.search(e.getKey());
					endTime = System.nanoTime();
					totalTimeSearch += (endTime - startTime);

				}
				counterResults1[i] = (float) MultiCounter.getCounter(1) / K;
				averageTime1[i] = (float) ((double) totalTimeSearch / K);

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list.delete(e.getKey());
					endTime = System.nanoTime();
					totalTimeDelete += (endTime - startTime);

				}
				
			
			averageTime2[i] = (float) ((double) totalTimeDelete / K);
			counterResults2[i] = (float) MultiCounter.getCounter(2) / K;

			}

		}
		/////////////////////////////////////////////////////////////////// SDLIST CASE

		for (int i = 0; i < numberOfNumbers.length; i++) { // numberOfNumbers.length
			
			totalTimeInsert = 0;
			totalTimeDelete = 0;
			totalTimeSearch =0;
			test_list1 = new SDList();

			int N = numberOfNumbers[i];

			int[] randomInts = randomGenerator.ints(1, 2 * N).distinct().limit(N).toArray();

			for (int j = 0; j < randomInts.length; j++) {

				MyElement e = new MyElement(randomInts[j]);
				test_list1.insert(e);

			}

			MultiCounter.resetCounter(4);
			MultiCounter.resetCounter(5);
			MultiCounter.resetCounter(6);

			if (N < 201) {

				int K = 10;
				int[] KrandomInts = randomGenerator.ints(1, 2 * N).distinct().limit(K).toArray();

				for (int j = 0; j < KrandomInts.length; j++) {
						long startTime = 0;
						long endTime = 0;
						MyElement e = new MyElement(KrandomInts[j]);
						startTime = System.nanoTime();
						test_list1.insert(e);
						endTime = System.nanoTime();
						totalTimeInsert += (endTime - startTime);
					
				}
				averageTime3[i] = (float) ((double) totalTimeInsert / K);
				counterResults3[i] = (float) MultiCounter.getCounter(3) / K;

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list1.search(e.getKey());
					endTime = System.nanoTime();
					totalTimeSearch += (endTime - startTime);

				}
				counterResults4[i] = (float) MultiCounter.getCounter(4) / K;
				averageTime4[i] = (float) ((double) totalTimeSearch / K);

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list1.delete(e.getKey());
					endTime = System.nanoTime();
					totalTimeDelete += (endTime - startTime);
				}
				counterResults5[i] = (float) MultiCounter.getCounter(5) / K;
				averageTime5[i] = (float) ((double) totalTimeDelete / K);

			} else if (N > 200 && N < 1001) {

				int K = 50;
				int[] KrandomInts = randomGenerator.ints(1, 2 * N).distinct().limit(K).toArray();

				for (int j = 0; j < KrandomInts.length; j++) {

						long startTime = 0;
						long endTime = 0;
						MyElement e = new MyElement(KrandomInts[j]);
						startTime = System.nanoTime();
						test_list1.insert(e);
						endTime = System.nanoTime();
						totalTimeInsert += (endTime - startTime);

				}
				counterResults3[i] = (float) MultiCounter.getCounter(3) / K;
				averageTime3[i] = (float) ((double) totalTimeInsert / K);

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list1.search(e.getKey());
					endTime = System.nanoTime();
					totalTimeSearch += (endTime - startTime);

				}
				counterResults4[i] = (float) MultiCounter.getCounter(4) / K;
				averageTime4[i] = (float) ((double) totalTimeSearch / K);

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list1.delete(e.getKey());
					endTime = System.nanoTime();
					totalTimeDelete += (endTime - startTime);
				}
				counterResults5[i] = (float) MultiCounter.getCounter(5) / K;
				averageTime5[i] = (float) ((double) totalTimeDelete / K);

			} else {

				int K = 100;
				int[] KrandomInts = randomGenerator.ints(1, 2 * N).distinct().limit(K).toArray();

				for (int j = 0; j < KrandomInts.length; j++) {
						long startTime = 0;
						long endTime = 0;
						MyElement e = new MyElement(KrandomInts[j]);
						startTime = System.nanoTime();
						test_list1.insert(e);
						endTime = System.nanoTime();
						totalTimeInsert += (endTime - startTime);

					}

				
				counterResults3[i] = (float) MultiCounter.getCounter(3) / K;
				averageTime3[i] = (float) ((double) totalTimeInsert / K);


				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list1.search(e.getKey());
					endTime = System.nanoTime();
					totalTimeSearch += (endTime - startTime);

				}
				counterResults4[i] = (float) MultiCounter.getCounter(4) / K;
				averageTime4[i] = (float) ((double) totalTimeSearch / K);

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list1.delete(e.getKey());
					endTime = System.nanoTime();
					totalTimeDelete += (endTime - startTime);
				}
			counterResults5[i] = (float) MultiCounter.getCounter(5) / K;
			averageTime5[i] = (float) ((double) totalTimeDelete / K);


			}

		}

		/////////////////////////////////////////////////////////////////// AALIST CASE
		for (int i = 0; i < numberOfNumbers.length; i++) { // numberOfNumbers.length

			AAList test_list2;
			int K;
			totalTimeInsert = 0;
			totalTimeDelete=0;
			totalTimeSearch = 0;

			int N = numberOfNumbers[i];

			if (N < 201) {
				K = 10;

			} else if (N > 200 && N < 1001) {
				K = 50;

			} else {
				K = 100;

			}

			test_list2 = new AAList(N + K);

			int[] randomInts = randomGenerator.ints(1, 2 * N).distinct().limit(N).toArray();

			for (int j = 0; j < randomInts.length; j++) {

				MyElement e = new MyElement(randomInts[j]);
				test_list2.insert(e);

			}

			MultiCounter.resetCounter(7);
			MultiCounter.resetCounter(8);
			MultiCounter.resetCounter(9);

			if (N < 201) {

				K = 10;
				int[] KrandomInts = randomGenerator.ints(1, 2 * N).distinct().limit(K).toArray();

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list2.insert(e);
					endTime = System.nanoTime();
					totalTimeInsert += (endTime - startTime);
				}

				counterResults6[i] = (float) MultiCounter.getCounter(6) / K;
				averageTime6[i] = (float) ((double) totalTimeInsert / K);


				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					startTime = System.nanoTime();
					MyElement e = new MyElement(KrandomInts[j]);
					test_list2.search(e.getKey());
					endTime = System.nanoTime();
					totalTimeSearch += (endTime - startTime);
				}
				counterResults7[i] = (long) ((double) MultiCounter.getCounter(7) / K);
				averageTime7[i] = (float) ((double) totalTimeSearch / K);


				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					startTime = System.nanoTime();
					MyElement e = new MyElement(KrandomInts[j]);
					test_list2.delete(e.getKey());
					endTime = System.nanoTime();
					totalTimeDelete += (endTime - startTime);
				}
				counterResults8[i] = (float) MultiCounter.getCounter(8) / K;
				averageTime8[i] = (float) ((double) totalTimeDelete / K);


			} else if (N > 200 && N < 1001) {

				K = 50;
				int[] KrandomInts = randomGenerator.ints(1, 2 * N).distinct().limit(K).toArray();

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list2.insert(e);
					endTime = System.nanoTime();
					totalTimeInsert += (endTime - startTime);
				}
				counterResults6[i] = (float) MultiCounter.getCounter(6) / K;
				averageTime6[i] = (float) ((double) totalTimeInsert / K);


				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					startTime = System.nanoTime();
					MyElement e = new MyElement(KrandomInts[j]);
					test_list2.search(e.getKey());
					endTime = System.nanoTime();
					totalTimeSearch += (endTime - startTime);
				}
				counterResults7[i] = (long) ((double) MultiCounter.getCounter(7) / K);
				averageTime7[i] = (float) ((double) totalTimeSearch / K);

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					startTime = System.nanoTime();
					MyElement e = new MyElement(KrandomInts[j]);
					test_list2.delete(e.getKey());
					endTime = System.nanoTime();
					totalTimeDelete += (endTime - startTime);
				}
				counterResults8[i] = (float) MultiCounter.getCounter(8) / K;
				averageTime8[i] = (float) ((double) totalTimeDelete / K);

			} else {

				K = 100;
				int[] KrandomInts = randomGenerator.ints(1, 2 * N).distinct().limit(K).toArray();

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list2.insert(e);
					endTime = System.nanoTime();
					totalTimeInsert += (endTime - startTime);
				}
				counterResults6[i] = (float) MultiCounter.getCounter(6) / K;
				averageTime6[i] = (float) ((double) totalTimeInsert / K);

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					startTime = System.nanoTime();
					MyElement e = new MyElement(KrandomInts[j]);
					test_list2.search(e.getKey());
					endTime = System.nanoTime();
					totalTimeSearch += (endTime - startTime);
				}
				counterResults7[i] = (long) ((double) MultiCounter.getCounter(7) / K);
				averageTime7[i] = (float) ((double) totalTimeSearch / K);

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					startTime = System.nanoTime();
					MyElement e = new MyElement(KrandomInts[j]);
					test_list2.delete(e.getKey());
					endTime = System.nanoTime();
					totalTimeDelete += (endTime - startTime);
				}
				counterResults8[i] = (float) MultiCounter.getCounter(8) / K;
				averageTime8[i] = (float) ((double) totalTimeDelete / K);

			}

		}

/////////////////////////////////////////////////////////////////// SAALIST CASE //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		for (int i = 0; i < numberOfNumbers.length; i++) { // numberOfNumbers.length

			SAAList test_list3;
			int K;
			totalTimeInsert=0;
			totalTimeDelete=0;
			totalTimeSearch=0;
			
			int N = numberOfNumbers[i];

			if (N < 201) {
				K = 10;

			} else if (N > 200 && N < 1001) {
				K = 50;

			} else {
				K = 100;

			}

			test_list3 = new SAAList(N + K);

			int[] randomInts = randomGenerator.ints(1, 2 * N).distinct().limit(N).toArray();

			for (int j = 0; j < randomInts.length; j++) {

				MyElement e = new MyElement(randomInts[j]);
				test_list3.insert(e);

			}

			MultiCounter.resetCounter(10);
			MultiCounter.resetCounter(11);
			MultiCounter.resetCounter(12);

			if (N < 201) {

				K = 10;
				int[] KrandomInts = randomGenerator.ints(1, 2 * N).distinct().limit(K).toArray();

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list3.insert(e);
					endTime = System.nanoTime();
					totalTimeInsert += (endTime - startTime);
				}
				counterResults9[i] = (float) MultiCounter.getCounter(9) / K;
				averageTime9[i] = (float) ((double) totalTimeInsert / K);


				for (int j = 0; j < KrandomInts.length; j++) {
				long startTime = 0;
				long endTime = 0;
				MyElement e = new MyElement(KrandomInts[j]);
				startTime = System.nanoTime();
				test_list3.search(e.getKey());
				endTime = System.nanoTime();
				totalTimeSearch += (endTime - startTime);
			}
				counterResults10[i] = (float) MultiCounter.getCounter(10) / K;
				averageTime10[i] = (float) ((double) totalTimeSearch / K);


				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list3.delete(e.getKey());
					endTime = System.nanoTime();
					totalTimeDelete += (endTime - startTime);
				
				}
				counterResults11[i] = (float) MultiCounter.getCounter(11) / K;
				averageTime11[i] = (float) ((double) totalTimeDelete / K);


			} else if (N > 200 && N < 1001) {

				K = 50;
				int[] KrandomInts = randomGenerator.ints(1, 2 * N).distinct().limit(K).toArray();

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list3.insert(e);
					endTime = System.nanoTime();
					totalTimeInsert += (endTime - startTime);
				}
				counterResults9[i] = (float) MultiCounter.getCounter(9) / K;
				averageTime9[i] = (float) ((double) totalTimeInsert / K);


				for (int j = 0; j < KrandomInts.length; j++) {
				long startTime = 0;
				long endTime = 0;
				MyElement e = new MyElement(KrandomInts[j]);
				startTime = System.nanoTime();
				test_list3.search(e.getKey());
				endTime = System.nanoTime();
				totalTimeSearch += (endTime - startTime);
			}
				counterResults10[i] = (float) MultiCounter.getCounter(10) / K;
				averageTime10[i] = (float) ((double) totalTimeSearch / K);

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list3.delete(e.getKey());
					endTime = System.nanoTime();
					totalTimeDelete += (endTime - startTime);
				
				}
				counterResults11[i] = (float) MultiCounter.getCounter(11) / K;
				averageTime11[i] = (float) ((double) totalTimeDelete / K);

			} else {

				K = 100;
				int[] KrandomInts = randomGenerator.ints(1, 2 * N).distinct().limit(K).toArray();

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list3.insert(e);
					endTime = System.nanoTime();
					totalTimeInsert += (endTime - startTime);
				}
				counterResults9[i] = (float) MultiCounter.getCounter(9) / K;
				averageTime9[i] = (float) ((double) totalTimeInsert / K);


				for (int j = 0; j < KrandomInts.length; j++) {
				long startTime = 0;
				long endTime = 0;
				MyElement e = new MyElement(KrandomInts[j]);
				startTime = System.nanoTime();
				test_list3.search(e.getKey());
				endTime = System.nanoTime();
				totalTimeSearch += (endTime - startTime);
			}
				counterResults10[i] = (float) MultiCounter.getCounter(10) / K;
				averageTime10[i] = (float) ((double) totalTimeSearch / K);

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list3.delete(e.getKey());
					endTime = System.nanoTime();
					totalTimeDelete += (endTime - startTime);
				
				}
				counterResults11[i] = (float) MultiCounter.getCounter(11) / K;
				averageTime11[i] = (float) ((double) totalTimeDelete / K);

			}

		}

/////////////////////////////////////////////////////////////////ALIST CASE///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		for (int i = 0; i < numberOfNumbers.length; i++) { // numberOfNumbers.length

			AList test_list4;
			int K;
			totalTimeInsert=0;
			totalTimeDelete=0;
			totalTimeSearch=0;

			int N = numberOfNumbers[i];

			if (N < 201) {
				K = 10;

			} else if (N > 200 && N < 1001) {
				K = 50;

			} else {
				K = 100;

			}

			test_list4 = new AList(N + K);

			int[] randomInts = randomGenerator.ints(1, 2 * N).distinct().limit(N).toArray();

			for (int j = 0; j < randomInts.length; j++) {

				MyElement e = new MyElement(randomInts[j]);
				test_list4.insert(e);

			}

			MultiCounter.resetCounter(13);
			MultiCounter.resetCounter(14);
			MultiCounter.resetCounter(15);

			if (N < 201) {

				K = 10;
				int[] KrandomInts = randomGenerator.ints(1, 2 * N).distinct().limit(K).toArray();

				
				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list4.insert(e);
					endTime = System.nanoTime();
					totalTimeInsert += (endTime - startTime);
				}
				counterResults12[i] = (float) MultiCounter.getCounter(12) / K;
				averageTime12[i] = (float) ((double) totalTimeInsert / K);

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list4.search(e.getKey());
					endTime = System.nanoTime();
					totalTimeSearch += (endTime - startTime);
				}
				counterResults13[i] = (float) MultiCounter.getCounter(13) / K;
				averageTime13[i] = (float) ((double) totalTimeSearch / K);


				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list4.delete(e.getKey());
					endTime = System.nanoTime();
					totalTimeDelete += (endTime - startTime);
				
				}
				counterResults14[i] = (float) MultiCounter.getCounter(14) / K;
				averageTime14[i] = (float) ((double) totalTimeDelete / K);


			} else if (N > 200 && N < 1001) {

				K = 50;
				int[] KrandomInts = randomGenerator.ints(1, 2 * N).distinct().limit(K).toArray();

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list4.insert(e);
					endTime = System.nanoTime();
					totalTimeInsert += (endTime - startTime);
				}
				counterResults12[i] = (float) MultiCounter.getCounter(12) / K;
				averageTime12[i] = (float) ((double) totalTimeInsert / K);
				

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list4.search(e.getKey());
					endTime = System.nanoTime();
					totalTimeSearch += (endTime - startTime);
				}
				counterResults13[i] = (float) MultiCounter.getCounter(13) / K;
				averageTime13[i] = (float) ((double) totalTimeSearch / K);

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list4.delete(e.getKey());
					endTime = System.nanoTime();
					totalTimeDelete += (endTime - startTime);
				
				}
				counterResults14[i] = (float) MultiCounter.getCounter(14) / K;
				averageTime14[i] = (float) ((double) totalTimeDelete / K);

			} else {

				K = 100;
				int[] KrandomInts = randomGenerator.ints(1, 2 * N).distinct().limit(K).toArray();

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list4.insert(e);
					endTime = System.nanoTime();
					totalTimeInsert += (endTime - startTime);
				}
				counterResults12[i] = (float) MultiCounter.getCounter(12) / K;
				averageTime12[i] = (float) ((double) totalTimeInsert / K);

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list4.search(e.getKey());
					endTime = System.nanoTime();
					totalTimeSearch += (endTime - startTime);
				}
				counterResults13[i] = (float) MultiCounter.getCounter(13) / K;
				averageTime13[i] = (float) ((double) totalTimeSearch / K);

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list4.delete(e.getKey());
					endTime = System.nanoTime();
					totalTimeDelete += (endTime - startTime);
				
				}
				counterResults14[i] = (float) MultiCounter.getCounter(14) / K;
				averageTime14[i] = (float) ((double) totalTimeDelete / K);

			}

		}

///////////////////////////////////////////////////////////////////////////////////////////////////////SALIST CASE//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		for (int i = 0; i < numberOfNumbers.length; i++) { // numberOfNumbers.length

			SAList test_list5;
			int K;
			totalTimeInsert=0;
			totalTimeDelete=0;
			totalTimeSearch=0;

			int N = numberOfNumbers[i];

			if (N < 201) {
				K = 10;

			} else if (N > 200 && N < 1001) {
				K = 50;

			} else {
				K = 100;

			}

			test_list5 = new SAList(N + K);

			int[] randomInts = randomGenerator.ints(1, 2 * N).distinct().limit(N).toArray();

			for (int j = 0; j < randomInts.length; j++) {

				MyElement e = new MyElement(randomInts[j]);
				test_list5.insert(e);

			}

			MultiCounter.resetCounter(16);
			MultiCounter.resetCounter(17);
			MultiCounter.resetCounter(18);
			MultiCounter.resetCounter(19);

			if (N < 201) {

				K = 10;
				int[] KrandomInts = randomGenerator.ints(1, 2 * N).distinct().limit(K).toArray();

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list5.insert(e);
					endTime = System.nanoTime();
					totalTimeInsert += (endTime - startTime);
				}
				counterResults15[i] = (float) (MultiCounter.getCounter(15) + MultiCounter.getCounter(18)) / K; // Maybe wrong
				averageTime15[i] = (float) ((double) totalTimeInsert / K);

				
				MultiCounter.resetCounter(19);

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list5.search(e.getKey());
					endTime = System.nanoTime();
					totalTimeSearch += (endTime - startTime);
				}
				counterResults16[i] = (float) (MultiCounter.getCounter(16) + MultiCounter.getCounter(18)) / K;
				averageTime16[i] = (float) ((double) totalTimeSearch / K);
				
				MultiCounter.resetCounter(19);

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list5.delete(e.getKey());
					endTime = System.nanoTime();
					totalTimeDelete += (endTime - startTime);
				}
				counterResults17[i] = (float) (MultiCounter.getCounter(17) + MultiCounter.getCounter(18)) / K;
				averageTime17[i] = (float) ((double) totalTimeDelete / K);

			} else if (N > 200 && N < 1001) {

				K = 50;
				int[] KrandomInts = randomGenerator.ints(1, 2 * N).distinct().limit(K).toArray();

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list5.insert(e);
					endTime = System.nanoTime();
					totalTimeInsert += (endTime - startTime);
				}
				counterResults15[i] = (float) (MultiCounter.getCounter(15) + MultiCounter.getCounter(18)) / K;
				averageTime15[i] = (float) ((double) totalTimeInsert / K);

				MultiCounter.resetCounter(19);

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list5.search(e.getKey());
					endTime = System.nanoTime();
					totalTimeSearch += (endTime - startTime);
				}
				counterResults16[i] = (float) (MultiCounter.getCounter(16) + MultiCounter.getCounter(18)) / K;
				averageTime16[i] = (float) ((double) totalTimeSearch / K);

				MultiCounter.resetCounter(19);

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list5.delete(e.getKey());
					endTime = System.nanoTime();
					totalTimeDelete += (endTime - startTime);
				}
				counterResults17[i] = (float) (MultiCounter.getCounter(17) + MultiCounter.getCounter(18)) / K;
				averageTime17[i] = (float) ((double) totalTimeDelete / K);

				MultiCounter.resetCounter(19);

			} else {

				K = 100;
				int[] KrandomInts = randomGenerator.ints(1, 2 * N).distinct().limit(K).toArray();

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list5.insert(e);
					endTime = System.nanoTime();
					totalTimeInsert += (endTime - startTime);
				}
				counterResults15[i] = (float) (MultiCounter.getCounter(15) + MultiCounter.getCounter(18)) / K;
				averageTime15[i] = (float) ((double) totalTimeInsert / K);

				
				MultiCounter.resetCounter(19);

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list5.search(e.getKey());
					endTime = System.nanoTime();
					totalTimeSearch += (endTime - startTime);
				}
				counterResults16[i] = (float) (MultiCounter.getCounter(16) + MultiCounter.getCounter(18)) / K;
				averageTime16[i] = (float) ((double) totalTimeSearch / K);

				MultiCounter.resetCounter(19);

				for (int j = 0; j < KrandomInts.length; j++) {
					long startTime = 0;
					long endTime = 0;
					MyElement e = new MyElement(KrandomInts[j]);
					startTime = System.nanoTime();
					test_list5.delete(e.getKey());
					endTime = System.nanoTime();
					totalTimeDelete += (endTime - startTime);
				}
				counterResults17[i] = (float) (MultiCounter.getCounter(17) + MultiCounter.getCounter(18)) / K;
				averageTime17[i] = (float) ((double) totalTimeDelete / K);


				MultiCounter.resetCounter(19);

			}

		}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// PRINT THE RESULTS FROM THE TESTS
		System.out.println("\nINSERT");
		System.out.println("**********************************************************************************************************************************************************************************");
		System.out.println("Mean operations:");
		System.out.print("\t");
		for (int i = 0; i < numberOfNumbers.length; i++) {
			System.out.printf("|%14s ", "N=" + numberOfNumbers[i]); 
		}
		System.out.println();

		System.out.print("1a:\t");
		for (int i = 0; i < counterResults.length; i++) {
		    System.out.printf("|%14.2f ", counterResults[i]);  
		}
		System.out.println();

		System.out.print("1b:\t");
		for (int i = 0; i < counterResults3.length; i++) {
		    System.out.printf("|%14.2f ", counterResults3[i]);
		}
		System.out.println();

		System.out.print("2a:\t");
		for (int i = 0; i < counterResults6.length; i++) {
		    System.out.printf("|%14.2f ", counterResults6[i]);
		}
		System.out.println();

		System.out.print("2b:\t");
		for (int i = 0; i < counterResults9.length; i++) {
		    System.out.printf("|%14.2f ", counterResults9[i]);
		}
		System.out.println();

		System.out.print("3a:\t");
		for (int i = 0; i < counterResults12.length; i++) {
		    System.out.printf("|%14.2f ", counterResults12[i]);
		}
		System.out.println();

		System.out.print("3b:\t");
		for (int i = 0; i < counterResults15.length; i++) {
		    System.out.printf("|%14.2f ", counterResults15[i]);
		}
		System.out.println();
	
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("\nDELETE");
		System.out.println("**********************************************************************************************************************************************************************************");
		System.out.println("Mean operations:");
		System.out.print("\t");
		for (int i = 0; i < numberOfNumbers.length; i++) {
			System.out.printf("|%14s ", "N=" + numberOfNumbers[i]);
		}
		System.out.println();

		System.out.print("1a:\t");
		for (int i = 0; i < counterResults2.length; i++) {
		    System.out.printf("|%14.2f ", counterResults2[i]);
		}
		System.out.println();

		System.out.print("1b:\t");
		for (int i = 0; i < counterResults5.length; i++) {
		    System.out.printf("|%14.2f ", counterResults5[i]);
		}
		System.out.println();

		System.out.print("2a:\t");
		for (int i = 0; i < counterResults8.length; i++) {
		    System.out.printf("|%14.2f ", counterResults8[i]);
		}
		System.out.println();

		System.out.print("2b:\t");
		for (int i = 0; i < counterResults11.length; i++) {
		    System.out.printf("|%14.2f ", counterResults11[i]);
		}
		System.out.println();

		System.out.print("3a:\t");
		for (int i = 0; i < counterResults14.length; i++) {
		    System.out.printf("|%14.2f ", counterResults14[i]);
		}
		System.out.println();

		System.out.print("3b:\t");
		for (int i = 0; i < counterResults17.length; i++) {
		    System.out.printf("|%14.2f ", counterResults17[i]);
		}
		System.out.println();


		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("\nSEARCH");
		System.out.println("**********************************************************************************************************************************************************************************");
		System.out.println("Mean operations:");
		System.out.print("\t");
		for (int i = 0; i < numberOfNumbers.length; i++) {
			System.out.printf("|%14s ", "N=" + numberOfNumbers[i]);
		}
		System.out.println();

		System.out.print("1a:\t");
		for (int i = 0; i < counterResults1.length; i++) {
		    System.out.printf("|%14.2f ", counterResults1[i]);
		}
		System.out.println();

		System.out.print("1b:\t");
		for (int i = 0; i < counterResults4.length; i++) {
		    System.out.printf("|%14.2f ", counterResults4[i]);
		}
		System.out.println();

		System.out.print("2a:\t");
		for (int i = 0; i < counterResults7.length; i++) {
		    System.out.printf("|%14.2f ", counterResults7[i]);
		}
		System.out.println();

		System.out.print("2b:\t");
		for (int i = 0; i < counterResults10.length; i++) {
		    System.out.printf("|%14.2f ", counterResults10[i]);
		}
		System.out.println();

		System.out.print("3a:\t");
		for (int i = 0; i < counterResults13.length; i++) {
		    System.out.printf("|%14.2f ", counterResults13[i]);
		}
		System.out.println();

		System.out.print("3b:\t");
		for (int i = 0; i < counterResults16.length; i++) {
		    System.out.printf("|%14.2f ", counterResults16[i]);
		}
		System.out.println();

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("\nINSERT");
		System.out.println("**********************************************************************************************************************************************************************************");
		System.out.println("Mean time(ns):");
		System.out.print("\t");
		for (int i = 0; i < numberOfNumbers.length; i++) {
			System.out.printf("|%14s ", "N=" + numberOfNumbers[i]);
		}
		System.out.println();

		System.out.print("1a:\t");
		for (int i = 0; i < counterResults.length; i++) {
		    System.out.printf("|%14.2f ", averageTime[i]);
		}
		System.out.println();

		System.out.print("1b:\t");
		for (int i = 0; i < counterResults.length; i++) {
		    System.out.printf("|%14.2f ", averageTime3[i]);
		}
		System.out.println();

		System.out.print("2a:\t");
		for (int i = 0; i < counterResults6.length; i++) {
		    System.out.printf("|%14.2f ", averageTime6[i]);
		}
		System.out.println();

		System.out.print("2b:\t");
		for (int i = 0; i < counterResults9.length; i++) {
		    System.out.printf("|%14.2f ", averageTime9[i]);
		}
		System.out.println();

		System.out.print("3a:\t");
		for (int i = 0; i < counterResults12.length; i++) {
		    System.out.printf("|%14.2f ", averageTime12[i]);
		}
		System.out.println();

		System.out.print("3b:\t");
		for (int i = 0; i < counterResults15.length; i++) {
		    System.out.printf("|%14.2f ", averageTime15[i]);
		}
		System.out.println();

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("\nDELETE");
		System.out.println("**********************************************************************************************************************************************************************************");
		System.out.println("Mean time(ns):");
		System.out.print("\t");
		for (int i = 0; i < numberOfNumbers.length; i++) {
			System.out.printf("|%14s ", "N=" + numberOfNumbers[i]);
		}
		System.out.println();

		System.out.print("1a:\t");
		for (int i = 0; i < counterResults2.length; i++) {
		    System.out.printf("|%14.2f ", averageTime2[i]);
		}
		System.out.println();

		System.out.print("1b:\t");
		for (int i = 0; i < counterResults5.length; i++) {
		    System.out.printf("|%14.2f ", averageTime5[i]);
		}
		System.out.println();

		System.out.print("2a:\t");
		for (int i = 0; i < counterResults8.length; i++) {
		    System.out.printf("|%14.2f ", averageTime8[i]);
		}
		System.out.println();

		System.out.print("2b:\t");
		for (int i = 0; i < counterResults11.length; i++) {
		    System.out.printf("|%14.2f ", averageTime11[i]);
		}
		System.out.println();

		System.out.print("3a:\t");
		for (int i = 0; i < counterResults14.length; i++) {
		    System.out.printf("|%14.2f ", averageTime14[i]);
		}
		System.out.println();

		System.out.print("3b:\t");
		for (int i = 0; i < counterResults17.length; i++) {
		    System.out.printf("|%14.2f ", averageTime17[i]);
		}
		System.out.println();

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("\nSEARCH");
		System.out.println("**********************************************************************************************************************************************************************************");
		System.out.println("Mean time(ns):");
		System.out.print("\t");
		for (int i = 0; i < numberOfNumbers.length; i++) {
			System.out.printf("|%14s ", "N=" + numberOfNumbers[i]);
		}
		System.out.println();

		System.out.print("1a:\t");
		for (int i = 0; i < counterResults1.length; i++) {
		    System.out.printf("|%14.2f ", averageTime1[i]);
		}
		System.out.println();

		System.out.print("1b:\t");
		for (int i = 0; i < counterResults4.length; i++) {
		    System.out.printf("|%14.2f ", averageTime4[i]);
		}
		System.out.println();

		System.out.print("2a:\t");
		for (int i = 0; i < counterResults7.length; i++) {
		    System.out.printf("|%14.2f ", averageTime7[i]);
		}
		System.out.println();

		System.out.print("2b:\t");
		for (int i = 0; i < counterResults10.length; i++) {
		    System.out.printf("|%14.2f ", averageTime10[i]);
		}
		System.out.println();

		System.out.print("3a:\t");
		for (int i = 0; i < counterResults13.length; i++) {
		    System.out.printf("|%14.2f ", averageTime13[i]);
		}
		System.out.println();

		System.out.print("3b:\t");
		for (int i = 0; i < counterResults16.length; i++) {
		    System.out.printf("|%14.2f ", averageTime16[i]);
		}
		System.out.println();

	}

}
