import java.util.LinkedList;
import java.util.Deque;

public class deque_Using_Stack {
    static class stack {

        Deque<Integer> deque = new LinkedList<>();

        public void push(int data) {

            deque.addLast(data);
        }

        public int pop() {
            return deque.removeLast();
        }

        public int peek() {
            return deque.getLast();
        }
    }

    public static void main(String[] args) {
        stack s = new stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println("Peek = " + s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

    }
}
