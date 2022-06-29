public class DoublyLinkedList {
    Node head;
    Node tail;
    int size;

    public DoublyLinkedList() {
        size = 0;
    }

    public class Node {
        Node nextNode;
        Node prevNode;
        Object data;

        Node(Object data) {
            this.data = data;
            this.nextNode = null;
            this.prevNode = null;
        }
    }

    public void addHead(Object data) {
        Node newNode = new Node(data);

        if(head != null) {
            newNode.nextNode = head;
            head.prevNode = newNode;
        }

        head = newNode;
        if (head.nextNode == null) {
            tail = head;
        }
        size ++;
    }

    public void addTail(Object data) {
        if (size == 0) {
            addHead(data);
        } else {
            Node newNode = new Node(data);
            tail.nextNode = newNode;
            newNode.prevNode = tail;
            tail = newNode;
            size ++;
        }
    }

    public void add(int index, Object data) {
        if (index == 0) {
            addHead(data);
        } else if (index == size - 1) {
            addTail(data);
        } else {
            Node newNode = new Node(data);
            Node prevNode = getNode(index - 1);
            Node nextNode = prevNode.nextNode;

            newNode.prevNode = prevNode;
            newNode.nextNode = nextNode;

            prevNode.nextNode = newNode;
            nextNode.prevNode = newNode;

            size ++;
        }
    }

    private  Node getNode(int index) {
        if (index < size / 2) {
            Node node = head;
            for (int i = 0; i < index; i++ ) {
                node = node.nextNode;
            }
            return node;
        } else {
            Node node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prevNode;
            }
            return node;
        }
    }

    public Object removeHead() {
        if (size == 0) {
            return null;
        }
        Node removeNode = head;
        head = null;
        head = removeNode.nextNode;
        head.prevNode = null;
        size --;

        return removeNode.data;
    }

    public Object removeTail() {
        if (size == 0) {
            return null;
        }
        Node removeNode = tail;
        tail = null;
        tail = removeNode.prevNode;
        tail.nextNode = null;
        size --;

        return removeNode.data;
    }

    public Object remove(int index) {
        if (size == 0) {
            return null;
        }

        if (index == 0) {
            return removeHead();
        } else if(index == size - 1) {
            return removeTail();
        } else {
            Node removeNode = getNode(index);
            Node prevNode = removeNode.prevNode;
            Node nextNode = removeNode.nextNode;

            prevNode.nextNode = nextNode;
            nextNode.prevNode = prevNode;

            size--;
            return removeNode.data;
        }
    }
}


