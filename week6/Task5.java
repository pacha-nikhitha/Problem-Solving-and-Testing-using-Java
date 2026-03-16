import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'marsExploration' function below.
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int marsExploration(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            if (i % 3 == 0 && s.charAt(i) != 'S') {
                count++;
            }
            else if (i % 3 == 1 && s.charAt(i) != 'O') {
                count++;
            }
            else if (i % 3 == 2 && s.charAt(i) != 'S') {
                count++;
            }
        }

        return count;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        int result = Result.marsExploration(s);

        System.out.println(result);

        bufferedReader.close();
    }
}
