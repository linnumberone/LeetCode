public class MyStack {
    
    Queue<Integer> queue = new LinkedList<Integer>();
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        Queue<Integer> temp = new LinkedList<Integer>();
        while(!queue.isEmpty()) {
            temp.offer(queue.poll());
        }
        queue.offer(x);
        while(!temp.isEmpty()) {
            queue.offer(temp.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll(); 
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
