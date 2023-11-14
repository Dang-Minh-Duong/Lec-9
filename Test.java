public class Test {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(10);
        tree.insert(12);
        tree.insert(-10);
        tree.insert(1);
        tree.insert(-100);
        System.out.println("DONE");
        tree.TreePrinter();

    }
}
