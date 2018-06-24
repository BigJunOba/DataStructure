package bigjun.iplab.linkBiTree;

public interface LinkBiTreeINF {
	
	// 前序递归遍历算法
	public void preOrderTraverse(BiTreeNode T);
	// 中序递归遍历算法
	public void inOrderTraverse(BiTreeNode T);
	// 后序递归遍历算法
	public void postOrderTraverse(BiTreeNode T);
	
	// 前序非递归遍历算法
	public void preOrderTraverse() throws Exception;
	// 后序非递归遍历算法
	public void inOrderTraverse() throws Exception;
	// 中序非递归遍历算法
	public void postOrderTraverse() throws Exception;
	// 层序非递归遍历算法
	public void levelOrderTraverse() throws Exception;
	
	// (基于前序递归遍历算法) 在二叉树中查找值为x的结点，若找到，则返回该结点;否则，返回null
	public BiTreeNode searchBTNode(BiTreeNode T, Object x);
	// (基于前序递归遍历算法) 统计二叉树中结点的个数并返回
	public int countBTNode(BiTreeNode T);
	// (基于后序递归遍历算法) 求二叉树的深度
	public int getBTDepth(BiTreeNode T);
	// (基于前序递归遍历算法) 判断两棵二叉树是否相等，若相等，返回true；否则，返回false
	public boolean isEqual(BiTreeNode T1, BiTreeNode T2);
	
	// 根据二叉链表的定义即基本的构造方法创建一棵二叉树
	public LinkBiTree createLinkBiTreeByDefinition();
	// 根据前序遍历序列和中序遍历序列建立一棵二叉树
	public LinkBiTree createBiTreeByPreAndInOrder(String preOrder, String inOrder, int preIndex, int inIndex, int count);
	// 根据标明空子树的先序遍历序列建立一棵二叉树
	public LinkBiTree creataBiTreeByPreHasNullSign(String preStr);
	// 根据完全二叉树的顺序存储结构建立一棵链式存储的二叉树
	public LinkBiTree createBiTreeBySeqBiTree(String seqBiTree, int index);
	
}
