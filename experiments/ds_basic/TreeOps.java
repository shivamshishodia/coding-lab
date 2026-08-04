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

    public static <T> void inorder(TreeNode<T> root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.println(root.value);
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(10);

        root.left = new TreeNode<>(20);
        root.right = new TreeNode<>(30);

        inorder(root);
    }
}
