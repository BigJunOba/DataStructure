package bigjun.iplab.sequenceString;

public interface SeqStrINF {
	// 判断顺序串是否为空
    public boolean isstrEmpty();
    // 将一个已经存在的顺序串置成空表
    public void strClear();
    // 求顺序串的长度
    public int strLength();
    // 读取并返回串中的第index个字符值
    public char charAt(int index) throws Exception;
    // 返回当前串中从序号begin开始，到序号end-1为止的子串
    public SeqStrINF strSubstr(int begin, int end) throws Exception;
    // 在当前串的第offset个字符之前插入串str
    public SeqStrINF strInsert(int offset, SeqStrINF str) throws Exception;
    // 删除当前串中从序号begin开始到序号end-1为止的子串
    public SeqStrINF strDelete(int begin, int end) throws Exception;
    // 把str串连接到当前串的后面
    public SeqStrINF strConcat(SeqStrINF str) throws Exception;
    // 将当前串与目标串str进行比较
    public int strCompare(SeqStrINF str) throws Exception;
    // 在当前串中从begin为止开始搜索与str相等的字符串
    public int strIndexOf(SeqStrINF str, int begin) throws Exception;
    // 输出顺序串中的所有元素
    public void strTraverse() throws Exception;
}