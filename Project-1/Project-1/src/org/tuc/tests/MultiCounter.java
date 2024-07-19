package org.tuc.tests;

public class MultiCounter {
	
	
	public MultiCounter() {
		
	}
	
	
	private static long[] counters = new long[25];
	
	
	public static void resetCounter(int counterIndex) {
		if(counterIndex -1 <counterIndex)
			counters[counterIndex-1] = 0;
	}
	
	
	public static boolean increaseCounter(int counterIndex, int step) {
		if(counterIndex<counters.length-1) {
			counters[counterIndex]+= step ;
		}
		return true;
	}


	public static long getCounter(int counterIndex) {
		return counters[counterIndex];
	}

}
