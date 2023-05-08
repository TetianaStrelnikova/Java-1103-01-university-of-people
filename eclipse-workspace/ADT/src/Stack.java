/**
 * A stack implementation for the array[].
 */
class Stack {

  // store elements of stack
  private int arr[];
  // represent top of stack
  private int top;
  // total capacity of the stack
  private int capacity;

  /**
   * Constructor creating a stack with the given size.
   * @param size the size of the stack
   */
  Stack(int size) {
    // create the array
    // initialize the stack variables
    arr = new int[size];
    capacity = size;
    top = -1;
  }

  /**
   * Pushes the given element to the top of the stack.
   * @param x the element to be pushed
   */
  public void push(int x) {
   // Check if the stack is full
   if (isFull()) {
       System.out.println("Stack OverFlow");
       // Return to the caller without adding the element
       return;
   }

    // insert element on top of stack
    System.out.println("Inserting " + x);
    arr[++top] = x;
  }

  /**
   * Pops the top element from the stack.
   * @return the popped element
   */
  public int pop() {

    // if stack is empty
    // no element to pop
    if (isEmpty()) {
      System.out.println("STACK EMPTY");
      // terminates the program
      return capacity;
    }

    // pop element from top of stack
    return arr[top--];
  }

  /**
   * Returns the size of the stack.
   * @return the size of the stack
   */
  public int getSize() {
    return top + 1;
  }

  /**
   * Checks if the stack is empty.
   * @return true if the stack is empty (top == -1) is true, false otherwise
   */
  public Boolean isEmpty() {
    return top == -1;
  }

  /**
   * Checks if the stack is full.
   * @return true if the stack is full, false otherwise
   */
  public Boolean isFull() {
    return top == capacity - 1;
  }

  /**
   * Displays all the elements of the stack.
   */
  public void printStack() {
    for (int i = 0; i <= top; i++) {
      System.out.print(arr[i] + ", ");
    }
  }

  /**
   * Main method to test the stack implementation.
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Stack stack = new Stack(5);

    stack.push(1);
    stack.push(2);
    stack.push(3);

    System.out.print("Stack: ");
    stack.printStack();

    // remove element from stack
    stack.pop();
    System.out.println("\nAfter popping out");
    stack.printStack();

  }
}