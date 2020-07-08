import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 *  涨势最大值
 */
public class TestMain {
    public static void main(String[] args) {
       // int arr[]={10,9,8,9,9,10};
        //int arr[] = {1, 2, 4, 5, 6, 7};
        int arr[] = {9, 8, 7, 8, 15, 14};
        int max = max(arr);
        System.out.println("最大值"+max);
    }

    /**
     *
     * @param arr 参数数组
     * @return   涨势最大值
     */
    private static int max(int arr[]) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int value = 0;
            for (int j = i + 1; j < arr.length; j++) {
                //如果索引>数组长度-1 或者 前一个值比后一个值大的情况直接break
                if (j > arr.length - 1 || arr[j - 1] > arr[j]) break;
                int temp = arr[j] - arr[j - 1];
                value += temp;
            }
            list.add(value);
        }
        System.out.println("如果前面的值大于后面的 集合值跟后面比自己大的 相差的金额"+list);
        return list.stream().max(Comparator.comparing(Function.identity())).orElse(0);
    }
}
