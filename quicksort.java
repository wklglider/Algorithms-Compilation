public void quicksort(int[] array, int left, int right) {
	if (left < right) {
		int wall = randomizedPartition(array, left, right);
		quicksort(array, left, wall - 1);
		quicksort(array, wall + 1, right);
	}
}

public int randomizedPartition(int[] array, int left, int right) {
	int randomPick = new Random().nextInt(right - left) + left;
	int pivot = array[randomPick];
	array[randomPick] = array[right];
	array[right] = pivot;
	int wall = left;
	for (int i = left; i < right; i++) {
		//Comparison happens only between the two parentheses.
		//Descending order would be (array[i] > pivot).
		if (array[i] < pivot) {
			int temp = array[wall];
			array[wall++] = array[i];
			array[i] = temp;
		}
	}
	int temp = array[wall];
	array[wall] = array[right];
	array[right] = temp;
	return wall;
}
