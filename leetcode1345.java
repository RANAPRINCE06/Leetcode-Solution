class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        if (n <= 1) return 0;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        q.offer(0);
        vis[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int idx = q.poll();

                if (idx == n - 1) return steps;

                if (idx + 1 < n && !vis[idx + 1]) {
                    vis[idx + 1] = true;
                    q.offer(idx + 1);
                }

                if (idx - 1 >= 0 && !vis[idx - 1]) {
                    vis[idx - 1] = true;
                    q.offer(idx - 1);
                }

                if (map.containsKey(arr[idx])) {
                    for (int next : map.get(arr[idx])) {
                        if (!vis[next]) {
                            vis[next] = true;
                            q.offer(next);
                        }
                    }

                    map.remove(arr[idx]);
                }
            }

            steps++;
        }

        return -1;
    }
}
