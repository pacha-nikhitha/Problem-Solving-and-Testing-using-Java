import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */

    public static void matrixRotation(List<List<Integer>> matrix, int r) {

        int m = matrix.size();
        int n = matrix.get(0).size();

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> elements = new ArrayList<>();

            // top row
            for (int j = layer; j < n - layer; j++)
                elements.add(matrix.get(layer).get(j));

            // right column
            for (int i = layer + 1; i < m - layer - 1; i++)
                elements.add(matrix.get(i).get(n - layer - 1));

            // bottom row
            for (int j = n - layer - 1; j >= layer; j--)
                elements.add(matrix.get(m - layer - 1).get(j));

            // left column
            for (int i = m - layer - 2; i > layer; i--)
                elements.add(matrix.get(i).get(layer));

            int len = elements.size();
            int rotations = r % len;

            Collections.rotate(elements, -rotations);

            int index = 0;

            // put back top row
            for (int j = layer; j < n - layer; j++)
                matrix.get(layer).set(j, elements.get(index++));

            // put back right column
            for (int i = layer + 1; i < m - layer - 1; i++)
                matrix.get(i).set(n - layer - 1, elements.get(index++));

            // put back bottom row
            for (int j = n - layer - 1; j >= layer; j--)
                matrix.get(m - layer - 1).set(j, elements.get(index++));

            // put back left column
            for (int i = m - layer - 2; i > layer; i--)
                matrix.get(i).set(layer, elements.get(index++));
        }

        // Print final matrix
        for (List<Integer> row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().trim().split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);
        int n = Integer.parseInt(firstMultipleInput[1]);
        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().trim().split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
