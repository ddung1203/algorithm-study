interface StackIF {
    boolean isEmpty();
    boolean isFull();
    void push(String data);
    void pop();
    void peek();
    void clear();
}

class ListStackNode {
    private String data;
    public ListStackNode link;

    public ListStackNode() {
        this.data = null;
        this.link = null;
    }

    public ListStackNode(String data) {
        this.data = data;
        this.link = null;
    }

    public ListStackNode(String data, ListStackNode link) {
        this.data = data;
        this.link = link;
    }

    public String getData() {
        return this.data;
    }
}
public class ListStack implements StackIF {

    private ListStackNode head;
    private ListStackNode top;
    private int stackSize;


    public ListStack(int size) {
        head = null;
        top = null;
        this.stackSize = size;
    }


    public boolean isEmpty(){
        return (top == null);
    }


    public boolean isFull() {

        if(isEmpty()) {
            return false;
        }

        else {
            int nodeCount = 0;
            ListStackNode tempNode = head;

            while(tempNode.link != null) {
                ++nodeCount;
                tempNode = tempNode.link;
            }


            return (this.stackSize-1 == nodeCount);
        }
    }


    public void push(String data) {
        ListStackNode newNode = new ListStackNode(data);

        if(isFull()) {
            System.out.println("Stack is full!");
            return;
        }

        else if(isEmpty()) {


            this.head = newNode;
            this.top = this.head;
        } else {


            ListStackNode tempNode = top;

            while(tempNode.link != null) {
                tempNode = tempNode.link;
            }


            tempNode.link = newNode;
        }
    }


    public void pop() {
        ListStackNode preNode;
        ListStackNode tempNode;


        if(isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }

        if(top.link == null) {

            head = null;
            top = null;
        } else {
            preNode = top;
            tempNode = top.link;


            while(tempNode.link != null) {
                preNode = tempNode;
                tempNode = tempNode.link;
            }

            preNode.link = null;
        }
    }

    public void peek() {
        if(isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        } else {
            ListStackNode tempNode = top;

            while(tempNode.link != null) {
                tempNode = tempNode.link;
            }

            System.out.println(tempNode.getData());
        }
    }

    public void clear() {
        if(isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        } else {

            head = null;
            top = null;
        }
    }

    public ListStackNode searchNode(String data) {
        ListStackNode tempNode = this.top;


        while(tempNode != null) {
            if(data.equals(tempNode.getData())) {
                return tempNode;
            } else {
                tempNode = tempNode.link;
            }
        }

        return tempNode;
    }


    public void printListStack() {
        if(isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        } else {
            ListStackNode tempNode = this.top;

            while(tempNode != null) {
                System.out.print(tempNode.getData() + " ");
                tempNode = tempNode.link;
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int stackSize = 5;
        String str = "B";
        ListStack listStack = new ListStack(stackSize);

        listStack.printListStack();

    }

}