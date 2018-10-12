package assignment4;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import org.junit.jupiter.api.Test;

/**
 * @author Evan Parry and Andrew Fryzel A collection of tests for the
 *         ArrayCollection class. Tests different cases as well as different
 *         Object types for each ArrayCollection method.
 *
 */

public class AnagramTester {

	// Edge Case Ideas
	// - If a string has a number in it
	// - Run tests for sorting doubles and integers
	// - (Maybe?) creating a custom object

	private static Random rand;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Set up the random number generator for the randomString function
		rand = new Random();
		rand.setSeed(0);

		// Reads a text file with a single word per line, returns them as an array of
		// Strings
		String[] words = readFile("sample_word_list.txt");
	}

	// sort Tests

	// Test a straight forward String
	@Test
	public void testSortSortedString() {
		String testWord = "Abracadabra";
		String sorted = "Aaaaabbcdrr";
		testWord = AnagramUtil.sort(testWord);
		// System.out.println("1");
		assertEquals(testWord, sorted);

	}

	// Test a String with numbers and letters
	@Test
	public void testSortSortedStringAndNumber() {
		String testWord = "Abra1cad2abra";
		String sorted = "12Aaaaabbcdrr";
		testWord = AnagramUtil.sort(testWord);
		assertEquals(testWord, sorted);

	}

	// Test capital and lower-case letters String
	@Test
	public void testSortRandomString() {
		String testWord = "HJKLnmopFDSAgh";
		String sorted = "ADFHJKLSghmnop";
		testWord = AnagramUtil.sort(testWord);
		assertEquals(testWord, sorted);
	}

	// Test numbers, capital and lowercase letters together
	@Test
	public void testSortNumberAndString() {
		String testWord = "HJKL12.5nmopFDSAgh";
		String sorted = ".125ADFHJKLSghmnop";
		testWord = AnagramUtil.sort(testWord);
		assertEquals(testWord, sorted);
	}

	// Tests sorting only number Strings
	@Test
	public void testInsertionSortReadFileNumbers() {
		// System.out.println("Testing Insertion Sort");
		StringComparator cmp = new StringComparator();
		String[] testWords = readFile("number_sample_sort.txt");
		String[] solutions = readFile("number_solutions.txt");

		AnagramUtil.insertionSort(testWords, cmp);

		for (int i = 0; i < testWords.length; i++) {

			String testWord = AnagramUtil.sort(testWords[i]);

			assertEquals(testWord, solutions[i]);
		}
	}

	// insertionSort Tests

	// Test basic InsertionSort
	@Test
	public void testInsertionSortReadFileSort() {
		// System.out.println("Testing Insertion Sort");
		StringComparator cmp = new StringComparator();
		String[] testWords = readFile("sample_word_list.txt");
		String[] solutions = readFile("sample_solutions.txt");
		AnagramUtil.insertionSort(testWords, cmp);

		for (int i = 0; i < testWords.length; i++) {
			assertEquals(solutions[i], testWords[i]);
		}
	}

	// Test a very small or non existent word list
	@Test
	public void testInsertionSortReadFileSortTwoOrLessItems() {
		// System.out.println("Testing Insertion Sort");
		StringComparator cmp = new StringComparator();
		String[] testWords = readFile("additional_word_list.txt");
		String[] solutions = readFile("additional_solutions.txt");
		AnagramUtil.insertionSort(testWords, cmp);

		for (int i = 0; i < testWords.length; i++) {
			assertEquals(solutions[i], testWords[i]);
		}
	}

	// Test a large word list
	@Test
	public void testInsertionSortModerateList() {
		// System.out.println("Testing Insertion Sort");
		StringComparator cmp = new StringComparator();
		String[] testWords = readFile("moderate_word_list.txt");
		String[] solutions = readFile("moderate_solutions.txt");
		AnagramUtil.insertionSort(testWords, cmp);

		for (int i = 0; i < testWords.length; i++) {

			assertEquals(solutions[i], testWords[i]);
		}
	}

	// Test insertionSort with number Strings
	@Test
	public void testInsertionSortNumbers() {
		// System.out.println("Testing Insertion Sort");
		StringComparator cmp = new StringComparator();
		String[] testWords = readFile("number_sample_sort.txt");
		String[] solutions = readFile("number_insert_shell_solutions.txt");
		AnagramUtil.insertionSort(testWords, cmp);

		for (int i = 0; i < testWords.length; i++) {
			assertEquals(solutions[i], testWords[i]);
		}
	}

	@Test
	public void testInsertionSortDouble() {
		// System.out.println("Testing Insertion Sort");
		DoubleComparator cmp = new DoubleComparator();
		Double[] testWords = { 12.5, 56.2, 59.1, 61.5, 1.0, 0.25965, .26541, 9.256 };
		Double[] solutions = { 0.25965, 0.26541, 1.0, 9.256, 12.5, 56.2, 59.1, 61.5 };

		AnagramUtil.insertionSort(testWords, cmp);

		for (int i = 0; i < testWords.length; i++) {
//			System.out.println(testWords[i]);

			assertEquals(solutions[i], testWords[i]);
		}
	}

	@Test
	public void testInsertionSortInteger() {
		// System.out.println("Testing Insertion Sort");
		IntegerComparator cmp = new IntegerComparator();
		Integer[] testWords = { 12, 56, 24, 154, 6743, 34634, 76756, 2354, 25, 59, 61, 1, 5965, 41, 96 };
		Integer[] solutions = { 1, 12, 24, 25, 41, 56, 59, 61, 96, 154, 2354, 5965, 6743, 34634, 76756 };

		AnagramUtil.insertionSort(testWords, cmp);

		for (int i = 0; i < testWords.length; i++) {

			assertEquals(solutions[i], testWords[i]);
		}
	}

	// How to Assert False?
