package bigjun.iplab.binarySortTree;

public class BinarySortTree {

	private BiTreeNode root = null;
		
	public static void inOrderTraverse(BiTreeNode T) {
		if (T != null) {
			inOrderTraverse(T.lchild);
			System.out.print(T.data + " ");
			inOrderTraverse(T.rchild);
		}
	}
	
	// 在二叉排序树p中查找key，若查找成功返回true，查找不成功返回false
	// 返回false有两种情况:1.二叉排序树p为空 2.二叉排序树p不为空但是没有查找到key
	public boolean searchBST(int key) {
		BiTreeNode current = root;
		while (current != null) {
			if (key == current.data) {
				return true;
			} else if (key < current.data) {
				current = current.lchild;
			} else {
				current = current.rchild;
			}
		}
		return false;
	}

	
	public void insertBST(int key) {
		BiTreeNode p = root;		// 二叉树的根结点
		BiTreeNode prev = null;		// 二叉树的双亲结点
		while (p!=null) {			// 新插入的结点一定是作为叶子结点添加到树中的
			prev = p;				// 记录孩子为空的结点作为新插入结点的双亲
			if (key < p.data) {
				p = p.lchild;
			} else if (key > p.data) {
				p = p.rchild;
			} else {
				return ;
			}
		}
		if (root == null) {
			root = new BiTreeNode(key);
		} else if (key < prev.data) {	// 将新插入的结点作为叶子结点插入到树中
			prev.lchild = new BiTreeNode(key);
		} else {
			prev.rchild = new BiTreeNode(key);
		}
	}
	
	public boolean deleteBST(BiTreeNode node, int key) {
		if (node == null) {
			return false;
		} else {							// 要删除的结点为node
			if (key == node.data) {
				return delete(node);
			} else if (key < node.data) {
				return deleteBST(node.lchild, key);
			} else {
				return deleteBST(node.rchild, key);
			}
		}
	}
	
	private boolean delete(BiTreeNode node) {
		BiTreeNode p = null;				// 要删除的结点p
		if (node.rchild == null) {			// 只有左子树
			node = node.lchild;				// 重连左子树
		} else if (node.lchild == null) {	// 只有右子树，
			node = node.rchild;				// 重连右子树
		} else {							// 左右子树都不为空
			p = node;						// p是要删除的结点
			BiTreeNode s = node.lchild;		// 寻找左子树
			while (s.rchild != null) {		// 找到左子树的最右结点
				p = s;
				s = s.rchild;
			}
			node.data = s.data;
			if (p != node) {
				p.rchild = s.lchild;
			} else {
				p.lchild = s.lchild;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		BinarySortTree bst = new BinarySortTree();
		int[] a = {62,88,58,47,35,73,51,99,37,93,29,36,37,48,49,50,56,89};
		System.out.print("插入前，遍历二叉排序树得到的序列为: ");
		inOrderTraverse(bst.root);
		for (int i = 0; i < a.length; i++) {
			bst.insertBST(a[i]);
		}
		System.out.println();
		System.out.print("插入后，中序遍历二叉排序树得到的序列为: ");
		inOrderTraverse(bst.root);
		System.out.println();
		System.out.print("查找二叉排序树中是否有73: ");
		System.out.println(bst.searchBST(73));
		bst.deleteBST(bst.root, 47);
		System.out.print("删除47后，中序遍历二叉排序树得到的序列为: ");
		inOrderTraverse(bst.root);
	}
}
