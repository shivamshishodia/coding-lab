import java.util.ArrayDeque;
import java.util.Deque;

class TreeNode<T> {
    T value;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class TreeOps {

    public static <T> void preOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }

        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static <T> void inOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    public static <T> void postOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }

    public static <T> void levelOrder(TreeNode<T> root) {
        if (root == null) {
            return;
        }

        Deque<TreeNode<T>> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode<T> current = queue.poll();
            System.out.print(current.value + " ");

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode<>(20);
        root.right = new TreeNode<>(30);

        System.out.print("Preorder:    ");
        preOrder(root);
        System.out.println();

        System.out.print("Inorder:     ");
        inOrder(root);
        System.out.println();

        System.out.print("Postorder:   ");
        postOrder(root);
        System.out.println();

        System.out.print("Level Order: ");
        levelOrder(root);
        System.out.println();
    }
}
