package learn.check;

public class IsHalfSumNeighbors {
    public String isHalfSumNeighbors(int[] arr) {
        String result = "";

        for (int i = 1; i < arr.length - 1; i++) {
            int left = arr[i - 1];
            int middle = arr[i];
            int right = arr[i + 1];

            if (middle == (left + right) / 2) {
                result += middle + " ";
            }
        }

        return result;
    }
}
