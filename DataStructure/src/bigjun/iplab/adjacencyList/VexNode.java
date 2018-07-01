package bigjun.iplab.adjacencyList;
/**
 * 图的邻接表存储结构中的顶点结点类
 */
public class VexNode {
	
	public Object data;			// 顶点的信息
	public ArcNode firstArc;	// 指向第一条依附于该顶点的弧
	
	public VexNode() {
		this(null, null);
	}
	
	public VexNode(Object data) {
		this(data, null);
	}
	
	public VexNode(Object data, ArcNode firstArc) {
		this.data = data;
		this.firstArc = firstArc;
	}

	public Object getData() {
		return data;
	}

	public ArcNode getFirstArc() {
		return firstArc;
	}
	
	
}
