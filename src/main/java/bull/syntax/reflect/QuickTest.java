package bull.syntax.reflect;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static bull.algorithm.sort.QuickSort.init;
import static bull.algorithm.sort.QuickSort.quickSort;

/**
 * @author: tianxin068
 * @date: 2022/7/9 11
 */
public class QuickTest implements Test {
    @Override
    public void test() {
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
}
