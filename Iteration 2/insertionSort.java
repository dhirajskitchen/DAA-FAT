class insertionSort {
    static public void IS(int nums[]) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    static public void main(String args[]) {
        int nums[] = { 5, 8, 31, 4, 8, 3, 6, 4 };
        IS(nums);
        for (int n : nums)
            System.out.print(n + " ");
    }
}