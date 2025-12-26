class Solution {
    public int bestClosingTime(String customers) {
        int bestHour = 0;
        int profit = 0;
        int maxProfit = 0;

        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                profit += 1;
            } else {
                profit -= 1;
            }

            if (profit > maxProfit) {
                maxProfit = profit;
                bestHour = i + 1;
            }
        }

        return bestHour;
    }
}
