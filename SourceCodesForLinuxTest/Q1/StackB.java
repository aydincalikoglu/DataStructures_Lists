import java.util.ArrayList;
/**
 * Composition StackB with ArrayList
 * @author AYDIN CALIKOGLU
 */
public class StackB<E> implements StackInterface<E>{
    private ArrayList<E> list = new ArrayList<E>();
    public StackB() {
    }
    public StackB(ArrayList<E> newList) {
        list=newList;
    }
    /**
     * get item witout delete
     * @return item which added last
     */
    @Override
    public E peek() {
        if( !isEmpty() ) {
            return list.get(0);
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
            return list.remove(0);
        }
        return null;
    }
    /**
     * add an item
     * @param item
     */
    @Override
    public void push(E item ) {
        list.add( 0, item );
    }
    /**
     * control of there any eleman in stack
     * Is there no element in stack
     * @return boolean Empty conditional
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    /**
     * size of stack
     * @return size
     */
    @Override
    public int size() {
        return list.size();
    }

}
