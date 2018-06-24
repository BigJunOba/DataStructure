package bigjun.iplab.linkBiTree;
import bigjun.iplab.linkQueue.LinkQueue;
import bigjun.iplab.linkStack.LinkStack;
/**
 * 二叉树的链式存储结构-二叉链表存储结构
 */
public class LinkBiTree implements LinkBiTreeINF{
	
	private BiTreeNode root;
	
	// 构造方法1: 构造一棵空树
	public LinkBiTree() {
		this.root = null;
	}
	
	// 构造方法2: 构造一棵非空树
	public LinkBiTree(BiTreeNode root) {
		this.root = root;
	}
	
	// 构造方法3:由前序遍历序列和中序遍历序列建立一棵二叉树
	public LinkBiTree(String preOrder, String inOrder, int preIndex, int inIndex, int count) {
		// 如果前序和中序遍历序列不为空
		if (count > 0) {
			// 取前序遍历序列的第一个结点作为根结点
			char rChar = preOrder.charAt(preIndex);
			int i = 0;
			// 确定根结点在中序遍历序列的第i(从0开始)个位置
			for ( ; i < count; i++) {
				if (rChar == inOrder.charAt(i + inIndex)) {
					break;
				}
			}
			// 创建根结点对应的二叉树链式存储结构的结点
			root = new BiTreeNode(rChar);
			// 确定左子树的根结点
			root.lchild = new LinkBiTree(preOrder, inOrder, preIndex + 1, inIndex, i).root;
			// 确定右子树的根结点
			root.rchild = new LinkBiTree(preOrder, inOrder, preIndex + i + 1, inIndex + i + 1, count - i - 1).root;
		}
	}
	
	// 构造方法4:由标明空子树的前序遍历序列建立一棵二叉树
	// static修饰的变量叫静态变量，JVM只分配一次内存，在对象之间共享值时要用static修饰
	private static int index = 0;// 这里要注意的是index要加staic关键字，否则每次new LinkBiTree(preStr)出新对象的时候index都是0，那样就会陷入死递归
	public LinkBiTree(String preStr) {
		char c = preStr.charAt(index++);
		if (c != '#') {
			root = new BiTreeNode(c);
			root.lchild = new LinkBiTree(preStr).root;
			root.rchild = new LinkBiTree(preStr).root;
		} else 
			root = null;
	}
	
	
	// 前序递归遍历算法
	public void preOrderTraverse(BiTreeNode T) {
		if (T != null) {
			System.out.print(T.data);
			preOrderTraverse(T.lchild);
			preOrderTraverse(T.rchild);
		}
	}
	
	// 中序递归遍历算法
	public void inOrderTraverse(BiTreeNode T) {
		if (T != null) {
			inOrderTraverse(T.lchild);
			System.out.print(T.data);
			inOrderTraverse(T.rchild);
		}
	}
	
	// 后序递归遍历算法
	public void postOrderTraverse(BiTreeNode T) {
		if (T != null) {
			postOrderTraverse(T.lchild);
			postOrderTraverse(T.rchild);
			System.out.print(T.data);
		}
	}
	
	// 前序非递归遍历算法
	public void preOrderTraverse() throws Exception {
		BiTreeNode T = root;
		if (T != null) {
			LinkStack stack = new LinkStack();				// 构造栈对象
			stack.stackPush(T);								// 根结点前入栈
			while (!stack.isStackEmpty()) {					// 栈不为空时
				T = (BiTreeNode) stack.stackPop();
				System.out.print(T.data);             		// 访问结点
				while (T != null) {
					if (T.lchild != null) 
						System.out.print(T.lchild.data);	// 访问结点的非空左孩子
					if (T.rchild != null) 
						stack.stackPush(T.rchild);			// 将结点的非空右孩子入栈
					T = T.lchild;							// 转换为原结点的非空左孩子
				}
			}
		}
	}
	
