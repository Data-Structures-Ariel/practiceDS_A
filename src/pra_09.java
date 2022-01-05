import java.util.LinkedList;
import java.util.Queue;

public class pra_09 {


    public static void main(String[] args) {

        Node1 head = new Node1(1);
        head.next = new Node1(1);
        head.next.next = new Node1(2);

        Queue<Integer> q = createQueue_N(4);
        System.out.println(q);

        boolean check = checkQueue_N(q, 4);
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

//        Node1 n = new Node1(1);
//        n.next = new Node1(1);
//        n.next.next = new Node1(2);
//        n.next.next.next = new Node1(4);
//        n.next.next.next.next = new Node1(8);
//        n.next.next.next.next.next = new Node1(16);
//        n.next.next.next.next.next.next = new Node1(32);

        Node1 n = new Node1(1);
        add(n, 1);
        add(n, 2);
        add(n, 4);
        add(n, 8);
        add(n, 16);
        add(n, 32);
        print(n);
        System.out.println(foo3(n));
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
        int i = 1;
        while (!temp_q.isEmpty()) {
            for (int j = 0; j < i && !temp_q.isEmpty(); j++)
                if (temp_q.poll() != i)
                    return false;
            if (i == n)
                break;
            if (!temp_q.isEmpty())
                i++;
        }
        return temp_q.isEmpty() && i == n;
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

    //O(n)
    public static boolean foo3(Node1 list) {
        if (list == null)
            return true;
        Node1 temp = list;
        int sum = 0;
        while (temp.next != null) {
            sum += temp.data;
            if (sum != temp.next.data)
                return false;
            temp = temp.next;
        }
        return true;
    }

    public static void print(Node1 list) {
        Node1 temp = list;
        while (temp != null) {
            System.out.printf("%d -> ", temp.data);
            temp = temp.next;
        }
        System.out.printf("null\n");
    }

    public static void add(Node1 list, int key) {
        if (list == null)
            list = new Node1(key);
        Node1 temp = list;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node1(key);
    }
}
//https://apps.moital.gov.il/WebServicesHandlers/Mahat/Rsrc/MahatTests/97105412021.pdf
//Q8

class Node1 {
    int data;
    Node1 next;

    public Node1(int data) {
        this.data = data;
        this.next = null;
    }
}