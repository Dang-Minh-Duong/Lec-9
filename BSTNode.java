public class BSTNode {
    private BSTNode left, right;
    private int value;
    BSTNode (int value) {
        this.value = value;
        left = null;
        right = null;
    }
    int getValue() {
        return value;
    }
    BSTNode getRight() {
        return right;
    }
    BSTNode getLeft() {
        return left;
    }
    void setLeft(BSTNode left) {
        this.left = left;
    }
    void setRight(BSTNode right) {
        this.right = right;
    }
}

