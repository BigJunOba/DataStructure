package bigjun.iplab.sparseMatrix;
/**
 * 稀疏矩阵的三元组结点类
 */
public class TripleNode {
	
	public int row;     // 行号
	public int column;  // 列号
	public int value;   // 数据元素值
	
	// 有参数构造方法
	public TripleNode(int row, int column, int value) {
		this.row = row;
		this.column = column;
		this.value = value;
	}
	
	// 无参数构造方法
	public TripleNode() {
		this(0, 0, 0);
	}
	
}