	// 中序非递归遍历算法
	public void inOrderTraverse() throws Exception{
		BiTreeNode T = root;
		if (T != null) {
			LinkStack stack = new LinkStack();			// 构造栈对象
			stack.stackPush(T);							// 根结点前入栈 
			while (!stack.isStackEmpty()) {	
				while (stack.getTopElem() != null)  	// 栈顶非空结点左孩子相继入栈
					stack.stackPush(((BiTreeNode)stack.getTopElem()).lchild);
				stack.stackPop();            			// 如果没有左孩子或右孩子，将空的左孩子或右孩子出栈
				if (!stack.isStackEmpty()) {
					T = (BiTreeNode) stack.stackPop();  // 栈顶结点出栈
					System.out.print(T.data);			// 访问栈顶结点
					stack.stackPush(T.rchild);			// 出栈的栈顶结点的右孩子入栈
				}
			}
		}
	}
	
	// 后序非递归遍历算法
	public void postOrderTraverse() throws Exception {
		BiTreeNode T = root;
		if (T != null) {
			LinkStack stack = new LinkStack();			// 构造栈对象
			stack.stackPush(T);							// 根结点前入栈 
			Boolean flag;
			BiTreeNode p = null;
			while (!stack.isStackEmpty()) {	
				while (stack.getTopElem() != null)  	// 栈顶非空结点左孩子相继入栈
					stack.stackPush(((BiTreeNode)stack.getTopElem()).lchild);
				stack.stackPop();            			// 如果没有左孩子或右孩子，将空的左孩子或右孩子出栈
				while (!stack.isStackEmpty()) {
					T = (BiTreeNode) stack.getTopElem();// 查看栈顶结点
					if (T.rchild == null || T.rchild == p) { // 右孩子为空或右子树已经被访问
						System.out.print(T.data);		// 访问栈顶结点
						stack.stackPop();				// 移除栈顶结点
						p = T;							// p指向当被访问的结点
						flag = true;					// 设置已访问标记
					} else {
						stack.stackPush(T.rchild);		// 右孩子入栈
						flag = false;					// 设置未被访问标记
					}
					if (!flag) 							// 如果未被访问，则break
						break;
				}
			}
		}
	}
	
	// 层序非递归遍历算法
	public void levelOrderTraverse() throws Exception {
		BiTreeNode T = root;
		if (T != null) {
			LinkQueue queue = new LinkQueue();			// 构造链队列
			queue.queueEnter(T);						// 根结点入链队列
			while (! queue.isqueueEmpty()) {	
				T = (BiTreeNode) queue.queuePoll();		// 访问结点并出队列
				System.out.print(T.data);
				if (T.lchild != null) 					// 左孩子非空，入队列
					queue.queueEnter(T.lchild);		
				if (T.rchild != null) 					// 右孩子非空，入队列
					queue.queueEnter(T.rchild);
			}
		}
	}
	
	// (前序递归遍历算法)在二叉树中查找值为x的结点，若找到，则返回该结点;否则，返回null
	public BiTreeNode searchBTNode(BiTreeNode T, Object x) {
		if (T != null) {
			if (T.data == x) {									// 判断根结点
				return T;// 注意这里的return语句，只要查找到了就不用再继续往下查找了，不同于前序递归遍历算法。
			} else {
				// 查找左子树
				BiTreeNode lResult = searchBTNode(T.lchild, x);
				// 若在左子树中查找到x的结点，则返回该结点;否则，查找右子树并返回结果
				return lResult != null ? lResult : searchBTNode(T.rchild, x);
			}
		}
		return null;
	}
	
	// (前序递归遍历算法)统计二叉树中结点的个数并返回
	public int countBTNode(BiTreeNode T) {
		int count = 0;
		if (T != null) {
			++count;
			count += countBTNode(T.lchild);
			count += countBTNode(T.rchild);
		}
		return count;
	}
	
