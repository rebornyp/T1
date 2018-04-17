import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class TestStack {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String str = "";
		try {
			while((str = br.readLine()) != null) {
				s.push((int)Double.parseDouble(str));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch(NumberFormatException e) {
			System.out.println("抱歉我们转换不了您的输入");
		} finally {
			System.out.print(str);
			while(!s.isEmpty()) {
				System.out.println(s.pop());
			}
		}
		
	}

}
