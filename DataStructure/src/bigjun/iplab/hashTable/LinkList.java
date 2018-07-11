package bigjun.iplab.hashTable;
/**
 * 带头结点的单链表类
 */
public class LinkList {
	
	public Node head;  			// 单链表的头结点
	
	// 单链表的构造函数
	public LinkList() {       	// 单链表的构造函数
		head = new Node();    	// 调用无参数构造函数，初始化一个空的结点作为头结点
	}
	
	// 判断带头结点的单链表是否为空
	public boolean isEmpty() {
		return head.next == null;
	}

	// 清空带头结点的单链表
	public void clear() {
		head.data = null;
		head.next = null;
	}

	// 求带头结点的单链表的长度
	public int getLength() {
		int length = 0;
		Node pNode = head.next;
		while (pNode != null) {
			length++;
			pNode = pNode.next;
		}
		return length;
	}

	// 读取带头结点的单链表中第i个结点
	public Object getElem(int i) throws Exception {
		Node pNode = head.next;
		int j = 0;
		while (pNode != null && j < i) {
			pNode = pNode.next;
			++j;
		}
		if (pNode == null || j>i) {
			throw new Exception("第" + i + "个元素不存在");
		}
		return pNode.data;
	}

	// 在带头结点的单链表中查找值为e的结点并返回结点下标
	public int indexof(Object e) {
		Node pNode = head.next;
		int j = 0;
		while (pNode!=null && !pNode.data.equals(e)) {
			pNode = pNode.next;
			++j;
		}
		if (pNode != null) {
			return j;
		} else {
			return -1;
		}
	}

	// 在带头结点的单链表中的第i个结点之前插入一个值为x的新结点
	public void insert(int i, Object x) throws Exception {
		Node pNode = head;
		int j = -1;
		while (pNode != null && j < i - 1) {
			pNode = pNode.next;
			++j;
		}
		if (j > i - 1 || pNode ==null)  
			throw new Exception("插入位置不合法");
		Node sNode = new Node(x);
		sNode.next = pNode.next;
		pNode.next = sNode;
	}

	// 删除带头结点的单链表的第i个结点
	public void delete(int i) throws Exception {
		Node pNode = head;
		int j = -1;
		while (pNode.next !=null && j<i - 1) {
			pNode = pNode.next;
			++j;
		}
		if (pNode.next == null ||  j > i - 1) {
			throw new Exception("删除位置不合法");
		}
		pNode.next = pNode.next.next;
	}

	// 遍历带头结点的单链表
	public void listTraverse() {
		Node node = head.next;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

}