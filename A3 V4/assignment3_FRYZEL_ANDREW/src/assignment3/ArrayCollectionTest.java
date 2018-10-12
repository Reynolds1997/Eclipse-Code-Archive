package assignment3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayCollectionTest {

//	@Before
//	public void setUp() {
//		ArrayCollection arr = new ArrayCollection();	
//	}

	// add test for duplicate
	// test for full colelction
	// test for edge cases

	// !!!!!!!!!!!!for all tests, test different types, Integer String etc

	// add Tests

	@Test
	public void testAddToBlank() {
		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();
		Integer ans = 10;

		assertEquals(true, arr.add(ans));

	}

	@Test
	public void testAddToDuplicate() {

		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();
		Integer ans = 10;
		arr.add(10);

		assertEquals(false, arr.add(ans));

	}

	@Test
	public void testAddToEnd() {
		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();
		int length = arr.size;

		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}

		assertEquals(true, arr.add(200));

		// how to see the total length of the arr
		// add three more tests that test same add ideas but

	}

	@Test
	public void testAddToBlankString() {
		ArrayCollection<String> arr = new ArrayCollection<String>();
		String ans = "hello";

		assertEquals(true, arr.add(ans));

	}

	@Test
	public void testAddToDuplicateString() {

		ArrayCollection<String> arr = new ArrayCollection<String>();
		String ans = "hello";
		arr.add("hello");

		assertEquals(false, arr.add(ans));

	}

	@Test
	public void testAddToEndString() {
		ArrayCollection<String> arr = new ArrayCollection<String>();
		int length = arr.size;

		for (int i = 0; i < 12; i++) {
			arr.add("hello" + i);

		}

		assertEquals(true, arr.add("hello1000"));

		// how to see the total length of the arr
		// add three more tests that test same add ideas but

	}

	// addAll Tests

	@Test
	public void testAddAllToBlank() {
		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();

		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}
		ArrayCollection<Integer> arr2 = new ArrayCollection<Integer>();

		assertEquals(true, arr2.addAll(arr));

	}

	@Test
	public void testAddAllDuplicates() {
		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();

		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}

		ArrayCollection<Integer> arr2 = new ArrayCollection<Integer>();
		for (int j = 0; j < 12; j++) {
			arr2.add(j);

		}

		assertEquals(false, arr2.addAll(arr));

	}

	@Test
	public void testAddAllToEnd() {

		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();

		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}

		ArrayCollection<Integer> arr2 = new ArrayCollection<Integer>();
		for (int j = 10; j < 22; j++) {
			arr2.add(j);

		}

		assertEquals(true, arr2.addAll(arr));

	}

	@Test
	public void testAddAllToBlankString() {
		ArrayCollection<String> arr = new ArrayCollection<String>();

		for (int i = 0; i < 12; i++) {
			arr.add("" + i);

		}
		ArrayCollection<String> arr2 = new ArrayCollection<String>();

		assertEquals(true, arr2.addAll(arr));

	}

//kicking us out. help
	// TODO
	@Test
	public void testAddAllDuplicatesString() {
		ArrayCollection<String> arr = new ArrayCollection<String>();
		ArrayCollection<String> arr2 = new ArrayCollection<String>();

		for (int i = 0; i < 12; i++) {
			arr.add("" + i);

			arr2.add("" + i);
		}

		for (int j = 0; j < 12; j++) {

		}

		assertEquals(false, arr2.addAll(arr));

	}

	@Test
	public void testAddAllToEndString() {

		ArrayCollection<String> arr = new ArrayCollection<String>();

		for (int i = 0; i < 12; i++) {
			arr.add("" + i);

		}

		ArrayCollection<String> arr2 = new ArrayCollection<String>();
		for (int j = 10; j < 22; j++) {
			arr2.add("" + j);

		}

		assertEquals(true, arr2.addAll(arr));

	}

