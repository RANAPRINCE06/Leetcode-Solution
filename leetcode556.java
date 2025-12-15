class Solution {
    public int nextGreaterElement(int n) {
        char[] a = String.valueOf(n).toCharArray();
        int i = a.length - 2;

        while (i >= 0 && a[i] >= a[i + 1]) i--;
        if (i < 0) return -1;

        int j = a.length - 1;
        while (a[j] <= a[i]) j--;

        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        reverse(a, i + 1, a.length - 1);

        long res = Long.parseLong(new String(a));
        return res > Integer.MAX_VALUE ? -1 : (int) res;
    }

    private void reverse(char[] a, int l, int r) {
        while (l < r) {
            char t = a[l];
            a[l++] = a[r];
            a[r--] = t;
        }
    }
}
