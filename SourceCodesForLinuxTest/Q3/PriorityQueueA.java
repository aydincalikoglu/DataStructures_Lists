import java.util.LinkedList;
        import java.util.ListIterator;

/**
 * Created by AYDIN CALIKOGLU
 */
public class PriorityQueueA<E> extends LinkedList<E>  implements priorityQueueInterface<E> {



    /**
     * remove the smallest item in priorityQueue
     * @return
     */
    @Override
    public E deleteMin()
    {
        return removeFirst();
    }

    /**
     * Control of priorityQueue if its empty
     * @return true if priorityQueue is empty
     */
    @Override
    public boolean isEmpty()
    {
        return size()<1;
    }

    /**
     * size of priorityQueue
     * @return size of priorityQueue
     */
    @Override
    public int size() {
        return super.size();
    }

    /**
     *  String of all elements of priorityQueue
     * @return String
     */
    @Override
    public String toString() {
        return super.toString().replace("[","").replace("]","");

    }

    /**
     * insert an item in priorityQueue
     * @param newItem
     */
    @Override
    public void insert(E newItem) {
        if (size()==0)
            add(newItem);
        else
        {
            ListIterator<E> itList = listIterator();
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
                add(newItem);
            }
        }
    }
}