//find ways to test clear thoroughly
	@Test
	public void testClear() {
		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();
		for (int i = 0; i < 12; i++) {
			arr.add(i);

			arr.clear();

		}
		System.out.println(arr.size);

	}

	// contains Tests
	@Test
	public void testContainsTrue() {
		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();
		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}
		assertEquals(true, arr.contains(1));

	}

	@Test
	public void testContainsFalse() {
		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();

		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}

		assertEquals(false, arr.contains(150));

	}

	@Test
	public void testContainsTrueString() {
		ArrayCollection<String> arr = new ArrayCollection<String>();
		for (int i = 0; i < 12; i++) {
			String ans = "";
			arr.add(ans + i);

		}
		assertEquals(true, arr.contains("1"));

	}

	@Test
	public void testContainsFalseString() {
		ArrayCollection<String> arr = new ArrayCollection<String>();
		for (int i = 0; i < 12; i++) {
			String ans = "";
			arr.add(ans + i);

		}
		assertEquals(false, arr.contains("100"));

	}

	// containsAll Tests

	@Test
	public void testContainsAllTrue() {
		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();
		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}

		ArrayCollection<Integer> arr2 = new ArrayCollection<Integer>();
		for (int j = 0; j < 5; j++) {
			arr2.add(j);

		}

		assertEquals(true, arr.containsAll(arr2));
	}

	@Test
	public void testContainsAllFalse() {
		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();
		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}

		ArrayCollection<Integer> arr2 = new ArrayCollection<Integer>();
		for (int j = 10; j < 15; j++) {
			arr2.add(j);

		}

		assertEquals(false, arr.containsAll(arr2));
	}

	@Test
	public void testContainsAllSecondArrBiggerThanFirst() {
		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();
		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}

		ArrayCollection<Integer> arr2 = new ArrayCollection<Integer>();
		for (int j = 0; j < 20; j++) {
			arr2.add(j);

		}

		assertEquals(false, arr.containsAll(arr2));
	}

	@Test
	public void testContainsAllHalfTrue() {
		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();
		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}

		ArrayCollection<Integer> arr2 = new ArrayCollection<Integer>();
		for (int j = 6; j < 13; j++) {
			arr2.add(j);

		}

		assertEquals(false, arr.containsAll(arr2));
	}

	@Test
	public void testContainsAllSecondBigger() {
		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();
		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}

		ArrayCollection<Integer> arr2 = new ArrayCollection<Integer>();
		for (int j = 0; j < 20; j++) {
			arr2.add(j);

		}

		assertEquals(false, arr.containsAll(arr2));
	}

	// isEmpty Tests
	@Test
	public void testIsEmptyTrue() {
		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();

		assertEquals(true, arr.isEmpty());
	}

	@Test
	public void testIsEmptyFalse() {
		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();
		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}

		assertEquals(false, arr.isEmpty());
	}

	@Test
	public void testIsEmptyAfterAClear() {
		ArrayCollection<String> arr = new ArrayCollection<String>();
		for (int i = 0; i < 12; i++) {
			arr.add("" + i);

		}
		arr.clear();

		assertEquals(true, arr.isEmpty());
	}

	@Test
	public void testIsEmptyTrueString() {
		ArrayCollection<String> arr = new ArrayCollection<String>();

		assertEquals(true, arr.isEmpty());
	}

	@Test
	public void testIsEmptyFalseString() {
		ArrayCollection<String> arr = new ArrayCollection<String>();
		for (int i = 0; i < 12; i++) {
			arr.add("" + i);

		}

		assertEquals(false, arr.isEmpty());
	}

	@Test
	public void testIsEmptyAfterAClearString() {
		ArrayCollection<String> arr = new ArrayCollection<String>();
		for (int i = 0; i < 12; i++) {
			arr.add("" + i);

		}
		arr.clear();

		assertEquals(true, arr.isEmpty());
	}

	// Iterator Tests

	// removeTests
	@Test
	public void testRemove() {

		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();
		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}

//		System.out.println(arr.contains(1));
//		System.out.println(arr.size);

		assertEquals(true, arr.remove(1));

//		System.out.println(arr.contains(1));
//		System.out.println(arr.size);
	}

	@Test
	public void testRemoveUnknownObject() {

		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();
		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}
//		System.out.println(arr.size());
//		System.out.println(arr.contains(20));

		assertEquals(false, arr.remove(20));

	}

	// removeAll Tests
	@Test
	public void testRemoveAllTwoExactSameArrayCollections() {
		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();
		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}

//		System.out.println(arr.size);
		ArrayCollection<Integer> arr2 = new ArrayCollection<Integer>();
		for (int j = 0; j < 12; j++) {
			arr2.add(j);

		}

		assertEquals(true, arr.removeAll(arr2));

//		System.out.println(arr.size);
	}

	@Test
	public void testRemoveAllHalfSameElements() {
		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();
		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}

//		System.out.println("The size before is " +arr.size);
		ArrayCollection<Integer> arr2 = new ArrayCollection<Integer>();
		for (int j = 6; j < 12; j++) {
			arr2.add(j);

		}

		assertEquals(true, arr.removeAll(arr2));

