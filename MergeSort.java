import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

class MergeSort {
    public static void main(String[] args)
    {
        // int[] input = new int[] {6126, 5702, 4179, 6827};
        // input = sort(input);
        // System.out.println(Arrays.toString(input));
        for (int i = 0; i < 10; i++)
        {
            int[] array = rand();
            // System.out.println(Arrays.toString(array));
            array = sort(array);
            if (!test(array))
            {
                System.out.println(Arrays.toString(array));
            }
        }

    }

    public static int[] rand()
    {
        int length = (int)(Math.random() * 10);
        int[] array = new int[length];
        for (int i = 0; i < length; i++)
        {
            array[i] = (int)(Math.random() * 10000);
        }
        return array;
    }

    public static boolean test(int[] array)
    {
        for (int i = 0; i < array.length - 1; i++)
        {
            if (array[i+1] < array[i])
            {
                // System.out.println(Arrays.toString(array));
                return false;
            }
        }
        return true;
    }

    public static int[] sort(int[] input){
        if (input == null || input.length == 0)
        {
            return input;
        }
        return sort(input, 0, input.length - 1);
    }

    private static int[] sort(int[] input, int start, int end)
    {

        int[] solution = new int[end - start + 1];
        if (start == end){
            solution[0] = input[start];
            return solution;
        }
        int mid = start + (end - start)/2; 
        int[] left = sort(input, start, mid);
        int[] right = sort(input, mid + 1, end);
        solution = merge(left, right);        
        return solution;
    }

    private static int[] merge(int[] left, int[] right)
    {
        int i = 0;
        int j = 0;
        int[] solution = new int[left.length + right.length];
        int index = 0;

        while (i < left.length && j < right.length)
        {
            if (left[i] < right[j])
            {
                solution[index++] = left[i++];
            }
            else
            {
                solution[index++] = right[j++];
            }
        }
        while (i < left.length)
        {
            solution[index++] = left[i++];
        }
        while (j < right.length)
        {
            solution[index++] = right[j++];
        }
        return solution;
    }
}