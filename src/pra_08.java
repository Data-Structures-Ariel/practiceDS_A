public class pra_08 {

    public static void main(String[] args) {
        int a[] = {1, 45, 73, 64, 8, 0, 3, 5, 2, 34};
        BST bst = new BST();
        for (int i = 0; i < a.length; i++) {
            bst.add(a[i]);
        }

        int countLeaves = BST.countLeaves(bst);
        System.out.println("The number of leaves in the tree " + countLeaves);
        int countNodes = BST.countNodes(bst);
        System.out.println("Number of nodes in the tree " + countNodes);
        boolean exist = BST.exist(bst,4);
        System.out.println("exist = " + exist);
        exist = BST.exist(bst,34);
        System.out.println("exist = " + exist);
    }

}

class BST {

    private BinNode root;

    public BST(int value) {
        this.root = new BinNode(value);
    }

    public BST() {
        this.root = null;
    }

    public void add(int value) {
        this.root = add(root, value);
    }

    private BinNode add(BinNode root, int value) {
        if (root == null)
            return new BinNode(value);
        if (value < root.getValue())
            root.setLeft(add(root.getLeft(), value));
        else
            root.setRight(add(root.getRight(), value));

        return root;
    }

    public void inOrder() {
        inOrder(this.root);
    }

    private void inOrder(BinNode root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.printf("%d ", root.getValue());
            inOrder(root.getRight());
        }
    }

    public static int countLeaves(BST T) {
        return countLeaves(T.root);
    }

    private static int countLeaves(BinNode root) {
        if (emptyTree(root))
            return 0;
        if (emptyTree(root.left) && emptyTree(root.right))
            return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    public static int countNodes(BST T) {
        return countNodes(T.root);
    }

    public static int countNodes(BinNode root) {
        if (emptyTree(root)) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    private static boolean emptyTree(BinNode T) {
        if (T == null)
            return true;
        return false;
    }

    public static boolean exist(BST T, int x) {
        return exist(T.root, x);
    }

    private static boolean exist(BinNode root, int x) {
        if (emptyTree(root))
            return false;
        if (root.getValue() == x)
            return true;
        return exist(root.left, x) || exist(root.right, x);
    }
}

class BinNode {
    private int value;
    public BinNode left;
    public BinNode right;

    public BinNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public BinNode(BinNode left, int value, BinNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BinNode getLeft() {
        return this.left;
    }

    public BinNode getRight() {
        return this.right;
    }

    public void setLeft(BinNode left) {
        this.left = left;
    }

    public void setRight(BinNode right) {
        this.right = right;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean hasLeft() {
        return this.left != null;
    }

    public boolean hasRight() {
        return this.right != null;
    }

    public String toString() {
        return " " + this.value;
    }
}
