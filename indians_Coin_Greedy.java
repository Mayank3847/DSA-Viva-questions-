import java.util.*;

public class indians_Coin_Greedy {
    public static void main(String[] args) {
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        Arrays.sort(coins, Comparator.reverseOrder());
        int coinOfLength = 0;
        int amount = 790;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                while (coins[i] <= amount) {
                    coinOfLength++;
                    ans.add(coins[i]);
                    amount = amount - coins[i];
                }
            }
        }
        System.out.println("THE TOTAL NUMBER OF COINS/NOTES " + coinOfLength);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}
