public void topDownMergeSort(int[] A, int n) {
    int[] B = Arrays.copyOf(A, A.length);	// duplicate array A[] into B[]
    topDownSplit(B, 0, n, A);			// sort data from B[] into A[]
}
// Sort the given run of array A[] using array B[] as a source.
// iBegin is inclusive; iEnd is exclusive (A[iEnd] is not in the set).
public void topDownSplit(int[] B, int iBegin, int iEnd, int[] A) {
    if(iEnd - iBegin < 2) return;		// if run size == 1, consider it sorted
    // split the run longer than 1 item into halves
    int iMiddle = (iEnd + iBegin) / 2;		// iMiddle = mid point
    // recursively sort both runs from array A[] into B[]
    topDownSplit(A, iBegin,  iMiddle, B);	// sort the left  run
    topDownSplit(A, iMiddle,    iEnd, B);	// sort the right run
    // merge the resulting runs from array B[] into A[]
    topDownMerge(B, iBegin, iMiddle, iEnd, A);
}
//  Left source half is A[ iBegin:iMiddle-1].
// Right source half is A[iMiddle:iEnd-1   ].
// Result is            B[ iBegin:iEnd-1   ].
public void topDownMerge(int[] A, int iBegin, int iMiddle, int iEnd, int[] B) {
    int i = iBegin, j = iMiddle;
    // While there are elements in the left or right runs...
    for (int k = iBegin; k < iEnd; k++) {
        // If left run head exists and is <= existing right run head.
        if (i < iMiddle && (j >= iEnd || A[i] <= A[j])) {
            B[k] = A[i++];
        } else {
            B[k] = A[j++];
        }
    } 
}
