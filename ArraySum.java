public class ArraySum {


    public static int sumOfArray(Integer [] array, int sum) {



        if (sum == 0) {
            return 0;
        } else {

            return array[sum-1] +  sumOfArray(array, sum-1);

        }

    }
}
