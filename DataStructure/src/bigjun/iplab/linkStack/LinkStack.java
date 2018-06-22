package bigjun.iplab.linkStack;

public class LinkStack implements IListStack {
	
	private Node top;
	
	public boolean isStackEmpty() {
		return top == null;
	}

	public void stackClear() {
		top = null;
	}

	public int stackLength() {
		Node pNode = top;     // 初始化，pNode指向栈顶元素
		int length = 0;       // length为计数器
		while (pNode != null) {
			pNode = pNode.next;
			++length;
		}
		return length;
	}

	public Object getTopElem() throws Exception {
		if (!isStackEmpty()) {
			return top.data;
		} else {
			throw new Exception("栈为空，无法获取栈顶元素");
		}
	}

	public void stackPush(Object e) {
		Node p = new Node(e);
		p.next = top;
		top = p;
	}

	public Object stackPop() throws Exception {
		if (isStackEmpty()) 
			throw new Exception("栈为空，无法弹出栈顶元素");
		else {
			Node p = top;
			top = top.next;
			return p.data;
		}
	}

	public void stackTraverse() {    // 从栈顶元素到栈底元素
		Node p = top;
		System.out.print("此时，链栈中的元素为: ");
		while (p != null) {
			System.out.print(p.data.toString() + " ");
			p = p.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		LinkStack lStack = new LinkStack();
		for (int j = 1; j <= 10; j++) {
			lStack.stackPush(j);
		}
		lStack.stackTraverse();
		
		System.out.println("栈顶元素为: " + lStack.getTopElem());
		System.out.println("栈是否为空: " + lStack.isStackEmpty());
		
		lStack.stackPop();
		lStack.stackTraverse();
		System.out.println("栈顶元素为: " + lStack.getTopElem());
		
		lStack.stackClear();
		System.out.println("栈是否为空: " + lStack.isStackEmpty());
	}

}
