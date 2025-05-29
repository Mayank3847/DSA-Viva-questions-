public class RodCutting {
      public static int rod(int money[], int index, int sum, int totalRod) {
        int n = money.length;
        if (index >= n || totalRod == 0) {
            return sum;
        }
        int include = 0;
        if (index + 1 <= totalRod) {
            include = rod(money, index, sum + money[index], totalRod - (index + 1)); 
        }
        int exclude = rod(money, index + 1, sum, totalRod);
        return Math.max(include, exclude);
    }

    public static int rodCutting(int money[], int n) {
        return rod(money, 0, 0, n); 
    }
    public static void main(String[] args) {
        int[] money = {1, 5, 8, 9, 10, 17, 17, 20};  
        int n = 8;    

        int maxProfit = rodCutting(money, n);
        System.out.println("Maximum Obtainable Value is: " + maxProfit);
    }

    
}
