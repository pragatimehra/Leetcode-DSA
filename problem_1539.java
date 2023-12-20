public class problem_1539 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 7;
        System.out.println(findKthPositive_NaiveApproach(arr, k));
        System.out.println(findKthPositive(arr, k));
    }

    // Optimised Approach - Binary Search
    public static int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] - (mid + 1) < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start + k;
    }

    // Naive Approach
    public static int findKthPositive_NaiveApproach(int[] arr, int k) {
        int m = 0, i = 1;
        while (k > 0) {
            if (m < arr.length && arr[m] == i) {
                ++m;
            } else {
                --k;
            }
            if (k == 0) {
                return i;
            }
            ++i;
        }
        return i - 1; // This line is added to handle the case where k > 0 after the loop
    }
}
