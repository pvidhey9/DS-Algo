## Stacks
* Stacks are exactly what they mean and what they sound like i.e., a stack of data just like a stack of cards
* The card here can be thought of as an Object(primitive or non primitive) whose collection you are storing in a stack
* Now lets say you can see your card only after removing all the cards on top of your desired card
* The time complexity inadvertently ends up at O(N) if you had to remove or look at the value of the Nth card
* A stack uses LIFO - Last In First Out
    * Whatever card you put on top of the deck will be the first thing that can be popped
    * This card is the last item you put in the stack
    * Imagine something more delicate rather than cards, and it would make even more sense

## Operations
* pop() - Remove the top card/item
* push() - Push a new card/item to the top of stack
* peek() - Just view what the top card/item is
* isEmpty() - Do you even have anymore cards/items left in your stack?

## Key Point
* Access to the Nth item is not constant time
* Addition and removal of elements is in constant time as there is no shifting involved like in arrays when you remove an element
* Stack can be implemented using a Linked List also, by restricting the addition and removal from only one side