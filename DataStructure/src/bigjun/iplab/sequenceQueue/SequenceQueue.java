package bigjun.iplab.sequenceQueue;

public class SequenceQueue implements QueueINF {
	
	private final static int MAXSIZE = 20;
	private int[] queueElem;
	private int front;
	private int rear;
	
	public SequenceQueue() {
		queueElem = new int[MAXSIZE];
		front = rear = 0;
	}

	@Override
	public boolean isqueueEmpty() {
		return front == rear;
	}

	public void queueClear() {
		front=rear=0;
	}

	public int queueLength() {
		return (rear - front + MAXSIZE) % MAXSIZE;
	}

	public int getHeadElem() throws Exception {
		if (front == rear) 
			throw new Exception("顺序队列为空，无法获取队头元素");
		return queueElem[front];
	}

	public void queueEnter(int e) throws Exception {
		if ((rear + 1) % MAXSIZE == front) 
			throw new Exception("队列为满的，无法实现入队列操作");
		queueElem[rear] = e;
		rear = (rear + 1) % MAXSIZE;
	}

	public void queueDel() throws Exception {
		if (front == rear) 
			throw new Exception("顺序队列为空，无法删除队头元素");
		front = (front + 1 ) % MAXSIZE;
	}

	public void queueTraverse() throws Exception {
		if (front == rear) 
			throw new Exception("顺序队列为空，无法获取队头元素");
		System.out.print("此时顺序队列的元素为: ");
		for (int i = front; i != rear; i = (i + 1 ) % MAXSIZE) {
			System.out.print(queueElem[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		int i = 0;
		SequenceQueue sQueue = new SequenceQueue();
		System.out.println("队列是否为空: " + sQueue.isqueueEmpty());
		do {
			int d = i + 100;
			i++;
			sQueue.queueEnter(d);
		} while (i  < MAXSIZE - 1);      // 这里留一个位置为空，注意一下。
		System.out.println("队列是否为空: " + sQueue.isqueueEmpty());
		System.out.println("队列长度为: " + sQueue.queueLength());
		sQueue.queueTraverse();
		
		for (int j = 1; j <= MAXSIZE; j++) {
			sQueue.queueDel();
			int f = j + 1000;
			sQueue.queueEnter(f);
		}
		sQueue.queueTraverse();
		
		for (int l = 1; l <= 17 ; l++) {
			sQueue.queueDel();
		}
		System.out.println("队列长度为: " + sQueue.queueLength());
		sQueue.queueTraverse();
		System.out.println("队列的队头为: " + sQueue.getHeadElem());
		sQueue.queueDel();
		System.out.println("队列的队头为: " + sQueue.getHeadElem());
	}
	

}
