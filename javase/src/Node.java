
/**
 * ½áµã
 * */
public class Node {


    public Object data;
    public Node next;

    public Node(){}
    public Node(Object data,Node next){
        this.data=data;
        this.next=next;
    }

    public Node getNext() {
        return next;
    }

    public Object getData() {
        return data;
    }


    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "data="+data+" next="+next;
    }
}
