package sub;

public class ScanCheck {

	public void check1(int pointA_x , int pointA_y) {
		if ((pointA_x < 0 && 1000 < pointA_x) || (pointA_y < 0 && 1000 < pointA_y)) {
			System.out.println("0から1000の数値を入力してください");
		}
	}

	public void check2(int k) {
		if (k < 1 && 100 < k) {
			throw new IllegalArgumentException("1から100の数値を入力してください");
		}
	}

	public void check3(int n, int k) {
		if (n < 2 && 100 < n) {
			throw new IllegalArgumentException("2から100の数値を入力してください");
		} else if (k > n) {
			throw new IllegalArgumentException("『k <= n』となるよう数値を入力してください");
		}
	}

	public void check4(int x, int y, int p) {
		if ((x < 0 && 1000 < x) || (y < 0 && 1000 < y) || (p < 1 && 100 < p)) {
			throw new IllegalArgumentException("『0 <= 位置 <= 1000』かつ『1 <= 地価 <= 100』となるよう数値を入力してください");
		}
	}
}
