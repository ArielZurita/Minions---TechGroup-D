public interface IQueue<T> {
    void offer(T element);
    T peek();
    void poll();
}
