public class CustomQueue<T> implements IQueue<T>{

    CustomLinkedList<T> customLinkedList;

    public CustomQueue(){
        customLinkedList = new CustomLinkedList<>();
    }

    public void offer(T element) {
        if (customLinkedList == null){
            customLinkedList.addFirst(element);
        } else {
            customLinkedList.addLast(element);
        }
    }

    public void poll() {
        if (customLinkedList == null){
            return;
        } else {
            customLinkedList.removeFirst();
        }
    }

    public T peek() {
        if (customLinkedList == null){
            return null;
        } else {
            return customLinkedList.head.data;
        }
    }

    public static void main(String[] args){
        CustomQueue<String> customQueue = new CustomQueue<>();
        customQueue.offer("Hello");
        try {
            System.out.println(customQueue.peek());
        } catch (NullPointerException e) {
            System.out.println("Queue is empty");
        }
    }
}
