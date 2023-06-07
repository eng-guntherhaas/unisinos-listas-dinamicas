import java.util.NoSuchElementException;

public class LinkedStack<T> implements Stack<T> {
    private Node<T> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    public void push(T element) {
        Node<T> newNode = new Node<>(element, top);
        if (top != null) {
            top.setPrevious(newNode);
        }
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T data = top.getData();
        top = top.getNext();
        if (top != null) {
            top.setPrevious(null);
        }
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return top.getData();
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
