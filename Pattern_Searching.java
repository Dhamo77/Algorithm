import java.util.Scanner;
public class Pattern_Searching {
    static Scanner scan =new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the text : ");
        String txt=scan.nextLine();
        System.out.print("Enter the text : ");
        String pat=scan.nextLine();
        naive_algo(txt,pat);
        kmp_Algorithm(txt,pat);
    }
    // Naive Algorithm
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
    // KMP Algorithm
    public static void kmp_Algorithm(String txt, String pat){
        int t=txt.length();
        int p=pat.length();
        int[] lps=new int[p];
        lps(lps,p,pat);
        int i=0,j=0;
        while (i<t){
            if (txt.charAt(i)==pat.charAt(j)){
                i++;
                j++;
            }
            if (j==p){
                System.out.println("Index at : "+(i-j));
                j=lps[j-1];
            }
            else if (i < t && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                }
                else {
                    i = i + 1;
                }
            }
        }
    }
    private static void lps(int[] lps,int length,String pat){
        int len = 0;
        lps[0] = 0;
        int i = 1;
        while (i < length) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if (len != 0)
                    len = lps[len - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
