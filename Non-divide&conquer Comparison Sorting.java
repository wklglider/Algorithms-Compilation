// Insertions Sort
public void insertionSort(int[] A) {
    for (int i = 0; i < A.length; i++)
        for (int j = i; j > 0 && A[j-1] > A[j]; j--)
            swap(A, j-1, j);
}
 
// Selection Sort
public void selectionSort(int[] A) {
    for (int i = 0; i < A.length-1; i++) {
        int min = i;
        for (int j = i+1; j < A.length; j++)
            if (A[j] < A[min])
                min = j;
        swap(A, i, min);
    }
}
 
// Bubble Sort
public void bubbleSort(int[] A) {
    for (int i = A.length-1; i >= 1; i--)
        for (int j = 0; j < i; j++)
            if (A[j] > A[j+1])
                swap(A, j, j+1);
}

public void swap(int[] A, int a, int b) {
    int temp = A[a];
    A[a] = A[b];
    A[b] = temp;
}
