public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
        tree.put(5, "Bangchan");
        tree.put(2, "Jungkook");
        tree.put(8, "Serkan");
        tree.put(1, "Suga");
        tree.put(3, "Felix");

        for (BinarySearchTree.Entry entry : tree) {
            System.out.println("Key is " + entry.key + " and value is " + entry.value);
        }
    }
}

