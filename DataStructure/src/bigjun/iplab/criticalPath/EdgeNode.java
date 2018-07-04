package bigjun.iplab.criticalPath;
/**
 * 用于关键路径算法中的邻接表存储结构中的边(或弧)结点类
 */
public class EdgeNode {

	public int adjVex;				// 该弧所指向的顶点在顶点数组中的下标
	public int weight;				// 用于表示事件完成需要的时间
	public EdgeNode nextEdge;		// 指向下一条表示边或弧的结点类
		
	public EdgeNode(int adjVex, int weight) {
		this(adjVex, weight, null);
	}
	
	public EdgeNode(int adjVex, int weight, EdgeNode nextEdge) {
		this.adjVex = adjVex;
		this.weight = weight;
		this.nextEdge = nextEdge;
	}
	
}
