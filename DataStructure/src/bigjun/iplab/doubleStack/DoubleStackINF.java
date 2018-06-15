package bigjun.iplab.doubleStack;

public interface DoubleStackINF {
    // 判断顺序栈是否为空
    public boolean isStackEmpty();
    // 将一个已经存在的顺序栈置成空表
    public void stackClear();
    // 求顺序栈的长度
    public int stackLength();
    // 读取顺序栈1的栈顶元素
    public int getTop1Elem() throws Exception;
    // 读取顺序栈2的栈顶元素
    public int getTop2Elem() throws Exception;
    // 在顺序栈中插入元素e
    public void stackPush(int stackNumber, int e) throws Exception;
    // 删除顺序栈中的栈顶元素
    public void stackPop(int stackNumber) throws Exception ;
    // 输出顺序栈中的所有元素
    public void stackTraverse();
}