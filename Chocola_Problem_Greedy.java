import java.util.*;

public class Chocola_Problem_Greedy {
    public static void main(String[] args) {
        int n = 4;
        int m = 6;
        Integer cost_Of_Vert[] = { 2, 1, 3, 1, 4 };// m-1;
        Integer cost_Of_Hor[] = { 4, 1, 2 };
        Arrays.sort(cost_Of_Vert, Collections.reverseOrder());
        Arrays.sort(cost_Of_Hor, Collections.reverseOrder());
        int h = 0;
        int v = 0;
        int hp = 1, vp = 1;// hp-horizontal piece vp=vertical piece
        int cost = 0;
        while (h < cost_Of_Hor.length && v < cost_Of_Vert.length) {
            if (cost_Of_Vert[v] <= cost_Of_Hor[h]) {
                cost += (cost_Of_Hor[h] * vp);
                hp++;
                h++;

            } else {
                cost += (cost_Of_Vert[v] * hp);
                vp++;
                v++;
            }
        }
        while (h < cost_Of_Hor.length) {
            cost += (cost_Of_Hor[h] * vp);
            hp++;
            h++;
        }
        while (v < cost_Of_Vert.length) {
            cost+= (cost_Of_Vert[v] * hp);
            vp++;
            v++;

        }
        System.out.println("MINIMUM COST OF CUTTING CHOCOLATE IN SINGLE PIECES : " + cost);
        System.out.println("TOTAL NUMBER OF PIECES OF CHOCOLATES : "+m*n);

    }
}
