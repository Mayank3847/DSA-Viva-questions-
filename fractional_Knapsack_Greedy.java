   import java.util.*;

public class fractional_Knapsack_Greedy {
    public static void main(String[] args) {
        int val[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int w = 50;
        double ratio[][] = new double[val.length][2];
        // 0th column =>idx;1st col=>ratios
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];

        }
        // ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        int capacity = w;
        int finalVal = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int index = (int) ratio[i][0];
            if (capacity >= weight[index]) {// include full items
                finalVal += val[index];
                capacity -= weight[index];

            } else {
                // include fractional items
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;

            }
        }
        System.out.println("FINAL VALUE = " + finalVal);
    }
}
