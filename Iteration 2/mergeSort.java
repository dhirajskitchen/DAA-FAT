public class mergeSort {
    static public void merge(int nums[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = nums[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = nums[m + 1 + i];
        }
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                nums[k++] = L[i++];
            } else {
                nums[k++] = R[j++];
            }
        }
        while (i < n1)
            nums[k++] = L[i++];
        while (j < n2)
            nums[k++] = R[j++];
    }

    static public void MS(int nums[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            MS(nums, l, m);
            MS(nums, m + 1, r);
            merge(nums, l, m, r);
        }
    }

    static public void main(String args[]) {
        int nums[] = { 5, 8, 31, 4, 8, 3, 6, 4 };
        MS(nums, 0, nums.length - 1);
        for (int n : nums)
            System.out.print(n + " ");
    }
}
