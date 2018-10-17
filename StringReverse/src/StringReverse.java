
public class StringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String inpStr = "helloworlde";
		int loop = 0;
		int rem = inpStr.length() % 2;
		if (rem == 0) {
			loop = inpStr.length() / 2;
		} else {
			loop = inpStr.length() / 2 + 1;
		}

		System.out.println(loop);

		int i = 0;
		int j = inpStr.length() - 1;
		char[] otpArray = new char[inpStr.length()];

		// while (i <= loop && j >= loop) {
		while (loop + 1 > 0) {

			boolean first = findEvenOrOdd(inpStr.charAt(i), inpStr);
			boolean second = findEvenOrOdd(inpStr.charAt(j), inpStr);

			if (first && second) {
				System.out.println("both even ");
				otpArray[i] = inpStr.charAt(i);
				otpArray[j] = inpStr.charAt(j);
				i++;
				j--;
			} else if (!first && second) {
				System.out.println("first odd second even ");
				// otpArray[i] = inpStr.charAt(i);
				otpArray[j] = inpStr.charAt(j);
				// i++;
				j--;
			} else if (first && !second) {
				System.out.println("first even second odd ");
				otpArray[i] = inpStr.charAt(i);
				// otpArray[j] = inpStr.charAt(j);
				i++;
				// j--;
			} else if (!first && !second) {
				System.out.println("both odd ");
				otpArray[j] = inpStr.charAt(i);
				otpArray[i] = inpStr.charAt(j);
				i++;
				j--;
			}
			loop--;
		}
//
//		if (0 != inpStr.length() % 2) {
//			int k = inpStr.length() / 2;
//			otpArray[k] = inpStr.charAt(k);
//		}

		System.out.println("Print the latest array");
		for (int p = 0; p < otpArray.length; p++) {
			System.out.println(otpArray[p]);
		}
	}

	public static boolean findEvenOrOdd(char c, String inputString) {
		boolean isEven = false;
		int count = 0;
		for (int i = 0; i < inputString.length(); i++) {
			// System.out.println(inputString.charAt(i));
			if (inputString.charAt(i) == c) {
				count++;
			}

		}
		if (count % 2 == 0) {
			isEven = true;
		}
		System.out.println("Count of " + c + " is " + count);
		// System.out.println("exit");
		return isEven;
	}
}