//		System.out.println("The size after is " +arr.size);
	}

	@Test
	public void testRemoveAllFalse() {
		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();
		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}

//		System.out.println(arr.size);
		ArrayCollection<Integer> arr2 = new ArrayCollection<Integer>();
		for (int j = 15; j < 20; j++) {
			arr2.add(j);

		}

		assertEquals(false, arr.removeAll(arr2));

//		System.out.println("The size is " +arr.size);
	}

	// retainAllTests
	@Test
	public void testRetainAll() {
		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();
		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}

		ArrayCollection<Integer> arr2 = new ArrayCollection<Integer>();
		for (int j = 0; j < 5; j++) {
			arr2.add(j);

		}

//		System.out.println("The size is " +arr.size);
//		System.out.println("The size is " +arr2.size);

		assertEquals(true, arr.retainAll(arr2));

//		System.out.println("The size is " +arr.size);
//		System.out.println("The size is " +arr2.size);
	}

	@Test

	public void testRetainsAllNoCommon() {
		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();
		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}

		ArrayCollection<Integer> arr2 = new ArrayCollection<Integer>();
		for (int j = 20; j < 25; j++) {
			arr2.add(j);

		}
//		System.out.println("The size is " +arr.size);
//		System.out.println("The size is " +arr2.size);

		assertEquals(true, arr.retainAll(arr2));

//		System.out.println("The size is " +arr.size);
//		System.out.println("The size is " +arr2.size);
	}

	@Test
	public void testRetainsFalse() {
		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();
		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}

		ArrayCollection<Integer> arr2 = new ArrayCollection<Integer>();
		for (int j = 0; j < 12; j++) {
			arr2.add(j);

		}

		assertEquals(false, arr.retainAll(arr2));

	}

	@Test
	public void testRetainsAllFalse() {
		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();
		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}

		ArrayCollection<Integer> arr2 = new ArrayCollection<Integer>();
		for (int j = 6; j < 12; j++) {
			arr2.add(j);

		}
//		System.out.println("The size is " +arr.size);
//		System.out.println("The size is " +arr2.size);

		assertEquals(false, arr2.retainAll(arr));

//		System.out.println("The size is " +arr.size);
//		System.out.println("The size is " +arr2.size);
	}
//average cases
	// bianry logn
	// contains avergage n, worst n, best n(1)
	//
	// toArray Tests

	// Needs MORE tests
	@Test
	public void testToArray() {

		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();
		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}

		ArrayCollection<Integer> arr2 = new ArrayCollection<Integer>();
		for (int j = 0; j < 12; j++) {
			arr2.add(j);

		}

		arr.toArray();
//		System.out.println(arr.size);

		assertEquals(true, arr.containsAll(arr2));

	}

	@Test
	public void testToArrayHalfValuesTrue() {

		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();
		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}

		ArrayCollection<Integer> arr2 = new ArrayCollection<Integer>();
		for (int j = 6; j < 12; j++) {
			arr2.add(j);

		}

		arr.toArray();
