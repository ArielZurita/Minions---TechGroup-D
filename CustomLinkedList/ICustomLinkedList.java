public interface ICustomLinkedList<T> {
    void addFirst(T element);
    void addLast(T element);
    void addToIndex(int index, T element);
    void removeFromIndex(int index);
    void removeFirst();
    void removeLast();
}
