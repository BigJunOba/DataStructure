package bigjun.iplab.sparseMatrix;
/**
 * 稀疏矩阵三元组顺序表类
 */
public class SparseMatrix {
	
	public TripleNode data[];   // 三元组表
	public int rows;			// 行数
	public int columns;			// 列数
	public int nums;			// 非零元素个数
	
	// 稀疏矩阵构造方法1: 为顺序表分配maxSize个存储单元并初始化
	public SparseMatrix(int maxSize) {
		data = new TripleNode[maxSize];
		for (int i = 0; i < data.length; i++) {
			data[i] = new TripleNode();
		}
		rows = 0;
		columns = 0;
		nums = 0;
	}
	
	// 稀疏矩阵构造方法2: 根据给定的稀疏矩阵创建你三元组表
	// 按先行序后列序的原则依次扫描已知稀疏矩阵的所有元素，并把非零元素插入到构造方法1生成的三元组顺序表中
	public SparseMatrix(int mat[][]) {
		int i,j, k = 0, count = 0;
		rows = mat.length;                  // 获取行数
		columns = mat[0].length;            // 获取列数
		for (i = 0; i < rows; i++) {        // 统计非零元素的个数
			for (j = 0; j < columns; j++) {
				if (mat[i][j] != 0) {
					count++;
				}
			}
		}
		nums = count;    // 非零元素的个数
		data = new TripleNode[nums];   // 调用构造方法1来申请三元组表的结点空间
		for (i = 0; i < rows; i++) {
			for (j = 0; j < columns; j++) {
				if (mat[i][j] != 0) {
					data[k] = new TripleNode(i, j, mat[i][j]);  // 建立三元组
					k++;
				}
			}
		}
	}
	
	// 矩阵转置算法
	public SparseMatrix transpose() {
		SparseMatrix tMatrix = new SparseMatrix(nums);      // 创建矩阵对象
		tMatrix.columns = rows;								// 行数变为列数
		tMatrix.rows = columns;								// 列数变为行数
		tMatrix.nums = nums;								// 非零元素个数不变
		int q = 0;
		for (int i = 0; i < columns; i++) {    				// 从第0行开始搜索
			for (int j = 0; j < nums; j++) {				// 遍历完所有元素
				if (data[j].column == i) {					// 第i行就找列号为i的，先0再1...
					tMatrix.data[q].row = data[j].column;
					tMatrix.data[q].column = data[j].row;
					tMatrix.data[q].value = data[j].value;
					q++;
				}
			}
		}
		return tMatrix;
	}
	
	// 矩阵快速转置算法
	public SparseMatrix fastTranspose() {
		SparseMatrix tMat = new SparseMatrix(nums);         // 创建矩阵对象
		tMat.columns = rows;								// 行数变为列数
		tMat.rows = columns;								// 列数变为行数
		tMat.nums = nums;								    // 非零元素个数不变
		int i, j = 0, k = 0;
		int[] num, cpot;
		if (nums > 0) {
			num = new int[columns];   // num[i]表示N中第i列的非零元素个数
			cpot = new int[columns];   
			// 每列非零元素个数数组num初始化全部归零
			for (i = 0; i < columns; i++) { 
				num[i] = 0;
			}
			// 计算每列非零元素个数，遍历所有非零元素，得到是在第j列，就在第j列非零元素个数上加1
			for (i = 0; i < nums; i++) {
				j = data[i].column;
				num[j]++;
			}
			// 计算每列第1个非零元素在TM中的位置
			cpot[0] = 0;
			for (i = 1; i < columns; i++) {
				cpot[i] = cpot[i-1] +num[i-1];//cpot[i]表示N中第i列的第一个非零元素在TM中的位置
			}
			// 执行转置操作
			for (i = 0; i < nums; i++) {		   // 扫描整个三元组表
				j = data[i].column;
				k = cpot[j];					   // 该元素在TM中的行号
				tMat.data[k].row = data[i].column;
				tMat.data[k].column = data[i].row;
				tMat.data[k].value = data[i].value;
				cpot[j]++; 						   // 该列下一个非零元素的存放位置
			}
		}
		
		return tMat;
	}
	// 遍历稀疏矩阵并打印输出
	public void MatrixTraverse() {
		System.out.println("稀疏矩阵的三元组存储结构: ");
		System.out.println("行数: " + rows + ", 列数: " + columns + ", 非零元素个数: " + nums);
		System.out.println("行下标       列下标           元素值");
		for (int j = 0; j < nums; j++) {
			System.out.println(data[j].row + "\t" + data[j].column + "\t" + data[j].value);
		}
	}
	
	public static void main(String[] args) {
		int m[][] = {
				{0, 0, 8,  0,  0,  0},
				{0, 0, 0,  0,  0,  0},
				{5, 0, 0,  0,  16, 0},
				{0, 0, 18, 0,  0,  0},
				{0, 0, 0,  9,  0,  0}
		};
		SparseMatrix sM = new SparseMatrix(m);
		sM.MatrixTraverse();
		
		SparseMatrix tM = sM.transpose();
		tM.MatrixTraverse();
		
		SparseMatrix fM = sM.fastTranspose();
		fM.MatrixTraverse();
	}
	
	
}
