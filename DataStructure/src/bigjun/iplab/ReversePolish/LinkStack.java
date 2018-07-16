package bigjun.iplab.ReversePolish;

public class LinkStack {
	
	private Node top;
	
	public boolean isEmpty() {
		return top == null;
	}

	public void Push(Object e) {
		Node p = new Node(e);
		p.next = top;
		top = p;
	}

	public Object Pop(){
		if (isEmpty()) {
			return null;
		}
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
	
}
