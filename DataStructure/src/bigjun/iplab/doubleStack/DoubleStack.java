package bigjun.iplab.doubleStack;

public class DoubleStack implements DoubleStackINF{
	
	private final static int MAXSIZE = 20;
	private int[] stackElem;
	private int top1;               // 将top1设置为指向栈1栈顶元素的存储位置即数组下标
	private int top2;				// 将top2设置为指向栈2栈顶元素的存储位置即数组下标
	
	public DoubleStack() {
		top1 = -1;
		top2 = MAXSIZE;
		stackElem = new int[MAXSIZE];
	}

	public boolean isStackEmpty() {
		if (top1 == -1 && top2 == MAXSIZE) 
			return true;
		else
			return false;
	}

	public void stackClear() {
		top1 = -1;
		top2 = MAXSIZE;
	}

	public int stackLength() {
		return (top1 + 1) + (MAXSIZE - top2);
	}

	public int getTop1Elem() throws Exception{
			if (top1 == -1) 
				throw new Exception("栈1为空，无法获取栈顶元素");
		return stackElem[top1];
	}
	
	public int getTop2Elem() throws Exception{
			if (top2 == MAXSIZE) 
				throw new Exception("栈2为空，无法获取栈顶元素");
		return stackElem[top2];
	}

	public void stackPush(int stackNumber, int e) throws Exception {
		if (top1 + 1 == top2) 
			throw new Exception("栈为满，无法在栈顶插入元素e");
		if (stackNumber == 1) {
			top1++;
			stackElem[top1] = e;
		}else if (stackNumber == 2) {
			top2--;
			stackElem[top2] = e;
		}
	}

	public void stackPop(int stackNumber) throws Exception {
		if (stackNumber == 1) {
			if (top1 == -1) 
				throw new Exception("栈1为空，无法获取栈顶元素");
			top1--;
		}else if (stackNumber == 2) {
			if (top2 == MAXSIZE) 
				throw new Exception("栈2为空，无法获取栈顶元素");
			top2++;
		}
	}

	public void stackTraverse() {
		System.out.print("此时，栈中的元素为: ");
		int i = 0;
		while (i <= top1) {
			System.out.print(stackElem[i++] + " ");
		}
		i = top2;
		while (i < MAXSIZE) {
			System.out.print(stackElem[i++] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		DoubleStack seqStack = new DoubleStack();
		
		for (int j = 1; j <= 5; j++) 
			seqStack.stackPush(1,j);
		for (int i = MAXSIZE; i >= MAXSIZE -2 ; i--) {
			seqStack.stackPush(2, i);
		}
		seqStack.stackTraverse();
		System.out.println("栈的长度为: " + seqStack.stackLength());
		
		seqStack.stackPop(2);
		seqStack.stackTraverse();
		System.out.println("栈1的栈顶元素为: " + seqStack.getTop1Elem());
		System.out.println("栈2的栈顶元素为: " + seqStack.getTop2Elem());
		System.out.println("栈的长度为: " + seqStack.stackLength());
		
		for (int i = 6; i <= MAXSIZE-2; i++) {
			seqStack.stackPush(1,i);
		}
		seqStack.stackTraverse();
		System.out.println("栈1的栈顶元素为: " + seqStack.getTop1Elem());
		System.out.println("栈2的栈顶元素为: " + seqStack.getTop2Elem());
		System.out.println("栈顶元素为: " + seqStack.getTop2Elem());
		System.out.println("栈的长度为: " + seqStack.stackLength());
		
		System.out.println("栈是否为空: " + seqStack.isStackEmpty());
		seqStack.stackClear();
		System.out.println("栈是否为空: " + seqStack.isStackEmpty());
		
		
	}

}
