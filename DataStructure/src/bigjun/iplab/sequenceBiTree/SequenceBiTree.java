package bigjun.iplab.sequenceBiTree;

public class SequenceBiTree implements SequenceBiTreeINF{
	
	private static final int MAX_TREE_SIZE = 100;
	private Object[] seqBiTree;
	
	public SequenceBiTree() {
		seqBiTree = new Object[MAX_TREE_SIZE]; 
		for (int i = 0; i < MAX_TREE_SIZE; i++) 
			seqBiTree[i] = null;
	}
	
	public boolean isBiTreeEmpty() {
		return seqBiTree[0] == null;
	}
	
	public int getBiTreeDepth() {
		int i = 0;
		int j = -1;
		for (i = MAX_TREE_SIZE - 1; i >= 0; i--) {   // 从后往前找到最后一个结点的位置
			if (seqBiTree[i] != null) {
				break;
			}
		}
		i++;
		do {
			j++;
		} while (i >= Math.pow(2, j));				// 计算求得不大于log以2为底i的对数
		return j;
	}
	
	public Object getBiTreeRoot() throws Exception {
		if (isBiTreeEmpty()) 
			throw new Exception("二叉树为空，无法获取根结点的值");
		return seqBiTree[0];
	}
	
	public Object getMyParent(Object e) throws Exception {
		if (isBiTreeEmpty()) 
			throw new Exception("二叉树为空，无法获取结点的双亲");
		int parentNum = -1;
		for (int i = 1; i < seqBiTree.length; i++) {   // 根结点没有双亲，从1开始
			if (seqBiTree[i] == e) {
				parentNum = (i+1)/2-1;
			} 
		}
		if (parentNum == -1) {
			throw new Exception("无法在二叉树中匹配到e");
		} else {
			return seqBiTree[parentNum];
		}
	}
	
	public Object getMyLeftChild(Object e) throws Exception {
		if (isBiTreeEmpty()) 
			throw new Exception("二叉树为空，无法获取结点的双亲");
		int lchildNum = -1;
		for (int i = 0; i < seqBiTree.length; i++) {   // 根结点有可能有左孩子，从0开始
			if (seqBiTree[i] == e) {
				lchildNum = 2*i+1;
			} 
		}
		if (lchildNum == -1) {
			throw new Exception("无法在二叉树中匹配到e");
		} else if (seqBiTree[lchildNum] == null) {
			return null;
		} else {
			return seqBiTree[lchildNum];
		}
	}
	
	public Object getMyRightChild(Object e) throws Exception {
		if (isBiTreeEmpty()) 
			throw new Exception("二叉树为空，无法获取结点的双亲");
		int rchildNum = -1;
		for (int i = 0; i < seqBiTree.length; i++) {   // 根结点有可能有左孩子，从0开始
			if (seqBiTree[i] == e) {
				rchildNum = 2*i+2;
			} 
		}
		if (rchildNum == -1) {
			throw new Exception("无法在二叉树中匹配到e");
		} else if (seqBiTree[rchildNum] == null) {
			return null;
		} else {
			return seqBiTree[rchildNum];
		}
	}
	
	public Object getMyLeftSibling(Object e) throws Exception {
		if (isBiTreeEmpty()) 
			throw new Exception("二叉树为空，无法获取结点的右兄弟");
		int lsiblingNum = -1;
		for (int i = 1; i < seqBiTree.length; i++) {   // 根结点不可能有左兄弟，从1开始
			if (seqBiTree[i] == e && i%2 == 0) {       // 找到e并且其序号i为偶数(是右孩子)
				lsiblingNum = i - 1;
			} 
		}
		if (lsiblingNum == -1 ) {
			throw new Exception("无法在二叉树中匹配到e或e本来就是左孩子");
		} else if (seqBiTree[lsiblingNum] == null) {
			return null;
		} else {
			return seqBiTree[lsiblingNum];
		}
	}
	
	public Object getMyRightSibling(Object e) throws Exception {
		if (isBiTreeEmpty()) 
			throw new Exception("二叉树为空，无法获取结点的右兄弟");
		int rsiblingNum = -1;
		for (int i = 1; i < seqBiTree.length; i++) {    // 根结点不可能有右兄弟，从1开始
			if (seqBiTree[i] == e && i%2 == 1) {	 	// 找到e并且其序号i为奇数(是左孩子)
				rsiblingNum = i + 1;
			} 
		}
		if (rsiblingNum == -1) {
			throw new Exception("无法在二叉树中匹配到e或e本来就是右孩子");
		} else if (seqBiTree[rsiblingNum] == null) {
			return null;
		} else {
			return seqBiTree[rsiblingNum];
		}
	}
	
