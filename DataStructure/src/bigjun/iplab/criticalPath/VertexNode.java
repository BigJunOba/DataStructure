package bigjun.iplab.criticalPath;
/**
 * 图的邻接表存储结构中的顶点结点类
 */
public class VertexNode {
	
	public int in;					// 顶点的入度
	public Object data;				// 顶点的符号信息
	public EdgeNode firstEdge;		// 指向第一条依附于该顶点的弧
	
	
	public VertexNode(int in, Object data) {
		this(in, data, null);
	}
	
	public VertexNode(int in, Object data, EdgeNode firstEdge) {
		this.in = in;
		this.data = data;
		this.firstEdge = firstEdge;
	}
		
}
