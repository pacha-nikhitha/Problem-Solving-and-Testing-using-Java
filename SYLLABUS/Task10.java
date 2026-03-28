import java.util.*;

class Task10 {
    public static int countAnagrams(String text, String pattern) {
        int[] p = new int[26];
        int[] w = new int[26];

        for (char c : pattern.toCharArray())
            p[c - 'a']++;

        int k = pattern.length(), count = 0;

        for (int i = 0; i < text.length(); i++) {
            w[text.charAt(i) - 'a']++;

            if (i >= k)
                w[text.charAt(i - k) - 'a']--;

            if (Arrays.equals(p, w))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String text = "forxxorfxdofr";
        String pattern = "for";

        System.out.println(countAnagrams(text, pattern));
    }
}
