
public class ArithmeticExpression {

	public static void arithmeticExpressions(int[] arr) {
		int vsf = arr[0];
		String expsp = arr[0] + "";
		arithmeticExpressions(arr, vsf, expsp, 1);
		return;
	}

	static boolean found = false;

	public static void arithmeticExpressions(int[] arr, int vsf, String expsf, int vidx) {
		if (vidx == arr.length) {
			if (vsf % 101 == 0 && found == false) {
				System.out.println(expsf);
				found = true;
			}
			return;
		}

		vsf += arr[vidx];
		arithmeticExpressions(arr, vsf, expsf + "+" + arr[vidx], vidx + 1);
		vsf -= arr[vidx];

		vsf -= arr[vidx];
		arithmeticExpressions(arr, vsf, expsf + "-" + arr[vidx], vidx + 1);
		vsf += arr[vidx];

		vsf *= arr[vidx];
		arithmeticExpressions(arr, vsf, expsf + "*" + arr[vidx], vidx + 1);
		vsf /= arr[vidx];

	}
}
