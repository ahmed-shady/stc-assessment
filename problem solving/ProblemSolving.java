public class ProblemSolving {

	private final static char OPEN_BRACKET = '(';
	private final static char CLOSE_BRACKET = ')';
	
	public static void main(String[] args) {
		System.out.println("####");
		System.out.println(reverse("abcdefghijk"));
		System.out.println(reverse("abc(abc)abc"));
		System.out.println(reverse("(a)(bc)(abc)abc"));
		System.out.println(reverse("(abcedefghijk)"));
	}

	public static String reverse(String str){
		int currentIndex = 0;

		StringBuilder stringBuilder = new StringBuilder(str.length());
		while(currentIndex < str.length()){
			char currentChar = str.charAt(currentIndex);
			if (currentChar == OPEN_BRACKET) {
				int indexOfClosedBracket = str.indexOf(CLOSE_BRACKET, currentIndex);
				for (int i = indexOfClosedBracket - 1; i > currentIndex; i--) {
					stringBuilder.append(str.charAt(i));
				}
				currentIndex = indexOfClosedBracket + 1;
			}else{
				stringBuilder.append(currentChar);
				currentIndex++;
			}
		}

		return  stringBuilder.toString();
	}

}