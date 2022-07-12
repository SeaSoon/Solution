package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 两数之和
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        int[] ints = twoSum(nums, target);
        System.out.println("[" + ints[0] + "," + ints[1] + "]");
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{0, 0};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer result = map.get(target - nums[i]);
            if (result != null) {
                return new int[] {map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{0, 0};
    }
}
