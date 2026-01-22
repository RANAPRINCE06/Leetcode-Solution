class Solution {
    public int minimumPairRemoval(int[] nums) {
     List<Integer> list = new LinkedList<>();
     for (int x : nums) list.add(x);

     int ops = 0;

     while (!isSorted(list)) {
         int minSum = Integer.MAX_VALUE;
         int idx = 0;

         for (int i = 0; i < list.size() - 1; i++) {
             int sum = list.get(i) + list.get(i + 1);
             if (sum < minSum) {
                 minSum = sum;
                 idx = i;
             }
         }

         list.set(idx, minSum);
         list.remove(idx + 1);
         ops++;
     }
     return ops;
 }

 private boolean isSorted(List<Integer> list) {
     for (int i = 1; i < list.size(); i++)
         if (list.get(i) < list.get(i - 1)) return false;
     return true;
 }
}