public class BST {
    private BSTNode root;
    /*BSTNode insert (BSTNode root, int value) {
        BSTNode newNode = new BSTNode(value);
        BSTNode Root = root;
        if (Root == null) return newNode;
        while (true) {
            if (value < Root.getValue()) {
                if (Root.getLeft() != null) {
                    Root = Root.getLeft();
                }
                else {Root.setLeft(newNode); break;}
            }
            else {
                if (Root.getRight()!=null) {
                    Root = Root.getRight();
                }
                else {
                    Root.setRight(newNode);
                    break;
                }
            }
        }
        return Root;
    }*/
    private BSTNode insert(BSTNode node, int value) {
        if (node == null) return new BSTNode(value);
        if (node.getValue() > value) {
            if (node.getLeft() == null) node.setLeft(new BSTNode(value));
            else {
                insert(node.getLeft(), value);
            }
        }
        else {
            if (node.getRight() == null) node.setRight(new BSTNode(value));
            else {
                insert(node.getRight(), value);
            }
        }
        return node;
    }
    void insert(int value) {
        root = insert(root, value);
    }
    public int height(BSTNode root) {
        if (root == null)
            return 0;
        return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
    }

    public int getcol(int h) {
        if (h == 1)
            return 1;
        return getcol(h - 1) + getcol(h - 1) + 1;
    }

    public void printTree(int[][] M, BSTNode root, int col, int row, int height) {
        if (root == null)
            return;
        M[row][col] = root.getValue();
        printTree(M, root.getLeft(), col - (int)Math.pow(2, height - 2), row + 1, height - 1);
        printTree(M, root.getRight(), col + (int)Math.pow(2, height - 2), row + 1, height - 1);
    }

    public void TreePrinter() {
        int h = height(root);
        int col = getcol(h);
        int[][] M = new int[h][col];
        printTree(M, root, col / 2, 0, h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < col; j++) {
                if (M[i][j] == 0)
                    System.out.print("  ");
                else
                    System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }
    }
}

