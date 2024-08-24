import java.util.Scanner;
public class Pattern_Searching {
    static Scanner scan =new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the text : ");
        String txt=scan.nextLine();
        System.out.print("Enter the text : ");
        String pat=scan.nextLine();
        naive_algo(txt,pat);
    }
    public static void naive_algo(String txt, String pat) {
        int textLength=txt.length();
        int patLength=pat.length();
        for (int i=0;i<=textLength-patLength;i++){
            int j;
            for ( j=0;j<patLength;j++){
                if (txt.charAt(j+i)!=pat.charAt(j)){
                    break;
                }
            }
            if (j==patLength){
                System.out.println("Index at : "+i);
            }
        }
    }
}
