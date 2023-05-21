# assignment5
#Mukanova Amina, SE-2215
BinarySearchTree class:

1. `put(K key, V value)`:  inserts a key-value pair into the binary search tree. It creates a new `Node` with the given key and value, 
and recursively traverses the tree to find the appropriate position for insertion based on the key's comparison with existing nodes. 
If the key already exists, the method updates the corresponding value.

2. `put(Node node, K key, V value, Node parent)`:a private helper method used by `put(K key, V value)` to perform the recursive insertion. 
It takes the current node, the key and value to be inserted, and the parent node of the current node. It compares the key with the current node's
key and decides whether to traverse left or right in the tree. If the current node is null, indicating an empty position, a new node is created
and returned. Otherwise, the method recursively calls itself on the left or right child node until the appropriate position for insertion is found.

3. `get(K key)`: retrieves the value associated with the given key from the binary search tree. It starts the search from the root node
and compares the key with the current node's key to determine whether to traverse left or right. If the key is found, the method returns 
the corresponding value. If the key is not found, it returns `null`.

4. `get(Node node, K key)`: a private helper method used by `get(K key)` to perform the recursive search. It takes the current node and
the key to be searched as parameters. It compares the key with the current node's key and decides whether to traverse left or right in
the tree. If the current node is null, indicating the key is not found, the method returns `null`. Otherwise, the method recursively 
calls itself on the left or right child node until the key is found or the appropriate position for insertion is reached.

5. `size()`: returns the number of elements (key-value pairs) currently stored in the binary search tree. It simply returns the value 
of the `size` variable, which is updated whenever a new element is inserted or an existing element is updated.

6. `iterator()`: returns an iterator over the elements in the binary search tree. It allows iterating through the tree in ascending order
 of the keys. It returns an instance of the `BSTIterator` class, which implements the `Iterator<Entry<K, V>>` interface.

7. `Node` class: a private inner class representing a node in the binary search tree. It contains fields for the key, value, parent node,
 and left and right child nodes.

8. `Entry` class:a public nested class representing a key-value pair. It provides a convenient way to encapsulate the key and value 
together. Objects of this class are returned by the iterator to provide access to the key-value pairs in the binary search tree.

9. `BSTIterator` class: a private inner class implementing the `Iterator<Entry<K, V>>` interface. It allows iterating through the binary
search tree in ascending order of the keys. The iterator maintains a `current` node and a `next` node. The `hasNext()` method checks
if there is a next element available, and the `next()` method returns the next element in the iteration. The `findSuccessor(Node node)` 
method is a helper method used to find the successor of a given node in the binary search tree, which is needed to determine the next node
to be visited in the iteration.




Main class:
1. 'main(String[] args)': This is the main method that serves as the entry point of the program. It creates an instance of
the BinarySearchTree class with key type Integer and value type String. It inserts several key-value pairs into the tree using the
put(K key, V value) method. Finally, it iterates over the elements in the tree using the enhanced for loop and prints each
key-value pair to the console.





