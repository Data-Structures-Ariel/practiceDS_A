import java.util.LinkedList;
import java.util.Queue;

public class pra_09 {


    public static void main(String[] args) {
        Queue<Integer> q = createQueue_N(4);
        System.out.println(q);

        boolean check = checkQueue_N(q);
        System.out.println("is Queue_N " + check);


        LinkedList<Integer> list = new LinkedList();
        LinkedList<Integer> list2 = new LinkedList();
        list.add(1);
        int lastElement = 0;
        for (int i = 0; i < 6; i++) {
            lastElement += list.getLast();
            list.add(lastElement);
        }
        System.out.println(list);
        check = foo(list);
        System.out.println(check);


        list2.addFirst(2);
        lastElement = 0;
        for (int i = 0; i < 6; i++) {
            lastElement += list2.getFirst();
            list2.addFirst(lastElement);
        }
        System.out.println(list2);
        check = foo2(list2);
        System.out.println(check);
    }

    //O(n^2)
    public static Queue<Integer> createQueue_N(int n) {
        Queue q = new LinkedList();
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < i; j++)
                q.add(i);
        return q;

    }

    //O()
    public static boolean checkQueue_N(Queue<Integer> q) {

        for (int i = 1; !q.isEmpty(); i++)
            for (int j = 0; j < i && !q.isEmpty(); j++)
                if (q.poll() != i)
                    return false;
        return true;
    }

    //O(n)
    public static boolean foo(LinkedList<Integer> list) {
        LinkedList<Integer> tempList = new LinkedList(list);
        int sumElement = 0;
        do {
            sumElement += tempList.removeFirst();
            if (sumElement != tempList.peek())
                return false;

        } while (tempList.size() - 1 != 0);

        return true;
    }

    //O(n)
    public static boolean foo2(LinkedList<Integer> list) {
        LinkedList<Integer> tempList = new LinkedList(list);
        int sumElement = 0;
        do {
            sumElement += tempList.removeLast();
            if (sumElement != tempList.getLast())
                return false;

        } while (tempList.size() - 1 != 0);
        return true;
    }
}
