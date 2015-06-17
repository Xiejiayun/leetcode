package nju.software.leetcode.array;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 *For example,
 *Given [1,2,0] return 3,
 *and [3,4,-1,1] return 2.
 *Your algorithm should run in O(n) time and uses constant space. 
 * @author furnace
 */
public class FirstMissingPositive {

	public static void main(String[] args) {

	}
	
	/*
	 * given an array A, return the first missing positive 
	 */
    public int firstMissingPositive(int[] A) {
        if (A == null)
            return 1;
        int N = A.length;
        for (int i=0; i<N; i++) {
            if (A[i] == i+1)
                continue;  
            if (A[i] != i+1 && A[i] > 0 && A[i] <= N) {
            	if (A[i] == A[A[i]-1])
            		continue;
            	exchange(A, i, A[i]-1);
            	 i--;
            }
        }
        for (int i=0; i<N; i++) {
            if (A[i] != i+1)
                return i+1;
        }
        return N+1;
    }
    
    /*
     * exchange two integers in an array A at position i and j
     */
    public void exchange(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

}
