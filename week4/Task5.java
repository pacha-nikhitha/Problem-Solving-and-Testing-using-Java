import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        System.out.println(timeConversion(s));
    }

    static String timeConversion(String s) {

        String period = s.substring(8);          // AM or PM
        int hour = Integer.parseInt(s.substring(0, 2));
        String rest = s.substring(2, 8);         // :mm:ss

        if (period.equals("AM")) {
            if (hour == 12) {
                hour = 0;
            }
        } else { // PM
            if (hour != 12) {
                hour += 12;
            }
        }

        return String.format("%02d", hour) + rest;
    }
}
