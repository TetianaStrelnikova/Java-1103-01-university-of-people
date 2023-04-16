package discussion_unit_2;
import java.util.Arrays;
/**
 * Sorts the given integer array in ascending order using QuickSort algorithm.
 *
 * @param a The integer array to be sorted.
 * @param low The starting index of the sub-array to be sorted.
 * @param high The ending index of the sub-array to be sorted.
 * @return The sorted integer array.
 */
public class QuickSort {
	public static int[] quickSort(int[] a, int low, int high) {
		if (low < high) {
			int pi = partition(a, low, high);

			quickSort(a, low, pi - 1);
			quickSort(a, pi + 1, high);
		}
		return a;

	}
	/**
	The partition method partitions a sub-array of an integer array around a pivot element
	and returns the index of the pivot element.
	@param arr The integer array to be partitioned.
	@param low The starting index of the sub-array to be partitioned.
	@param high The ending index of the sub-array to be partitioned.
	@return The index of the pivot element.
	*/
	private static int partition(int arr[], int low, int high) {
	    int pivot = arr[high];
	    int i = (low-1);

	    for (int j = low; j < high; j++) {
	        if (arr[j] <= pivot) {
	            i++;

	            int swapTemp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = swapTemp;
	        }
	    }

	    int swapTemp = arr[i+1];
	    arr[i+1] = arr[high];
	    arr[high] = swapTemp;

	    return i+1;
	}
	/**
	The main method demonstrates the usage of the QuickSort class by sorting an integer array using the quickSort method
	and printing the sorted array.
	@param args The command line arguments.
	*/
	public static void main(String[] args) {
		int[] a = { 1, 20, 4, 5, 13, 7, 6, 3, 9, 12, 8, 10, 11 };
		quickSort(a,0,a.length-1);
		System.out.println(Arrays.toString(a));
	}
}
