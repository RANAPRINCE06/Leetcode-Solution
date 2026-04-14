class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        int n = robot.size();
        int m = factory.length;

        Long[][] memo = new Long[n][m];
        return dfs(0, 0, robot, factory, memo);
    }

    private long dfs(int i, int j, List<Integer> robot, int[][] factory, Long[][] memo) {
        if (i == robot.size()) return 0;
        if (j == factory.length) return Long.MAX_VALUE / 2;

        if (memo[i][j] != null) return memo[i][j];

        long res = dfs(i, j + 1, robot, factory, memo); 

        long dist = 0;
        for (int k = 0; k < factory[j][1] && i + k < robot.size(); k++) {
            dist += Math.abs(robot.get(i + k) - factory[j][0]);
            res = Math.min(res, dist + dfs(i + k + 1, j + 1, robot, factory, memo));
        }

        return memo[i][j] = res;

    }
}
