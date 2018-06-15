package bigjun.iplab.linkList;

import java.util.Random;

public class LinkList implements IList{
	
	public Node head;  // 单链表的头指针，头指针head指向头结点，头结点的指针域指向首结点
	
	// 单链表的构造函数
	public LinkList() {       // 单链表的构造函数
		head = new Node();    // 调用无参数构造函数，初始化一个空的结点作为头结点
	}
	
	public boolean isListEmpty() {
		return head.next == null;
	}

	public void clearList() {
		head.data = null;
		head.next = null;
	}

	public int getListLength() {
		int length = 0;
		Node pNode = head.next;
		while (pNode != null) {
			length++;
			pNode = pNode.next;
		}
		return length;
	}

	public int getElem(int i) throws Exception {
		Node pNode = head.next;
		int j = 1;
		while (pNode != null && j < i) {
			pNode = pNode.next;
			++j;
		}
		if (pNode==null || j>i) {
			throw new Exception("第" + i + "个元素不存在");
		}
		return pNode.data;
	}

	public int locateElem(int e) {
		Node pNode = head.next;
		int j = 0;
		while (pNode!=null) {
			j++;
			if (pNode.data==e) 
				return j;
			pNode=pNode.next;
		}
		return 0;
	}

	public void listInsert(int i, int x) throws Exception {
		Node pNode = head;
		int j = 1;
		while (pNode != null && j < i) {
			pNode = pNode.next;
			++j;
		}
		if (j>i || pNode ==null)  
			throw new Exception("插入位置不合法");
		Node sNode = new Node(x);
		sNode.next = pNode.next;
		pNode.next = sNode;
	}

	public void listDelete(int i) throws Exception {
		Node pNode = head;
		int j = 1;
		while (pNode.next !=null && j<i) {
			pNode = pNode.next;
			++j;
		}
		if (pNode.next == null && j >i) {
			throw new Exception("删除位置不合法");
		}
		pNode.next = pNode.next.next;
	}

	public void listTraverse() {
		Node node = head.next;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	public void createListHead(int n) throws Exception {
		for (int i = 1; i <= n; i++) 
			listInsert(i, new Random().nextInt(100));
	}

	public void createListTail(int n) throws Exception {
		for (int i = 1; i <= n; i++) 
			listInsert(1, new Random().nextInt(100));
	}
	
	public static void main(String[] args) throws Exception {
		LinkList lList = new LinkList();
		System.out.println("初始化后单链表的长度为：" + lList.getListLength());
		
		for (int i = 1; i <= 5; i++) 
			lList.listInsert(1, i);
		System.out.print("在表头插入1~5后：");
		lList.listTraverse();
		System.out.println("在表头插入1~5后,此时单链表的长度为:" + lList.getListLength());
		
		lList.clearList();
		System.out.println("清空线性表后，此时单链表的长度为:" + lList.getListLength());
		
		for (int i = 1; i <= 10; i++) 
			lList.listInsert(i, i);
		System.out.print("在表尾插入1~10后：");
		lList.listTraverse();
		System.out.println("在表头插入1~10后,此时单链表的长度为:" + lList.getListLength());
		
		lList.listInsert(1, 0);
		System.out.print("在表头插入0后：");
		lList.listTraverse();
		System.out.println("在表头插入0后,此时单链表的长度为:" + lList.getListLength());
		
		System.out.println("第5个元素的值为：" + lList.getElem(5));
		System.out.println("第几个结点的值为4:" + lList.locateElem(4));
		
		lList.listTraverse();
		System.out.println("此时单链表的长度为:" + lList.getListLength());
		
		lList.listDelete(11);
		System.out.print("删除第11个元素后：");
		lList.listTraverse();
		
		lList.listDelete(5);
		System.out.print("删除第5个元素后：");
		lList.listTraverse();
		
		lList.clearList();
		System.out.print("清空单链表后：");
		lList.listTraverse();
		
		lList.createListTail(20);
		System.out.print("使用尾插法整体创建单链表后：");
		lList.listTraverse();
		
		lList.clearList();
		System.out.print("清空单链表后：");
		lList.listTraverse();
		
		lList.createListHead(20);
		System.out.print("使用头插法整体创建单链表后：");
		lList.listTraverse();
	}
}