package bigjun.iplab.linkStack;

public class Node {
	
	public Integer data;   // 存放结点的数据元素的数据域(int类型不能设置null，而Integer类型可以)
	public Node next;      // 存放后继元素的引用
	
	// 可实现初始化一个空的结点
	public Node() {
		this(null, null);
	}
	
	// 可实现构造一个数据域值为指定参数值，而指针域为空的结点
	public Node(Integer data) {
		this(data, null);
	}
	
	// 可实现构造一个数据域和指针域值都为指定参数的结点
	public Node(Integer data, Node next) {
		this.data = data;
		this.next = next;
	}
	
}
