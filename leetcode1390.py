class Solution:
    def sumFourDivisors(self, nums):
        ans = 0

        for x in nums:
            cnt = 2
            total = 1 + x

            d = 2
            while d * d <= x:
                if x % d == 0:
                    e = x // d
                    if d == e:
                        cnt += 1
                        total += d
                    else:
                        cnt += 2
                        total += d + e

                    if cnt > 4:
                        break
                d += 1

            if cnt == 4:
                ans += total

        return ans
