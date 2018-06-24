package bigjun.iplab.sequenceBiTree;
/**
 * 二叉树的顺序存储结构通常用来对完全二叉树进行存储
 */
public interface SequenceBiTreeINF {
	// 判断完全二叉树是否为空
	public boolean isBiTreeEmpty();
	// 求完全二叉树的深度
	public int getBiTreeDepth();
	// 求完全二叉树的根结点数据元素
	public Object getBiTreeRoot() throws Exception;
	// 求完全二叉树的某个数据e的双亲
	public Object getMyParent(Object e) throws Exception;
	// 求完全二叉树的某个数据e的左孩子
	public Object getMyLeftChild(Object e) throws Exception;
	// 求完全二叉树的某个数据e的右孩子
	public Object getMyRightChild(Object e) throws Exception;
	// 求完全二叉树的某个数据e的左兄弟
	public Object getMyLeftSibling(Object e) throws Exception;
	// 求完全二叉树的某个数据e的右兄弟
	public Object getMyRightSibling(Object e) throws Exception;
	// 求完全二叉树的第levelNum层的数据元素并打印出来
	public void printByLevel(int levelNum) throws Exception;
	// 完全二叉树的前序遍历
	public void preOrderTraverse();
	// 完全二叉树的中序遍历
	public void inOrderTraverse();
	// 完全二叉树的后序遍历
	public void postOrderTraverse();
	// 完全二叉树的层序遍历
	public void levelOrderTraverse();
}
