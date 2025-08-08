import java.util.NoSuchElementException;
public class Queue<E extends Comparable<E>> implements WorkerList<E> {
    private ListNode<E> front;
    private ListNode<E> rear;

    public Queue() {
        front = rear = null;
    }
    
    public Queue(Queue<E> other) {
        if (other.front == null) {
            front = rear = null;
        } else {
            front = new ListNode<>(other.front.getValue(), null);
            ListNode<E> current = front;
            ListNode<E> otherCurrent = other.front.getNext();

            while (otherCurrent != null) {
                current.setNext(new ListNode<>(otherCurrent.getValue(), null));
                current = current.getNext();
                otherCurrent = otherCurrent.getNext();
            }

            rear = current;
        }
    }

    public void enqueue(E value) {
        ListNode<E> newNode = new ListNode<>(value, null);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    public E dequeue() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        ListNode<E> temp = front;
        front = front.getNext();
        if (front == null) { // queue is empty
            rear = null;
        }
        return temp.getValue();
    }

    public E peek() {
        if (isEmpty()) return null;
        return front.getValue();
    }

    public boolean isEmpty() {
        return front == null;
    }

    public String toString() {
        String result = "";
        ListNode<E> current = front;
        while (current != null) {
            result += current.getValue();
            if (current != rear) {
                result += "->";
            }
            current = current.getNext();
        }
        return result;
    }

    @Override
    public void add(E x) {
        enqueue(x);
    }

    @Override
    public E remove() {
        return dequeue();
    }
}
