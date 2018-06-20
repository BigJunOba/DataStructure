package bigjun.iplab.stringMatching;

public class StrMatching implements StrMatchingINF{
	
	private char[] strElem;
	private int curlength;
	
	// 构造方法：以字符串常量构造串对象
	public StrMatching(String str) {
		char[] tempCharArray = str.toCharArray();
		strElem = tempCharArray;     
		curlength = tempCharArray.length;
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

	
	/*****************************朴素模式匹配算法*******************************************/
	public int indexOf_BF(StrMatchingINF str, int begin) throws Exception {
		if ((this != null) && (str != null) && (str.strLength() > 0 && (this.strLength() >= str.strLength()))) {
			int i = begin;
			int j = 0;
			int slen = this.strLength();          // strLength()函数返回的数组下标最大值
			int tlen = str.strLength();
			while ((i < slen) && (j < tlen)) {
				if (this.charAt(i) == str.charAt(j)) {
					i++;
					j++;
				} else {
					i = i - j + 1;         // 注意：i退回到主串上次匹配首位的下一位
					j = 0;                 // j回退到子串的首位
				}
			}
			if (j >= tlen) {    // 全部匹配成功
				return i - tlen;           // 返回 子串在主串中的下标
			} else {
				return -1;
			}
		} else {
			throw new Exception("主串为空或者子串为空或者子串长度大于主串长度");
		}
	}
	
	// BF算法比较次数统计
	public int indexOf_BFCount(StrMatchingINF str, int begin) throws Exception {
			int i = begin;
			int j = 0;
			int count = 0;
			int slen = this.strLength();
			int tlen = str.strLength();
			while ((i < slen) && (j < tlen)) {
				if (this.charAt(i) == str.charAt(j)) {
					i++;
					j++;
				} else {
					i = i - j + 1;         // 注意：i退回到主串上次匹配首位的下一位
					j = 0;                 // j回退到子串的首位
				}
				count ++;
				if (j >= tlen)              // 全部匹配成功
					return count;           // 返回 子串在主串中的下标
			}
		return count;
	}
	
	
	/************************************KMP模式匹配算法***********************************************/
	// KMP模式匹配算法
	public int indexOf_KMP(StrMatchingINF str, int begin) throws Exception {
		int[] next = get_Next(str);
		int i = begin;
		int j = 0;
		while (i < this.strLength() && j < str.strLength()) {
			if (j == -1 || this.charAt(i) == str.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		if (j < str.strLength()) {
			return -1;
		} else {
			return (i - str.strLength());
		}
	}
	
	private int[] get_Next(StrMatchingINF T) throws Exception {
		int[] next = new int[T.strLength()];
		int j = 1;  // 注意这里，只给定了数组下标为0和1的初始值，所以要令j从1开始，和get_Nextval()区分开
		int k = 0;
		next[0] = -1;
		next[1] = 0;
		while (j < T.strLength() - 1) {
			if (T.charAt(j) == T.charAt(k)) {
				next[j + 1] = k + 1;
				j++;
				k++;
			} else if (k == 0) {
				next[j + 1] = 0;
				j++;
			} else {
				k = next[k];
			}
		}
		return next;
	}
	
	public int indexOf_KMPCount(StrMatchingINF str, int begin) throws Exception {
		int[] next = get_Next(str);
		int count = 0;
		int i = begin;
		int j = 0;
		while (i < this.strLength() && j < str.strLength()) {
			if (j == -1 || this.charAt(i) == str.charAt(j)) {
				i++;
				j++;
			} else if (j == 0) {
				i++;
			} else {
				j=next[j];
			}
			count++;
		}
		return count;
	}

	/*********************************改进的KMP模式匹配算法**********************************************/
	public int indexOf_ImprovedKMP(StrMatchingINF str, int begin) throws Exception {
		int[] next = get_NextVal(str);
		int i = begin;
		int j = 0;
		while (i < this.strLength() && j < str.strLength()) {
			if (j == -1 || this.charAt(i) == str.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		if (j < str.strLength()) {
			return -1;
		} else {
			return (i - str.strLength());
		}
	}
	
	private int[] get_NextVal(StrMatchingINF T) throws Exception {
		int[] nextval = new int[T.strLength()];
		int j = 0;          // 注意这里，只给定了数组下标为0的初始值，所以要令j从0开始，和get_Next()区分开
		int k = -1;
		nextval[0] = -1;
		while (j < T.strLength() - 1) {
			if (k == -1 || T.charAt(j) == T.charAt(k)) {
				j++;
				k++;
				if (T.charAt(j) != T.charAt(k)) 
					nextval[j] = k;
				else 
					nextval[j] = nextval[k];
				
			} else 
				k = nextval[k];
			
		}
		return nextval;
	}
	
	public int indexOf_ImprovedKMPCount(StrMatchingINF str, int begin) throws Exception {
		int[] next = get_NextVal(str);
		int i = begin;
		int j = 0;
		int count = 0;
		while (i < this.strLength() && j < str.strLength()) {
			if (j == -1 || this.charAt(i) == str.charAt(j)) {
				i++;
				j++;
			} else if (j == 0) {
				i++;
			}{
				j = next[j];
			}
			count++;
		}
		return count;
	}
	
	/***********************************************************************/
	
	public static void main(String[] args) throws Exception {
		StrMatching str1 = new StrMatching("aaaaaaab");
		StrMatching str2 = new StrMatching("aaaab");
		System.out.println("采用BF算法，   主串和子串在主串数组下标为" + str1.indexOf_BF(str2, 0) + "的位置首次匹配成功");
		System.out.println("采用KMP算法，主串和子串在主串数组下标为" + str1.indexOf_KMP(str2, 0) + "的位置首次匹配成功");
		System.out.println("采用改进的KMP算法，主串和子串在主串数组下标为" + str1.indexOf_ImprovedKMP(str2, 0) + "的位置首次匹配成功");
		System.out.println("采用BF算法，   比较次数为: " + str1.indexOf_BFCount(str2, 0));
		System.out.println("采用KMP算法，比较次数为: " + str1.indexOf_KMPCount(str2, 0));
		System.out.println("采用改进的KMP算法，比较次数为: " + str1.indexOf_ImprovedKMPCount(str2, 0));
		
		System.out.println();	
		
		StrMatching str3 = new StrMatching("aaaaaaaa");
		StrMatching str4 = new StrMatching("aaaab");
		System.out.println("采用BF算法，   主串和子串在主串数组下标为" + str3.indexOf_BF(str4, 0) + "的位置首次匹配成功");
		System.out.println("采用KMP算法，主串和子串在主串数组下标为" + str3.indexOf_KMP(str4, 0) + "的位置首次匹配成功");
		System.out.println("采用改进的KMP算法，主串和子串在主串数组下标为" + str3.indexOf_ImprovedKMP(str4, 0) + "的位置首次匹配成功");
		System.out.println("采用BF算法，   比较次数为: " + str3.indexOf_BFCount(str4, 0));
		System.out.println("采用KMP算法，比较次数为: " + str3.indexOf_KMPCount(str4, 0));
		System.out.println("采用改进的KMP算法，比较次数为: " + str3.indexOf_ImprovedKMPCount(str4, 0));
		
		System.out.println();

		StrMatching str5 = new StrMatching("00000000000000000000000000000000000000000000000001");
		StrMatching str6 = new StrMatching("0000000001");
		System.out.println("采用BF算法，   主串和子串在主串数组下标为" + str5.indexOf_BF(str6, 0) + "的位置首次匹配成功");
		System.out.println("采用KMP算法，主串和子串在主串数组下标为" + str5.indexOf_KMP(str6, 0) + "的位置首次匹配成功");
		System.out.println("采用改进的KMP算法，主串和子串在主串数组下标为" + str5.indexOf_ImprovedKMP(str6, 0) + "的位置首次匹配成功");
		System.out.println("采用BF算法，   比较次数为: " + str5.indexOf_BFCount(str6, 0));
		System.out.println("采用KMP算法，比较次数为: " + str5.indexOf_KMPCount(str6, 0));
		System.out.println("采用改进的KMP算法，比较次数为: " + str5.indexOf_ImprovedKMPCount(str6, 0));
		
		System.out.println();

		StrMatching str7 = new StrMatching("bbbcbbbbc");
		StrMatching str8 = new StrMatching("bbbbc");
		System.out.println("采用BF算法，   主串和子串在主串数组下标为" + str7.indexOf_BF(str8, 0) + "的位置首次匹配成功");
		System.out.println("采用KMP算法，主串和子串在主串数组下标为" + str7.indexOf_KMP(str8, 0) + "的位置首次匹配成功");
		System.out.println("采用改进的KMP算法，主串和子串在主串数组下标为" + str7.indexOf_ImprovedKMP(str8, 0) + "的位置首次匹配成功");
		/* i从0到4，每一趟的次数为：4 , 3 , 2 , 1 , 5 */
		System.out.println("采用BF算法，   比较次数为: " + str7.indexOf_BFCount(str8, 0));
		/* next[j]    为-1、0、1、2、3 */
		/* i从0到4，每一趟的次数为：4 , 1 , 1 , 1 , 5 */
		System.out.println("采用KMP算法，比较次数为: " + str7.indexOf_KMPCount(str8, 0));
		/* nextval[j] 为-1、0、 0、0、3*/
		/* 由于t0、t1、t2都与t3相等，却s3不等于t3，所以s3不等于t0、t1、t2，所以没有必要让s3和t0、t1、t2比较*/
		/* i从0到4，每一趟的次数为：4 , 0 , 0 , 0 , 5 */
		System.out.println("采用改进的KMP算法，比较次数为: " + str7.indexOf_ImprovedKMPCount(str8, 0));

	}

}
