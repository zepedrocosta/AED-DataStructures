package dataStructures;

public class InvertibleQueueClass<E> extends QueueInList<E> implements InvertibleQueue<E> {

    // instance variables
    private static boolean inverted;

    public InvertibleQueueClass() {
        super();
        inverted = false;
    }
    @Override
    public void invert() {
        for (int i = 0; i < list.size(); i++) {
            E last = list.removeLast();
            list.add(i, last);
        }
        inverted = !inverted;
    }

    @Override
    public void enqueue(E element) {
        if (inverted) {
            list.addLast(element);
        } else {
            list.addFirst(element);
        }
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if ( list.isEmpty() )
            throw new EmptyQueueException();
        if (inverted) {
            return list.removeLast();
        } else {
            return list.removeFirst();
        }
    }
}
