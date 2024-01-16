package linkedList;


public class MyLinkedListTests {

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        System.out.println("list.size() = " + list.size());

        list.add("a");
        System.out.println("list.size() = " + list.size());

        list.add("b");
        System.out.println("list.size() = " + list.size());
        list.add("c");

        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("list.get(1) = " + list.get(1));

        //list.clear();
        list.remove(3);
        list.remove(0);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

}
