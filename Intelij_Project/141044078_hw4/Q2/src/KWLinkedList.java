import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.AbstractSequentialList;

/**
 * Class KWLinkedList a double linked list
 * @param <E>
 **/
public class KWLinkedList<E> extends AbstractSequentialList<E>  {
    Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    /**
     * Add an item at index.
     * @param index index add place
     * @param item value will is added
     */
    public void add(int index, E item) {
        listIterator(index).add(item);
    }

    /**
     * Get the element at index.
     * @param index will deleted index
     * @return The item at index
     */
    public E get(int index) {
        if (head!=null) {
            return listIterator(index).next();
        }
        else
            return null;
    }

    /**
     * Return the size of the list
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Get the iterator at index.
     * @param i iterotor index
     * @return listIterator of KWlistIter
     */
    public ListIterator<E> listIterator(int i) {
        return new KWListIter(i);
    }


    // Inner Class
    /**
     * A Node build a double-linked list.
     */
    private static class Node<E> {

        private E data;
        private Node<E> next = null;
        private Node<E> prev = null;

        /**
         * @param dataItem The data value
         */
        private Node(E dataItem) {
            data = dataItem;
        }
    }

    /** Inner class from ListIterator interface. */
    private class KWListIter implements ListIterator<E> {

        private Node<E> nextItem;
        private Node<E> lastItemReturned;
        private int index = 0;

        @Override
        public void remove() {
            if (size()>0) {

                if (index==0) {
                    head=head.next;
                }
                else
                {

                    nextItem.prev.next=nextItem.next;
                    nextItem.next.prev=nextItem.prev;
                }
                size--;
                //index++;
            }
        }

        @Override
        public void set(E e) {
            nextItem.prev.data=e;
        }

        /**
         * @param i The index of the item to be referenced
         */
        public KWListIter(int i) {
            if (i < 0 || i > size) {
                throw new IndexOutOfBoundsException(
                        "Invalid index " + i);
            }
            lastItemReturned = null;

            if (i == size) {
                index = size;
                nextItem = null;
            } else {
                nextItem = head;
                for (index = 0; index < i; index++) {
                    nextItem = nextItem.next;
                }
            }
        }

        /**
         * @param other The other KWListIter
         */
        public KWListIter(KWListIter other) {
            KWListIter itr = new KWListIter(0);
            itr.index = other.index;
            itr.lastItemReturned = other.lastItemReturned;
            itr.nextItem = other.nextItem;
        }

        /**
         * @return true if call to next will not throw an exception
         */
        @Override
        public boolean hasNext() {
            return nextItem != null;
        }

        /** Move the iterator forward
         @return The next item in the list
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;
            return lastItemReturned.data;
        }

        /**
         * control of backward is defined.
         * @return true or Exception
         */
        @Override
        public boolean hasPrevious() {
            head.prev=null;
            return (nextItem == null && size != 0)
                    || nextItem.prev != null;
        }

        /**
         * Return the index of the next item
         * @return the index of the next item
         */
        @Override
        public int nextIndex() {
            return index;
        }

        /**
         * Return the index of the next item
         * @return the index of the next item
         */
        @Override
        public int previousIndex() {
            return index - 1;
        }

        /**
         * Move the iterator backward
         * @return The previous item in the list
         */
        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (nextItem == null) { // Iterator past the last element
                nextItem = tail;
            } else {
                nextItem = nextItem.prev;
            }
            lastItemReturned = nextItem;
            index--;
            return lastItemReturned.data;
        }
        /**
         * Add a new item
         * @param item to be inserted
         */
        @Override
        public void add(E item) {
            if (head == null) {
                head = new Node<E>(item);
                tail = head;
            } else if (nextItem == head) {
                Node<E> newNode = new Node<E>(item);
                newNode.next = nextItem;

                nextItem.prev = newNode;
                head = newNode;
            } else if (nextItem == null) {
                Node<E> newNode = new Node<E>(item);
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } else {
                Node<E> newNode = new Node<E>(item);

                newNode.prev = nextItem.prev;
                nextItem.prev.next = newNode;

                newNode.next = nextItem;
                nextItem.prev = newNode;
            }
            lastItemReturned = null;
            ++size;
            ++index;
        }

    }
}
