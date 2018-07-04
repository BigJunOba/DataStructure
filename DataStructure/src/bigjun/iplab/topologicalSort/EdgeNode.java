package bigjun.iplab.topologicalSort;
/**
 * 用于拓扑排序算法中的邻接表存储结构中的边(或弧)结点类
 */
public class EdgeNode {

	public int adjVex;				// 该弧所指向的顶点在顶点数组中的下标
	public EdgeNode nextEdge;		// 指向下一条表示边或弧的结点类
		
	public EdgeNode(int adjVex) {
		this(adjVex, null);
	}
	
	public EdgeNode(int adjVex, EdgeNode nextEdge) {
		this.adjVex = adjVex;
		this.nextEdge = nextEdge;
	}
	
}
