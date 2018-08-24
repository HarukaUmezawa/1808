package main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

import sub.ScanCheck;

public class LandPrice{
	public static void main(String[] args) {
		int pointA_x = 0; // 地点Aの位置X
		int pointA_y = 0; // 地点Aの位置Y
		int k = 0; // 近傍法で計算対象とする値(基準値)の数
		int n = 0; // 既知の地価の数
		int num = 0;
		Scanner sc = new Scanner(System.in);
		TreeMap<Double, Integer> map = new TreeMap<>();

		/** 各入力値の受け取り
		   * ScanCheckクラスでの入力チェック
		   */
		ScanCheck check = new ScanCheck();
		try {
			System.out.println("地価を予測したい地点Aの位置を入力してください");
			pointA_x = sc.nextInt();
			pointA_y = sc.nextInt();
			check.check1(pointA_x, pointA_y);

			System.out.println("基準値の個数(k)を入力してください");
			k = sc.nextInt();
			check.check2(k);

			System.out.println("地価が既知である地点の個数(n)を入力してください");
			n = sc.nextInt();
			check.check3(n, k);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("プログラムを終了します");
			sc.close();
			System.exit(0);
		}

		System.out.println("地価が既知である地点の位置と地価を入力してください");
		/** 既知の数分、位置と地価の入力値を受け取る
		  * ScanCheckクラスでの入力チェック
		  * 地点AからK点までの距離計算
		  * 距離をキーとしてTreeMapへ格納 → 自動的に昇順(距離が近い順)
		  */

		for (int i = 0; i < n; i++) {
			sc = new Scanner(System.in);
			int x = sc.nextInt();
			int y = sc.nextInt();
			int p = sc.nextInt();

			try {
				check.check4(x, y, p);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("プログラムを終了します");
				sc.close();
				System.exit(0);
			}
			double distance = Math.sqrt((pointA_x - x) * (pointA_x - x) + (pointA_y - y) * (pointA_y - y));
			map.put(distance, p);
		}

		/** TreeMapのキーをリスト化
		  * リストからk個のキーを取り出し、それを元にTreeMapから値(地価)を取り出す
		  * numへ加算
		  */
		ArrayList<Double> list = new ArrayList<>(map.keySet());
		for (int j = 0; j < k; j++) {
			num += map.get(list.get(j));
		}

		// 地価の平均値計算
		BigDecimal bd1 = new BigDecimal(num);
		BigDecimal bd2 = new BigDecimal(k);
		BigDecimal sum = bd1.divide(bd2, 0, RoundingMode.HALF_UP);
		System.out.println(sum);
	}
}
