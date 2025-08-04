package stack;

public class ArrayStack {
    private int[] stack;
    private int top;
    private int capacity;

    public ArrayStack(int size) {
        stack = new int[size];
        capacity = size;
        top = -1;
    }

    // 스택에 데이터 추가 (push)
    public void push(int item) {
        if (isFull()) {
            throw new RuntimeException("Stack Overflow");
        }
        stack[++top] = item;
    }

    // 스택에서 데이터 제거 (pop)
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        return stack[top--];
    }

    // 스택의 top 요소 보기 (peek)
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return stack[top];
    }

    // 비어 있는지 확인
    public boolean isEmpty() {
        return top == -1;
    }

    // 가득 찼는지 확인
    public boolean isFull() {
        return top == capacity - 1;
    }

    // 현재 크기 반환
    public int size() {
        return top + 1;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); // 30
        System.out.println("Popped element: " + stack.pop()); // 30
        System.out.println("Stack size: " + stack.size()); // 2
    }
}
