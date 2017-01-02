public void quicksort(int[] array, int left, int right) {
	if (left < right) {
		int pivot = array[right];
		int wall = left;
		for (int i = left; i < right; i++) {
			//Comparison happens only between the if parentheses
			if (array[i] <= pivot) {
				int temp = array[wall];
				array[wall++] = array[i];
				array[i] = temp;
			}
		}
		int temp = array[wall];
		array[wall] = array[right];
		array[right] = temp;
		quicksort(array, left, wall - 1);
		quicksort(array, wall + 1, right);
	}
}
