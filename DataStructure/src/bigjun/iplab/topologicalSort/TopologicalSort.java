package bigjun.iplab.topologicalSort;

import bigjun.iplab.linkStack.LinkStack;

public class TopologicalSort {

	public static void TopoSort(ActivityOnVertexNetwork G) throws Exception {
		int count = 0;          			// 统计输出顶点的个数
		LinkStack S = new LinkStack();		
		for (int i = 0; i < G.getVexNum(); i++) {// 将入度为0的顶点入栈
			if (G.getVexs()[i].in == 0) {
				S.stackPush(i);
			}
		}
		System.out.println("对AOV网进行拓扑排序得到打印结果为: ");
		while (!S.isStackEmpty()) {
			int i = (int) S.stackPop();
			System.out.print(G.getVex(i) + "->");
			count++;
			// 遍历顶点Vi的边链表，将每一个弧头对应的顶点的入度减1，也就是把Vi和连接自己的弧断开
			for (EdgeNode edge = G.getVexs()[i].firstEdge; edge != null; edge = edge.nextEdge) {
				int k = edge.adjVex;
				if (--G.vexs[k].in == 0) {
					S.stackPush(k);
				}
			}
		if (count > G.getVexNum()) 
			throw new Exception("这是一个有回环的图！");
		}
		System.out.println("Over!");
	}
}
