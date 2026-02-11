import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'maxSubarray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> maxSubarray(List<Integer> arr) {

        int maxSubarraySum = Integer.MIN_VALUE;
        int currentSum = 0;

        int maxSubsequenceSum = 0;
        int maxElement = Integer.MIN_VALUE;

        for (int num : arr) {

            // Kadane's Algorithm for max subarray
            currentSum = Math.max(num, currentSum + num);
            maxSubarraySum = Math.max(maxSubarraySum, currentSum);

            // Max subsequence logic
            if (num > 0) {
                maxSubsequenceSum += num;
            }

            maxElement = Math.max(maxElement, num);
        }

        // If all numbers are negative
        if (maxSubsequenceSum == 0) {
            maxSubsequenceSum = maxElement;
        }

        return Arrays.asList(maxSubarraySum, maxSubsequenceSum);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(
                        bufferedReader.readLine().trim().split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> result = Result.maxSubarray(arr);

                bufferedWriter.write(
                        result.stream()
                              .map(Object::toString)
                              .collect(Collectors.joining(" "))
                );
                bufferedWriter.newLine();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
