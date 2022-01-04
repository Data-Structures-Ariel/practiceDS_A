import java.util.LinkedList;
import java.util.Queue;

public class pra_09 {


    public static void main(String[] args) {
        Queue<Integer> q = createQueue_N(4);
        System.out.println(q);

        boolean check = checkQueue_N(q,4);
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

        //i=1 | --> 1
        //i=2 | --> 2
        // ..
        //i=n | --> n
        //1+2+3+4+...+n = n(n+1)/2 = 0.5*n^2 +0.5n

        return q;

    }

    //O(n^2)
    public static boolean checkQueue_N(Queue<Integer> q, int n) {

        Queue<Integer> temp_q = new LinkedList(q);
        for (int i = 1; !temp_q.isEmpty(); i++)
            for (int j = 0; j < i && !temp_q.isEmpty(); j++)
                if (temp_q.poll() != i)
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
//https://apps.moital.gov.il/WebServicesHandlers/Mahat/Rsrc/MahatTests/97105412021.pdf
//Q8

