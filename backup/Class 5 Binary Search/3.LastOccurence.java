/*
Given a target integer T and an integer array A sorted in ascending order, find the index of the last occurrence of T in A or return -1 if there is no such index.
A = {1, 2, 3}, T = 2, return 1
A = {1, 2, 3}, T = 4, return -1
A = {1, 2, 2, 2, 3}, T = 2, return 3
*/


public class Solution {
  public int lastOccur(int[] array, int target) {
    // Write your solution here
    if(array == null || array.length == 0){
      return -1;
    }
    int left = 0;
    int right = array.length - 1;
    while(left+1 < right){
      int mid = left + (right - left) / 2;
      if(array[mid] == target){
        left = mid;
      }
      else if(array[mid] > target){
        right = mid;
      } else{
        left = mid;
      }
    }
    if(array[right] == target){
      return right;
    }
    if(array[left] == target){
      return left;
    }
    return -1;
  }
}
