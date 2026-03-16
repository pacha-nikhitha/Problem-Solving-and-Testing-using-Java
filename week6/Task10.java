import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {

        int m = matrix.size();
        int n = matrix.get(0).size();

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> elements = new ArrayList<>();

            int top = layer;
            int bottom = m - layer - 1;
            int left = layer;
            int right = n - layer - 1;

            // top row
            for (int j = left; j <= right; j++)
                elements.add(matrix.get(top).get(j));

            // right column
            for (int i = top + 1; i <= bottom - 1; i++)
                elements.add(matrix.get(i).get(right));

            // bottom row
            for (int j = right; j >= left; j--)
                elements.add(matrix.get(bottom).get(j));

            // left column
            for (int i = bottom - 1; i >= top + 1; i--)
                elements.add(matrix.get(i).get(left));

            int len = elements.size();
            int rotations = r % len;

            Collections.rotate(elements, -rotations);

            int index = 0;

            // put back top row
            for (int j = left; j <= right; j++)
                matrix.get(top).set(j, elements.get(index++));

            // put back right column
            for (int i = top + 1; i <= bottom - 1; i++)
                matrix.get(i).set(right, elements.get(index++));

            // put back bottom row
            for (int j = right; j >= left; j--)
                matrix.get(bottom).set(j, elements.get(index++));

            // put back left column
            for (int i = bottom - 1; i >= top + 1; i--)
                matrix.get(i).set(left, elements.get(index++));
        }

        // print rotated matrix
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
