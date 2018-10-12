package assignment3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class TimeArrayCollection {
	private static Random rand;

	public static void main(String[] args) {
		rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		// TODO: Write code to time your toSortedList, contains, and
		// SearchUtil.binarySearch methods so you can plot the results.
		ArrayList<Integer> garbage;

		long startTime, midpointTime, stopTime;

		// First, spin computing stuff until one second has gone by.
		// This allows this thread to stabilize.
		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) { // empty block
		}

		// Now, run the test. Use 5 iterations for toSortedList since it's slow
		// int timesToLoop = 5;

		// Use 25000 for for contains since it's fast
		// 25000 for contains
		// 25 for selection sort
		int timesToLoop = 25;

		// int N = 5000;

		// Instead of hard-coding N, we analyze growing values of N
		for (int N = 1000; N < 30000; N += 1000) {
			// Generate the random inputs before starting the timer

			ArrayCollection<Integer> aci = new ArrayCollection<>();
			// generateRandomCollection(N);
//binary search
			while (aci.size() < N) {
				aci.add(randomInteger());
			}
			
			// Generate contains inputs
			int[] testVals = new int[timesToLoop];
			for (int i = 0; i < timesToLoop; i++)
				testVals[i] = randomInteger();

			

			garbage = aci.toSortedList(new IntegerComparator());

			IntegerComparator cmp = new IntegerComparator();
			startTime = System.nanoTime();
			
			for (int i = 0; i < timesToLoop; i++) {
				// Time contains method
//				aci.contains(testVals[i]);

				// Time sorting method
//				garbage = aci.toSortedList(new IntegerComparator());

				// Time Binary
				SearchUtil.binarySearch(garbage, testVals[i], cmp);
			}

			midpointTime = System.nanoTime();

			// Run an empty loop to capture the cost of running the loop.

			for (long i = 0; i < timesToLoop; i++) { // empty block
			}

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and computing square roots.
			// Average it over the number of runs.

			double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / timesToLoop;

			System.out.println(N + "\t" + averageTime);
		}
	}

	public static ArrayCollection<Integer> generateRandomCollection(int N) {
		ArrayCollection<Integer> aci = new ArrayCollection<Integer>();
		while (aci.size() != N)
			aci.add(randomInteger());
		return aci;
	}

	public static Integer randomInt() {
		return rand.nextInt();
	}

	public static Integer randomInteger() {
		return rand.nextInt();
	}

}
