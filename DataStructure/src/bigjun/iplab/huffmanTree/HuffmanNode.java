package bigjun.iplab.huffmanTree;
/**
 * Huffman Tree的结点存储结构
 */
public class HuffmanNode {
	
	public int weight;							// 结点权值
	public short flag;							// 结点是否加入到霍夫曼树的标识
	public HuffmanNode parent, lchild, rchild;	// 结点的双亲、左孩子和右孩子
	
	public HuffmanNode() {						// 构造一个空结点
		this(0);
	}

	public HuffmanNode(int weight) {			// 构造一个非空结点
		this.weight = weight;
		flag = 0;
		parent = lchild = rchild = null;
	}
	
}
