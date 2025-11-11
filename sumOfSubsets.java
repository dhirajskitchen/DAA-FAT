import java.util.*;

class sumOfSubsets {
    static public void SOS(int nums[], int i, int target, List<Integer> set) {
        if (target == 0) {
            System.out.print(set);
            return;
        }
        if (i == nums.length)
            return;

        SOS(nums, i + 1, target, set);

        if (nums[i] <= target) {
            set.add(nums[i]);
            SOS(nums, i + 1, target - nums[i], set);
            set.remove(set.size() - 1);
        }
    }

    static public void main(String args[]) {
        int nums[] = { 3, 34, 4, 12, 5, 2 };
        SOS(nums, 0, 7, new ArrayList<>());
    }
}