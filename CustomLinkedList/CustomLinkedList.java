public class CustomLinkedList<T> implements ICustomLinkedList<T> {

    Node<T> head;

    public CustomLinkedList(){
        head = null;
    }

    public void addFirst(T element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
        } else {
            newNode.tail = head;
            head = newNode;
        }
    }

    public void addLast(T element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
        }

        Node tmp = head;
        while (tmp.tail != null) {
            tmp = tmp.tail;
        }
        tmp.tail = newNode;
    }

    public void addToIndex(int index, T element) {
        Node newNode = new Node(element);
        if (head == null) {
            return;
        } else {
            Node tmp = head;
            if (index == 0) {
                addFirst(element);
            } else {
                while (index > 1) {
                    if (tmp == null) {
                        return;
                    } else {
                        tmp = tmp.tail;
                        index--;
                    }
                }
                Node nextNode = tmp.tail;
                tmp.tail = newNode;
                tmp.tail.tail = nextNode;
            }
        }
    }

    public void removeFromIndex(int index) {
        Node tmp = head;

        if (index < 0)
            return;
        if (index == 0) {
            removeFirst();
        }

        while (index > 0) {
            if (tmp == null) {
                return;
            }
            tmp = tmp.tail;
            index--;
        }
        tmp.data = tmp.tail.data;
        tmp.tail = tmp.tail.tail;
    }

    public void removeFirst(){
        if (head == null) {
            return;
        } else {
            Node nextNode = head.tail;
            head = nextNode;
        }
    }

    public void removeLast(){
        if (head == null){
            return;
        } else {
            Node tmp = head;
            while (tmp.tail.tail != null) {
                tmp = tmp.tail;
            }
            tmp.tail = null;
        }
    }

    public void printAll(CustomLinkedList list) {
        Node currentNode = list.head;
        System.out.println("Linked List: ");
        while (currentNode != null) {
            System.out.println(currentNode.data + " ");
            currentNode = currentNode.tail;
        }
    }


    public static void main(String[] args) {
        CustomLinkedList<Integer> test = new CustomLinkedList();
        test.addFirst(1);
        test.addFirst(5);
        test.addFirst(2);
        test.addLast(10);
        test.addToIndex(3, 7);
        test.removeFromIndex(0);
        //test.removeFirst();
        test.printAll(test);
        test.removeLast();
        test.printAll(test);
    }
}
