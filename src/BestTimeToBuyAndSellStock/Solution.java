package BestTimeToBuyAndSellStock;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1}));
    }

    public static int maxProfit(int[] prices) {
        int smaller = -1;
        int greater = -1;
        for (int price : prices) {
            if(smaller == -1 || smaller >= price) {
                smaller = price;
            } else if(price > greater) {
                greater = price;
            }
        }
        return greater == -1 ? 0 : greater - smaller;
    }
}
