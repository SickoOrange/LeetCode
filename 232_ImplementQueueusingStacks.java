import java.util.Stack;

class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();

    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        int element = outStack.pop();
        while (!outStack.isEmpty()) {
            inStack.push(outStack.pop());
        }
        return element;
    }

    /** Get the front element. */
    public int peek() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        int element = outStack.peek();
        while (!outStack.isEmpty()) {
            inStack.push(outStack.pop());
        }
        return element;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty();
    }
}