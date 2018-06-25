package bigjun.iplab.ThreadBinaryTree;
/**
 * 二叉树的线索存储结构
 */
public class LinkBiThrNode {
	
	public Object data;                    // 结点的数据域
	public LinkBiThrNode lchild, rchild;   // 左孩子和右孩子域
	public short ltag, rtag;
	
	// 构造一个线索二叉链表结点
	public LinkBiThrNode(Object data) {
		this.data = data;
		this.lchild = null;
		this.rchild = null;
		this.ltag = 0;
		this.rtag = 0;
	}

}
