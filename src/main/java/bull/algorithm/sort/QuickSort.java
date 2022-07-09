package bull.algorithm.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

/**
 * @author: jhaoniu
 * @date: 2022/6/10  19:38
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] array = init(10);
        Consumer<int[]> printFunc = num -> {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < num.length; i++) {
                list.add(String.valueOf(num[i]));
            }
            System.out.println(String.join(",", list));
        };
        printFunc.accept(array);
        quickSort(array);
        printFunc.accept(array);
    }

    public static int[] init(int length) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(20);
            array[i] = num;
        }
        return array;
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end]; //轴
        int i = start - 1; // 慢指针 指向最后一个比pivot小的数据
        for (int j = start; j < end; j++) {
            if (array[j] < pivot) { // 条件是小于，这也决定了快排是非稳定的排序；即相同值的元素的相对位置会变
                i = i + 1;
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        i = i + 1;
        array[end] = array[i];
        array[i] = pivot;
        return i;
    }

    /**
     * 快速排序的时间复杂度；每一轮partition复杂度为n，需要进行lgn轮
     * 最好nlgn（没有倾斜时）
     * 平均nlgn 系数为(1~n)
     * 最坏n的平方（倾斜最严重）
     * @param array
     */
    public static void quickSort(int[] array) {
        if (array.length == 0) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = partition(array, start, end);
            quickSort(array, start, mid - 1);
            quickSort(array, mid + 1, end);
        }
    }
}
