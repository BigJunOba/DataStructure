package bigjun.iplab.hashTable;
/**
 * 散列表查找，通过除留取余法定义哈希函数，同时通过链地址法解决冲突的问题
 * 包括插入、删除、查找和遍历等方法
 * Java中的hashCode()方法就是根据一定的规则将与对象相关的信息映射成一个数值，这个数值称作为散列值
 * @param <E>  泛型，可以是int，String等其他类型
 */
public class HashTable<E> {
	
	public LinkList[] table;						// 哈希表的对象数组
	
	public HashTable(int size) {					// 构造和要插入的数组长度一致的单链表数组
		this.table = new LinkList[size];
		for (int i = 0; i < table.length; i++) {
			table[i] = new LinkList();				// 构造空单链表
		}
	}
	
	public int hash(int key) {						// 除留取余法哈希函数，除数是哈希表的长度
		return key % table.length;
	}
	
	public void insert(E elem) throws Exception {	// 向哈希表中插入指定的数据元素
		int key = elem.hashCode();					// 计算每个对象的散列值并返回
		System.out.println(elem + "的hashCode值为:  " + key);
		int i = hash(key);							// 根据计算得到的int数值计算哈希地址
		table[i].insert(0, elem);					// 向对应的单链表中插入指定的数据元素
	}
	
	public void printHashTable() {					// 遍历哈希表中各个单链表的数据元素
		System.out.println("遍历散列表得到的结果为: ");
		for (int i = 0; i < table.length; i++) {
			System.out.print("数组下标为" + i + "的table遍历得到: ");
			table[i].listTraverse();				// 遍历单链表
		}
	}
	
	public Object search(E elem) throws Exception {	// 在哈希表中找到指定对象，若查找成功，返回对象在单链表中的索引，否则，返回null
		int key = elem.hashCode();
		int i = hash(key);
		int index = table[i].indexof(elem);
		if (index >= 0) {
			return table[i].getElem(index);
		} else {
			return null;
		}
	} 
	
	public boolean contain(E elem) throws Exception {	// 判断哈希表中是否包含指定对象
		return this.search(elem) != null;
	}
	
	public boolean remove(E elem) throws Exception {	// 在哈希表中删除指定对象，删除成功返回true，否则返回false
		int key = elem.hashCode();
		int i = hash(key);
		int index = table[i].indexof(elem);
		if (index >= 0) {
			table[i].delete(index);;
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		int[] key = {12,67,56,16,25,37,22,29,15,47,48,34};
		HashTable<Integer> hTable = new HashTable<>(key.length);
		for (int i = 0; i < key.length; i++) {
			hTable.insert(key[i]);
		}
		System.out.println("**************************************");
		hTable.printHashTable();
		System.out.println("**************************************");
		String[] str = {"A", "B","C","D","Lian","Jiang","hhh"};
		HashTable<String> strTable = new HashTable<>(str.length);
		for (int i = 0; i < str.length; i++) {
			strTable.insert(str[i]);
		}
		System.out.println("**************************************");
		strTable.printHashTable();
		System.out.println("散列表中是否包含“Lian”? : " + strTable.contain("Lian"));
		System.out.println("**************************************");
		System.out.println("是否删除“Lian”成功: " + strTable.remove("Lian"));
		System.out.println("**************************************");
		strTable.printHashTable();
		System.out.println("散列表中是否包含“Lian”? : " + strTable.contain("Lian"));
	}
}
