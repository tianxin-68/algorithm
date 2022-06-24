package bull.algorithm.tree;

import java.util.*;

/**
 * 判断是不是完全二叉树
 * </>https://www.nowcoder.com/practice/8daa4dff9e36409abba2adbe413d6fae?tpId=295&tqId=2299105&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
 *
 * @author:
 * @date: 2022/6/16  15:07
 */
public class CompleteBinaryTree {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isCompleteTree(TreeNode root) {
        // write code here
        if (Objects.isNull(root)) {
            return false;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (Objects.nonNull(node.left)) {
                if (Objects.nonNull(node.right)) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
                if (Objects.isNull(node.right)) {
                    queue.add(node.left);
                    break;
                }
            }
            if (Objects.isNull(node.left)) {
                if (Objects.nonNull(node.right)) {
                    return false;
                } else break;
            }
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (Objects.nonNull(node.left)
                    || Objects.nonNull(node.right)) {
                return false;
            }
        }
        return true;
    }
}
