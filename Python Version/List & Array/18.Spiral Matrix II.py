"""
Given an integer n, generate a square matrix filled with elements from 1 to n^2n
​2
​​  in spiral order.

(The spiral rotates clockwise from the outside to the inside, referring to examples)

Example
Example 1:

input: 2
output:
[
  [1, 2],
  [4, 3]
]
Example 2:

input: 3
output:
[
  [ 1, 2, 3 ],
  [ 8, 9, 4 ],
  [ 7, 6, 5 ]
]
"""
class Solution:
    """
    @param n: An integer
    @return: a square matrix
    """
    def generateMatrix(self, n):
        # Write your code here
        if n == 0: return []
        matrix = [[0 for i in range(n)] for j in range(n)]
        #matrix = [[0]*n]*n
        up = 0; down = len(matrix)-1
        left = 0; right = len(matrix[0])-1
        direct = 0; count = 0
        while True:
            if direct == 0:
                for i in range(left, right+1):
                    count += 1; matrix[up][i] = count
                up += 1
            if direct == 1:
                for i in range(up, down+1):
                    count += 1; matrix[i][right] = count
                right -= 1
            if direct == 2:
                for i in range(right, left-1, -1):
                    count += 1; matrix[down][i] = count
                down -= 1
            if direct == 3:
                for i in range(down, up-1, -1):
                    count += 1; matrix[i][left] = count
                left += 1

            if count == n*n:
                break

            direct = (direct+1) % 4

        return matrix
