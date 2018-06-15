package bigjun.iplab.linkStack;

public interface IListStack {
    // 判断顺序栈是否为空
    public boolean isStackEmpty();
    // 将一个已经存在的顺序栈置成空表
    public void stackClear();
    // 求顺序栈的长度
    public int stackLength();
    // 读取顺序栈的栈顶元素
    public int getTopElem() throws Exception;
    // 在顺序栈中插入元素e
    public void stackPush(int e);
    // 删除顺序栈中的栈顶元素
    public void stackPop() throws Exception ;
    // 输出顺序栈中的所有元素
    public void stackTraverse();
}
