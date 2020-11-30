package stacks;

import java.util.EmptyStackException;

public class StackArray<T> implements StackInterface<T> {

   private T[] array;
   private int top;

   public StackArray(int size) {
      this.top = -1;
      this.array = (T[]) new Object[size];
   }

   @Override
   public void push(T t) {
      if(array.length > top){
         throw new StackOverflowError();
      }
      array[++top] = t;
   }

   @Override
   public T pop() {
      if(top == -1){
         throw new EmptyStackException();
      }
      return array[top--];
   }

   @Override
   public boolean isEmpty() {
      return top == -1;
   }

   @Override
   public T peek() {
      if(top == -1){
         throw new EmptyStackException();
      }
      return array[top];
   }

   public static void main(String[] args) {
      StackArray<Integer> integerStackArray = new StackArray<>(10);
      integerStackArray.push(5);
      integerStackArray.push(6);
      integerStackArray.pop();
      integerStackArray.isEmpty();
   }
}
