package bull.algorithm.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Optional;

/**
 * @author: jhaoniu
 * @date: 2022/6/10  10:49
 */
public class BinaryTreeTravel {

    public static void main(String[] args) {
        BinaryTreeTravel travelBinaryTree = new BinaryTreeTravel();
        TreeNode root = travelBinaryTree.initTree();
        travelBinaryTree.inOrderTraversal(root);
        System.out.println(" ==== ");
        travelBinaryTree.recursionInOrderTraversal(root);
        System.out.println(" ==== ");
        travelBinaryTree.recursionPreOrderTraversal(root);
        System.out.println(" ==== ");
        travelBinaryTree.preOrderTraversal(root);
        System.out.println(" ==== ");
        travelBinaryTree.recursionPostOrderTraversal(root);
        System.out.println(" ====== ");
        travelBinaryTree.postOrderTraversal(root);
    }

    public TreeNode initTree() {
        TreeNode root = new TreeNode(0);
        root.setLeft(new TreeNode(1));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(5));
        root.getLeft().setRight(new TreeNode(6));
        root.getLeft().getLeft().setLeft(new TreeNode(7));
        root.getLeft().getRight().setLeft(new TreeNode(8));
        return root;
    }

    public void recursionInOrderTraversal(TreeNode root) {
        if (Objects.nonNull(root)) {
            recursionInOrderTraversal(root.getLeft());
            visit(root);
            recursionInOrderTraversal(root.getRight());
        }
    }

    public void recursionPreOrderTraversal(TreeNode root) {
        if (Objects.nonNull(root)) {
            visit(root);
            recursionPreOrderTraversal(root.getLeft());
            recursionPreOrderTraversal(root.getRight());
        }
    }

    public void recursionPostOrderTraversal(TreeNode root) {
        if (Objects.nonNull(root)) {
            recursionPostOrderTraversal(root.getLeft());
            recursionPostOrderTraversal(root.getRight());
            visit(root);
        }
    }

    public void postOrderTraversal(TreeNode root) {
        if (Objects.nonNull(root)) {
            TreeNode node = root;
            TreeNode prev = null;//关键
            Deque<TreeNode> stack = new ArrayDeque<>();
            while (Objects.nonNull(node)
                    || !stack.isEmpty()) {
                while (Objects.nonNull(node)) {
                    stack.push(node);
                    node = node.getLeft();
                }
                node = stack.peek();
                if (Objects.isNull(node.getRight())
                        || node.getRight().equals(prev)) {//关键
                    stack.pop();
                    visit(node);
                    prev = node;
                    node = null;
                } else {
                    node = node.getRight();
                }
            }
        }
    }

    public void preOrderTraversal(TreeNode root) {
        if (Objects.nonNull(root)) {
            TreeNode node = root;
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                while (Objects.nonNull(node)) {
                    visit(node);
                    if (Objects.nonNull(node.getRight())) {
                        stack.push(node.getRight());
                    }
                    node = node.getLeft();
                }
            }
        }
    }

    public void inOrderTraversal(TreeNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        TreeNode node = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (Objects.nonNull(node)
                || !stack.isEmpty()) {
            while (Objects.nonNull(node)) {
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            visit(node);
            node = node.getRight();
        }
    }

    private void visit(TreeNode node) {
        Optional.ofNullable(node).map(TreeNode::getValue)
                .ifPresent(System.out::println);
    }

}
