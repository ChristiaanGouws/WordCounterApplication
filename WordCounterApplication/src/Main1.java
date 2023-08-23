import java.util.Scanner;
public class Main1 {
	
	public static void main(String[] args) {
		
		System.out.println("Hello user. This program shows how many words you have typed.");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\nPlease type away: ");
		String essay = scanner.nextLine();
		
		String words[]=essay.split("\\s");
		int length=words.length;
		int clength=essay.length();
		
		System.out.println(length);
		System.out.println(clength);
		
		
	}

}
