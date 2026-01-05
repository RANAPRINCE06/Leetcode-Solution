class Solution:
    def maxMatrixSum(self, matrix):
        total_sum = 0
        min_abs = float('inf')
        neg_count = 0

        for row in matrix:
            for x in row:
                total_sum += abs(x)
                min_abs = min(min_abs, abs(x))
                if x < 0:
                    neg_count += 1

        if neg_count % 2 == 1:
            total_sum -= 2 * min_abs

        return total_sum
