public class pra_10 {

    public static void main(String[] args) {
        IntNode first = new IntNode(1);
        addInt(first, 1);
        addInt(first, 2);
        addInt(first, 4);
        addInt(first, 1);
        addInt(first, 16);
        addInt(first, 32);
        printInt(first);
        IntNode second = splitListToEvenAndOdd(first);
        printInt(first);
        printInt(second);

        StringNode Strings = new StringNode("Barak Sharabi");
        addString(Strings, "Shay Gali");
        addString(Strings, "Shir Segev");
        addString(Strings, "Shay Zaltzman");
        addString(Strings, "Arik Na");
        addString(Strings, "Maor Barzilay");
        addString(Strings, "Aviel cohen");
        printString(Strings);
        System.out.println(longestWord(Strings));
        int number[] = {1234, 123, 352, 365, 231, 9834, 2619, 4567, 5, 0};
        for (int i = 0; i < number.length; i++) {

            System.out.println(number[i] +" "+checkNumber(number[i]));
        }

    }

    //Solution by Shay Gali
    public static IntNode splitListToEvenAndOdd(IntNode first) {
        if(first==null)
            return null;
        //1,1,1,1,1,1,2,46,7,8,9
        IntNode returnNode = null, temp = first;
        while (temp.next != null && returnNode == null) {
            if (temp.next.data % 2 != first.data % 2) {
                returnNode = new IntNode(temp.next.data);
                temp.next = temp.next.next;
            } else
                temp = temp.next;
        }
        IntNode tempForSecond = returnNode;
        //
        //temp -> 1 -> 1 -> 1 -> 1 -> 1 -> 1 -> 46 -> 7 -> 8 -> 9
       //returnNode-> 2->null
        while (temp.next != null) {
            if (temp.next.data % 2 != first.data % 2) {
                tempForSecond.next = new IntNode(temp.next.data);
                tempForSecond = tempForSecond.next;

                temp.next = temp.next.next;
            } else
                temp = temp.next;
        }
        //temp -> 1 -> 1 -> 1 -> 1 -> 1 -> 1 ->  7  -> 9
        //returnNode-> 2-> 46 -> 8 -> null
        return returnNode;
    }

    public static String longestWord(StringNode head) {
        if (head.next == null)
            return head.data;
        String nameLongest = longestWord(head.next);
        if (head.data.length() > nameLongest.length())
            return head.data;
        return nameLongest;
    }

    public static boolean checkNumber(int number) {
        if (number == 0)
            return true;
        int temp = number / 10;
        if (temp % 10 < number % 10)
            return checkNumber(temp);
        return false;
    }

    public static void addInt(IntNode list, int key) {

        IntNode temp = list;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new IntNode(key);
    }

    public static void addString(StringNode list, String str) {

        StringNode temp = list;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new StringNode(str);
    }

    public static void printInt(IntNode list) {
        IntNode temp = list;
        while (temp != null) {
            System.out.printf(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.printf("null\n");
    }

    public static void printString(StringNode list) {
        StringNode temp = list;
        while (temp != null) {
            System.out.printf(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.printf("null\n");
    }

}

class IntNode {
    int data;
    IntNode next;

    public IntNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class StringNode {
    String data;
    StringNode next;

    public StringNode(String data) {
        this.data = data;
        this.next = null;
    }
}