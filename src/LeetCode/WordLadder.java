package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		String[] str = {"hot","dot","dog","lot","log", "cog"};
		List<String> list = new ArrayList<String>();
		list.addAll(Arrays.asList(str));
		System.out.println(list);
		String start = "hit", end = "cog";
		System.out.println(ladderLength(start, end, list));
		System.out.println(findLadders(start, end, list));
	}

	private static List<List<String>> findLadders(String start, String end, List<String> list) {
		List<List<String>> total = new ArrayList<List<String>>();
		if(!list.contains(end)) return total;
		if(start.equals(end)) {
			List<String> temp = new ArrayList<String>();
			temp.add(start);
			temp.add(end);
			total.add(temp);
			return total;
		}
		Set<String> wordList = new HashSet<String>();
		for(String temp : list)
			wordList.add(temp);
		
		return Ladders(start, end, wordList, new ArrayList<String>(), total);
	}

	public static List<List<String>> Ladders(String start, String end, Set<String> set, List<String> list, List<List<String>> total) {
        return null;
    }
	
	private static int ladderLength(String start, String end, List<String> wordList) {
		Set<String> list = new HashSet<String>();
		for(String temp : wordList)
			list.add(temp);
		if(start.equals(end)) return 1;
		if(!list.contains(end)) return 0;
		int level = 1, len = start.length();
		int curNum = 0, lastNum = 1;
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		Set<String> set = new HashSet<String>();
		set.add(start);
		while(!queue.isEmpty()) {
			String str = queue.poll();
			lastNum --;
			for(int i=0; i<len; i++) {
				char[] strChar = str.toCharArray();
				for(char c = 'a'; c <= 'z'; c++) {
					strChar[i] = c;
					String temp = new String(strChar);
					if(temp.equals(end))
						return level+1;
					if(list.contains(temp) && !set.contains(temp)) {
						queue.add(temp);
						curNum ++;
						set.add(temp);
					}
				}
			}
			if(lastNum == 0) {
				lastNum = curNum;
				curNum = 0;
				level ++;
			}
		}
		return 0;
	}

}
