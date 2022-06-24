package bull.algorithm.line;

/**
 * @author:
 * @date: 2022/6/16  18:06
 */
public class BinarySearch {
    /**
     * https://www.nowcoder.com/practice/d3df40bd23594118b57554129cadf47b?tpId=295&tqId=1499549&ru=%2Fpractice%2F8daa4dff9e36409abba2adbe413d6fae&qru=%2Fta%2Fformat-top101%2Fquestion-ranking&sourceUrl=%2Fexam%2Foj
     * 请实现无重复数字的升序数组的二分查找
     * <p>
     * 给定一个 元素升序的、无重复数字的整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标（下标从 0 开始），否则返回 -1
     * <p>
     * 数据范围：0 \le len(nums) \le 2\times10^50≤len(nums)≤2×10
     * 5
     * ， 数组中任意值满足 |val| \le 10^9∣val∣≤10
     * 9
     * <p>
     * 进阶：时间复杂度 O(\log n)O(logn) ，空间复杂度 O(1)O(1)
     */
    public int search(int[] nums, int target) {
        // write code here
        return search(nums, 0, nums.length - 1, target);
    }

    public int search(int[] nums, int start, int end, int target) {
        // write code here
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            start = mid + 1;
        }
        if (nums[mid] < target) {
            end = mid - 1;
        }
        return search(nums, start, end, target);
    }
}
