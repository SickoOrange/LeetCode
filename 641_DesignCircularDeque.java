//double stack solution 
class MyCircularDeque {

    /** Initialize your data structure here. Set the size of the deque to be k. */

    Stack<Integer> stack = new Stack<>();
    int maxSize = 0;

    public MyCircularDeque(int k) {
        this.maxSize = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertFront(int value) {
        Stack<Integer> supportStack = new Stack<>();

        if (stack.size() < maxSize) {
            while (!stack.isEmpty()) {
                supportStack.push(stack.pop());
            }
            supportStack.push(value);
            while (!supportStack.isEmpty()) {
                stack.push(supportStack.pop());
            }
            return true;
        }

        return false;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertLast(int value) {
        if (stack.size() < maxSize) {
            stack.push(value);
            return true;
        }

        return false;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteFront() {
        Stack<Integer> supportStack = new Stack<>();
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                supportStack.push(stack.pop());
            }
            supportStack.pop();
            while (!supportStack.isEmpty()) {
                stack.push(supportStack.pop());
            }
            return true;
        }

        return false;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteLast() {
        if (!stack.isEmpty()) {
            stack.pop();
            return true;
        }
        return false;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        Stack<Integer> supportStack = new Stack<>();
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                supportStack.push(stack.pop());
            }
            int value = supportStack.peek();
            while (!supportStack.isEmpty()) {
                stack.push(supportStack.pop());
            }
            return value;
        }

        return -1;

    }

    /** Get the last item from the deque. */
    public int getRear() {

        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;

    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return stack.size() == maxSize;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k); boolean param_1 =
 * obj.insertFront(value); boolean param_2 = obj.insertLast(value); boolean
 * param_3 = obj.deleteFront(); boolean param_4 = obj.deleteLast(); int param_5
 * = obj.getFront(); int param_6 = obj.getRear(); boolean param_7 =
 * obj.isEmpty(); boolean param_8 = obj.isFull();
 */
