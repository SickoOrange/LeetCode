import java.util.Stack;

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek() < x ? minStack.peek() : x);
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}