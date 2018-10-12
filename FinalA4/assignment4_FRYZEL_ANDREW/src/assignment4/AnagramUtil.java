package assignment4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author Evan Parry and Andrew Fryzel A class that uses various sort methods
 *         and Comparators to sort values and determine whether or no they are
 *         anagrams of one another. Also contains a method to return the largest
 *         anagram group.
 *
 */
public class AnagramUtil {

	/**
	 * This method returns the sorted version of the input string using
	 * lexicographical ordering (as defined by Character.compareTo). The sorting is
	 * accomplished using an insertion sort.
	 * 
	 * @param input The input String to be lexicographically sorted
	 * @return The sorted String
	 */
	public static String sort(String input) {
		Character arr[] = new Character[input.length()];
		String output = "";

		for (int i = 0; i < input.length(); i++) {

			arr[i] = input.charAt(i);
		}

		charCompare cmp = new charCompare();

		insertionSort(arr, cmp);

		for (int j = 0; j < input.length(); j++) {
			output += arr[j];
		}

		return output;
	}

	/**
	 * This generic method sorts the input array using an insertion sort and the
	 * input Comparator object.
	 * 
	 * @param arr The input array to be sorted
	 * @param cmp The Comparator object that determines how the array will be sorted
	 */
	public static <T> void insertionSort(T[] arr, Comparator<? super T> cmp) {
		int stop = arr.length;
		int i;
		T key;
		int j;

		for (i = 1; i < stop; i++) {
			key = arr[i]; // Initializes key to currently compared value
			j = i - 1; // sets J to the index directly before index i

			while (j >= 0 && (cmp.compare(arr[j], key) > 0)) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

	/**
	 * This generic method sorts the input array using a Shell sort and the input
	 * Comparator object.
	 * 
	 * @param arr The input array to be sorted
	 * @param cmp The Comparator object that determines how the array will be sorted
	 */
	public static <T> void shellSort(T[] arr, Comparator<? super T> cmp) {
		int stop = arr.length;

		// draw this out visually to help better understand the underlying process

		for (int gap = (stop / 2); gap > 0; gap /= 2) {

			for (int i = gap; i < stop; i += 1) {
				T temp = arr[i];
				int j;
				for (j = i; j >= gap && cmp.compare(arr[j - gap], temp) > 0; j -= gap) {
					arr[j] = arr[j - gap];
				}
				arr[j] = temp;
			}
		}

	}

	/**
	 * This method returns true if the two input strings are anagrams of each other,
	 * otherwise returns false.
	 * 
	 * @param string1 The first input String that will be compared to the string2
	 *                String
	 * @param string2 The secondinput String that will be compared to the string1
	 *                String
	 * @return True if the Strings are anagrams, other wise returns false
	 */
	public static boolean areAnagrams(String string1, String string2) {

		string1 = string1.toLowerCase();
		string2 = string2.toLowerCase();

		if (string1 == null || string2 == null) {
			return false;
		}

		String inString1 = sort(string1);
		String inString2 = sort(string2);

		if (inString1.equals(inString2)) {
			return true;
		}
		return false;
	}

	/**
	 * This method returns the largest group of anagrams in the input array of
	 * words, in no particular order. It returns an empty array if there are no
	 * anagrams in the input array.
	 * 
	 * @param array The input array whose values will be analyzed
	 * @return The new String Array containing all of the values that are anagrams
	 *         in their original form.
	 */
	public static String[] getLargestAnagramGroup(String[] array) {

//Do a null check in every method
		String[] arr = new String[array.length];

		// Main program
		for (int i = 0; i < array.length; i++) {
			arr[i] = array[i];
		}

		for (int j = 0; j < arr.length; j++) {
			String input = arr[j];
			input = input.toLowerCase();
			arr[j] = sort(input);
		}

		if (array.length == 2) {
			if (areAnagrams(arr[0], arr[1])) {
				String[] edgeArr = new String[2];

				edgeArr[0] = array[0];
				edgeArr[1] = array[1];
				return edgeArr;
			} else
				return null;
		}
		if (array.length == 1) {
			return array;
		}
		if (array.length == 0) {
			return null;
		}

		stringCompare cmp = new stringCompare();

		// Change this for time tests

		 insertionSort(arr, cmp);
		// shellSort(arr, cmp);
		//Arrays.sort(arr);

		int largestCounter = 1;
		int currentCounter = 1;

		String largestAnagram = "";

		for (int k = 0; k < arr.length - 1; k++) {

			if (areAnagrams(arr[k], arr[k + 1])) {
				// System.out.println(arr[j]);
				currentCounter++;
			} else { // if they aren't anagrams
				if (currentCounter > largestCounter) {
					largestCounter = currentCounter;
					largestAnagram = arr[k];
					currentCounter = 1;
					// System.out.println("Largest anagram " + largestAnagram);
				} else {
					currentCounter = 1;
				}
			}
		}

		String[] output = new String[largestCounter];
		int counter = 0;

		for (int l = 0; l < array.length; l++) {
			String testWord = array[l];
			if (areAnagrams(testWord, largestAnagram)) {
				// System.out.println(testWord);
				output[counter] = array[l];
				counter++;
			}
		}

		return output;
	}

	/**
	 * @author Evan Parry and Andrew Fryzel
	 *
	 *         This class contains the Character Comparator Method
	 */
	static class charCompare implements Comparator<Character> {

		/*
		 * This method takes in and compares two Characters to determine if they are
		 * equal to one another.
		 * 
		 * @param o1 The first character
		 * 
		 * @param o2 The second character
		 * 
		 * @Return Returns 0 if the values are equal, returns -1 if the left value is
		 * less than the right and returns 1 if the value on the left is greater than
		 * the right.
		 */
		@Override
		public int compare(Character o1, Character o2) {
			return o1.compareTo(o2);
		}

	}

	/**
	 * @author Evan Parry and Andrew Fryzel
	 *
	 *         This class contains the String Comparator Method
	 */
	static class stringCompare implements Comparator<String> {

		/*
		 * This method takes in and compares two Strings to determine if they are equal
		 * to one another.
		 * 
		 * @param o1 The first String
		 * 
		 * @param o2 The second String
		 * 
		 * @Return Returns 0 if the values are equal, returns -1 if the left value is
		 * less than the right and returns 1 if the value on the left is greater than
		 * the right.
		 */
		@Override
		public int compare(String o1, String o2) {
			if (o1.compareTo(o2) < 0) {
				return -1;
			} else if (o1.compareTo(o2) > 0) {
				return 1;
			}
			return 0;
		}
	}
}
