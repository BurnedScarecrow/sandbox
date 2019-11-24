public class LinkedList {
    public  class Node {
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    private Node head;
    private Node end;
    private int size;

    LinkedList(){
        head = null;
        end = null;
        size = 0;
    }

    int getSize() { return size; }

    void getEnd(){
        System.out.println(end.val);
    }

    void add (int val) {
        if (head == null) {
            head = new Node(val);
            head.next = null;
            end = head;
        }
        else{
            Node newNode = new Node(val);
            newNode.next = null;
            end.next = newNode;
            end = newNode;
        }
        size++;
    }

    void print () {
        Node current = head;
        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.print("\n");
    }

    void remove (int pos) {
        if(pos < 1 || pos > size) {
            System.out.println("Position is out of range");
            return;
        }
        if (pos == 1) head = head.next;
        else{
            Node p = head;
            for (int i = 1; i < pos-1; i++) p = p.next;
            if(pos == size) end = p;
            Node temp = p.next;
            p.next = p.next.next;
            temp = null;
        }
        size--;
    }

    void reverse() {
        Node oldHead = head;
        for(int i = 0; i < size-1; i++){
            Node temp = head.next;
            head.next = end;
            end = head;
            head = temp;
        }
        Node temp = head;
        head.next = end;
        oldHead.next = null;
    }
}