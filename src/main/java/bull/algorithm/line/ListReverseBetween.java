package bull.algorithm.line;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 描述
 * 将一个节点数为 size 链表 m 位置到 n 位置之间的区间反转，要求时间复杂度 O(n)O(n)，空间复杂度 O(1)O(1)。
 * 例如：
 * 给出的链表为 1\to 2 \to 3 \to 4 \to 5 \to NULL1→2→3→4→5→NULL, m=2,n=4m=2,n=4,
 * 返回 1\to 4\to 3\to 2\to 5\to NULL1→4→3→2→5→NULL.
 * <p>
 * 数据范围： 链表长度 0 < size \le 10000<size≤1000，0 < m \le n \le size0<m≤n≤size，链表中每个节点的值满足 |val| \le 1000∣val∣≤1000
 * 要求：时间复杂度 O(n)O(n) ，空间复杂度 O(n)O(n)
 * 进阶：时间复杂度 O(n)O(n)，空间复杂度 O(1)O(1)
 */

public class ListReverseBetween {
    public static void main(String[] args) {
        ListReverseBetween reverseBetween = new ListReverseBetween();
        ListNode case1Head = reverseBetween.getTestCase(1, 2, 3, 4, 5);
        case1Head = reverseBetween.reverseBetween(case1Head, 2, 4);
        reverseBetween.print(case1Head);

        ListNode case2Head = reverseBetween.getTestCase(5);
        case2Head = reverseBetween.reverseBetween(case2Head, 1, 1);
        reverseBetween.print(case2Head);
    }

    /**
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int size = getSize(head);
        if (m > n || n > size || m <= 0) {
            throw new RuntimeException("params error!!");
        }
        //地址标识
        ListNode mNode = null;
        ListNode mFrontNode = null;
        ListNode nNode = null;
        ListNode nBackNode = null;
        //关键指针
        ListNode cur = head;
        ListNode last = null;
        for (int i = 1; i <= n + 1; i++) {
            if (i == m - 1) {
                mFrontNode = cur;
            }
            if (i == m) {
                mNode = cur;
            }
            if (i == n + 1) {
                nBackNode = cur;
            }
            if (i == n) {
                nNode = cur;
            }
            ListNode temp = cur;
            cur = cur.next;
            if (i >= m && i <= n) {
                temp.next = last;
                last = temp;
            }
            if (Objects.isNull(cur)
                    || i == n + 1
                    || i > size) {
                break;
            }
        }
        if (Objects.nonNull(mFrontNode)) {
            mFrontNode.next = nNode;
        }
        if (Objects.isNull(mFrontNode)) {
            head = nNode;
        }
        mNode.next = nBackNode;
        return head;
    }

    private int getSize(ListNode head) {
        if (Objects.isNull(head)) {
            return 0;
        }
        ListNode node = head;
        int size = 0;
        while (Objects.nonNull(node)) {
            size++;
            node = node.next;
        }
        return size;
    }

    private ListNode getTestCase(Integer... values) {
        List<ListNode> demos = Stream.of(values)
                .map(ListNode::new).collect(Collectors.toList());
        for (int i = 0; i < demos.size() - 1; i++) {
            demos.get(i).next = demos.get(i + 1);
        }
        return demos.get(0);
    }

    private void print(ListNode head) {
        Optional<ListNode> opHead = Optional.ofNullable(head);
        List<String> value = new ArrayList<>();
        while (opHead.isPresent()) {
            ListNode node = opHead.get();
            value.add(String.valueOf(node.val));
            opHead = Optional.ofNullable(node.next);
        }
        System.out.println("value = " + String.join(",", value));
    }

    class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
}