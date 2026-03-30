import java.util.*;

class Task12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        StringBuilder temp = new StringBuilder();
        int count = 1;

        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
            temp.append(s.charAt(i));
            temp.append(Integer.toHexString(count)); // hex
            count = 1;
        }

        System.out.println(temp.reverse().toString());
    }
}