	public void printByLevel(int levelNum) throws Exception {
		if (levelNum < 1 || levelNum > getBiTreeDepth()) {
			throw new Exception("层序号不合法");
		}
		System.out.print("第" + levelNum + "层的数据为: ");
		for (int i = (int) Math.pow(2, levelNum - 1) - 1; i <= Math.pow(2, levelNum) - 2 ; i++) {
			if (seqBiTree[i] != null) {
				System.out.print(seqBiTree[i] + " ");
			} else {
				System.out.print("null" + " ");
			}
		}
		System.out.println();
	}
	
	/**********前序遍历算法***************/
	public void preTraverse(int e) {
		System.out.print(seqBiTree[e] + " ");
		if (seqBiTree[2*e+1]!=null) {
			preTraverse(2*e+1);
		}
		if (seqBiTree[2*e+2]!=null) {
			preTraverse(2*e+2);
		}
	}
	public void preOrderTraverse() {
		System.out.print("前序遍历算法得到的序列为: ");
		if (!isBiTreeEmpty()) {
			preTraverse(0);
		}
		System.out.println();
	}
	
	/**********中序遍历算法***************/
	public void inTraverse(int e) {
		if (seqBiTree[2*e+1]!=null) {
			inTraverse(2*e+1);
		}
		System.out.print(seqBiTree[e] + " ");
		if (seqBiTree[2*e+2]!=null) {
			inTraverse(2*e+2);
		}
	}
	public void inOrderTraverse() {
		System.out.print("中序遍历算法得到的序列为: ");
		if (!isBiTreeEmpty()) {
			inTraverse(0);
		}
		System.out.println();
	}
	
	/**********后序遍历算法***************/
	public void postTraverse(int e) {
		if (seqBiTree[2*e+1]!=null) {
			postTraverse(2*e+1);
		}
		System.out.print(seqBiTree[e] + " ");
		if (seqBiTree[2*e+2]!=null) {
			postTraverse(2*e+2);
		}
	}
	public void postOrderTraverse() {
		System.out.print("后序遍历算法得到的序列为: ");
		if (!isBiTreeEmpty()) {
			postTraverse(0);
		}
		System.out.println();
	}
	
	/**********层序遍历算法***************/
	public void levelOrderTraverse() {
		System.out.print("层序遍历算法得到的序列为: ");
		int i = MAX_TREE_SIZE - 1;
		while (seqBiTree[i] == null) {
			i--;
		}
		for (int j = 0; j <= i; j++) {
			if (seqBiTree[j] != null) {
				System.out.print(seqBiTree[j] + " ");
			}
		}
		System.out.println();
	}
	
	public Object[] createBiTree() throws Exception {
		int i = 0;
		while (i < 10) {
			seqBiTree[i] = i + 1;
			if (i!=0 && seqBiTree[(i+1)/2-1]==null&&seqBiTree[i]!=null) {
				throw new Exception("出现无双亲的非根结点");
			}
			i++;
		}
		while (i<MAX_TREE_SIZE) {
			seqBiTree[i] = null;
			i++;
		}
		return seqBiTree;
	}
	
	public static void main(String[] args) throws Exception {
		
		SequenceBiTree seqBiTree = new SequenceBiTree();
		seqBiTree.createBiTree();
		
		seqBiTree.preOrderTraverse();
		seqBiTree.inOrderTraverse();
		seqBiTree.postOrderTraverse();
		seqBiTree.levelOrderTraverse();
		
		System.out.println("二叉树的深度为: " + seqBiTree.getBiTreeDepth());
		System.out.println("二叉树的根结点为: " + seqBiTree.getBiTreeRoot());
		System.out.println("二叉树中，数据为8的双亲为: " + seqBiTree.getMyParent(8));
		System.out.println("二叉树中，数据为4的左孩子为: " + seqBiTree.getMyLeftChild(4));
		System.out.println("二叉树中，数据为4的右孩子为: " + seqBiTree.getMyRightChild(4));
		System.out.println("二叉树中，数据为8的右兄弟为: " + seqBiTree.getMyRightSibling(8));
		System.out.println("二叉树中，数据为9的兄弟子为: " + seqBiTree.getMyLeftSibling(9));
		System.out.println("*******************************************");
		System.out.println("按层序分别打印每一层的数据为: ");
		for (int i = 1; i <= seqBiTree.getBiTreeDepth(); i++) {
			seqBiTree.printByLevel(i);
		}
		System.out.println("*******************************************");
	}
	
}
