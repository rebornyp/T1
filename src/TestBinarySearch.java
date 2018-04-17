import java.util.*;
import java.io.*;

public class TestBinarySearch {

	public static void main(String[] args) {
		ArrayList<Double> c = creatArrayList();
		pt(c);
		Collections.sort(c);
		while(true) {
			System.out.println("请输入续药查找的数值，若存在则打印true，不存在则打印false...退出搜寻输入“exit”...");
			BufferedInputStream bsr = new BufferedInputStream(System.in);
			InputStreamReader isr = new InputStreamReader(bsr);
			BufferedReader br = new BufferedReader(isr);
			double temp = 0;
			try {
				String s = br.readLine();
				if(s.equals("exit"))
					break;
				temp = Double.parseDouble(s);
				System.out.println(search(c, temp));
			} catch (NumberFormatException | IOException e) {
				System.out.println("输入不正确，请重新输入...");
				continue;
			}
		}
		
	}

	private static String search(ArrayList<Double> c, double temp) {
		int min = 0, max = c.size(), flag;
//		boolean bl = false;
		String s = "对不起，您想查找的数据不存在容器里...";
		while(min <= max) {
			flag = (min + max) / 2;
			if(temp == c.get(flag)) {
				s = "查找成功，您查找的数据在容器第" + (flag + 1) + "个位置";
				break;
			} else if(temp > c.get(flag))
				min = flag + 1;
			else
				max = flag - 1;
		}
		return s;
	}
	
	/*private static boolean search(ArrayList<Double> c, double temp) {
		return mainSearch(c, temp, 0, c.size() - 1);
	}

	private static boolean mainSearch(ArrayList<Double> c, double temp, int min, int max) {
		if(min > max)
			return false;
		else if(temp == c.get((min + max) / 2))
			return true;
		else {
			mainSearch(c, temp, min, (min + max) / 2 - 1);
			mainSearch(c, temp, (min + max) / 2 - 1, max);
		}
		return false;
	}*/

	private static ArrayList<Double> creatArrayList() {
//		Scanner s = new Scanner(System.in);
		ArrayList<Double> c = new ArrayList<Double>();
/*		System.out.println("请随便输入任意数量的...double类型的数字，输入“#”结束输入...");
		while(true) {
			try {
				c.add(s.nextDouble());
			} catch (Exception e) {
				System.out.println("停止输入...");
				break;
			}
		}*/
		int i = 0;
		int k = 0;
		Random r = new Random();
		while(i < 20) {
			k = r.nextInt(100);
			c.add((double)k);
			i++;
		}
		
		return c;
	}

	private static void pt(ArrayList<Double> c) {
		Iterator<Double> it = c.iterator();
		System.out.println("打印所有容器里的数值...");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}