//		System.out.println(arr.size);

		assertEquals(true, arr.containsAll(arr2));

	}

	@Test
	public void testToArrayHalfValuesFalse() {

		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();
		for (int i = 0; i < 12; i++) {
			arr.add(i);

		}

		ArrayCollection<Integer> arr2 = new ArrayCollection<Integer>();
		for (int j = 15; j < 20; j++) {
			arr2.add(j);

		}

		arr.toArray();
//		System.out.println(arr.size);

		assertEquals(false, arr.containsAll(arr2));

	}

	// toSorted Tests

	// return an arraylist idk how to test
	// TODO
	// probably good
	@Test
	public void testToSortedList() {

		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();

		arr.add(14);
		arr.add(4);
		arr.add(21);
		arr.add(5);
		arr.add(13);
		arr.add(3);

		ArrayList<Integer> arr2 = new ArrayList<Integer>();

		// cant add duplicates
		// wont add these to arr

		arr2.add(3);
		arr2.add(4);
		arr2.add(5);
		arr2.add(13);
		arr2.add(14);
		arr2.add(21);

		// make array of sorted value
		// call to sorted on unsorted arr and compare to sorted

		SortCollectionInteger cmp = new SortCollectionInteger();

		ArrayList<Integer> ans = new ArrayList<Integer>();

		arr.toSortedList(cmp);

		ans = arr.toSortedList(cmp);

		for (int i = 0; i < 6; i++) {
			assertEquals(ans.get(i), arr2.get(i));
		}
		System.out.println(ans);

//		assertEquals();

	}

	// sortedList Tests

	protected class SortCollectionInteger implements Comparator<Integer> {

		@Override
		public int compare(Integer arg0, Integer arg1) {

			return (arg0.compareTo(arg1));
		}

	}

	@Test
	public void testToSortedString() {

		ArrayCollection<String> arr = new ArrayCollection<String>();

		arr.add("apple");
		arr.add("banana");
		arr.add("fred");
		arr.add("moon");
		arr.add("zebra");
		arr.add("monkey");
		arr.add("no");
		arr.add("cat");
		arr.add("xylophone");
		arr.add("a");
		arr.add("b");
		arr.add("cdsad");
		arr.add("pdaif");
		arr.add("king");
		arr.add("queen");

		// ask about this moon nonsense

		SortCollectionString cmp = new SortCollectionString();

		ArrayList<String> ans = new ArrayList<String>();

		arr.toSortedList(cmp);

		ans = arr.toSortedList(cmp);

		System.out.println(ans);

	}

	protected class SortCollectionString implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {

			return (arg0.compareTo(arg1));
		}

	}

	// binarySearch Tests
	@Test
	public void testBinarySearchTrue() {

		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();

		arr.add(14);
		arr.add(4);
		arr.add(21);
		arr.add(5);
		arr.add(70);
		arr.add(56);
		arr.add(16);
		arr.add(1);

		SortCollectionInteger cmp = new SortCollectionInteger();

		ArrayList<Integer> ans = new ArrayList<Integer>();

		arr.toSortedList(cmp);

		ans = arr.toSortedList(cmp);

		assertEquals(true, SearchUtil.binarySearch(ans, 21, cmp));

	}

	@Test
	public void testBinarySearchFalse() {

		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();

		arr.add(14);
		arr.add(4);
		arr.add(21);
		arr.add(5);
		arr.add(70);
		arr.add(56);
		arr.add(16);
		arr.add(1);

		SortCollectionInteger cmp = new SortCollectionInteger();

		ArrayList<Integer> ans = new ArrayList<Integer>();

		arr.toSortedList(cmp);

		ans = arr.toSortedList(cmp);

		assertEquals(false, SearchUtil.binarySearch(ans, 70, cmp));

	}

	@Test
	public void testBinarySearchSingle() {

		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();

		arr.add(1);

		SortCollectionInteger cmp = new SortCollectionInteger();

		ArrayList<Integer> ans = new ArrayList<Integer>();

		arr.toSortedList(cmp);

		ans = arr.toSortedList(cmp);

		assertEquals(true, SearchUtil.binarySearch(ans, 1, cmp));
	}

	@Test
	public void testBinarySearchDouble() {

		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();

		arr.add(1);
		arr.add(2);

		SortCollectionInteger cmp = new SortCollectionInteger();

		ArrayList<Integer> ans = new ArrayList<Integer>();

		arr.toSortedList(cmp);

		ans = arr.toSortedList(cmp);

		assertEquals(true, SearchUtil.binarySearch(ans, 2, cmp));

	}

	@Test
	public void testBinarySearchDoubleFirstItemTrue() {

		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();

		arr.add(1);
		arr.add(2);

		SortCollectionInteger cmp = new SortCollectionInteger();

		ArrayList<Integer> ans = new ArrayList<Integer>();

		arr.toSortedList(cmp);

		ans = arr.toSortedList(cmp);

		assertEquals(true, SearchUtil.binarySearch(ans, 1, cmp));

	}

	@Test
	public void testBinarySearchThreeItems() {

		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();

		arr.add(1);
		arr.add(2);
		arr.add(3);

		SortCollectionInteger cmp = new SortCollectionInteger();

		ArrayList<Integer> ans = new ArrayList<Integer>();

		arr.toSortedList(cmp);

		ans = arr.toSortedList(cmp);

		assertEquals(true, SearchUtil.binarySearch(ans, 3, cmp));

	}

	@Test
	public void testBinarySearchFourItems() {

		ArrayCollection<Integer> arr = new ArrayCollection<Integer>();

		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);

		SortCollectionInteger cmp = new SortCollectionInteger();

		ArrayList<Integer> ans = new ArrayList<Integer>();

		arr.toSortedList(cmp);

		ans = arr.toSortedList(cmp);

		assertEquals(true, SearchUtil.binarySearch(ans, 4, cmp));

	}
}
