class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        long operations = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );

        int[] nextGreater = new int[n];
        Arrays.fill(nextGreater, n);

        List<List<Integer>> affected = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            affected.add(new ArrayList<>());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            while (!stack.isEmpty() &&
                   nums[stack.peek()] <= nums[right]) {
                nextGreater[stack.pop()] = right;
            }

            if (!stack.isEmpty()) {
                affected.get(stack.peek()).add(right);
            }

            stack.push(right);

            pq.offer(new int[]{nums[right], right});

            operations += Math.max(
                0L, (long) pq.peek()[0] - nums[right]
            );

            while (operations > k) {
                for (int idx : affected.get(left)) {
                    int end = Math.min(nextGreater[idx], right + 1);

                    operations -=
                        (long) (nums[left] - nums[idx]) *
                        (end - idx);
                }

                left++;
            }

            while (!pq.isEmpty() && pq.peek()[1] < left) {
                pq.poll();
            }

            ans += right - left + 1;
        }

        return ans;
    }
}
