import java.util.*;

public class Solution {

    public static int stringSimilarity(String s) {
        int n = s.length();
        int total = n;

        for (int i = 1; i < n; i++) {
            int j = 0;

            while (i + j < n && s.charAt(j) == s.charAt(i + j)) {
                j++;
            }

            total += j;
        }

        return total;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < t; i++) {
            String s = sc.nextLine();
            System.out.println(stringSimilarity(s));
        }

        sc.close();
    }
}
