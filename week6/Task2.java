import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            int n = s.length();

            int mid = n / 2;

            String left, right;

            if (n % 2 == 0) {
                left = s.substring(0, mid);
                right = s.substring(mid);
            } else {
                left = s.substring(0, mid);
                right = s.substring(mid + 1);
            }

            if (isLapindrome(left, right)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }

    private static boolean isLapindrome(String a, String b) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : a.toCharArray()) {
            freq1[c - 'a']++;
        }

        for (char c : b.toCharArray()) {
            freq2[c - 'a']++;
        }

        return Arrays.equals(freq1, freq2);
    }
}
