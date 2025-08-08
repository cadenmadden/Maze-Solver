public class ListNode<E>{
    private E value;
    private ListNode<E> next;

    public ListNode(E x, ListNode<E> pt){
        value = x;
        next = pt;
    }

    public ListNode<E> getNext(){
        return next;
    }

    public void setValue(E x){
        value = x;
    }

    public E getValue(){
        return value;
    }

    public void setNext(ListNode<E> pt){
        next = pt;
    }

    public String toString(){
        if (next != null) return value.toString() + "->";
        else return value.toString() + "-//";
    }

    public static void main(String[] args) {
        ListNode node = new ListNode<>(5, null);
        System.out.println(node.getNext());
        node.setNext(node);
        System.out.println(node.getNext());
        System.out.println(node.getValue());
        node.setValue(10);
        System.out.println(node.getValue());
        System.out.println(node.toString());
    }
}