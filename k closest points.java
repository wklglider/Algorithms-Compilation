public void quicksort(int[] array, int left, int right) {
	if (left < right) {
		int wall = randomizedPartition(array, left, right);
		quicksort(array, left, wall - 1);
		quicksort(array, wall + 1, right);
	}
}

public int randomizedSelect(int[] array, int left, int right, int index) {
	if (left == right) {
		return array[left];
	}
	int wall = randomizedPartition(array, left, right);
	int k = wall - left + 1;
	if (index == k) {
		return array[wall];
	} else if (index < k) {
		return randomizedSelect(array, left, wall - 1, index);
	} else {
		return randomizedSelect(array, wall + 1, right, index - k);
	}
}

public int randomizedPartition(int[] array, int left, int right) {
	int randomPick = ThreadLocalRandom.current().nextInt(left, right + 1);
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
