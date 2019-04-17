import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
	public static void main(String[] arg) {
		String s = "pineapplepenapple";
		List<String> wordDict = new ArrayList<String>();
		String[] str = { "apple", "pen", "applepen", "pine", "pineapple" };
		wordDict = Arrays.asList(str);
		System.out.println(wordBreak(s, wordDict));

	}

	public static List wordBreak(String s, List<String> wordDict) {
		int len = s.length();
		boolean[] dp = new boolean[len + 1];
		dp[0] = true;
		int maxLen = 0;
		for (String str : wordDict)
			maxLen = maxLen >= str.length() ? maxLen : str.length();
		for (int i = 0; i <= len; i++) {
			for (int j = i - 1; j >= 0 && i - j <= maxLen; j--) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return null;
	}

}
