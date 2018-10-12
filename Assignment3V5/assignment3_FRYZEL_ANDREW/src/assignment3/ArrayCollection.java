package assignment3;

//toSOrtedList 
//Iteratro

//2
//plotting performance of to sorted list using varying sizes N
//compare contains to binary search (same purpose)
//study code from selection sort and to sorted list 
//best average and worst cases for methods

//testing binary, selection sort (toSorted), contains 

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Daniel Kopta and ?? Implements the Collection interface using an
 *         array as storage. The array must grow as needed. An ArrayCollection
 *         can not contain duplicates. All methods should be implemented as
 *         defined by the Java API, unless otherwise specified.
 * 
 *         It is your job to fill in the missing implementations and to comment
 *         this class. Every method should have comments (Javadoc-style
 *         prefered). The comments should at least indicate what the method
 *         does, what the arguments mean, and what the returned value is. It
 *         should specify any special cases that the method handles. Any code
 *         that is not self-explanatory should be commented.
 *
 * @param <T> - generic type placeholder
 */
public class ArrayCollection<T> implements Collection<T> {

	T data[]; // Storage for the items in the collection
	int size; // Keep track of how many items this collection holds

	// There is no clean way to convert between T and Object, so we suppress the
	// warning.
	@SuppressWarnings("unchecked")
	public ArrayCollection() {
		size = 0;
		// We can't instantiate an array of unknown type T, so we must create an Object
		// array, and typecast
		data = (T[]) new Object[10]; // Start with an initial capacity of 10
	}

	/**
	 * This is a helper function specific to ArrayCollection Doubles the size of the
	 * data storage array, retaining its current contents.
	 */
	@SuppressWarnings("unchecked")
	private void grow() {

		// test for size 0 arr
//		for(int i =0; i < data.length; i++) {
//		if(data[i] != null)
//			size++;
//		}
		int newSize = data.length * 2;

		T[] arr = (T[]) new Object[newSize];

		for (int j = 0; j < data.length; j++) {
			arr[j] = data[j];

//			if(data[j] != null)
//     			size++;
		}
		data = arr;

		// TODO fill in
		// You will need to use something similar to the code in the constructor above
		// to create a new array.
	}

	public boolean add(T arg0) {

		// should we use a binary search for this? faster/better?
		if (contains(arg0)) {
//			System.out.println(data[i]);

			return false;

			// data[data.length+1] = arg0

		}
		if (size == data.length) {
			this.grow();
		}
		data[size] = arg0;
		size++;
		return true;

		// if size == dat.length call grow
		// TODO Auto-generated method stub

	}

	public boolean addAll(Collection<? extends T> arg0) {
		boolean hasAdded = false;

		for (T s : arg0) {

			if (add(s)) {

				hasAdded = true;
			}

		}

		// TODO Auto-generated method stub
		return hasAdded;
	}

	// need tests
	public void clear() {

		for (int i = 0; i <= size; i++) {
			data[i] = null;
		}

//		T[] arr = (T[]) new Object[data.length];
//		data = arr;
		size = 0;

	}

//need tests
	public boolean contains(Object arg0) {

		for (int i = 0; i < size; i++) {
			if (data[i].equals(arg0)) {
				return true;

			}

		}

		return false;
	}

// need tests

	public boolean containsAll(Collection<?> arg0) {

		// collections need an interator
		// objects use comparator and .equals

		for (Object s : arg0) {

			if (!contains(s)) {
				return false;
			}
		}
		return true;

	}

	// needs tests
	public boolean isEmpty() {
		if (size == 0) {
			return true;

		} else
			return false;
	}

	// done
	public Iterator<T> iterator() {

		return new ArrayCollectionIterator();
	}

	// come back to
	public boolean remove(Object arg0) {
//Remove methods
		// use iterator to find it
		// can use either iterator or for loops or wahtever

		// Target Index
		int index = 0;

		if (!contains(arg0))
			return false;
		else

		{

			// set one item to null and then move all after back one
			for (int i = 0; i < size; i++) {
				if (data[i].equals(arg0)) {
					index = i;
					data[i] = null;
				}
			}

			for (int j = index; j < size; j++) {
				data[j] = data[j + 1];

			}
			size = size - 1;

			return true;
		}

		// Before the null stay the same
//			for (int k = 0; k < index; k++) {
//				newData[k] = data[k];
//			}

		// sets all values after the removed value to one index less than before

		// not sure if <or <= size
		// worrie about null ponter at end
		// need to test a same size same length examp
	}

	public boolean removeAll(Collection<?> arg0) {

		// test to make sure
		boolean ans = false;
		for (Object s : arg0) {
			// dont need this check
//			if (contains(s) == true)
			{
				if (remove(s)) {
					ans = true;
				}
			}

		}

		return ans;
	}

	public boolean retainAll(Collection<?> arg0) {

//		Iterator<Object> itr = arg0.iterator();
		boolean ans = false;
		Iterator<?> itr = this.iterator();
		while (itr.hasNext()) {

			if (!arg0.contains(itr.next())) {

				itr.remove();
				ans = true;

			}
		}
		return ans;

	}

//need tests
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	public Object[] toArray() {
		@SuppressWarnings("unchecked")

		T[] arr = (T[]) new Object[size];
		for (int i = 0; i < size; i++) {

			arr[i] = data[i];

		}

		return arr;
	}

	/*
	 * Don't implement this method (unless you want to). It must be here to complete
	 * the Collection interface. We will not test this method.
	 */
	public <T> T[] toArray(T[] arg0) {

		return null;
	}

	/*
	 * Sorting method specific to ArrayCollection - not part of the Collection
	 * interface. Must implement a selection sort (see Assignment 2 for code).
	 */
	public ArrayList<T> toSortedList(Comparator<? super T> cmp) {

		ArrayList<T> ans = new ArrayList<T>(size);

		for (int i = 0; i < size; i++) {

			int j;
			int minIndex = 0;

			for (j = i + 1; j < size; j++) {
				if (cmp.compare(data[j], data[i]) < 0) {
					minIndex = j;

					T temp = data[i];
					data[i] = data[j];

					data[minIndex] = temp;

				}
			}
			ans.add(data[i]);

		}

		return ans;
	}

	private class ArrayCollectionIterator implements Iterator<T> {
		public ArrayCollectionIterator() {

		}

		int nextIndex = 0;
		boolean allowed = false;

		public boolean hasNext() {

			if (nextIndex < size)
				return true;
			else
				return false;
		}

		public T next() {

			if (hasNext() == false) {
				throw new NoSuchElementException("No more items to iterate through");
			}
			allowed = true;

			return data[nextIndex++];
		}

		public void remove() {

			// issue with this method

			if (allowed = true) {
				int newIndex = nextIndex - 1;

//
//				for (int j = index; j < size; j++) {
//					data[j] = data[j + 1];
//
//				}
//				size = size - 1;

				data[newIndex] = null;

				for (int j = newIndex; j < size; j++) {
					data[j] = data[j + 1];

				}
				size = size - 1;

				// create a newIndex that is the same as the nextIndex so that we dont influence
				// the nextIndex counter

				// set all the values before the removed value to their same index

				nextIndex--;
			}

			else {
				throw new IllegalStateException(
						"Cannot call remove() twice in a row without calling next() in betwen remove() calls");
			}
			allowed = false;
		}

	}

}
