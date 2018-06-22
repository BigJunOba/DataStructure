package bigjun.iplab.linkQueue;

public interface LinkQueueINF {
    // 判断链队列是否为空
    public boolean isqueueEmpty();
    // 将一个已经存在的链队列置成空表
    public void queueClear();
    // 求链队列的长度
    public int queueLength();
    // 读取链队列的队列队头元素
    public Object getHeadElem() throws Exception;
    // 在链队列的队尾插入元素e
    public void queueEnter(Object e);
    // 删除链队列队头元素
    public void queueDel() throws Exception ;
    // 输出链队列中的所有元素
    public void queueTraverse();
}