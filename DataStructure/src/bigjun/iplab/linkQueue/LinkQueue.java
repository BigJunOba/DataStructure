package bigjun.iplab.linkQueue;

import bigjun.iplab.linkStack.Node;

public class LinkQueue implements LinkQueueINF{
	
	private Node front;     // 队头指针指向头结点
	private Node rear;      // 队尾指针指向终端结点
	
	public LinkQueue() {
		front = rear = null;
	}

	public boolean isqueueEmpty() {
		return front == rear;
	}

	public void queueClear() {
		front = rear = null;
	}

	public int queueLength() {
		int length = 0;
		Node p = front;
		while (p != null) {
			p = p.next;
			++ length;
		}
		return length;
	}

	public Object getHeadElem() throws Exception {
		if (front == null) 
			throw new Exception("链队列为空，无法获取队头元素");
		return front.data;
	}

	public void queueEnter(Object e){
		Node p = new Node(e);
		if (front != null) {
			rear.next = p;
			rear = p;
		} else {
			front = rear = p;
		}
	}

	public Object queuePoll() throws Exception {
		if (front != null) {		// 如果队列不为空
			Node p = front;			// p指向被删除的队头结点
			front = front.next;		// 队头结点出队列
			if (p == rear) {		// 如果被删除的结点是队尾最后一个结点
				rear = null;		// 令队尾结点为空
			}
			return p.data;			// 返回 被删除的结点的数据域
		} else {
			throw new Exception("链队列为空，无法删除队头元素并返回");
		}
	}

	public void queueTraverse() {
		Node p = front;
		System.out.print("此时，链队列中的元素为: ");
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		LinkQueue lQueue = new LinkQueue();
		lQueue.queueEnter(-5);
		lQueue.queueTraverse();
		System.out.println("此时，链队列的长度为: " + lQueue.queueLength());
		
		lQueue.queueEnter(5);
		lQueue.queueEnter(10);
		lQueue.queueTraverse();
		System.out.println("此时，链队列的长度为: " + lQueue.queueLength());
		System.out.println("此时，链队列的头结点元素为: " + lQueue.getHeadElem());
		
		lQueue.queuePoll();
		lQueue.queueTraverse();
		System.out.println("此时，链队列的长度为: " + lQueue.queueLength());
		System.out.println("此时，链队列的头结点元素为: " + lQueue.getHeadElem());
		
		lQueue.queueClear();
		System.out.println("此时，链队列是否为空: " + lQueue.isqueueEmpty());
		
	}
	

}
