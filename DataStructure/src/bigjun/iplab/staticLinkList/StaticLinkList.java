package bigjun.iplab.staticLinkList;

public class StaticLinkList {

    private Element[] L = null; 
    private int MAXSIZE = 1000;//默认存储大小
    
    class Element{
        int data;
        int cur;
    }

    // 静态链表的初始化
    public StaticLinkList(){
        L = new Element[MAXSIZE];
        for (int i = 0; i < MAXSIZE-1; i++) {
            L[i] = new Element();
            L[i].cur = i+1;
        }
        L[MAXSIZE-1] = new Element();
        L[MAXSIZE-1].cur = 0;
    }
    
    public int listLength() {
    	int j = 0;
    	int i = L[MAXSIZE-1].cur;
    	while (i!=0) {
			i = L[i].cur;
			j++;
		}
    	return j;
    }
    
    // 获得静态链表中存放备用链表的第一个结点的下标，即第一个空闲空间的数组下标
    public int mallocSLL() {
    	int i = L[0].cur;
    	if (L[0].cur!=0) {  // 链表为空时，空闲元素的下标即为1
			L[0].cur = L[i].cur;
		}
    	return i;
    }
    
    public void listInsert(int i, int e) throws Exception{
        int k = MAXSIZE-1;
        if (i < 1 || i > listLength() + 1) 
			throw new Exception("超出范围，无法插入");
		int j = mallocSLL();
		if (j!=0) { 
			L[j].data = e;
			for (int l = 1; l <= i -1 ; l++) 
				k = L[k].cur;
			L[j].cur = L[k].cur;
			L[k].cur = j;
		}
    }
    
    public void freeSSL(int k) {
    	L[k].cur = L[0].cur;
    	L[0].cur = k;
    }
    
    public void listDelete(int i) throws Exception {
    	if (i < 1 || i > listLength()) 
    		throw new Exception("超出范围，无法删除");
		int k = MAXSIZE - 1 ;
		for (int l = 1; l <= i - 1; l++) 
			k = L[k].cur;
		int j = L[k].cur;
		L[k].cur = L[j].cur;
		freeSSL(j);
    }
    
    public void ListTraverse() {
    	int i = L[MAXSIZE-1].cur;
    	while (i!=0) {
			System.out.print(L[i].data + " ");
			i = L[i].cur;
		}
    }
    

    
    public static void main(String[] args) throws Exception {
    	StaticLinkList sList = new StaticLinkList();
    	sList.listInsert(1, 1);
    	System.out.print("此时链表的输出为:");
    	sList.ListTraverse();
    	System.out.println("此时链表的长度为" + sList.listLength());
    	
    	sList.listInsert(1, 2);
    	System.out.print("此时链表的输出为:");
    	sList.ListTraverse();
    	System.out.println("此时链表的长度为" + sList.listLength());
    	
    	sList.listInsert(1, 3);
    	System.out.print("此时链表的输出为:");
    	sList.ListTraverse();
    	System.out.println("此时链表的长度为" + sList.listLength());
    	
    	sList.listInsert(1, 4);
    	System.out.print("此时链表的输出为:");
    	sList.ListTraverse();
    	System.out.println("此时链表的长度为" + sList.listLength());
    	
    	sList.listInsert(1, 5);
    	System.out.print("此时链表的输出为:");
    	sList.ListTraverse();
    	System.out.println("此时链表的长度为" + sList.listLength());
    	
    	sList.listInsert(3, 6);
    	System.out.print("在第三个元素之前插入一个值6，此时链表的输出为:");
    	sList.ListTraverse();
    	System.out.println("此时链表的长度为" + sList.listLength());
    	
    	sList.listDelete(1);
    	System.out.print("删除第一个元素后，此时链表的输出为:");
    	sList.ListTraverse();
    	System.out.println("此时链表的长度为" + sList.listLength());
    	
    	sList.listDelete(3);
    	System.out.print("删除第三个元素后，此时链表的输出为:");
    	sList.ListTraverse();
    	System.out.println("此时链表的长度为" + sList.listLength());
	}
    
    
}