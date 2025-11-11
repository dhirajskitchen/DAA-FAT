public class quickSort {
    static public void swap(int n1, int n2) {
        n1 += n2;
        n2 = n1 - n2;
        n1 = n1 - n2;
    }

    static public int partition(int nums[], int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] < pivot) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

            }
        }
        nums[r] = nums[i + 1];
        nums[i + 1] = pivot;
        return i + 1;
    }

    static public void QS(int nums[], int l, int r) {
        if (l < r) {
            int pi = partition(nums, l, r);
            QS(nums, l, pi - 1);
            QS(nums, pi + 1, r);
        }
    }

    static public void main(String args[]) {
        int nums[] = { 5, 8, 9, 2, 6 };
        QS(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ", nums[i]);
        }
    }
}
