/**
 * Created by AYDIN CALIKOGLU
 */
public interface priorityQueueInterface<E> {

    public void insert(E newItem);
    public E deleteMin();
    public boolean isEmpty();
    public int size();

}