//	@Test
//	public void insertionSortFalse() {
//		// System.out.println("Testing Insertion Sort");
//		StringComparator cmp = new StringComparator();
//		String[] testWords = readFile("moderate_word_list.txt");
//		String[] solutions = readFile("sample_solutions.txt");
//		AnagramUtil.insertionSort(testWords, cmp);
//
//		for (int i = 0; i < testWords.length; i++) {
//
//			assertEquals( solutions[i], testWords[i]);
//		}
//	}

	// shellSort Tests
	// Test basic shellSort
	@Test
	public void testShellSortReadFileSort() {
		// System.out.println("Testing Shell Sort");
		StringComparator cmp = new StringComparator();
		String[] testWords = readFile("sample_word_list.txt");
		String[] solutions = readFile("sample_solutions.txt");
		AnagramUtil.shellSort(testWords, cmp);

		for (int i = 0; i < testWords.length; i++) {
			assertEquals(solutions[i], testWords[i]);
		}
	}

	// Test a very small or non existent word list
	@Test
	public void testShellSortReadFileSortTwoItems() {
		// System.out.println("Testing Shell Sort");
		StringComparator cmp = new StringComparator();
		String[] testWords = readFile("additional_word_list.txt");
		String[] solutions = readFile("additional_solutions.txt");
		AnagramUtil.shellSort(testWords, cmp);

		for (int i = 0; i < testWords.length; i++) {
			assertEquals(solutions[i], testWords[i]);
		}
	}

	// Test a large word list
	@Test
	public void testShellSortModerateList() {
		// System.out.println("Testing Insertion Sort");
		StringComparator cmp = new StringComparator();
		String[] testWords = readFile("moderate_word_list.txt");
		String[] solutions = readFile("moderate_solutions.txt");
		AnagramUtil.shellSort(testWords, cmp);

		for (int i = 0; i < testWords.length; i++) {

			assertEquals(solutions[i], testWords[i]);
		}
	}

	// Test shellSort with number Strings
	@Test
	public void testShellSortNumbers() {
		// System.out.println("Testing Insertion Sort");
		StringComparator cmp = new StringComparator();
		String[] testWords = readFile("number_sample_sort.txt");
		String[] solutions = readFile("number_insert_shell_solutions.txt");
		AnagramUtil.shellSort(testWords, cmp);

		for (int i = 0; i < testWords.length; i++) {
			assertEquals(solutions[i], testWords[i]);
		}
	}

	@Test
	public void testShellSortDouble() {
		// System.out.println("Testing Insertion Sort");
		DoubleComparator cmp = new DoubleComparator();
		Double[] testWords = { 12.5, 56.2, 59.1, 61.5, 1.0, 0.25965, .26541, 9.256 };
		Double[] solutions = { 0.25965, 0.26541, 1.0, 9.256, 12.5, 56.2, 59.1, 61.5 };

		AnagramUtil.shellSort(testWords, cmp);

		for (int i = 0; i < testWords.length; i++) {
//			System.out.println(testWords[i]);

			assertEquals(solutions[i], testWords[i]);
		}
	}

	@Test
	public void testShellSortInteger() {
		// System.out.println("Testing Insertion Sort");
		IntegerComparator cmp = new IntegerComparator();
		Integer[] testWords = { 12, 56, 24, 154, 6743, 34634, 76756, 2354, 25, 59, 61, 1, 5965, 41, 96 };
		Integer[] solutions = { 1, 12, 24, 25, 41, 56, 59, 61, 96, 154, 2354, 5965, 6743, 34634, 76756 };

		AnagramUtil.shellSort(testWords, cmp);

		for (int i = 0; i < testWords.length; i++) {

			assertEquals(solutions[i], testWords[i]);
		}
	}

	// Test Shell/Insertion Sort Combined with Sort to sort all the letters in abc
	// order followed by the words in abc order
	@Test
	public void testInsertionSortAndNormalSortTogether() {
		// System.out.println("Testing Insertion Sort");
		StringComparator cmp = new StringComparator();
		String[] testWords = readFile("number_sample_sort.txt");

		String[] afterSort = new String[testWords.length];

		for (int i = 0; i < testWords.length; i++) {

			afterSort[i] = AnagramUtil.sort(testWords[i]);

		}

		String[] solutions = readFile("number_solution_bothSorts.txt");

		AnagramUtil.insertionSort(afterSort, cmp);

		for (int j = 0; j < testWords.length; j++) {

			assertEquals(afterSort[j], solutions[j]);
//			System.out.println(afterSort[j]);
		}
	}

	// areAnagrams Tests

	// Test that two Strings are anagrams
	@Test
	public void testAreAnagramsTrue() {
		String a = "rats";
		String b = "star";

		assertEquals(true, AnagramUtil.areAnagrams(a, b));

	}

	// Test that two Strings are NOT anagrams
	@Test
	public void testAreAnagramsFalse() {
		String a = "rats";
		String b = "art";

		assertEquals(false, AnagramUtil.areAnagrams(a, b));

	}

	@Test
	public void testAreAnagramsTrueIntegerString() {
		String a = "12345";
		String b = "53421";

		assertEquals(true, AnagramUtil.areAnagrams(a, b));

	}

	@Test
	public void testAreAnagramsFalseIntegerString() {
		String a = "12348";
		String b = "53421";

		assertEquals(false, AnagramUtil.areAnagrams(a, b));

	}

	@Test
	public void testAreAnagramsTrueCharacters() {
		String a = "10-2.34/5";
		String b = "-./012345";

		assertEquals(true, AnagramUtil.areAnagrams(a, b));

	}

	// getLargestAnagrams Tests

	@Test
	public void testGetLargestAnagramGroupReadFile() {
		// System.out.println("Testing Get Largest Anagram Group");
		String[] testWords = readFile("sample_word_list.txt");
		String[] testArr = AnagramUtil.getLargestAnagramGroup(testWords);
		String[] solutions = readFile("anagram_sample_sort.txt");

		for (int i = 0; i < testArr.length; i++) {
//			System.out.println(testArr[i]);
			assertEquals(solutions[i], testArr[i]);
		}
	}

	@Test
	public void testGetLargestAnagramGroupTwoItems() {
		// System.out.println("Testing Get Largest Anagram Group Two Items");
		String[] testWords = { "trap", "rapt" };
		String[] testArr = AnagramUtil.getLargestAnagramGroup(testWords);
		String[] solutions = { "trap", "rapt" };

		// does this need to return the orignals in abc order?

		for (int i = 0; i < testArr.length; i++) {

//			System.out.println(testArr[i]);
			assertEquals(solutions[i], testArr[i]);
		}
	}

	@Test
	public void tesGetLargestAnagramGroupOneItem() {
		// System.out.println("Testing Get Largest Anagram Group One Item");
		StringComparator cmp = new StringComparator();
		String[] testWords = { "trap" };
		String[] testArr = AnagramUtil.getLargestAnagramGroup(testWords);
		String[] solution = { "trap" };

		for (int i = 0; i < testArr.length; i++) {

			assertEquals(solution[i], testArr[i]);
		}
	}

	// Test getLargestAnagram using number Strings
	@Test
	public void testGetLargestAnagramNumbers() {
		// System.out.println("Testing Get Largest Anagram Group");
		String[] testWords = { "56", "12", "24", "154", "6743", "34634", "76756", "21", "2354", "25", "59", "61", "1",
				"5965", "41", "96" };

		String[] testArr = AnagramUtil.getLargestAnagramGroup(testWords);
		String[] solution = { "12", "21" };

		for (int i = 0; i < testArr.length; i++) {
//			System.out.println(testArr[i]);
			assertEquals(solution[i], testArr[i]);
		}
	}

	@Test
	public void testGetLargestAnagramNumbersNoneMatching() {
		// System.out.println("Testing Get Largest Anagram Group");
		String[] testWords = { "56", "24", "154", "6743", "34634", "76756", "21", "2354", "25", "59", "61", "1", "5965",
				"41", "96" };

		String[] testArr = AnagramUtil.getLargestAnagramGroup(testWords);
		String[] solution = { null };

		for (int i = 0; i < testArr.length; i++) {
//			System.out.println(testArr[i]);
			assertEquals(solution[i], testArr[i]);
		}
	}

	
	
	
	
	
	// How to test a null case??
	@Test
	public void testGetLargestAnagramGroupZeroItems() {
		// System.out.println("Testing Get Largest Anagram Group Zero Items");
		StringComparator cmp = new StringComparator();
		String[] testWords = new String[0];
		String[] testArr = AnagramUtil.getLargestAnagramGroup(testWords);
		String[] solution = new String[0];

		// System.out.println("test 1 arr i: " + testArr[i]);
		// assertEquals(solution[0], testArr[0]);

	}

//	F117
//	part
//	G11
//	autumn
//	MI6
//	lives
//	GSG9
//	11G
//	Boeing747
//	rapt
//	rike
//	prat
//	Viles
//	evils
//	erik

	// String comparator for testing
	public class StringComparator implements Comparator<String> {
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}
	}

	public class DoubleComparator implements Comparator<Double> {

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return (arg0.compareTo(arg1));
		}
	}

	public class IntegerComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer arg0, Integer arg1) {
			// TODO Auto-generated method stub
			return (arg0.compareTo(arg1));
		}
	}

	// Create a random string [a-z] of specified length
	public static String randomString(int length) {
		String retval = "";
		for (int i = 0; i < length; i++) {
			// ASCII values a-z are contiguous (26 characters)
			retval += (char) ('a' + (rand.nextInt(26)));
		}
		return retval;
	}

	// Reads words from a file (assumed to contain one word per line)
	// Returns the words as an array of strings.
	public static String[] readFile(String filename) {
		ArrayList<String> results = new ArrayList<String>();
		try {
			BufferedReader input = new BufferedReader(new FileReader(filename));
			while (input.ready()) {
				results.add(input.readLine());
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] retval = new String[1];
		return results.toArray(retval);
	}

}
