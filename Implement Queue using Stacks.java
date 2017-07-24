public class MyQueue {

    Deque<Integer> pushStack = new LinkedList<Integer>(); // stack used for pushing new elements
    Deque<Integer> popStack = new LinkedList<Integer>(); // stack used for pushing new elements
    
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        // while(!popStack.isEmpty()) {
        //     pushStack.push(popStack.pop());
        // }
        pushStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(popStack.isEmpty()) {
            while(!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(popStack.isEmpty()) {
            while(!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */