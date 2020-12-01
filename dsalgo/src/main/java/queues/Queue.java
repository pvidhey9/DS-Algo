package queues;

import java.util.NoSuchElementException;

public class Queue<T> {

   class QueueNode<T> {

      private T data;
      private QueueNode<T> next;

      public QueueNode(T data) {
         this.data = data;
         next = null;
      }
   }

   private QueueNode<T> first;
   private QueueNode<T> last;

   public void add(T t){
      QueueNode<T> newNode = new QueueNode<>(t);
      if(last != null){
         last.next = newNode;
      }
      last = newNode;
      if(first == null){
         first = last;
      }
   }

   public T remove(){
      if(first == null){
         throw new NoSuchElementException();
      }
      T data = first.data;
      first = first.next;
      if(first == null){
         last = null;
      }
      return data;


   }

   public boolean isEmpty(){
      return first == null;
   }

   public T peek(){
      if(first == null){
         throw new NoSuchElementException();
      }
      return first.data;
   }


}
