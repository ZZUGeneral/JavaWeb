package test;

public class test {
	public static void main(String[] args) {
		superEggDrop(4, 1);
	}

	public static int superEggDrop(int K, int N) {
		int[] dp = new int[K + 1];
		int step = 0;
		for (; dp[K] < N; step++) {
			for (int i = K; i > 0; i--) {
				dp[i] += (1 + dp[i - 1]);
				System.out.print(dp[i] + " ");
			}
			System.out.println("");
		}

		return step;
	}
}
