package bigjun.iplab.sequenceQueue;

public interface QueueINF {
    // 判断顺序队列是否为空
    public boolean isqueueEmpty();
    // 将一个已经存在的顺序队列置成空表
    public void queueClear();
    // 求顺序队列的长度
    public int queueLength();
    // 读取顺序队列的队列队头元素
    public int getHeadElem() throws Exception;
    // 在顺序队列的队尾插入元素e
    public void queueEnter(int e) throws Exception;
    // 删除顺序队列队头元素
    public void queueDel() throws Exception ;
    // 输出顺序队列中的所有元素
    public void queueTraverse() throws Exception;
}