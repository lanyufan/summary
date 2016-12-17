package com.lan.yu.fan;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.*;
import java.util.*;

public class Zong {

	/**
	 * 9*9
	 */
	public void test01() {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + "*" + j + "=" + (i * j) + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * 闰年
	 */
	public void test02(int a) {
		if ((a % 4 == 0 && a % 100 != 0) || a % 400 == 0) {
			System.out.println(a + "年是闰年");
			return;
		}
		System.out.println(a + "年不是闰年");
	}

	/**
	 * 10的阶乘
	 */
	public static long test03(int x) {
		if (x <= 1)
			return 1;
		else
			return x * test03(x - 1);
	}
	// public static void main(String[] args) {
	// for (int counter = 0; counter <= 10; counter++){
	// System.out.printf("%d! = %d\n", counter,test3(counter));
	// }
	// }

	/**
	 * 获取当前时间
	 */
	public void test04() {

		SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间

		sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记

		Date date = new Date();// 获取当前时间

		System.out.println("现在时间：" + sdf.format(date)); // 输出已经格式化的现在时间（24小时制）
	}

	/**
	 * 数组排序以及元素查找
	 */
	public void test05() {

		int array[] = { 2, 5, -2, 6, -3, 8, 0, -7, -9, 4 };/* 定义数组 */

		/*
		 * 数组中的Arrays类(默认排序：从小到大) sort为Arrays类中的一种方法 array为定义的参数
		 */
		Arrays.sort(array);/* 重新排序 */

		printArray("数组排序结果为", array);/* 输出排序后的数组 */

		int index = Arrays.binarySearch(array, 2);/* 元素2在数组中的位置 */

		System.out.println("元素 2  在第 " + index + " 个位置");

	}

	// 数组排序
	private static void printArray(String message, int array[]) {

		System.out.println(message + ": [length: " + array.length + "]");/* 数组长度 */

		// 按照从小到大的顺序依次输出
		for (int i = 0; i < array.length; i++) {
			if (i != 0) {
				System.out.print(", ");
			}
			System.out.print(array[i]);
		}
		System.out.println();
	}

	/**
	 * 数组转集合 List<String> list = Arrays.asList(name);
	 */
	public void test06() {

		int n = 10;// 定义一个长度(下标)

		String[] name = new String[n];// 定义一个数组

		/* 循环出数组里边每个数 */
		for (int i = 0; i < n; i++) {

			name[i] = String.valueOf(i);// 返回每个值
		}

		// 把数组(String)转换成集合(List)
		List<String> list = Arrays.asList(name);

		System.out.println();// 输出

		for (String li : list) {
			String str = li;
			System.out.print(str + " ");
		}
	}

	/**
	 * List元素转换 Collections.replaceAll();
	 */
	public void test07() {

		// 定义一个list集合
		// split 分离的意思
		List<String> list = Arrays.asList("one Two three Four five six one three Four".split(" "));

		// 输出list
		System.out.println("List :" + list);

		// 把one全部换成aaa
		Collections.replaceAll(list, "one", "aaa");

		// 输出修改后
		System.out.println("replaceAll: " + list);
	}

	/**
	 * 判断子集合在原集合中的位置 indexOfSubList lastIndexOfSubList
	 */
	public void test08() {

		// 定义一个list集合
		List<String> list = Arrays.asList("one Two three Four five one three Four six".split(" "));

		// 输出
		System.out.println("list:" + list);

		// 定义一个子集合
		List<String> sublist = Arrays.asList("three Four".split(" "));

		// 输出子集合
		System.out.println("子列表 :" + sublist);

		// indexOfSubList 查看子集合在原集合中第一次出现的位置
		System.out.println("indexOfSubList: " + Collections.indexOfSubList(list, sublist));

		// lastIndexOfSubList 查看子集合在原集合中最后一次出现的位置
		System.out.println("lastIndexOfSubList: " + Collections.lastIndexOfSubList(list, sublist));
	}

	/**
	 * 查找List中的最大值和最小值 Collections.max Collections.min
	 */
	public void test09() {

		// 定义一个list集合
		List<String> list = Arrays.asList("1 2 3 4 5 6 1 3 4".split(" "));

		// 输出list集合
		System.out.println(list);

		// 输出最大值和最小值
		System.out.println("最大值: " + Collections.max(list));
		System.out.println("最小值: " + Collections.min(list));
	}

	/**
	 * LinkedList链表 修改链表中的指定元素 officers.set()
	 */
	public void test10() {

		// LinkedList链表
		LinkedList<String> officers = new LinkedList<String>();

		// add(添加)元素并输出组成的集合
		officers.add("1");
		officers.add("2");
		officers.add("3");
		officers.add("4");
		officers.add("5");
		System.out.println(officers);

		// 把下标为2的元素改变并输出改变之后的集合
		officers.set(2, "6");
		System.out.println(officers);
	}

	/**
	 * 使用 Collections 类 Collections.shuffle() 方法 打乱集合元素的顺序：
	 */
	public void test11() {

		List<Integer> list = new ArrayList<Integer>();

		// 集合开始的元素顺序
		for (int i = 0; i < 10; i++)
			// 依次排序
			list.add(new Integer(i));
		System.out.println("打乱前:");
		System.out.println(list);

		// 循环次数（打乱的次数）
		for (int i = 1; i < 6; i++) {
			System.out.println("第" + i + "次打乱：");
			Collections.shuffle(list);
			System.out.println(list);
		}
	}

	/**
	 * 使用 Collection 类的 iterator() 方法来遍历集合
	 */
	public void test12() {

		HashMap<String, String> hMap = new HashMap<String, String>();

		// 添加元素
		hMap.put("1", "1st");
		hMap.put("2", "2nd");
		hMap.put("3", "3rd");

		Collection<String> cl = hMap.values();

		Iterator<String> itr = cl.iterator();

		while (itr.hasNext()) {

			System.out.println(itr.next());

		}
	}

	/**
	 * do...while求1-100的整数之和
	 */
	public void test13() {

		// 定义int
		int li = 100;
		int i = 1;
		int sum = 0;

		// 从1-100相加
		do {
			sum = sum + i;
			i++;
		} while (i <= li);
		System.out.println("sum=" + sum);
	}

	/**
	 * LinkedList开头和结尾添加元素
	 */
	public void test14() {

		LinkedList<String> list = new LinkedList<String>();

		// 增加集合元素
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		System.out.println(list);

		// 开头加0
		list.addFirst("0");
		System.out.println(list);

		// 结尾加6
		list.addLast("6");
		System.out.println(list);
	}

	/**
	 * indexOf 第一次位置 lastIndexOf 最后一次位置
	 */
	public void test15() {

		LinkedList<String> list = new LinkedList<String>();

		// 添加集合中的元素，可重复
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("2");

		/*
		 * 输出元素出现位置 indexOf 第一次位置 lastIndexOf 最后一次位置
		 */
		System.out.println("元素 2 第一次出现的位置：" + list.indexOf("2"));
		System.out.println("元素 2 最后一次出现的位置：" + list.lastIndexOf("2"));
	}

	/**
	 * LinkedList中 获取链表的第一个和最后一个元素
	 */
	public void test16() {

		LinkedList<String> list = new LinkedList<String>();

		// 添加集合中的元素
		list.add("100");
		list.add("200");
		list.add("300");
		list.add("400");
		list.add("500");

		/*
		 * 输出 getFirst 第一个元素 getLast 最后一个元素
		 */
		System.out.println("链表的第一个元素是：" + list.getFirst());
		System.out.println("链表的最后一个元素是：" + list.getLast());
	}

	/**
	 * LinkedList 用clear删除指定下标的元素
	 */
	public void test17() {

		LinkedList<String> list = new LinkedList<String>();

		// 添加集合的元素并输出
		list.add("1");
		list.add("8");
		list.add("6");
		list.add("4");
		list.add("5");
		System.out.println(list);

		// 删除下标为2-4的元素（前包后不包），并输出
		list.subList(2, 4).clear();
		System.out.println(list);
	}

	/**
	 * 创建文件 createNewFile
	 */
	public void test18() {
		// 路径
		String path = "F:/myfile.txt";
		// File类
		File file = new File(path);
		// 创建
		try {
			boolean mk = file.createNewFile();
			System.out.println(mk);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// try{
		// //路径，File类
		// File file = new File("F:/myfile.txt");
		// if(file.createNewFile())
		// System.out.println("文件创建成功！");
		// else
		// System.out.println
		// ("出错了，改文件已经存在。");
		// }
		// catch(IOException ioe) {
		// ioe.printStackTrace();
		// }
	}

	/**
	 * 删除文件 delete
	 */
	public void test19() {
		// 路径
		String path = "F:/myfile.txt";
		// File类
		File file = new File(path);
		// 删除
		boolean del = file.delete();
		System.out.println(del);
	}

	/**
	 * 创建文件夹 mkdirs
	 */
	public void test20() {
		// 路径
		String path = "F:/aaa/bbb/ccc";
		// File类
		File file = new File(path);
		// 创建
		boolean mk = file.mkdirs();
		System.out.println(mk);
	}

	/**
	 * 删除文件夹 无法从根目录上删除 必须从里往外层层删除
	 */
	public void test21() {
		// 路径
		String path = "F:/aaa";
		// File类
		File file = new File(path);
		// 删除
		boolean del = file.delete();
		System.out.println(del);
	}

	/**
	 * 同时创建多级文件夹以及文件
	 */
	public static final String ROOT = "F:/d";

	public static final String D1 = ROOT + File.separator + "d1";
	public static final String D2 = ROOT + File.separator + "d2";

	public static final String D11 = D1 + File.separator + "d11";
	public static final String D12 = D1 + File.separator + "d12";
	public static final String D21 = D2 + File.separator + "d21";
	public static final String D22 = D2 + File.separator + "d22";

	public static final String D1111 = D11 + File.separator + "d1111.txt";
	public static final String D1112 = D11 + File.separator + "d1112.txt";
	public static final String D1211 = D12 + File.separator + "d1211.txt";
	public static final String D1212 = D12 + File.separator + "d1212.txt";
	public static final String D2111 = D21 + File.separator + "d2111.txt";
	public static final String D2112 = D21 + File.separator + "d2112.txt";
	public static final String D2121 = D22 + File.separator + "d2121.txt";
	public static final String D2122 = D22 + File.separator + "d2122.txt";

	private String dirs[] = { D11, D12, D21, D22 };
	private String paths[] = { D1111, D1112, D1211, D1212, D2111, D2112, D2121, D2122 };

	public void test22() {
		// 先创建文件夹
		for (String string : dirs) {
			File file = new File(string);
			boolean str = file.mkdirs();
			System.out.println(str);
		}
		// 创建文件
		for (String string1 : paths) {
			File file = new File(string1);
			try {
				boolean cr = file.createNewFile();
				System.out.println(cr);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 整体遍历。
	 */
	public void test23(File f, String div) {
		// 参数检查
		if (!f.exists()) {
			System.out.println("文件不存在");
			return;
		}

		// 打印名字
		System.out.println(div + f.getName());
		div += "--";

		// 如果是文件夹，更近一层
		if (f.isDirectory()) {
			File[] children = f.listFiles();
			for (File child : children) {
				// 递归
				test23(child, div);
			}
		}
	}

	/**
	 * 整体删除。
	 */
	public void test24(String path) {
		// File
		File file = new File(path);
		if (!file.exists()) {
			System.out.println("文件不存在");
			return;
		}

		// 如果是文件夹，更进一层
		if (file.isDirectory()) {
			File[] children = file.listFiles();
			for (File child : children) {
				String p = child.getPath();
				// 递归
				test24(p);
			}
		}

		// 如果是文件，直接删除
		boolean b = file.delete();
		System.out.println("del:" + file.getName() + ":" + b);
	}

	/**
	 * 检测文件其余方法
	 */
	public void test25() {

		String path = "F:/aaa.txt";

		File file = new File(path);
		System.out.println(file.exists());// 文件是否存在
		// System.out.println(file.getName());//文件名称
		// System.out.println(file.getPath());//文件...?
		// System.out.println(file.isFile());//文件...?
		// System.out.println(file.isDirectory());
		// System.out.println(file.isHidden());
		// System.out.println(file.lastModified());
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// String date = sdf.format(file.lastModified());
		// System.out.println(date);
		// System.out.println(file.canRead());
		// System.out.println(file.canWrite());
		// System.out.println(file.length());
	}

	/**
	 * IO流
	 */
	/* 写入数据 */
	public void test26() {
		// 写入数据
		String data = "Hello World";
		// 路径
		String pata = "F:/aaa.txt";
		// File类
		File file = new File(pata);
		// IO流
		try {
			// 定义流
			FileOutputStream fos = new FileOutputStream(file);
			// 输入数据
			fos.write(data.getBytes());
			// 关闭流
			fos.close();
			// 输出
			System.out.println("输出成功");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 输出流 FileWriter write
	 */
	public void test27() {

		// 数据
		String data = "hello world";

		// 路径
		String path = "F:/aaa.txt";

		// File类
		File file = new File(path);

		// 输出流
		try {
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(data);

			fileWriter.close();
			System.out.println("输出完成");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 输入流 FileReader read
	 */
	public void test28() {
		String data = "";
		String path = "F:/aaa.txt";
		File file = new File(path);

		try {
			FileReader fileReader = new FileReader(file);

			// 定义数据空间的大小
			char[] cbuf = new char[128];
			// 定义数据的长度
			int len = 0;
			// 判断
			while ((len = fileReader.read(cbuf)) != -1) {

				// 精确控制数据所用的空间
				data = new String(cbuf, 0, len);
				System.out.println(data);
			}
			fileReader.read(cbuf);
			System.out.println("输入完成");

			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Buffer流(缓存流) 读取文本中的多行数据 bufferedReader包（fileReader）包path
	 * readLine把数据直接输到显示器上
	 */
	public void test29() {
		String path = "F:/aaa.txt";
		try {
			// FileReader fileReader = new FileReader(new File(path));
			// BufferedReader br = new BufferedReader(fileReader);

			BufferedReader br = new BufferedReader(new FileReader(path));

			String line1 = br.readLine();
			String line2 = br.readLine();
			String line3 = br.readLine();
			String line4 = br.readLine();

			System.out.println(line1 + "\n" + line2 + "\n" + line3 + "\n" + line4);

			br.close();
			// fileReader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 字节流
	 */
	// 输出
	public void test30() {
		// 定义数据
		String data = "nihao";
		// 文件
		String path = "F:/aaa.txt";
		// File类
		File file = new File(path);

		try {
			// 输出
			FileOutputStream fs = new FileOutputStream(file);

			// 写数据
			fs.write(data.getBytes());

			// 关闭流
			fs.close();
			System.out.println("输出完成");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 输入
	public void test31() {
		// 定义数据
		String data = "";
		// 文件
		String path = "F:/aaa.txt";
		// File类
		File file = new File(path);

		try {
			// 输入
			FileInputStream fr = new FileInputStream(file);
			// 读取数据长度
			System.out.println(fr.available());
			byte[] b = new byte[fr.available()];
			fr.read(b);

			// 收编数据
			data = new String(b);

			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 输出数据，显示输入的内容
		System.out.println(data);
	}

	/**
	 * 多次输出
	 */
	public void test32() {
		// 数据
		String[] data = { "白日依山尽", "黄河入海流", "欲穷千里目", "更上一层楼" };

		String path = "F:/aaa.txt";

		File file = new File(path);

		try {
			// 创建流
			FileOutputStream fo = new FileOutputStream(file);

			// 写出
			for (String s : data) {
				fo.write(s.getBytes());
				System.out.println("写出：" + s);
			}

			// 关闭流
			fo.close();
			System.out.println("写出完成");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 多次输入
	 */
	public void test33() {
		// 数据
		StringBuilder sb = new StringBuilder();
		// 路径
		String path = "F:/aaa.txt";
		// File类
		File file = new File(path);

		try {
			// 创建流
			FileInputStream fs = new FileInputStream(file);

			/*
			 * 读取的字数长度 3=一个汉字
			 */
			byte[] buf = new byte[15];

			// 判断内容是否被读完
			while (fs.read(buf) != -1) {
				//
				String s = new String(buf);
				// 打印内容
				System.out.println("read:" + s);
				// 文本数据转到显示屏上输出
				sb.append(s);
			}

			// 关闭流
			fs.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 输出内容，显示输入的内容
		System.out.println(sb.toString());
	}

	/**
	 * 文件内容复制
	 */
	public void test34(String str, String st) {
		/*
		 * 定义两个文件 判断文件是否为空
		 */
		if (str == null || st == null) {
			System.out.println("数据为空");
			return;
		}

		/* 复制过程 */

		// File类
		File filestr = new File(str);
		File filest = new File(st);

		try {

			// 创建两个流
			FileInputStream fi = new FileInputStream(filestr);
			FileOutputStream fo = new FileOutputStream(filest);

			/* 读写 */
			// 复制一次的数据长度
			byte[] b = new byte[15];
			// 定义长度
			int len = 0;
			// 定义整形循环次数
			int i = 0;
			// 判断数据是否已经循环读完
			while ((len = fi.read(b)) != -1) {
				// 数据的本身长度
				fo.write(b, 0, len);
				// 循环次数
				i++;
				// 输出读到的数据以及循环次数
				System.out.println(i + "次：" + len + "," + new String(b));
			}

			// 关闭流
			fi.close();
			fo.close();
			System.out.println("复制完成");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 字符流
	 */
	/* 输出一个字符 */
	public void test35() {
		// 创建一个char数据
		char ch = '我';
		// 路径
		String path = "F:/aaa.txt";
		// File类
		File file = new File(path);
		try {
			// 创建
			FileWriter fw = new FileWriter(file);

			// 写入
			fw.write(ch);

			// 关闭流
			fw.close();
			System.out.println("输出完成");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/* 输出多个字符 */
	public void test36() {
		// 创建一个char数组
		char[] ch = { '我', '要', '玩' };
		// 路径
		String path = "F:/aaa.txt";
		// File类
		File file = new File(path);

		try {
			// 创建流
			FileWriter fw = new FileWriter(file);

			// 输出
			fw.write(ch);

			// 关闭流
			fw.close();
			System.out.println("输出完成");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* 输出一个字符串 */
	public void test37() {
		// 定义一个字符串
		String str = "你若成功了，放屁都有道理 。 你若失败了，再有道理都是放屁。";
		// 路径
		String path = "F:/aaa.txt";
		// File类
		File file = new File(path);

		try {
			// 创建输出流
			FileWriter fw = new FileWriter(file);

			// 写入字符串
			fw.write(str);

			// 关闭流
			fw.close();
			System.out.println("输出完成");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/* 输入一个字符 */
	public void test38() {
		// 创建一个字符数据
		char ch = '0';
		// 路径
		String path = "F:/aaa.txt";
		// File类
		File file = new File(path);

		try {
			// 创建流
			FileReader fr = new FileReader(file);

			// 用整形接收读到的数据
			int c = fr.read();
			// 把读到的数据转成定义的char型
			ch = (char) c;

			// 输出读到的数据
			System.out.println(c);

			// 输出定义的char数据
			System.out.println(ch);

			// 关闭流
			fr.close();
			System.out.println("输入完成");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/* 输入多个字符 */
	public void test39() {
		// 定义一个长度为30的数组
		char[] cBuf = new char[30];
		// 路径
		String path = "F:/aaa.txt";
		// File类
		File file = new File(path);

		try {
			// 创建
			FileReader fr = new FileReader(file);

			// 定义的读取数据长度
			int count = fr.read(cBuf);

			// 单个输出读取到的文件内容
			System.out.println("read:" + count + ":" + Arrays.toString(cBuf));

			/* 文件中只有8个字符，所以读的个数就是8，字符数组后面的元素都是空的 */
			// new数组中的文件数据所需的空间
			String s = new String(cBuf, 0, count);
			// 输出读到的数据
			System.out.println("read:" + s);

			// 关闭流
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取指定主机的IP地址
	 */
	public void test40() {

		// 定义一个空地址
		InetAddress address = null;

		try {

			// 调用指定的主机IP
			address = InetAddress.getByName("www.baidu.com");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		// 输出主机名和主机地址
		System.out.println(address.getHostName() + "=" + address.getHostAddress());
	}

	/**
	 * 获取本机的IP和用户名
	 */
	public void test41() {

		try {
			// 获取本机IP
			InetAddress address = InetAddress.getLocalHost();

			// 输出本机的IP以及用户名
			System.out.println(address.getHostName() + "=" + address.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 输入年月，输出日历
	 */
	public void test42() {
		Scanner in = new Scanner(System.in);
		System.out.println("输入年份");
		int year = in.nextInt();
		System.out.println("输入月份");
		int month = in.nextInt();
		int sum = 0;
		int b;

		for (int i = 1; i <= month - 1; i++) {
			if (i == 2) {
				if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
					sum = sum + 29;
					// int a=29;
				} else {
					sum = sum + 28;
					// int a = 28;
				}
			} else {
				if (i == 4 || i == 6 || i == 9 || i == 11) {
					sum = sum + 30;
					// int a = 30;
				} else {
					sum = sum + 31;
					// int a = 31;
				}
			}
		}

		for (int i = 1900; i <= year - 1; i++) {
			if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
				sum += 366;
			} else {
				sum += 365;
			}
		}

		sum += 1;
		int a = sum % 7;
		System.out.println("日\t一\t二\t三\t四\t五\t六");
		for (int i = 1; i <= a; i++) {
			System.out.print("\t");
		}

		if (month == 2) {
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				b = 29;
			} else {
				b = 28;
			}
		} else {
			if (month == 4 || month == 6 || month == 9 || month == 11) {
				b = 30;
			} else {
				b = 31;
			}
		}
		for (int i = 1; i <= b; i++) {
			if (sum % 7 == 6) {
				System.out.print(i + "\n");
			} else {
				System.out.print(i + "\t");
			}
			sum++;
		}
	}
}
