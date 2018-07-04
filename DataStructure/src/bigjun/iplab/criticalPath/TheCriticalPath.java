package bigjun.iplab.criticalPath;


import bigjun.iplab.linkStack.LinkStack;

public class TheCriticalPath {

	private static LinkStack T = new LinkStack();		// 拓扑逆序列顶点栈
	private static int[] etv, ltv;						// 各顶点的最早发生时间和最晚发生时间
	
	public static void CriticalPath(ActivityOnEdgeNetwork G) throws Exception {
		
		if (!topologicalOrder(G)) 
			throw new Exception("给定的AOE网是一个带回环的网图，不能找到关键路径！");
		ltv = new int[G.getVexNum()];
		for (int i = 0; i < G.getVexNum(); i++) {
			ltv[i] = etv[G.getVexNum() - 1];
		}
		while (!T.isStackEmpty()) {
			int i = (int) T.stackPop();
			for (EdgeNode edge = G.getVexs()[i].firstEdge; edge != null; edge = edge.nextEdge) {
				int k = edge.adjVex;
				int time = edge.weight;
				if (ltv[k] - time < ltv[i]) 
					ltv[i] = ltv[k] - time;
			}
		}
		
		for (int i = 0; i < G.getVexNum(); i++) {
			for (EdgeNode edge = G.getVexs()[i].firstEdge; edge != null; edge = edge.nextEdge) {
				int k = edge.adjVex;
				int time = edge.weight;
				int ete = etv[i];
				int lte = ltv[k] - time;
				char tag = (ete==lte)? 'Y':'N';
				System.out.println(G.getVex(i) + "->" + G.getVex(k) + " " + "活动持续的时间: " + time + " " 
				+ "最早开始时刻: " + ete + " " +  "最晚开始时刻: "+ lte + " " + "是否是关键路径 : " + tag);
			}
		}
	}
	
	// 使用拓扑排序求事件的最早发生时间etv，以及将拓扑序列存入全局变量栈T中
	private static boolean topologicalOrder(ActivityOnEdgeNetwork G) throws Exception {
		int count = 0;          						// 统计输出顶点的个数
		LinkStack S = new LinkStack();		
		for (int i = 0; i < G.getVexNum(); i++) {		// 将入度为0的顶点入栈
			if (G.getVexs()[i].in == 0) {
				S.stackPush(i);
			}
		}
		etv = new int[G.getVexNum()];
		while (!S.isStackEmpty()) {
			int i = (int) S.stackPop();
			T.stackPush(i);
			count++;
			// 遍历顶点Vi的边链表，将每一个弧头对应的顶点的入度减1，也就是把Vi和连接自己的弧断开
			for (EdgeNode edge = G.getVexs()[i].firstEdge; edge != null; edge = edge.nextEdge) {
				int k = edge.adjVex;
				if (--G.vexs[k].in == 0) {
					S.stackPush(k);
				}
				if (etv[i] + edge.weight > etv[k]) 
					etv[k] = etv[i] + edge.weight;
			}
		}
		if (count < G.getVexNum()) 
			return false;			// 如果遍历完后count值小于总的顶点数，就说明该有向图有回路，即拓扑排序的过程中又绕回去了
		else 
			return true;			
	}
	
}
