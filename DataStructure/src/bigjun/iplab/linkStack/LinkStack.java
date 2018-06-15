package bigjun.iplab.linkStack;

public class LinkStack implements IListStack {
	
	public Node top;
	
	public LinkStack() {
		top = new Node();
	}

	public boolean isStackEmpty() {
		return top == null;
	}

	public void stackClear() {
		top = null;
	}

	public int stackLength() {
		Node pNode = top;     // 初始化，pNode指向栈顶元素
		int length = 0;       // length为计数器
		while (pNode != null) 
			pNode = pNode.next;
			++length;
		return length;
	}

	@Override
	public int getTopElem() throws Exception {
		if (!isStackEmpty()) {
			return top.data;
		} else {
			throw new Exception("栈为空，无法获取栈顶元素");
		}
	}

	public void stackPush(int e) {
		Node p = new Node(e);
		p.next = top;
		top = p;
	}

	public void stackPop() throws Exception {
		if (isStackEmpty()) 
			throw new Exception("栈为空，无法弹出栈顶元素");
		else {
			top = top.next;
		}
	}

	public void stackTraverse() {    // 从栈顶元素到栈底元素
		Node p = top;
		System.out.print("此时，链栈中的元素为: ");
		while (p.data != null) {// 这块有一个问题，就是由于Node类的构造函数的原因，第一个Node的data会为空，如果用p ！= null的话，就会输出一个null
			System.out.print(p.data + " ");
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
