public class MyLinkedList {
    private int size = 0;
    private Node head;
    private Node tail;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public void add(int element) {
        Node link = new Node(element);
        if (size == 0) {
            head = link;
            tail = link;
        } else {
            tail.next = link;
            tail = link;
        }
        size++;
    }

    public void addFirst(int value) {
        Node link = new Node(value);
        if (size == 0) {
            head = link;
            tail = link;
        } else {
            link.next = head;
            head = link;
        }
        size++;
    }

    public void set(int value, int index) {
        checkEx(index);
        if (index == 0) {
            addFirst(value);
        } else {
            Node element = head;
            for (int i = 0; i < index - 1; i++) {
                element = element.next;
            }
            Node a = new Node(value);
            a.next = element.next;
            element.next = a;
            size++;
        }
    }

    public void remove(int index) {
        checkEx(index);
        if (size == 1) {
            head = null;
            tail = null;
        } else if (index == 0) {
            head = head.next;
        } else {
            Node element = head;
            for (int i = 0; i < index - 1; i++) {
                element = element.next;
            }
            element.next = element.next.next;
            if (index == size - 1) tail = element;
        }
        size--;
    }

    public int get(int index) {
        checkEx(index);
        Node element = head;
        for (int i = 0; i < index; i++) {
            element = element.next;
        }
        return element.value;
    }

        public int size() {
        return size;
    }

    public void print() {
        Node element = head;
        for (int i = 0; i < size(); i++) {
            System.out.print(element.value + " ");
            element = element.next;
        }
        System.out.println();
    }

    public int[] toArray() {     //ПРОВЕРИТЬ
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = get(i);
        }
        return arr;
    }

    public Node findElement() {
        Node res = new Node(-1);
        Node posNums = null;
        Node element = head;
        int counter = 0;
        int maxCounter = 0;
        for (int i = 0; i < size; i++) {
            if (element.value > 0) {
                posNums = element;
                counter = 0;
            } else if (element.value == 0) {
                counter = 0;
                element = element.next;
                continue;
            }
            else {
                if (posNums != null) counter++;
            }

            if (counter >= maxCounter && counter != 0) {
                res = posNums;
                maxCounter = counter;
            }
            element = element.next;
        }
        return res;
    }

    private void checkEx(int index) {
        if (index < 0) throw new IndexOutOfBoundsException("Index can't be less than 0");
        if (index >= size) throw new IndexOutOfBoundsException("Index must be less than size");
    }
}
