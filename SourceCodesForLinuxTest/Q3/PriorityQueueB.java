import java.util.LinkedList;
        import java.util.ListIterator;

/**
 * @param <E>
 */
public class PriorityQueueB<E> implements priorityQueueInterface<E>  {
    // Data Types
    private LinkedList<E> list = new LinkedList<E>();

    public PriorityQueueB() {
    }

    /**
     * priortiyQueue start with A LinkedList
     * @param list
     */
    public PriorityQueueB(LinkedList<E> list) {
        this.list = list;
    }

    /**
     * insert an item in priorityQueue
     * @param newItem
     */
    @Override
    public void insert(E newItem) {
        if (list.size()==0)
            list.add(newItem);
        else
        {
            ListIterator<E> itList = list.listIterator();
            boolean isAdded=false;
            while (itList.hasNext())
            {
                int status=newItem.toString().compareTo(itList.next().toString());
                if(status==0)
                {
                    itList.add(newItem);
                    isAdded=true;
                }
                else if(status<0)
                {
                    if (itList.hasPrevious())
                        itList.previous();
                    itList.add(newItem);
                    isAdded=true;
                    break;
                }
            }
            if (!isAdded)
            {
                list.add(newItem);
            }
        }

    }


    /**
     * remove the smallest item in priorityQueue
     * @return
     */
    @Override
    public E deleteMin()
    {
        return list.removeFirst();
    }

    /**
     * Control of priorityQueue if its empty
     * @return true if priorityQueue is empty
     */
    @Override
    public boolean isEmpty()
    {
        return list.size()<1;
    }

    /**
     * size of priorityQueue
     * @return size of priorityQueue
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     *  String of all elements of priorityQueue
     * @return String
     */
    @Override
    public String toString() {
        return list.toString().replace("[","").replace("]","");
    }
}