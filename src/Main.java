public class Main {
    public static void main(String[] args){
        MyLinkedList example1 = new MyLinkedList();
        for (int i = 2; i < 11; i++) {
            example1.add(i);
        }
        example1.addFirst(1);
        System.out.println("Проверка добавления элементов");
        for (int i = 0; i < example1.size(); i++) {
            System.out.print(example1.get(i) + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("Проверка удаления последнего элемента");
        example1.remove(9);
        example1.print();
        System.out.println();

        System.out.println("Проверка удаления первого элемента");
        example1.add(10);
        example1.remove(0);
        example1.print();
        example1.addFirst(1);
        System.out.println();

        System.out.println("Проверка вставки и удаления по индексу");
        example1.remove(5);
        example1.print();
        example1.set(6, 5);
        example1.print();
        System.out.println();

        System.out.println("Проверка перевода в массив");
        int[] sup = example1.toArray();
        for (int i = 0; i < sup.length; i++) {
            System.out.print(sup[i] + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("Проверка выполнения поиска");
        sup = new int[]{-3, 4, -2, -5, -2, 0, -1, -1, -1, 2, 3, -1, -4, -5, -6, -7, 4, -1, -1, -1, 10, -1, -2, -3, -4, -5-
                1, -2, -5, -4};
        MyLinkedList example2 = toList(sup);
        MyLinkedList.Node test = example2.findElement();
        System.out.println(test.value);
    }

    private static MyLinkedList toList(int[] array) {
        MyLinkedList list = new MyLinkedList();
        for (int value : array) {
            list.add(value);
        }
        return list;
    }
}
