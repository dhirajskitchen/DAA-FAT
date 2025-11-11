
class insertionSort {
    static public int[] IS(int nums[]) {
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
        return nums;
    }

    static public void main(String args[]) {
        int nums[] = { 5, 8, 9, 2, 6 };
        int nums2[] = IS(nums);
        for (int i = 0; i < nums2.length; i++) {
            System.out.printf("%d ", nums2[i]);
        }
    }
}