package bigjun.iplab.binarySortTree;
/**
 * 二叉树的结点类
 */
public class BiTreeNode {
	
	public int data;                 // 结点的数据域
	public BiTreeNode lchild, rchild;   // 左孩子和右孩子域
	
	// 构造方法1:构造一个空结点
	public BiTreeNode() {
	}
	
	// 构造方法2:构造一个只有数据域，左、右孩子域都为空的结点
	public BiTreeNode(int data) {
		this(data, null, null);
	}
	
	// 构造方法3:构造一棵数据域和左、右孩子域都不为空的二叉树
	public BiTreeNode(int data, BiTreeNode lchild, BiTreeNode rchild) {
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
	}

}
