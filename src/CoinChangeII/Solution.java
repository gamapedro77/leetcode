package CoinChangeII;

public class Solution {
    public  static void main(String[] args) {
        System.out.println(change(5, new int[]{1,2,5}));
    }

    public static int change(int amount, int[] coins) {

        int[] possibleSums = new int[amount + 1];
        possibleSums[0] = 1;
        for(int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                    possibleSums[i] += possibleSums[i - coin];
            }
        }
        return possibleSums[amount];
    }
}
