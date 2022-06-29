public class SinglyLinkedList {
    Node head = null;
    Node tail = null;
    int size = 0;

    class Node {
        Node next;
        Object data;

        Node(Object input) {
            this.data = input;
            this.next = null;
        }
    }

    public void addHead(Object input) {
        Node newNode = new Node(input);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size ++;
        System.out.println(input + " added as the first");
    }

    public void addTail(Object input) {
        Node newNode = new Node(input);
        if (tail == null) {
            tail = newNode;
            head = tail;
        } else {
            tail.next = newNode;
            head = tail;
        }
        size ++;
        System.out.println(input + " added as the last");
    }

    public void add(int k, Object input) {
        if (k == 0) {
            addHead(input);
        } else if (k == size) {
            addTail(input);
        } else {
            Node newNode = new Node(input);
            Node x = node(k - 1);
            newNode.next = x.next;
            x.next = newNode;
            size++;
            System.out.println(input + " added in the list. ");
        }
    }

    public Node node(int index) {
        Node x = head;
        for (int i = 1; i <= index; i++) {
            x = x.next;
        }

        return x;
    }

    public void print() {
        if (head != null) {
            System.out.print("list = [ ");
            Node x = head;

            while (true) {
                System.out.print(x.data);

                if (x == tail){
                    break;
                } else {
                    System.out.print(", ");
                }
                x = x.next;

            }
            System.out.print(" ]");
            System.out.print(System.lineSeparator());

        } else {
            System.out.print("list is now empty.");
        }
    }



    public Object removeFirst() {
        Object removedData = head.data;
        head = head.next;
        size--;

        System.out.println(removedData + " is removed in the list. ");

        return removedData;

    }



    public Object removeLast() {
        Object removedData = tail.data;
        node(size - 2).next = null;
        tail = node(size - 2);
        size--;

        System.out.print(removedData + " is removed in the list. ");
        print();
        return removedData;

    }



    public Object remove(int k) {
        Object removedData = node(k).data;

        if (node(k) == head) {
            removeFirst();
        } else if (node(k) == tail) {
            removeLast();
        } else {
            node(k - 1).next = node(k).next;
            System.out.println(removedData + " is removed in the list. ");
            size--;
        }

        return removedData;

    }

    public int size() {
        return size;
    }



    public Object get(int k) {
        Object data = node(k).data;
        return data;
    }



    public int indexOf(Object data) {
        Node x = head;

        for(int i = 0; i < size; i++) {
            if(x.data == data) {
                return i;
            }
            x = x.next;
        }
        return -1;

    }
}