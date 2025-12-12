class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            // while current temp > temp at stack top index
            while (!st.isEmpty() && temp[i] > temp[st.peek()]) {
                int idx = st.pop();
                ans[idx] = i - idx;
            }

            st.push(i); // push index
        }

        return ans;
    }
}
