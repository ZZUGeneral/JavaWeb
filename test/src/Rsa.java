
/**
 * 
 * @author YHL
 *��ʵ��RSA:
 * 			1. Ѱ������������p��q,��n = p * q;
 * 			2. ����r = f(n) = (p - 1) * (q - 1)
 * 			3. ѡ��һ��С��r������r���ʵ�����e,һ��Ϊ10001����65537
 * 			4. ����e��ģ��Ԫ��d,��(e * d) % r ����� 1 
 * 			5. C = M ** e % n
 * 			6. M = C ** d % n
 * 			7. ����n,˽��d
 */
public class Rsa {
	public static void main(String[] args) {
		System.out.print("���ܺ���Ϊ: ");
		System.out.println(encodeByRsa(456, 1147, 301));
		System.out.print("���ܺ���Ϊ: ");
		System.out.println(decodeByRsa(53, 1147, 301));
	}

	/**
	 * 
	 * @param data  ���ܵ�����
	 * @param n   ģ��
	 * @param e   ָ��
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
	 * @param data  ���ܵ�����
	 * @param n   ģ��
	 * @param e   ָ��
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
	  *  ��� e ����Ԫ
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
	 * �ֽ�����n,�õ��Ľ��Ϊ��������
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
