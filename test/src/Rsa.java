
/**
 * 
 * @author YHL
 *真实的RSA:
 * 			1. 寻找两个大素数p和q,令n = p * q;
 * 			2. 计算r = f(n) = (p - 1) * (q - 1)
 * 			3. 选择一个小于r并且与r互质的整数e,一般为10001或者65537
 * 			4. 计算e的模反元素d,即(e * d) % r 恒等于 1 
 * 			5. C = M ** e % n
 * 			6. M = C ** d % n
 * 			7. 公开n,私有d
 */
public class Rsa {
	public static void main(String[] args) {
		System.out.print("加密后结果为: ");
		System.out.println(encodeByRsa(456, 1147, 301));
		System.out.print("解密后结果为: ");
		System.out.println(decodeByRsa(53, 1147, 301));
	}

	/**
	 * 
	 * @param data  加密的数据
	 * @param n   模数
	 * @param e   指数
	 * @return
	 */
	private static int encodeByRsa(int data, int n, int e) {
		int rst = 1;
		for (int i = 0; i < e; i++) {
			rst = data * rst % n;
		}
		return rst;
	}
	/**
	 * 
	 * @param data  加密的数据
	 * @param n   模数
	 * @param e   指数
	 * @return
	 */
	private static int decodeByRsa(int data, int n, int e) {
		int rst = 1;
		int d = reverse(e, n);
		for (int i = 0; i < d; i++) {
			rst = data * rst % n;
		}
		return rst;
	}
	/**
	  *  求解 e 的逆元
	 * @param e
	 * @param n
	 * @return
	 */
	private static int reverse(int e, int n) {
		int[] pq = factor(n);
		for (int i = 1; i < e; i++) {
			if (e * i % ((pq[0] - 1) * (pq[1] - 1)) == 1) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * 分解整数n,得到的结果为两个素数
	 * @param n
	 * @return
	 */
	private static int[] factor(int n) {
		int[] rst = new int[2];
		for (int i = 2; i < n / 2; i++) {
			if (n % i == 0) {
				rst[0] = i;
				rst[1] = n / i;
				break;
			}
		}
		return rst;
	}
}
