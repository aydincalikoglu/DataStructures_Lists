import java.util.ArrayList;
/**
 *
 * @author AyKo
 */
public class StackA<E>  extends ArrayList<E> implements StackInterface<E> {

    /**
     * get item witout delete
     * @return item which added last
     */
    @Override
    public E peek() {
        if( !isEmpty() ) {
            return get(0);
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
            return remove( 0 );
        }
        return null;
    }
    /**
     * add an item
     * @param item
     */
    @Override
    public void push(E item ) {
        add( 0, item );
    }
    /**
     * control of there any eleman in stack
     * Is there no element in stack
     * @return boolean Empty conditional
     */
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }
    /**
     * size of stack
     * @return size
     */
    @Override
    public int size() {
        return super.size();
    }

}
