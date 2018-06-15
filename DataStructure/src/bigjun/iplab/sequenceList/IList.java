package bigjun.iplab.sequenceList;

public interface IList {
    //置空操作
    public void clear();
    //判空操作
    public boolean isEmpty();
    //取表长度
    public int getLength();
    //取表元素
    public int getElem(int i) throws Exception;
    //插入操作
    public void insert(int i, int x) throws Exception;
    //删除操作
    public void remove(int i) throws Exception;
    //显示
    public void display();
    // 定位元素e
    public int locateElem(int e);
    // 合并两个集合
    public void union(IList bIList) throws Exception;
}