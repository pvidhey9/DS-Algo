package stacks;

public interface StackInterface<T> {

   public void push(T t);

   public T pop();

   public boolean isEmpty();

   public T peek();
}
