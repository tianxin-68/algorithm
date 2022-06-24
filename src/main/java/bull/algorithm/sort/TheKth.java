package bull.algorithm.sort;

/**
 * 寻找第K大
 * 描述
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第 k 大的数。
 * <p>
 * 给定一个整数数组 a ,同时给定它的大小n和要找的 k ，请返回第 k 大的数(包括重复的元素，不用去重)，保证答案存在。
 * 要求：时间复杂度 O(nlogn)O(nlogn)，空间复杂度 O(1)O(1)
 * 数据范围：0\le n \le 10^50≤n≤10
 * 5
 * ， 1 \le K \le n1≤K≤n，数组中每个元素满足 0 \le val \le 10^90≤val≤10
 * 9
 * https://www.nowcoder.com/practice/e016ad9b7f0b45048c58a9f27ba618bf?tpId=295&tqId=44581&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
 *
 * @author: tianxin-68
 * @date: 2022/6/21  16:07
 */
public class TheKth {
    public static void main(String[] args) {
        TheKth kth = new TheKth();
        int[] a = {6, 6, 6, 8, 9, 9, 9, 12, 12, 12, 14};
        int num = kth.findKth(a, 11, 1);
        System.out.println("num = " + num);
    }

    public int findKth(int[] a, int n, int K) {
        if (K > n) {
            throw new RuntimeException("error!");
        }
        // write code here
        int pos = findKth(a, 0, n - 1, K - 1);
        return a[pos];
    }

    private int findKth(int[] a, int start, int end, int K) {
        // write code here
        int pos = partition(a, start, end);
        if (pos == K) {
            return pos;
        } else if (pos > K) {
            return findKth(a, start, pos - 1, K);
        } else {
            return findKth(a, pos + 1, end, K);
        }
    }

    //    private int partition(int[] array, int start, int end) {
//        int pivot = array[end]; //轴
//        int i = start - 1; // 慢指针 指向最后一个比pivot小的数据
//        for (int j = start; j < end; j++) {
//            if (array[j] >= pivot) { // 条件是小于，这也决定了快排是非稳定的排序；即相同值的元素的相对位置会变
//                i = i + 1;
//                int temp = array[j];
//                array[j] = array[i];
//                array[i] = temp;
//            }
//        }
//        i = i + 1;
//        array[end] = array[i];
//        array[i] = pivot;
//        return i;
//    }
    private int partition(int[] array, int start, int end) {
        int pivotPos = start + (end - start) / 2;   //关键点 取中位，避免有序时倾斜导致的 N的平方的复杂度
        int pivot = array[pivotPos]; //轴
        int i = start - 1; // 慢指针 指向最后一个比pivot小的数据
        for (int j = start; j <= end; j++) {
            if (pivotPos == j) {
                continue;
            }
            if (array[j] >= pivot) { // 条件是小于，这也决定了快排是非稳定的排序；即相同值的元素的相对位置会变
                i = i + 1;
                if (i == pivotPos) {  //慢指针记得跃过 轴坐标
                    i++;
                }
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        if (i < pivotPos) {
            i += 1;
        }
        array[pivotPos] = array[i];
        array[i] = pivot;
        return i;
    }
}
