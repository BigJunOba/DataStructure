package bigjun.iplab.linkBiTree;
/**
 * 二叉树的结点类
 */
public class BiTreeNode {
	
	public Object data;                 // 结点的数据域
	public BiTreeNode lchild, rchild;   // 左孩子和右孩子域
	
	// 构造方法1:构造一个空结点
	public BiTreeNode() {
	}
	
	// 构造方法2:构造一个没有左右孩子的结点
	public BiTreeNode(Object data) {
		this(data, null, null);
	}
	
	// 构造方法3:构造一棵数据域和左、右孩子域都不为空的二叉树
	public BiTreeNode(Object data, BiTreeNode lchild, BiTreeNode rchild) {
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
	}

}
