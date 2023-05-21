import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchTree<K extends Comparable<K>, V> implements Iterable<BinarySearchTree.Entry<K, V>> {

    private Node root;
    private int size;

    public void put(K key, V value) { //Inserts a key-value pair into the binary search tree
        root = put(root, key, value, null);
    }

    private Node put(Node node, K key, V value, Node parent) {
        if (node == null) {
            size++;
            return new Node(key, value, parent);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value, node);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value, node);
        } else {
            node.value = value;
        }

        return node;
    }

    public V get(K key) { //Retrieves the value associated with the given key from the binary search tree.
        Node node = get(root, key);
        return node != null ? node.value : null;
    }

    private Node get(Node node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node;
        }
    }

    public int size() { //Returns the number of elements (key-value pairs) stored in the binary search tree.
        return size;
    }

    public Iterator<Entry> iterator() { //Returns an iterator over the elements in the binary search tree
        return new BSTIterator();
    }

    private class Node { //Represents a node in the binary search tree
        private K key;
        private V value;
        private Node parent;
        private Node left;
        private Node right;

        public Node(K key, V value, Node parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }
    }

    public class Entry<K, V> { //Represents a key-value pair
        public K key;
        public V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private class BSTIterator implements Iterator<Entry<K, V>> { //Implements the iterator for the binary search tree
        private Node current;
        private Node next;

        public BSTIterator() {
            this.current = null;
            this.next = root;

            if (next != null) {
                while (next.left != null) {
                    next = next.left;
                }
            }
        }

        public boolean hasNext() {
            return next != null;
        }

        public Entry<K, V> next() { // Returns the next key-value pair in the iteration
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            current = next;
            next = findSuccessor(next);

            return new Entry<>(current.key, current.value);
        }

        private Node findSuccessor(Node node) { //finds the successor node of a given node
            if (node.right != null) {
                node = node.right;
                while (node.left != null) {
                    node = node.left;
                }
                return node;
            } else {
                while (node.parent != null && node == node.parent.right) {
                    node = node.parent;
                }
                return node.parent;
            }
        }
    }
}
