package assignment4;

import java.util.Comparator;

import java.util.Random;

//Insertion Sort

public class TimeAnagramUtil {

//    Analyze the run-time performance of the areAnagramsmethod.
//        What is the Big-O behavior and why? Be sure to define N.
//        Plot the running time for various problem sizes (up to you to choose problem sizes 
	// that sufficiently analyze the problem).
//        The provided AnagramTester.java contains a method for generating a random string of 
	// a certain length.
//        Does the growth rate of the plotted running times match the Big-O behavior you 
	// predicted?
//    Analyze the run-time performance of the getLargestAnagramGroup method using both your 
	// insertion sort and Shell sort algorithms. (Use the same list of guiding
	// questions
	// as in #1.) Note that in this case, N is the number of words, not the length
	// of words.
	// Finding the largest group of anagrams involves sorting the entire list of
	// words based
	// on some criteria (not the natural ordering). The performance of your
	// getLargestAnagramGroup method will depend on which sort is used on the list
	// of
	// words. If you plot both versions in the same chart, be sure to show them
	// separately
	// as well, since Shell sort will (hopefully) look like a flat line compared to
	// insertion sort. To get varying input size, consider using a very large list
	// of
	// words found online, save it as a file, and take out words as necessary to get
	// different problem sizes, or use a random word generator, provided in
	// AnagramTester.java.
	// If you use the random word generator, use a modest word length, such as 5-15
	// characters.

//    What is the run-time performance of the getLargestAnagramGroup method if we use Java's sort
	// method (Links to an external site.)Links to an external site.
	// instead? How does it compare to using insertion sort and Shell sort?
	// (Use the same list of guiding questions as in #1.)

	private static Random rand;

	public static void main(String[] args) {
		rand = new Random();
		rand.setSeed(System.currentTimeMillis());

		long startTime, midPointTime, stopTime;

		startTime = System.nanoTime();

		while ((System.nanoTime() - startTime) < 1000000000) {
		}

		StringComparator stringCmp = new StringComparator();
		charCompare charCmp = new charCompare();
		int wordLength = 5;

		int timesToLoop = 2500;
		for (int N = 10; N <= 1000; N += 10) {
			
			//for areanagram can set V N to 100 or whatever
			String[] testArray = new String[N];

			for (int i = 0; i < N; i++) {

				// chagne random string to 10 for sort tests
				// n for get anagram tests
				testArray[i] = randomString(10);
			}

			startTime = System.nanoTime();

			for (int j = 0; j < timesToLoop; j++) {

//				areAnagrams test
//				for (int k = 0; k < N - 1; k++) {
//					AnagramUtil.areAnagrams(testArray[k], testArray[k + 1]);
//				}

				// largestAnagramGroup true
				 AnagramUtil.getLargestAnagramGroup(testArray);

			}

			midPointTime = System.nanoTime();

			for (long l = 0; l < timesToLoop; l++) {
			}

			stopTime = System.nanoTime();

			double averageTime = ((midPointTime - startTime) - (stopTime - midPointTime)) / timesToLoop;

			System.out.println(N + "\t" + averageTime);

		}

	}

	static class charCompare implements Comparator<Character> {

		@Override
		public int compare(Character o1, Character o2) {
			return o1.compareTo(o2);
		}

	}

	static class StringComparator implements Comparator<String> {
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}
	}

	public static String randomString(int length) {
		String retval = "";
		for (int i = 0; i < length; i++) {
			// ASCII values a-z are contiguous (26 characters)
			retval += (char) ('a' + (rand.nextInt(26)));
		}
		return retval;
	}

}
