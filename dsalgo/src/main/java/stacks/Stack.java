package stacks;

import java.util.EmptyStackException;

public class Stack<T> implements StackInterface<T>{

   private static class StackNode<T>{

      private T data;
      private StackNode<T> next;

      public StackNode(T data) {
         this.data = data;
         this.next = null;
      }
   }

   private StackNode<T> top;

   public T pop(){
      if(top == null){
         throw new EmptyStackException();
      }
      T item = top.data;
      top = top.next;
      return item;
   }


   public void push(T t){
      StackNode<T> newItem = new StackNode<>(t);
      newItem.next = top;
      top = newItem;
   }

   public T peek(){
      if(top == null){
         throw new EmptyStackException();
      }
      return top.data;
   }

   public boolean isEmpty(){
      return top == null;
   }

}
