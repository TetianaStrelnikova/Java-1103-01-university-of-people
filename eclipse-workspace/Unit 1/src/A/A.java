/*
Array size 1,000
Elapsed time:
 selectionSort(): 3 milliseconds
 Arrays.sort():   2 milliseconds

Array size 10,000
Elapsed time:
selectionSort():  27 milliseconds
Arrays.sort():    4 milliseconds

Array size 100,000
Elapsed time:
selectionSort():  2189 milliseconds
Arrays.sort():    25 milliseconds
*/
package A;
import java.util.Arrays;
/**
 * A class representing an integer array of size 1000/1000/100,000 
 * filled with random integer values between 0 and Integer.MAX_VALUE.
 */
public class A {
	static final int S = 100000; // constant holding the arrow size (1000, 10000, 100000)
	int[] arr = new int[S];
	 /**
     * Constructor that fills the array with random integer values.
     */
	A() {
		for (int i = 0; i < S; i++) {
			arr[i] = (int) (Integer.MAX_VALUE * Math.random()); // generates random integer between 0 and 999

		}
	}
	/**
	 * Sorts the specified array of integers in ascending order using the selection
	 * sort algorithm.
	 * 
	 * Selection sort works by iterating through the array, finding the smallest
	 * element in the unsorted part of the array, and swapping it with the first
	 * unsorted element. The process is repeated until the entire array is sorted.
	 *
	 * @param arr the array of integers to be sorted in ascending order
	 * 
	 * @throws NullPointerException if arr is null
	 */
	public void selectionSort() {
		try {
			int iMin;
			/*
			 * With the outer loop we iterating through the array
			 * 
			 * we use index< arr.lenght-1 because by the time the program reach the last
			 * element the array will be already sorted and it is not needed to make whole
			 * comparing operations for the last element
			 * 
			 * with the inner loop we comparing the element from the array with all the
			 * elements in this array starting from minimal index Searching for the smallest
			 * element in the unsorted part and place it at beginning
			 */
			for (int i = 0; i < arr.length - 1; i++) {
				// iMin variable will keep track of the index of the smallest unsorted element
				// found in the inner loop.
				iMin = i;
				for (int iToSort = i + 1; iToSort < arr.length; iToSort++) {
					/*
					 * If the current element being iterated (arr[iToSort]) is smaller than the
					 * current smallest unsorted element (arr[iMin]), the iMin variable is updated
					 * to point to the new smallest element.
					 */
					if (arr[iMin] > arr[iToSort]) {
						iMin = iToSort;
					}
				}
				/*
				 * these three lines of code swap the values of two elements in an array while
				 * preserving the original value of one of them in a temporary variable
				 * 
				 * After the inner loop finishes, the smallest unsorted element found
				 * (arr[iMin]) is swapped with the first unsorted element in the array (arr[i]).
				 * 
				 * the value of the element at index i is stored in a temporary variable called
				 * smallest. This is necessary because once the value at index i is replaced
				 * with the value at index iMin, the original value at index i would be lost.
				 */
				int smallest = arr[i];
				// replacing the value at index i with the value at index iMin.
				arr[i] = arr[iMin];
				// replacing the value at index iMin with the value stored in smallest, which is
				// the original value at index i.
				arr[iMin] = smallest;
			}
		} catch (NullPointerException e) {
			System.err.println("Input array cannot be null");
		}
	}
	/**
	Sorts the input integer array using selection sort algorithm in ascending order.
	@throws NullPointerException If the input array is null.
	*/
	public void selectionSort(int[] arr) {
		try {
			int iMin;
			for (int i = 0; i < arr.length - 1; i++) {
				iMin = i;
				for (int iToSort = i + 1; iToSort < arr.length; iToSort++) {
					if (arr[iMin] > arr[iToSort]) {
						iMin = iToSort;
					}
				}
				int smallest = arr[i];
				arr[i] = arr[iMin];
				arr[iMin] = smallest;
			}
		} catch (NullPointerException e) {
			System.err.println("Input array cannot be null");
		}
	}
	public static void main(String[] args) {
		A first = new A();
		// System.out.println(Arrays.toString(first.arr));
		// Capture the start time
		long startTime = System.currentTimeMillis();
		// Sorting using custom search
		first.selectionSort();
		// Capture the end time
		long endTime = System.currentTimeMillis();
		// Calculate the elapsed time
		long elapsedTime = endTime - startTime;
		// Printing the sorted arrow
		// System.out.println(Arrays.toString(first.arr));
		// Print out the sorted array and elapsed time
		System.out.println("Elapsed time: " + elapsedTime + " milliseconds");

		A second = new A();
		// System.out.println(Arrays.toString(second.arr));
		// Capture the start time
		startTime = System.currentTimeMillis();
		// Sorting using sort() method
		Arrays.sort(second.arr);
		// Capture the end time
		endTime = System.currentTimeMillis();
		// Calculate the elapsed time
		elapsedTime = endTime - startTime;
		// Printing the arrow
		// System.out.println(Arrays.toString(first.arr));
		// Print out the sorted array and elapsed time
		System.out.println("Elapsed time: " + elapsedTime + " milliseconds");
	}
}
