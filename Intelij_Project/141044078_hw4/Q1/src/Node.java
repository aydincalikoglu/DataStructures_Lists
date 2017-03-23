/**
 *
 * @author Aydın CALIKOGLU
 */
/**
 * Composition  NODE CLASS
 * @author AyKo
 * @param <E>
 */
public class Node<E> {
    private Node next;
    private E data;
    /**
     * Contructor with Param And Node
     * @param newNode
     * @param newData
     */
    Node(Node<E> newNode,E newData)
    {
        next=newNode;
        data=newData;
    }

    /**
     * add new data
     * @param newData
     */
    public void addFirst(E newData)
    {
        next = new Node<E>(next,data);
        data=newData;
    }
    /**
     * get a data
     * @return Data
     */
    public E getData()
    {
        return data;
    }
    /**
     * get next item
     * @return
     */
    public Node<E> getNext( )
    {
        return next;
    }

    /**
     * remove the node and return the data
     * @return data
     */
    public E removeFirst( )
    {
        E temp=data;
        data=(E) next.data;
        next=next.next;
        return temp;
    }

    /**
     * set data into Node
     * @param newData
     */
    public void setData(E newData)
    {
        data = newData;
    }
    /**
     * Set Next Node into the Node
     * @param newNode
     */
    public void setLink(Node<E> newNode)
    {
        next = newNode;
    }



}