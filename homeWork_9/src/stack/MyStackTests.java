package stack;


public class MyStackTests {
    public static void main(String[] args) {


        MyStack<Integer> stack = new MyStack<>();

        for (int i = 0; i < 7; i++) {
            stack.push(i);
        }
//        for (int i = 0; i < stack.size(); i++) {
//            System.out.println();
//        }

//        for (int i = 0; i < 7; i++) {
//            System.out.println(stack.poop());
//        }

        //System.out.println(stack.size());

        //stack.clear();
    }
}
