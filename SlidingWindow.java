public class SlidingWindow {
    public static void main(String[] args) {
        int[] arr = {12, 1, 7, 8, 30, -16, 28 };
        int k = 4;
        printFirstNegativeInteger(arr,k, arr.length);
        minimumSubArray(arr,29);
        all_permutations("BACDGABCDA", "ABCD");
    }
    // Fixed Window size
    public  static void maximumSubArray(int[] arr,int k){
        if (arr.length<k){
            System.out.println("SubArray size is maximum then original array size! ");
            return;
        }
        int maximum =0;
        for (int i=0;i<k;i++)
            maximum+=arr[i];
        int currentSum=maximum;
        int index=0;
        for (int i=k;i<arr.length;i++){
            currentSum+=arr[i]-arr[i-k];
            if (currentSum>maximum){
                index=i-k+1;
                maximum=currentSum;
            }
        }
        System.out.println("Maximum sub array is "+maximum+" index start at "+index);
    }
    static void printFirstNegativeInteger(int[] arr, int k, int n)
    {
        int firstNegativeIndex = 0;
        int firstNegativeElement;
        for(int i = k - 1; i < n; i++)
        {
            for (int j = i - k + 1; j <= i; j++) {
                if (arr[j] < 0) {
                    firstNegativeIndex = j;
                    break;
                }
            }
            if (arr[firstNegativeIndex] < 0)
            {
                firstNegativeElement = arr[firstNegativeIndex];
            }
            else
            {
                firstNegativeElement = 0;
            }
            System.out.print(firstNegativeElement + " ");
        }
        System.out.println();
    }
    // Sliding Window algorithm for variable size
    public static void minimumSubArray(int[] arr, int value){
        int currentSum=0;
        int minSize=Integer.MAX_VALUE;
        int start=0;
        int end=0;
        while (end<arr.length){
            currentSum+=arr[end];
            while (currentSum>=value){
                minSize=Math.min(minSize,end-start+1);
                currentSum-=arr[start];
                start++;
                if (minSize==1){
                    System.out.println(minSize);
                    return;
                }
            }
            end++;
        }
        System.out.println(minSize);
    }
    // Search for all permutations in string
    public static void all_permutations(String text,String word){
        int w=word.length();
        int t=text.length();
        int[] large =new int[t];
        int[] small =new int[w];
        for (int i=0;i<t;i++)
            large[i]=text.charAt(i)-'A'+1;
        for (int i=0;i<w;i++)
            small[i]=word.charAt(i)-'A'+1;
        int current_sum=0;
        int word_sum=0;
        for (int i=0;i<w;i++) {
            current_sum +=large[i];
            word_sum+=small[i];
        }
        for (int i=w;i<=t;i++){
            if (current_sum==word_sum){
                System.out.print((i-w)+" ");
            }
            if (i < t) {
                current_sum = current_sum + large[i] - large[i - w];
            }
        }
        System.out.println();
    }
// the above function have some issues when using repeated charater.
}
