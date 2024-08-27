import java.util.Scanner;
public class addString {
    static int i=0,carry=0;
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        String s1=scan.next();
        String s2=scan.next();
        System.out.println(sum(s1,s2));
    }
    public static String sum(String s1, String s2){
        String ans="";
        int l1=s1.length()-1,l2=s2.length()-1;
        int length=Math.max(l1,l2);
        char c1,c2;
        for (int i=length;i>=0;i--){
            c1='0';
            c2='0';
            if (l1>=0){
                c1=s1.charAt(l1);
                l1--;
            }
            if (l2>=0){
                c2=s2.charAt(l2);
                l2--;
            }
            ans=add(c1,c2,ans,length);
        }
        return ans;
    }
    private static String add(char c1,char c2,String ans ,int length){
        int add=carry+c1-'0'+c2-'0';
        if (length==i){
            return add+ans;
        }
        if (add / 10 != 0)
        {
            carry = add / 10;
            add = add % 10;
        }
        ans=add+ans;
        i++;
        return ans;
    }
}
