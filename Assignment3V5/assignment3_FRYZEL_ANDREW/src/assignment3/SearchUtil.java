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

		int firstIndex = 0;
		int lastIndex = list.size() - 1;
		int mid = 0;

		while (firstIndex < lastIndex) {

			// try mid = (lastIndex - firstIndex
			mid = (firstIndex + (lastIndex - firstIndex) / 2);

			if (cmp.compare(item, list.get(mid)) == 0) {
				return true;
			}
			if (cmp.compare(item, list.get(mid)) < 0) {
				lastIndex = mid - 1;

			}
			if ((cmp.compare(item, list.get(mid)) > 0)) {
				firstIndex = mid + 1;
			}

		}
		return false;

	}
}

//		
//		
//		
//		
//		
//
//		// if too slow, test for cutting out the edge cases and
//		// Size of 1 or 2 edge cases
//		if (list.size() == 1) {
//			if (cmp.compare(list.get(0), item) == 0) {
//				return true;
//			} else
//				return false;
//		} // Size 2 edge cases
//		if (list.size() == 2) {
//			if (cmp.compare(list.get(0), item) == 0) {
//				return true;
//			} else if (cmp.compare(list.get(1), item) == 0) {
//				return true;
//			} else
//				return false;
//		}
//
//		// can put at beginning so it fails earlier
//		// before this was if(list.size() - 1 <= 1)
//
//		else if (list.size() == 0) {
//			return false;
//		}
//
//		int mid = (1 + (list.size()) / 2);
//
//		if (cmp.compare(list.get(mid), item) == 0) {
//			return true;
//		}
//
//		else if (cmp.compare(list.get(mid), item) < 0)
//
//		{
//
//			// [] [] [] MID [] [] []
//			ArrayList<T> newList;
////size()-1
//			newList = new ArrayList<T>(list.subList(mid, list.size()));
//
//			binarySearch(newList, item, cmp);
//
//		}
//		//use a whilel loop and dont use sublist or any array functions other than get
//		//
//
//		else if (cmp.compare(list.get(mid), item) > 0) {
//
//			ArrayList<T> newList;
//
//		
//
//			// [] [] [] MID [] [] []
//
//			binarySearch(, item, cmp);
//
//		}
//
////		if (list.size() - 1 <= 1)
////			return false;
