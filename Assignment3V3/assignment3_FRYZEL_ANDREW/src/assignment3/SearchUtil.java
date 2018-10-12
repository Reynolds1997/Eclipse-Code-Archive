package assignment3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SearchUtil {

	/**
	 * 
	 * @param      <T> The type of elements contained in the list
	 * @param list An ArrayList to search through. This ArrayList is assumed to be
	 *             sorted according to the supplied comparator. This method has
	 *             undefined behavior if the list is not sorted.
	 * @param item The item to search for
	 * @param cmp  Comparator for comparing Ts or a super class of T
	 * @return true if "item" exists in "list", false otherwise
	 */
	public static <T> boolean binarySearch(ArrayList<T> list, T item, Comparator<? super T> cmp) {

		if (list.size() < 1)
			return false;

		int mid = 1 + (list.size() / 2);

		if (cmp.compare(list.get(mid), item) == 0) {
			return true;
		}

		if (cmp.compare(list.get(mid), item) < 0)

		{

			ArrayList<T> newList;

			newList = new ArrayList<T>(list.subList(mid, list.size()));

			// [] [] [] MID [] [] []

			binarySearch(newList, item, cmp);

		}

		else if (cmp.compare(list.get(mid), item) > 0) {

			ArrayList<T> newList;

			newList = new ArrayList<T>(list.subList(0, mid));

			// [] [] [] MID [] [] []

			binarySearch(newList, item, cmp);

		}

		return false;
	}
}