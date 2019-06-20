Examples

A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.

A = {1, 2, 3, 4}, B = {}, the 2nd smallest number is 2.


public class Solution {
  public int kth(int[] a, int[] b, int k) {
    return kth(a, 0, b, 0, k);
  }

  private int kth(int[] a, int aleft, int[] b, int bleft, int k){
    // 1. We already eliminate all the elements in a
    // 2. We already eliminate all the elements in b

    if (aleft >= a.length) {
      return b[bleft + k - 1];
    }

    if (bleft >= b.length) {
      return a[aleft + k - 1];
    }

    if (k == 1) {
      return Math.min(a[aleft], b[bleft]);
    }

    int amid = aleft + k / 2 - 1;
    int bmid = bleft + k / 2 - 1;
    int avel = amid >= a.length ? Integer.MAX_VALUE : a[amid];
    int bvel = bmid >= b.length ? Integer.MAX_VALUE : b[bmid];
    if (avel <= bvel) {
      return kth(a, amid + 1, b, bleft, k - k / 2);
    } else {
      return kth(a, aleft, b, bmid + 1, k - k / 2);
    }

  }
}
