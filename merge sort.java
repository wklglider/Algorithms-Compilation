public void topDownMergeSort(int[] array, int n) {
    int[] helper = Arrays.copyOf(array, array.length);   // duplicate array array[] into helper[]
    topDownSplit(helper, 0, n, array);               // sort data from helper[] into array[]
}
// Sort the given run of array array[] using array helper[] as a source.
// iBegin is inclusive; iEnd is exclusive (array[iEnd] is not in the set).
public void topDownSplit(int[] helper, int iBegin, int iEnd, int[] array) {
    if (iEnd - iBegin < 2) return;          // if run size == 1, consider it sorted
    // split the run longer than 1 item into halves
    int iMiddle = (iEnd + iBegin) / 2;      // iMiddle = mid point
    // recursively sort both runs from array array[] into helper[]
    topDownSplit(array, iBegin, iMiddle, helper);    // sort the left  run
    topDownSplit(array, iMiddle, iEnd, helper);      // sort the right run
    // merge the resulting runs from array helper[] into array[]
    topDownMerge(helper, iBegin, iMiddle, iEnd, array);
}
//  Left source half is array[ iBegin:iMiddle-1].
// Right source half is array[iMiddle:iEnd-1   ].
// Result is            helper[ iBegin:iEnd-1   ].
public void topDownMerge(int[] array, int iBegin, int iMiddle, int iEnd, int[] helper) {
    int i = iBegin, j = iMiddle;
    // While there are elements in the left or right runs...
    for (int k = iBegin; k < iEnd; k++) {
        // If left run head exists and is <= existing right run head.
        if (i < iMiddle && (j >= iEnd || array[i] <= array[j])) {
            helper[k] = array[i++];
        } else {
            helper[k] = array[j++];
        }
    } 
}
