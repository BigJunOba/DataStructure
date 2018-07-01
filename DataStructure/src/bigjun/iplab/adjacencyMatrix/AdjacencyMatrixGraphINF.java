package bigjun.iplab.adjacencyMatrix;
/**
 * 图的邻接矩阵存储结构接口类
 */
public interface AdjacencyMatrixGraphINF {
	
	// 创建一个图
	public void createGraph();
	// 返回图中的顶点数
	public int getVexNum();
	// 返回图中的边数
	public int getArcNum();
	// 给定顶点的位置v，返回其对应的顶点值
	public Object getVex(int x) throws Exception;
	// 给定顶点的值vex，返回其在图中的位置
	public int locateVex(Object vex);
	// 返回顶点v的第一个邻接点
	public int firstAdjvex(int v) throws Exception;
	// 返回v相对于w的下一个邻接点
	public int nextAdjvex(int v, int w) throws Exception;
	
}
