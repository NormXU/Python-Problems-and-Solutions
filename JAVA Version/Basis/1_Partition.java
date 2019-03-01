"""
Given an array, and a pivotIndex. Rearrange the array so that the numbers smaller than array[pivotIndex] are on the left side of array[pivotIndex] and numbers larger than array[pivotIndex] are on the right side of array[pivotIndex].



Assumption:

The array is not null or empty. pivotIndex is within the boundary of the array.



Example:

array = {9,4,6,2,0,1,7}

pivotIndex = 2



Result: {1, 4, 0, 2, 6, 9, 7}
"""

class Solution{
  public void static partition(int[] array, int pivotIndex){
    int pivot = array[pivotIndex];
    // Firstlt, swap the pivot to the rightmost of the array
    swap(array, pivotIndex, array.length - 1);
    int leftBound = 0;
    int rightBound = array.length - 2;
    while (leftBound <= rightBound) {
      if (array[leftBound] < pivot) {
        leftBound++;

      }else{
        swap(array, leftBound, rightBound);
        rightBound--;
      }


    }
    swap(array, leftBound, array.length - 1);
  }

  public void swap(int[] array, int left, int right){
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }

}
