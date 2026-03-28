import java.util.*;

class Task8 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            while (!dq.isEmpty() && dq.peek() <= i - k)
                dq.poll();

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.pollLast();

            dq.offer(i);

            if (i >= k - 1)
                res.add(nums[dq.peek()]);
        }

        System.out.println(res);
    }
}
