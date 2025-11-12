import java.util.*;

public class sumOfSubsets {
    static public void SOS(List<Integer> set, int[] nums, int target, int k) {
        if (target == 0) {
            System.out.print(set);
            return;
        }
        if (k == nums.length)
            return;
        SOS(set, nums, target, k + 1);
        if (nums[k] <= target) {
            set.add(nums[k]);
            SOS(set, nums, target - nums[k], k + 1);
            set.remove(set.size()-1);
        }
    }

    static public void main(String args[]) {
        int[] nums = { 2, 4, 1, 0, 7 };
        SOS(new ArrayList<>(), nums, 7, 0);
    }
}
