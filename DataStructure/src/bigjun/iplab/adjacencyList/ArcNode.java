package bigjun.iplab.adjacencyList;
/**
 * 图的邻接表存储结构中的边(或弧)结点类
 */
public class ArcNode {

	public int adjVex;			// 该弧所指向的顶点在顶点数组中的下标
	public int weight;			// 边或弧的权值
	public ArcNode nextArc;		// 指向下一条表示边或弧的结点类
	
	public ArcNode() {
		this(-1, 0, null);
	}
	
	public ArcNode(int adjVex) {
		this(adjVex, 0, null);
	}
	
	public ArcNode(int adjVex, int weight) {
		this(adjVex, weight, null);
	}
	
	public ArcNode(int adjVex, int weight, ArcNode nextArc) {
		this.adjVex = adjVex;
		this.weight = weight;
		this.nextArc = nextArc;
	}
	
	
	
}
