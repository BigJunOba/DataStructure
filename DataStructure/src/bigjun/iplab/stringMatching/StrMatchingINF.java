package bigjun.iplab.stringMatching;

public interface StrMatchingINF {

    // 求顺序串的长度
    public int strLength();
    // 读取并返回串中的第index个字符值
    public char charAt(int index) throws Exception;

    // Brute-Force模式匹配算法
    public int indexOf_BF(StrMatchingINF str, int begin) throws Exception;
    // KMP模式匹配算法
    public int indexOf_KMP(StrMatchingINF str, int begin) throws Exception;
    // 改进的KMP模式匹配算法
    public int indexOf_ImprovedKMP(StrMatchingINF str, int begin) throws Exception;
    
}