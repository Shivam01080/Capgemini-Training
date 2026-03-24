package Capg;

class StockSpanLL {

	static class Node {
        int data;     
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;
        void addAtBeginning(int val) {
            Node n = new Node(val);
            n.next = head;
            head = n;
        }

        void addAtEnd(int val) {
            Node n = new Node(val);

            if (head == null) {
                head = n;
                return;
            }

            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = n;
        }

        void insertAtIndex(int index, int val) {
            if (index == 0) {
                addAtBeginning(val);
                return;
            }

            Node temp = head;
            for (int i = 0; i < index - 1 && temp != null; i++)
                temp = temp.next;

            if (temp == null)
                return;

            Node n = new Node(val);
            n.next = temp.next;
            temp.next = n;
        }

        int deleteAtBeginning() {
            if (head == null)
                return -1;

            int val = head.data;
            head = head.next;
            return val;
        }

        int deleteAtIndex(int index) {
            if (head == null)
                return -1;

            if (index == 0)
                return deleteAtBeginning();

            Node temp = head;
            for (int i = 0; i < index - 1 && temp.next != null; i++)
                temp = temp.next;

            if (temp.next == null)
                return -1;

            int val = temp.next.data;
            temp.next = temp.next.next;
            return val;
        } 

        int getFirst() {
            if (head == null)
                return -1;
            return head.data;
        }

        boolean isEmpty() {
            return head == null;
        }
    }

    static int[] stockSpan(int[] price) {

        int n = price.length;
        int[] span = new int[n];
        LinkedList list = new LinkedList();
        list.addAtBeginning(0);
        span[0] = 1;

        for (int i = 1; i < n; i++) {
            while (!list.isEmpty() &&
                    price[list.getFirst()] <= price[i]) {

                list.deleteAtBeginning();
            }

            if (list.isEmpty())
                span[i] = i + 1;
            else
                span[i] = i - list.getFirst();

            list.addAtBeginning(i);
        }

        return span;
    }

    public static void main(String[] args) {

        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        int[] ans = stockSpan(prices);

        for (int x : ans)
            System.out.print(x + " ");
    }
}