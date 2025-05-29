class Node {
    int data;
    Node next, prev;

    Node(int data) {
        this.data = data;
        this.next = this.prev = null;
    }
}

class Deque {
    private Node front, rear;

    public Deque() {
        front = rear = null;
    }
    public void insertFront(int data) {
        Node newNode = new Node(data);
        if (front == null) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        System.out.println(data + " inserted at front.");
    }

    // Insert at rear
    public void insertRear(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println(data + " inserted at rear.");
    }

    // Delete from front
    public void deleteFront() {
        if (front == null) {
            System.out.println("Deque is empty. Nothing to delete at front.");
            return;
        }
        System.out.println(front.data + " deleted from front.");
        front = front.next;
        if (front == null)
            rear = null;
        else
            front.prev = null;
    }

    // Delete from rear
    public void deleteRear() {
        if (rear == null) {
            System.out.println("Deque is empty. Nothing to delete at rear.");
            return;
        }
        System.out.println(rear.data + " deleted from rear.");
        rear = rear.prev;
        if (rear == null)
            front = null;
        else
            rear.next = null;
    }

    // Display contents of deque
    public void display() {
        if (front == null) {
            System.out.println("Deque is empty.");
            return;
        }
        System.out.print("Deque: ");
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class Deque_Insertion_Deletion {
    public static void main(String[] args) {
        Deque dq = new Deque();

        dq.insertFront(10);
        dq.insertRear(20);
        dq.insertFront(5);
        dq.insertRear(25);
        dq.display();

        dq.deleteFront();
        dq.display();

        dq.deleteRear();
        dq.display();
    }
}

