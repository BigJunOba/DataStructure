package bigjun.iplab.sequenceStack;

public class SequenceStack implements StackINF{
	
	private final static int MAXSIZE = 20;
	private int[] stackElem;
	private int top;             // 将top设置为指向栈顶元素的存储位置即数组下标，则空栈时，top==-1
	
	public SequenceStack() {
		top = -1;
		stackElem = new int[MAXSIZE];
	}

	public boolean isStackEmpty() {
		if (top == -1) 
			return true;
		else
			return false;
	}

	public void stackClear() {
		top = -1;
	}

	public int stackLength() {
		return top + 1 ;
	}

	public int getTopElem() throws Exception{
		if (top == -1) 
			throw new Exception("栈为空，无法获取栈顶元素");
		else {
			return stackElem[top];
		}
	}

	public void stackPush(int e) throws Exception {
		if (top == MAXSIZE -1) 
			throw new Exception("栈为满，无法在栈顶插入元素e");
		else 
			top++;
			stackElem[top] = e;
	}

	public void stackPop() throws Exception {
		if (top == -1) 
			throw new Exception("栈为空，无法删除栈顶元素");
		else {
			top--;
		}
	}

	public void stackTraverse() {
		System.out.print("此时，栈中的元素为: ");
		int i = 0;
		while (i <= top) {
			System.out.print(stackElem[i++] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		SequenceStack seqStack = new SequenceStack();
		
		for (int j = 1; j <= 10; j++) 
			seqStack.stackPush(j);
		seqStack.stackTraverse();
		
		seqStack.stackPop();
		seqStack.stackTraverse();
		System.out.println("栈顶元素为: " + seqStack.getTopElem());
		System.out.println("栈的长度为: " + seqStack.stackLength());
		
		System.out.println("栈是否为空: " + seqStack.isStackEmpty());
		seqStack.stackClear();
		System.out.println("栈是否为空: " + seqStack.isStackEmpty());
	}

}
