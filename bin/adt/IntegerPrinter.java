package adt
public class IntegerPrinter {
	
	int[] members;					// instance variable
	
	IntegerPrinter(int[] members) {	// constructor
		this.members = members;
	}
	
	int getMaxLength() {
		
		int maxLength = 0; 	
		for (int member : members) {
			int currentLength = ((Integer)member).toString().length();
			if (currentLength > maxLength)
				maxLength = currentLength;
		}
		return maxLength;
	}
	
	void printBorder() {
		for (int i=0; i < getMaxLength()+4; i++) {
			System.out.print("-");
		}
	}
	
	void printMargin(String member) {
		int marginWidth = 1 + (getMaxLength()-member.toString().length())/2;
		for (int i=0; i<marginWidth; i++) {
			System.out.print(" ");
		}
	}
	
	void printMember(String member) {
		printBorder();
		System.out.println();
		System.out.print("*");
		printMargin(member);
		System.out.print(member);
		printMargin(member);
		System.out.print("*");
		System.out.println();
		printBorder();
		System.out.println();
	}
	
	void printAll() {
		for (int member : members) {
			printMember(((Integer)member).toString());
		}
	}
}
