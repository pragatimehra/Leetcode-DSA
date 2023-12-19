public class problem_81 {
    public static void main(String[] args) {
        int [] nums = {4, 4, 5, 1, 1, 2, 3};
        int target = 1;
        System.out.println(search(nums, target));
    }

    public static boolean search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if (pivot != -1 && nums[pivot] == target) {
            return true;
        }
        if (binarySearch(nums, target, 0, pivot))
            return true;
        else return binarySearch(nums, target, pivot, nums.length - 1);
    }

    private static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            while (start < end && nums[start] == nums[start + 1]) {
                ++start;
            }
            while (start < end && nums[end] == nums[end - 1]) {
                --end;
            }
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private static boolean binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
