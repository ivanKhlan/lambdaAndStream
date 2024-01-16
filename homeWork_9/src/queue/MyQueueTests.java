package queue;

public class MyQueueTests {
    public static void main(String[] args) {

        MyQueue<Integer> queue = new MyQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }

//        for (int i = 0; i < queue.size(); i++) {
//            System.out.println(queue.get(i));
//        }
//        System.out.println(queue.size());
//        System.out.println(queue.get(0));
        //queue.clear();
        //System.out.println(queue.peek());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());
    }
}
