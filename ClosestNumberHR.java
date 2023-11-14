import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
    // Write your code here
        List<Integer> resultList = new ArrayList<>();
        Integer [] a = new Integer[arr.size()];
        a = arr.toArray(a);
        a = mergeSort(a, 0, a.length - 1);
        int min = a[1] - a[0];
        
        for (int i = 1;i<a.length - 1;i++) {
            int dif = a[i+1] - a[i];
            if (dif < min) min = dif;
        }
        for (int i = 0;i<a.length - 1;i++) {
            int dif = a[i+1] - a[i];
            if (dif == min) {
                resultList.add(a[i]);
                resultList.add(a[i+1]);
            }
        }
        return resultList;
    }
    public static Integer [] merge(Integer [] a, Integer[] b) {
        int n = a.length + b.length;
        Integer [] result = new Integer[n];
        int index = 0, aIndex = 0, bIndex = 0;
        while (index < n) {
            if (aIndex < a.length && bIndex < b.length) {
                if (less(a[aIndex], b[bIndex])) result[index++] = a[aIndex++];
                else result[index++] = b[bIndex++];
            }
            else {
                if (aIndex < a.length){
                    result[index++] = a[aIndex++];
                }
                else result[index++] = b[bIndex++];
            }
        }
        return result;
    }
    public static boolean less(Integer a, Integer b) {
        return a < b;
    }
    public static Integer [] mergeSort(Integer [] a, int left, int right) {
        if (left == right) {
            Integer [] b = {a[left]};
            return b;
        }
        int mid = (left + right) / 2;
        Integer [] a1 = mergeSort(a, left, mid);
        Integer [] a2 = mergeSort(a, mid + 1, right);
        Integer[] result = merge(a1, a2);
        return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.closestNumbers(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
