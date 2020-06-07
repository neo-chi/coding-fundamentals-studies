package stacks;

/**
 * Represents the entire stack
 * @param <T>
 */
public class Stack<T>
{
        /**
         * A single item in the stack
         * @param <T>
         */
        private static class StackNode<T>
        {
                private T data;
                private StackNode<T> next;

                public StackNode(T data)
                {
                        this.data = data;
                }
        }

        /** The item at the top of the stack */
        private StackNode<T> top;

        /**
         * Adds item to the top of the stack.
         * @param item
         */
        public void push(T item)
        {
                StackNode<T> t = new StackNode<T>(item);
                t.next = top;
                top = t;
        }

        /**
         * Adds all items to the stack, with the last item on top.
         * @param items
         */
        public void pushAll(T[] items)
        {
                for (T item : items) {
                        push(item);
                }
        }

        /**
         * Removes the item at the top of the stack.
         * @return top of stack
         */
        public T pop() throws EmptyStackException
        {
                if (top == null) {
                        throw new EmptyStackException();
                }
                T item = top.data;
                top = top.next;
                return item;
        }

        /**
         * Returns the item at the top of the stack.
         * @return
         */
        public T peek() throws EmptyStackException
        {
                if (top == null) throw new EmptyStackException();
                return top.data;
        }

        /**
         * Returns whether the stack is empty.
         * @return
         */
        public boolean isEmpty()
        {
                return top == null;
        }

        @Override
        public String toString()
        {
                return display(this.top);
        }

        public String display(StackNode<T> node) {
                String message = "";
                message += node.data + " ";
                if (node.next != null) {
                        message += display(node.next);
                }
                return message;
        }


}