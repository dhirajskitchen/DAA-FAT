public class quickSort {
    static public int parition(int nums[], int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] < pivot) {
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        nums[r] = nums[i + 1];
        nums[i + 1] = pivot;
        return i + 1;
    }

    static public void QS(int nums[], int l, int r) {
        if (l < r) {
            int pi = parition(nums, l, r);
            QS(nums, l, pi - 1);
            QS(nums, pi + 1, r);
        }
    }

    static public void main(String args[]) {
        int nums[] = { 5, 8, 31, 4, 8, 3, 6, 4 };
        QS(nums, 0, nums.length - 1);
        for (int n : nums)
            System.out.print(n + " ");
    }
}
