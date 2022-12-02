package dataStructures;

public class BSTKeyOrderIterator<K, V> implements Iterator<Entry<K,V>> {

    // instance variables
    private BSTNode<K, V> root;
    private Stack<BSTNode<K, V>> stack;

    public BSTKeyOrderIterator(BSTNode<K, V> root) {
        stack = new StackInList<>();
        this.root = root;
        rewind();
    }

    @Override
    public boolean hasNext() { //done
        return !stack.isEmpty();
    }

    @Override
    public EntryClass<K, V> next() throws NoSuchElementException {
        if (stack.isEmpty()) throw new NoSuchElementException();
        BSTNode<K, V> next = stack.pop();
        if(next.getRight() != null){
            BSTNode<K, V> temp = next.getRight();
            while (temp != null){
                stack.push(temp);
                temp = temp.getLeft();
            }
        }
        return next.getEntry();
    }

    @Override
    public void rewind() {
        BSTNode<K, V> temp = root;
        while (temp != null) {
            stack.push(temp);
            temp = temp.getLeft();
        }
    }
}
