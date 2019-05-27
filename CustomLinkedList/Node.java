public class Node<T>{
    T data;
    Node<T> tail;

    Node(T data){
        this.data = data;
        this.tail = null;
    }
}