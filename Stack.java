import java.util.ArrayList;
import java.util.NoSuchElementException;
public class Stack<E>{

    ListNode<E> top;

    public Stack(){
        top = null;
    }

    public Stack(Stack other){
        if (other.top == null) top = null;
        else{
            top = new ListNode(other.top.getValue(), null);
            ListNode<E> cur = top;
            ListNode<E> otherCur = other.top.getNext();

            while (otherCur != null){
                cur.setNext(new ListNode<>(otherCur.getValue(), null));
                cur = cur.getNext();
                otherCur = otherCur.getNext();
            }
        }
    }

    public void push(E value){
        top = new ListNode<E>(value, top);
    }

    public E pop() throws NoSuchElementException{
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        ListNode<E> temp = top;
        top = top.getNext();
        return temp.getValue();
    }

    public E peek(){
        return top.getValue();
    }

    public boolean isEmpty(){
        return (top == null);
    }

    public String toString(){
        String result = "";
        ListNode<E> n = top;
        if (n == null) return result;
        while (n.getNext() != null){
            result += n.getValue() + "->";
            n = n.getNext();
        }
        result += n.getValue() + "\\";
        return result;
    }

}
