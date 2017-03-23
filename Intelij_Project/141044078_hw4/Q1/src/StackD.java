import java.util.Queue;
import java.util.LinkedList;

/**
 * Stack with Queue
 * @param <E>
 */
public class StackD<E> implements StackInterface<E>{
    private Queue<E> queue = new LinkedList<E>();

    public StackD() {
        queue = new LinkedList<E>();
    }

    public StackD(LinkedList<E> list) {
        queue = list;
    }
    /**
     * get item witout delete
     * @return item which added last
     */
    @Override
    public E peek() {
        if( !isEmpty() ) {
            return queue.peek();
        }
        return null;
    }
    /**
     * get item and delete it
     * @return item which added last
     */
    @Override
    public E pop() {
        if( !isEmpty() ) {
            for (int i = 0; i < queue.size()-1; i++) {
                queue.add(queue.remove());
            }
            return queue.remove();
        }
        return null;
    }
    /**
     * add an item
     * @param item
     */
    @Override
    public void push(E item ) {
        queue.add(item);
    }
    /**
     * control of there any eleman in stack
     * Is there no element in stack
     * @return boolean Empty conditional
     */
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    /**
     * size of stack
     * @return size
     */
    @Override
    public int size() {
        return queue.size();
    }

}
