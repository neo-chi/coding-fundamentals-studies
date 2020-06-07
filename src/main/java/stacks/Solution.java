package stacks;

public class Solution
{
        public static void main(String[] args)
        {
                Integer[] items = {1, 2, 3, 4, 5};
                Stack<Integer> s1 = new Stack<Integer>();
                s1.pushAll(items); // items will be in reverse order
                sortDescending_V1(s1);

                Stack<Integer> s2 = new Stack<Integer>();
                s2.pushAll(items);
                sortDescendingSolution(s2);
        }

        /**
        * Problem 3.5
        * Sort a stack with the minimum item on top using only 2 stacks.
        * Do not use any other data structures. Only a temporary variable may be
        * used.
        * Sorting Algorithm
        * Rule 1. initialize by moving s.top to t
        * Rule 2. if a.peek() >= b.peek() b.push(a.pop())
        * Rule 3. if a.peek() < b.peek()
        *         move a -> t
        *         move b -> a while !b.isEmpty() and t < b.peek()
        * Rule 4. if (a.isEmpty()) while(!b.isEmpty() a.push(b.pop))
        * @param items
        */
        public static void sortDescending_V1(Stack<Integer> a)
        {
                int numTransitions = 0;
                Stack<Integer> b = new Stack<Integer>();
                Integer t = null;
                System.out.println(a);

                try {
                        // initialize sorting, move item from a to b
                        b.push(a.pop());
                        numTransitions++;
                        System.out.println(b.peek() + " -> b");

                        // Move stack items from a to b where b is sorted with
                        // max on top, min on bottom.
                        while (!a.isEmpty()) {
                                if (a.peek() >= b.peek()) {
                                        b.push(a.pop());
                                        numTransitions++;
                                        System.out.println(b.peek() + " -> b");

                                // Move item from stack a below greater items in
                                // stack b
                                } else if (a.peek() < b.peek()) {
                                        t = a.pop();
                                        numTransitions++;
                                        System.out.println(t + " -> t");
                                        while (!b.isEmpty() && t < b.peek()) {
                                                a.push(b.pop());
                                                numTransitions++;
                                                System.out.println("a <- " + a.peek());
                                        }
                                        b.push(t);
                                        numTransitions++;
                                        System.out.println(b.peek() + " -> b");
                                        t = null;
                                }
                        }

                        // Stack b is sorted from max on top to min on bottom.
                        // Pushing all items to stack a will reverse the order to
                        // min on top, max on bottom.
                        while (!b.isEmpty()) {
                                a.push(b.pop());
                                numTransitions++;
                                System.out.println("a <- " + a.peek());
                        }

                        // Display results to the user.
                        if (b.isEmpty()) {
                                System.out.println("------------------------------------RESULTS-------------------------------------");
                                System.out.println(a);
                                System.out.println("Number of Transitions: " + numTransitions);
                                System.out.println("------------------------------------RESULTS-------------------------------------");
                        }

                } catch (Exception e) {
                        System.out.println(e);
                }
        }

        public static void sortDescendingSolution(Stack<Integer> s) {
                int numTransistions = 0;
                Stack<Integer> r = new Stack<Integer>();
                while (!s.isEmpty()) {
                        /* Insert each element in s in sorted order into r. */
                        try {
                                int tmp = s.pop();
                                numTransistions++;
                                while (!r.isEmpty() && r.peek() > tmp) {
                                        s.push(r.pop());
                                        numTransistions++;
                                }
                                r.push(tmp);
                                numTransistions++;
                        } catch (EmptyStackException e) {
                                System.out.println("Stack is empty!");
                        }
                }

                /* Copy the elements from r back into s. */
                while (!r.isEmpty()) {
                        try {
                                s.push(r.pop());
                                numTransistions++;
                        } catch (Exception e) {
                                System.out.println("Stack is empty!");
                        }
                }

                /* Display results */
                System.out.println(s);
                System.out.println("number of transitions: " + numTransistions);
        }

}