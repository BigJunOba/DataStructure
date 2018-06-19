package bigjun.iplab.sequenceString;

public class SeqString implements SeqStrINF{
	
	private char[] strElem;
	private int curlength;
	
	// 构造方法1：构造一个空串
	public SeqString() {
		strElem = new char[0];   
		curlength = 0;
	}
	
	// 构造方法2：以字符串常量构造串对象
	public SeqString(String str) {
		char[] tempCharArray = str.toCharArray();
		strElem = tempCharArray;     
		curlength = tempCharArray.length;
	}
	
	// 构造方法3：以字符数组构造串对象
	public SeqString(char[] strValue) {
		strElem = new char[strValue.length];    
		for (int i = 0; i < strValue.length; i++) {
			strElem[i] = strValue[i];
		}
		curlength = strValue.length;
	}

	public boolean isstrEmpty() {
		return curlength==0;
	}

	public void strClear() {
		curlength = 0;
	}

	public int strLength() {
		return curlength;
	}

	public char charAt(int index) throws Exception {
		if ((index < 0) || (index >= curlength)) {
			throw new Exception("索引值超出范围，无法给出对应字符");
		}
		return strElem[index];
	}

	public SeqStrINF strSubstr(int begin, int end) throws Exception {
		if (begin < 0 || end > curlength || begin > end) 
			throw new Exception("取子字符串操作参数值设定不合法");
		if (begin == 0 && end == curlength) {
			return this;
		}else {
			char[] buffer = new char[end - begin];
			for (int i = 0; i < buffer.length; i++) {
				buffer[i] = this.strElem[i + begin];
			}
			return new SeqString(buffer);       // 调用构造函数，返回SeqString类型的字符串数组
		}
	}
	
	// 扩充字符串存储空间，如果当前数组已经满了，就要使用此函数来扩充数组
	public void allocate(int newCapacity) {
		char[] temp = strElem;
		strElem = new char[newCapacity];
		for (int i = 0; i < temp.length; i++) {
			strElem[i] = temp[i];
		}
	}

	public SeqStrINF strInsert(int offset, SeqStrINF str) throws Exception {
		if (offset < 0 || offset > curlength ) 
			throw new Exception("插入操作参数值设定不合法");
		int len = str.strLength();
		int newCount = this.curlength + len;
		if (newCount > strElem.length)      // 如果插入后的字符串总长度超过最大值，就要扩充可用数组长度
			allocate(newCount);
		for (int i = this.curlength - 1; i >= offset; i--)  // 将第offset后面的字符向后移动len
			strElem[len + i] = strElem[i];
		for (int i = 0; i < len; i++) 
			strElem[offset + i] = str.charAt(i);     // 将str字符串插入到原来的字符串中
		this.curlength = newCount;
		return this;
	}

	public SeqStrINF strDelete(int begin, int end) throws Exception {
		if (begin < 0 || end > curlength || begin > end) 
			throw new Exception("删除操作参数值设定不合法"); 
		for (int i = 0; i < curlength - end; i++)    // 从end开始至串尾的子串向前移动从begin开始的位置
			strElem[begin + i] = strElem[end + i];
		curlength = curlength - (end - begin);
		return this;
	}

	public SeqStrINF strConcat(SeqStrINF str) throws Exception {
		return strInsert(curlength, str);
	}

	public int strCompare(SeqStrINF str) throws Exception {
		int len1 = curlength;
		int len2 = str.strLength();
		int n = Math.min(len1, len2);
		char[] s1 = strElem;
		char[] s2 = new char[len2];
		for (int i = 0; i < s2.length; i++) {
			s2[i] = str.charAt(i);
		}
		int k = 0;
		while (k < n) {
			char ch1 = s1[k];
			char ch2 = s2[k];
			if (ch1 != ch2) 
				return ch1 - ch2;      // 返回第一个不相等字符的数值差
			k++;
		}
		return Math.max(len1, len2) - n;      // 返回两个字符串长度差的绝对值
	}

	public int strIndexOf(SeqStrINF str, int begin) throws Exception {
		if (begin < 0  || begin > curlength) 
			throw new Exception("索引子字符串操作参数值设定不合法"); 
		int n = curlength;
		int m = str.strLength();
		int i = begin;
		while (i <= n - m) {
			SeqString str1 = (SeqString) strSubstr(i, i + m);
			if (str1.strCompare(str) != 0) {
				++i;
			} else {
				return i;             // 返回在主串中的索引值
			}
		}
		return 0;                    // 没有子串与str相等，返回0
	}

	public void strTraverse() throws Exception {
		for (int i = 0; i < curlength; i++) {
			System.out.print(strElem[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		SeqString str1 = new SeqString("abcd");
		System.out.print("str1字符串的输出: ");
		str1.strTraverse();
		
		char cha[] = {'e','f','g','h','i','j','k'};
		SeqString str2 = new SeqString(cha);
		System.out.print("str2字符串的输出: ");
		str2.strTraverse();
		System.out.println("str2是否为空: " + str2.isstrEmpty());
		System.out.println("str2此时的长度为: " + str2.strLength());
		System.out.println("str2数组下标为2的字符为: " + str2.charAt(2));
		
		System.out.println("str2和str1比大小的结果为: " + str2.strCompare(str1));
		
		System.out.print("str2数组下标为2-5(不包括5)的子字符串为: ");
		SeqString str3 = (SeqString) str2.strSubstr(2, 5);
		str3.strTraverse();
		
		System.out.print("在str2的第0个位置前面插入str1所得的字符串str4为: ");
		SeqString str4 = (SeqString) str2.strInsert(0, str1);
		str4.strTraverse();
		
		System.out.println("str4和str1比大小的结果为: " + str4.strCompare(str1));
		
		System.out.print("在str4的第6个位置前面插入str1所得的字符串str5为: ");
		SeqString str5 = (SeqString) str4.strInsert(0, str1);
		str5.strTraverse();
		
		System.out.print("删除str5的前七个位置的字符所得的字符串str6为: ");
		SeqString str6 = (SeqString) str5.strDelete(0, 8);
		str6.strTraverse();
		
		System.out.print("在str6的后面连接str1所得的字符串str7为: ");
		SeqString str7 = (SeqString) str6.strConcat(str1);
		str7.strTraverse();
		
		System.out.print("在清空str7后，");
		str7.strClear();
		System.out.print("str7是否为空: " + str7.isstrEmpty());
		System.out.println("。 str7此时的长度为: " + str7.strLength());
		
		System.out.print("在清空str1后，");
		str1.strClear();
		System.out.print("str1是否为空: " + str1.isstrEmpty());
		System.out.println("。 str1此时的长度为: " + str1.strLength());
		
		SeqString string1 = new SeqString("abcd");
		SeqString string2 = new SeqString("dadfdaabcdedad");
		System.out.print("string2中数组下标为0之后第一次存在string1的下标位置为: ");
		System.out.println(string2.strIndexOf(string1, 0));
		
		System.out.print("string2中数组下标为7之后第一次存在string1的下标位置为: ");
		System.out.println(string2.strIndexOf(string1, 7));
	}

}
