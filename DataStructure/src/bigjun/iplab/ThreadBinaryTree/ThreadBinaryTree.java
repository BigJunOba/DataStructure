package bigjun.iplab.ThreadBinaryTree;
/**
 * 二叉树的线索链表实现
 * 包括中序遍历进行中序线索化与中序遍历二叉线索链表
 */
public class ThreadBinaryTree {
	
	private LinkBiThrNode head;		// 声明头结点
	
	// 创建一棵空树
	public ThreadBinaryTree() {
		this.head = null;
	}
	
	// //由顺序存储的完全二叉树建立一棵普通的链式存储的二叉树
	public ThreadBinaryTree(String seqBiTree) {
		this.head = createBiTreeNodeBySeqBiTree(seqBiTree, 0);
	}
	//由顺序存储的完全二叉树建立一棵连式存储的二叉树结点
	public LinkBiThrNode createBiTreeNodeBySeqBiTree(String seqBiTree, int index) {
		LinkBiThrNode root = null;									// 根结点
		if (index < seqBiTree.length()) {						// 位置不超过字符串长度
			root = new LinkBiThrNode(seqBiTree.charAt(index));		// 从下标为0开始，建立二叉链表根结点
			root.lchild = createBiTreeNodeBySeqBiTree(seqBiTree, 2 * index + 1);// 建立左子树
			root.rchild = createBiTreeNodeBySeqBiTree(seqBiTree, 2 * index + 2);// 建立右子树
		}
		return root; // 返回二叉链表根结点对象
	}
	
	private LinkBiThrNode pre = null;  // 全局变量，始终指向刚刚被访问过的结点
	// 将以p为根结点的普通链式二叉树，通过中序遍历进行中序线索化转化成线索二叉链表
	public void inThreading(LinkBiThrNode p) {
		if (p != null) {
			inThreading(p.lchild);		// 递归左子树线索化
			if (p.lchild == null) {		// 没有当前结点没有左孩子
				p.ltag = 1;				// 前驱线索
				p.lchild = pre;			// 左孩子指针指向刚刚访问过的结点，也就是前驱
			}
			/*****注意这里pre != null必须要放在前面，因为如果pre是空，但是先判断pre.rchild的话就会造成空指针异常***/
			if (pre != null&&pre.rchild == null) {	// 没有刚刚访问过的结点没有右孩子，因为此时还没有访问到p结点的后继
				pre.rtag = 1;			// 后继线索
				pre.rchild = p;			// 将刚刚访问过的结点的右孩子指向当前访问的结点
			}
			pre = p;
			inThreading(p.rchild);
		}
	}
	
	// 中序遍历线索二叉链表表示的二叉树T
	public void inThreadOrderTraverse(LinkBiThrNode T) {
		if (T != null) {
			while (T != null && T.ltag == 0) { 			// 找到左子树的最左下角，也就是中序遍历的第一个结点
				T = T.lchild;
			}
			do {
				System.out.print(T.data + " ");			// 先访问中序遍历的第一个结点，给T
				if (T.rtag == 1) {						// 如果T没有右孩子
					T = T.rchild;						// 将T的中序遍历的后继结点给T
				} else {
					T = T.rchild;						// T有右孩子的情况下
					while (T != null && T.ltag == 0) {	// T不是最后一个结点(G)并且T有左孩子
						T = T.lchild;					// 将T的左孩子给T
					}
				}
			} while (T != null);
		}
	}
	
	public static void main(String[] args) {
		String seqBiTree = "ABCDEFGHIJ";
		// 先根据完全二叉树的顺序存储结构建立一棵普通的二叉树的二叉链表存储结构
		ThreadBinaryTree binaryTree = new ThreadBinaryTree(seqBiTree);
		// 然后将普通的二叉链表存储结构通过中序遍历线索化
		binaryTree.inThreading(binaryTree.head);
		// 中序遍历线索化之后的线索二叉链表
		binaryTree.inThreadOrderTraverse(binaryTree.head);
	}
}