	// (后序递归遍历算法) 求二叉树的深度
	public int getBTDepth(BiTreeNode T) {
		if (T != null) {
			int lDepth = getBTDepth(T.lchild);
			int rDepth = getBTDepth(T.rchild);
			return 1 + (lDepth > rDepth ? lDepth : rDepth);
		}
		return 0;
	}
	
	// (前序递归遍历算法) 判断两棵二叉树是否相等，若相等，返回true；否则，返回false
	public boolean isEqual(BiTreeNode T1, BiTreeNode T2) {
		if (T1 == null && T2 == null) 
			return true;
		if (T1 != null && T2 != null) {
			if (T1.data.equals(T2.data)) {
				if (isEqual(T1.lchild, T2.lchild)) {
					if (isEqual(T1.rchild, T2.rchild)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	// 采用构造方法2来构造二叉树1
	public LinkBiTree createLinkBiTreeByDefinition() {
		
		BiTreeNode k = new BiTreeNode('K');         // 要前定义孩子，因为程序是按前后顺序执行的
		BiTreeNode i = new BiTreeNode('I');
		BiTreeNode j = new BiTreeNode('J');
		BiTreeNode e = new BiTreeNode('E');
		
		BiTreeNode h = new BiTreeNode('H', null, k);
		BiTreeNode f = new BiTreeNode('F', i, null);
		BiTreeNode g = new BiTreeNode('G', null, j);
		BiTreeNode d = new BiTreeNode('D', h, null);
		
		BiTreeNode c = new BiTreeNode('C', f, g);
		BiTreeNode b = new BiTreeNode('B', d, e);
		BiTreeNode a = new BiTreeNode('A', b, c);
		
		return new LinkBiTree(a);
	}
	
	// 采用构造方法2来构造二叉树2(对比二叉树1来说，删除一个结点K)
	public LinkBiTree createLinkBiTreeByDefinitionSimilar() {
		
		BiTreeNode i = new BiTreeNode('I');
		BiTreeNode j = new BiTreeNode('J');
		BiTreeNode e = new BiTreeNode('E');
		
		BiTreeNode h = new BiTreeNode('H', null, null);
		BiTreeNode f = new BiTreeNode('F', i, null);
		BiTreeNode g = new BiTreeNode('G', null, j);
		BiTreeNode d = new BiTreeNode('D', h, null);
		
		BiTreeNode c = new BiTreeNode('C', f, g);
		BiTreeNode b = new BiTreeNode('B', d, e);
		BiTreeNode a = new BiTreeNode('A', b, c);
		
		return new LinkBiTree(a);
	}
	
	//由顺序存储的完全二叉树建立一棵连式存储的二叉树结点
	public BiTreeNode createBiTreeNodeBySeqBiTree(String seqBiTree, int index) {
		BiTreeNode root = null;									// 根结点
		if (index < seqBiTree.length()) {						// 位置不超过字符串长度
			root = new BiTreeNode(seqBiTree.charAt(index));		// 从下标为0开始，建立二叉链表根结点
			root.lchild = createBiTreeNodeBySeqBiTree(seqBiTree, 2 * index + 1);// 建立左子树
			root.rchild = createBiTreeNodeBySeqBiTree(seqBiTree, 2 * index + 2);// 建立右子树
		}
		return root; // 返回二叉链表根结点对象
	}
	
	// 由顺序存储的完全二叉树建立一棵连式存储的二叉树
	public LinkBiTree createBiTreeBySeqBiTree(String seqBiTree, int index) {
		BiTreeNode root = createBiTreeNodeBySeqBiTree(seqBiTree, index);
		return new LinkBiTree(root);
	}
	
	// 由前序遍历序列和中序遍历序列建立一棵二叉树
	public LinkBiTree createBiTreeByPreAndInOrder(String preOrder, String inOrder, int preIndex, int inIndex, int count) {
		return new LinkBiTree(preOrder, inOrder, preIndex, inIndex, count);
	}
	
	// 由标明空子树的先序遍历序列建立一棵二叉树
	public LinkBiTree creataBiTreeByPreHasNullSign(String preStr) {
		return new LinkBiTree(preStr);
	}
	
	
	
	public static void main(String[] args) throws Exception {
		LinkBiTree linkBiTree = new LinkBiTree();            // 创建一棵空树
		LinkBiTree biTree = linkBiTree.createLinkBiTreeByDefinition();   // 调用创造方法创造根结点为a的二叉树
		BiTreeNode root = biTree.root;                       // 取得二叉树的根结点
		
		System.out.print("前序递归遍历算法得到的序列为:  ");
		linkBiTree.preOrderTraverse(root);                   
		System.out.println();
		System.out.print("中序递归遍历算法得到的序列为:  ");
		linkBiTree.inOrderTraverse(root);                    
		System.out.println();
		System.out.print("后序递归遍历算法得到的序列为:  ");
		linkBiTree.postOrderTraverse(root);                  
		System.out.println();
		
		System.out.print("前序非递归遍历算法得到的序列为: ");
		biTree.preOrderTraverse();                   
		System.out.println();
		System.out.print("中序非递归遍历算法得到的序列为: ");
		biTree.inOrderTraverse();                   
		System.out.println();
		System.out.print("后序非递归遍历算法得到的序列为: ");
		biTree.postOrderTraverse();                   
		System.out.println();
		System.out.print("层序非递归遍历算法得到的序列为: ");
		biTree.levelOrderTraverse();                   
		System.out.println();
		
		System.out.print("在二叉树中查找字符D返回的结点的数据域为:");
		System.out.println(linkBiTree.searchBTNode(root, 'D').data);
		System.out.print("在二叉树中查找字符W返回的结点为:");
		System.out.println(linkBiTree.searchBTNode(root, 'W'));
		
		System.out.println("二叉树中结点个数的统计结果为: " + linkBiTree.countBTNode(root));
		
		System.out.println("二叉树的深度为: " + linkBiTree.getBTDepth(root));
		
		LinkBiTree biTreeSimiliar = linkBiTree.createLinkBiTreeByDefinitionSimilar(); 
		BiTreeNode rootSimiliar = biTreeSimiliar.root;
		System.out.println("判断两棵不同的二叉树是否相等: " + linkBiTree.isEqual(root, rootSimiliar));
		System.out.println("判断两棵相同的二叉树是否相等: " + linkBiTree.isEqual(root, root));
		
		String preOrder = "ABDHKECFIGJ";
		String inOrder  = "HKDBEAIFCGJ";
		LinkBiTree biTreeByPreAndIn = linkBiTree.createBiTreeByPreAndInOrder(preOrder, inOrder, 0, 0, preOrder.length());
		System.out.print("由前序和中序遍历序列得到的一棵二叉树的层序非递归遍历算法得到的序列为: ");
		biTreeByPreAndIn.levelOrderTraverse();
		System.out.println();
		
		String NumberSign = "ABDH#K###E##CFI###G#J##";
		LinkBiTree biTreeHasNumberSign = linkBiTree.creataBiTreeByPreHasNullSign(NumberSign);
		System.out.print("由表明空子树的前序遍历序列得到的一棵二叉树的层序非递归遍历算法得到的序列为: ");
		biTreeHasNumberSign.levelOrderTraverse();
		System.out.println();
		
		String seqBiTree = "ABCDEFGHIJ";
		LinkBiTree linkBiTreeBySeqBiTree = linkBiTree.createBiTreeBySeqBiTree(seqBiTree, 0);
		System.out.print("由完全二叉树的顺序存储结构得到的一棵二叉树的层序非递归遍历算法得到的序列为: ");
		linkBiTreeBySeqBiTree.levelOrderTraverse();
		System.out.println();
		
		
	}
	
}
