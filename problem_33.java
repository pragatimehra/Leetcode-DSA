public class problem_33 {
    public static void main(String[] args) {
        int [] nums = {3, 5, 1};
        int target = 5;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        // Find the Pivot -- Smallest Element
        int pivot = smallestNum(nums);

        // Binary Search
        int ans = binarySearch(nums, target, 0, pivot);
        if (ans == -1)
            ans = binarySearch(nums, target, pivot, nums.length - 1);
        return ans;
    }

    private static int smallestNum(int [] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    private static int binarySearch(int [] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
