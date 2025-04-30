import java.util.ArrayList;

public class ArrayListStack<E> implements StackInterface<E> {

    private final ArrayList<E> stack;

    public ArrayListStack() {
        stack = new ArrayList<>();
    }
    @Override
    public boolean empty() {
        return stack.isEmpty();
    }

    @Override
    public E peek() {
        if (empty()) throw new IllegalStateException("Stack is empty");
        return stack.getLast();
    }

    @Override
    public E pop() {
        if (empty()) throw new IllegalStateException("Stack is empty");
        return stack.removeLast();
    }

    @Override
    public E push(E obj) {
       stack.add(obj);
       return obj;
    }
}
