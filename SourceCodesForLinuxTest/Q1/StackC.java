/**
 * Stack With Node Class
 * @param <E>
 */
public class StackC<E> implements StackInterface<E>{
    Node<E> head=new Node<E>(null,null);
    int size=0;

    /**
     * get item witout delete
     * @return item which added last
     */
    @Override
    public E peek() {
        if( head!=null ) {
            return head.getData();
        }
        return null;
    }
    /**
     * get item and delete it
     * @return item which added last
     */
    @Override
    public E pop() {
        if( head!=null ) {
            size--;
            return head.removeFirst();
        }
        return null;
    }
    /**
     * add an item
     * @param item
     */
    @Override
    public void push(E item ) {
        head.addFirst(item);
        size++;
    }
    /**
     * control of there any eleman in stack
     * Is there no element in stack
     * @return boolean Empty conditional
     */
    @Override
    public boolean isEmpty() {
        return head==null;
    }
    /**
     * size of stack
     * @return size
     */
    @Override
    public int size() {
        return size;
    }


}
