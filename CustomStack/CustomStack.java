public class CustomStack<T> implements IStack<T>{
    CustomLinkedList<T> customLinkedList = new CustomLinkedList<>();

    public void push(T element){
        customLinkedList.addFirst(element);
    }

    public void pop(){
        customLinkedList.removeFirst();
    }

    public T peek(){
        if (customLinkedList == null){
            return null;
        } else {
            return customLinkedList.head.data;
        }
    }

    public static void main(String[] args){
        CustomStack<Integer> test = new CustomStack<>();
        try {
            test.peek();
        } catch (NullPointerException e) {
            System.out.println("There is no item into Stack");
        }

    }
}
