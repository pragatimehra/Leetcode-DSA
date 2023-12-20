/*
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

/*
public class GuessGame {
    static int pickedNumber = 3;
    public static int guess(int num) {
        if (pickedNumber < num) {
            return -1;
        } else if (pickedNumber > num) {
            return 1;
        } else {
            return 0;
        }
    }
}
 */

public class problem_374 extends GuessGame {
    public static void main(String[] args) {
        int upperLimitOfRange = 10;
        System.out.println(guessNumber(upperLimitOfRange));
    }

    public static int guessNumber (int n) {
        int start = 1;
        int end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (guess(mid) == -1) {
                end = mid - 1;
            } else if (guess(mid) == 1) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
