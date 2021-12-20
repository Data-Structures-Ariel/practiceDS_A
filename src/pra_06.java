import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

 class pre_06 {
    public static void main(String[] args) {
        Stack st = new Stack();
        Queue qu = new LinkedList();
        for (int i = 0; i < 10; i++) {
            st.push(i);
            qu.add(i);
        }
        System.out.println(qu);
        q4(qu);
        System.out.println(qu);
    }

    //O(n) --> 3n
    //Memory O(n)
    public static void q1(Stack st) {
        Stack st1 = new Stack();
        Stack st2 = new Stack();
        while (!st.isEmpty())
            st1.push(st.pop());
        while (!st1.isEmpty())
            st2.push(st1.pop());
        while (!st2.isEmpty())
            st.push(st2.pop());
    }
    //O(n) --> 2n
    //Memory O(n)
    public static void q3(Stack st) {
        Queue q1 = new LinkedList();
        while (!st.isEmpty())
            q1.add(st.pop());
        while (!q1.isEmpty())
            st.push(q1.poll());
    }
    //O(n) --> 2n
    //Memory O(n)
    public static void q4(Queue q) {
        Stack st1 = new Stack();
        while (!q.isEmpty())
            st1.push(q.poll());
        while (!st1.isEmpty())
            q.add(st1.pop());
    }
}

class StackQ {
    private Queue q;

    //Memory O(n)
    public StackQ() {
        this.q = new LinkedList<>();
    }

    //O(1)
    public void push(int data) {
        q.add(data);
    }

    //O(n)
    public int pop() {
        if (isEmpty())
            return Integer.MAX_VALUE;
        return 0;
    }

    //O(1)
    public boolean isEmpty() {
        return q.isEmpty();
    }


}

class QueueSt {

    private Stack st;

    //Memory O(n)
    public QueueSt() {
        this.st = new Stack();
    }

    //O(1)
    public void enQueue(int data) {
        st.push(data);
    }

    //O(n)
    public int poll() {
        if (st.isEmpty())
            return Integer.MAX_VALUE;
        return 0;
    }

    //O(1)
    public boolean isEmpty() {
        return st.isEmpty();
    }



}
