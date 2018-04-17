import java.util.*;
import java.io.*;

public class TestBinarySearch {

	public static void main(String[] args) {
		ArrayList<Double> c = creatArrayList();
		pt(c);
		Collections.sort(c);
		while(true) {
			System.out.println("��������ҩ���ҵ���ֵ�����������ӡtrue�����������ӡfalse...�˳���Ѱ���롰exit��...");
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
				System.out.println("���벻��ȷ������������...");
				continue;
			}
		}
		
	}

	private static String search(ArrayList<Double> c, double temp) {
		int min = 0, max = c.size(), flag;
//		boolean bl = false;
		String s = "�Բ���������ҵ����ݲ�����������...";
		while(min <= max) {
			flag = (min + max) / 2;
			if(temp == c.get(flag)) {
				s = "���ҳɹ��������ҵ�������������" + (flag + 1) + "��λ��";
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
/*		System.out.println("�������������������...double���͵����֣����롰#����������...");
		while(true) {
			try {
				c.add(s.nextDouble());
			} catch (Exception e) {
				System.out.println("ֹͣ����...");
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
		System.out.println("��ӡ�������������ֵ...");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}

