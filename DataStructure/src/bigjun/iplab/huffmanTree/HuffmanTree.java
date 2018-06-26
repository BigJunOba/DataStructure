package bigjun.iplab.huffmanTree;

public class HuffmanTree {
	
	public int[][] huffmanCoding(int[] W){
		int n = W.length;						// 权重数组的长度
		int m = 2 * n - 1;						// 霍夫曼树结点的总个数
		HuffmanNode[] HN = new HuffmanNode[m];	// 霍夫曼树的结点数组
		int i;									// 霍夫曼树的结点数组的下标
		for (i = 0; i < n; i++) {				// 构造n个具有给定权值的结点，放在结点数组的前n个位置
			HN[i] = new HuffmanNode(W[i]);
		}
		for (i = n; i < m; i++) {				// 从数组下标n开始，存放其他的结点
			HuffmanNode[] minNode = selectMinWeight(HN, i - 1);	// 从结点数组中的[0],[1]...[i-1]中选择权值最小的一个
			HuffmanNode min1 = minNode[0];		// 选出数组结点中权值最小的结点
			HuffmanNode min2 = minNode[1];		// 选出数组结点中权值第二小的结点
			
			min1.flag = 1;						// 标记已经被选中到结点数组中
			min2.flag = 1;						
			HN[i] = new HuffmanNode();			// 新建霍夫曼结点，放在数组下标为i的位置
			min1.parent = HN[i];				// 权值最小结点和第二小结点的双亲为新结点
			min2.parent = HN[i];
			HN[i].lchild = min1;				// 新结点的左、右孩子为权值最小的两个结点
			HN[i].rchild = min2;
			HN[i].weight = min1.weight + min2.weight;// 新结点的权重就是两个孩子的权值之和
		}
		
		int[][] Huffcode = new int[n][n];		// 建立霍夫曼编码二维数组
		for (int j = 0; j < n; j++) {			// 一共n个结点
			int start = n - 1;					// 编码开始的位置，初始化为数组的结尾
			// 
			for (HuffmanNode c = HN[j], p = c.parent ; p != null ; c = p, p = p.parent) {
				if (p.lchild.equals(c)) {
					Huffcode[j][start--] = 0;		// 左孩子编码为0
				} else {
					Huffcode[j][start--] = 1;		// 右孩子编码为1
				}
			}
			Huffcode[j][start] = -1;				// 编码的开始标识为-1,即从-1开始后面才是编码序列
		}
		return Huffcode;
		
	}
	
	// 在霍夫曼树结点数组的[0],[1]...[end]中选择不在霍夫曼树中且weight最小的两个结点
	private HuffmanNode[] selectMinWeight(HuffmanNode[] HN, int end) {
		HuffmanNode[] min = {new HuffmanNode(100),new HuffmanNode(100)};
		for (int i = 0; i <= end; i++) {
			HuffmanNode h = HN[i];
			if (h.flag == 0 && h.weight < min[0].weight) {
				min[1] = min[0];
				min[0] = h;
			} else if (h.weight < min[1].weight && h.flag == 0) {
				min[1] = h;
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		int[] W = {27, 8, 15, 15, 30, 5};
		HuffmanTree hTree = new HuffmanTree();
		int[][] HN = hTree.huffmanCoding(W);
		for (int i = 0; i < HN.length; i++) {
			System.out.print(W[i] + "的霍夫曼编码为 ");
			for (int j = 0; j < HN[i].length; j++) {
				if (HN[i][j] == -1) {
					for (int k = j + 1; k < HN[i].length; k++) {
						System.out.print(HN[i][k]);
					}
					break;
				}
			}
			System.out.println();
		}
	}
}
