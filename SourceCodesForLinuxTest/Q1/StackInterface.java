/**
 * Stack Interface Methods
 * @param <E>
 */
public interface StackInterface<E> {
    public void push(E item);
    public E pop();
    public E peek();
    public int size();
    public boolean isEmpty();
}
