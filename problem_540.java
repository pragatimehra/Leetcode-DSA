public class problem_540 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4};
        System.out.println(singleNonDuplicate(nums));
    }

    public static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int count = end - mid;

            if (nums[mid] == nums[mid + 1]) {
                if (count % 2 == 0)
                    start = mid + 2;
                else
                    end = mid - 1;
            } else if (nums[mid] == nums[mid - 1]) {
                if (count % 2 == 0)
                    end = mid - 2;
                else
                    start = mid + 1;
            } else {
                return nums[mid];
            }
        }

        return nums[start]; // or nums[end], both will be the same
    }
}
