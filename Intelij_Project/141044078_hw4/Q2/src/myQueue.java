import java.util.Queue;
import java.util.ListIterator;

/**
 * @param <E>
 */
public class myQueue<E> extends KWLinkedList<E> implements Queue<E> {
    /**
     * Reverse The Queue
     */
    public void reverse()
    {
        if (size()>0) {
            ListIterator<E> it = listIterator(size());
            while (it.hasPrevious()) {
                add(it.previous());
                listIterator(it.nextIndex()).remove();
            }
        }
    }

    /**
     * Reverse Given Queue Recursively
     * @param aQueue
     * @return aQueue
     */
    public Queue reverseQueue(Queue<E> aQueue)
    {
        if(aQueue.size()<1)
            return aQueue;
        E item=aQueue.poll();
        reverseQueue(aQueue);
        aQueue.add(item);
        return aQueue;
    }
    /**
     * add item begining of the Queue
     * @param e
     * @return boolean
     */
    @Override
    public boolean add(E e) {
        ListIterator<E> it=listIterator(size());
        it.add(e);
        return true;
    }
    /**
     * get item first witout delete
     * @return data
     */
    @Override
    public E element() {
        return get(0);
    }
    /**
     * remove first item from stack and return it
     * @return Data
     */
    @Override
    public E remove() {
        ListIterator<E> it=listIterator(0);
        E temp=get(0);
        it.remove();
        return temp;
    }
    /**
     * get first item and delete it
     * @return Data
     */
    @Override
    public E poll() {
        return remove();
    }
    /**
     * give first item of stuck
     * @return
     */
    @Override
    public E peek() {
        return element();
    }
    /**
     * add item
     * @param data
     * @return boolean
     */
    @Override
    public boolean offer(E data) {
        return add(data);
    }
}
