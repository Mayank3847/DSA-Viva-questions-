import java.util.LinkedList;
import java.util.Deque;
public class deque_Using_Queue {
    static class Queue {

        Deque<Integer> deque = new LinkedList<>();

        public void add(int data) {
            deque.addLast(data);
        }

        public int remove() {
            return deque.removeFirst();
        }

        public int peek(){
            return deque.getFirst();
        }
    }

    public static void main(String[] args) {
        Queue deque = new Queue();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        System.out.println("PEEK:" + deque.peek());
        System.out.println(deque.remove());
        System.out.println(deque.remove());
        System.out.println(deque.remove());


    }
}
