import java.util.Scanner;
public class AppleBasket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum weight a basket can hold (K): ");
        int K = scanner.nextInt();
        System.out.print("Enter the number of apples: ");
        int n = scanner.nextInt();
        int[] appleWeights ={ 2, 5, 4, 7, 1, 3, 8 };
        java.util.Arrays.sort(appleWeights);
        for (int i = 0; i < n / 2; i++) {
            int temp = appleWeights[i];
            appleWeights[i] = appleWeights[n - i - 1];
            appleWeights[n - i - 1] = temp;
        }
       int[] basket =new int[n];
        for (int i=0;i<n;i++){
            for (int j=0;j<=i;j++){
                if (basket[j]==0){
                    basket[j]=appleWeights[i];
                    break;
                }
                if (basket[j]+appleWeights[i]<=K){
                    basket[j]+=appleWeights[i];
                    break;
                }
            }
        }
       int i=0;
        int cont=0;
        while (basket[i]!=0){
            i++;
            cont++;
        }
        System.out.println(cont);
    }
}
