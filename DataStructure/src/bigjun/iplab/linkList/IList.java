package bigjun.iplab.linkList;

public interface IList {
    // 判断带头结点的单链表是否为空
    public boolean isListEmpty();
    // 将一个已经存在的带头结点的单链表置成空表
    public void clearList();
    // 求带头结点的单链表的长度
    public int getListLength();
    // 读取带头结点的单链表中第i个结点
    public int getElem(int i) throws Exception;
    // 在带头结点的单链表中查找值为e的结点
    public int locateElem(int e);
    // 在带头结点的单链表中第i个结点之前插入一个值为x的结点
    public void listInsert(int i, int x) throws Exception;
    // 删除带头结点的单链表中的第i个结点
    public void listDelete(int i) throws Exception;
    // 输出单链表中的所有结点
    public void listTraverse();
    // 随机产生n个元素的值，用头插法顺序建立单链表，n为单链表的结点个数
    public void createListHead(int n) throws Exception;
    // 随机产生n个元素的值，用尾插法顺序建立单链表，n为单链表的结点个数
    public void createListTail(int n) throws Exception;
}