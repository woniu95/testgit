package algorithm;

/**
 * @program: wqIntegration
 * @description:
 * @author: 王强
 * @create: 2020-12-16 19:35
 */
public class MaxSubStr {

    public static void main(String[] args) {
        /**
         * S1 = “123456778”
         * S2 = “357486782”
         *
         *   s1[i] = s2[j]
         *   s1[i+1] = s2[j+1]
         *         ...
         *   s1[i+k] = s2[j+k]
         *
         *  i[0, s1.length] j[0, s2.length]
         *
         *  求： max k
         */
        String s1 = "asdfasdfxcvtxfa";
        String s2 = "asasdfasd";
        int maxK = getMaxKUseBrute(s1, s2);
        System.out.println("max k:"+maxK);
        int k = getMaxKUseDP(s1, s2);
        System.out.println("dp max k:"+k);
    }

    private static int getMaxKUseDP(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for(int i=0,length=s1.length();i<length;i++){
            for(int j=0,jlength=s2.length();j<jlength;j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        int k = 0;
        for(int i=0,length=s1.length();i<length;i++){

            for(int j=0,jlength=s2.length();j<jlength;j++){
                if(dp[i][j] == 1 && i!=0 && j!=0){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                if(dp[i][j]>k){
                    k=dp[i][j];
                }
            }
        }
        return k;
    }

    private static int getMaxKUseBrute(String s1, String s2) {
        int maxK = 0;
        for(int i=0;i<s1.length();i++){
            for(int j=0;j<s2.length();j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    int k = 1;
                    while(i+k<s1.length() && j+k<s2.length() && s1.charAt(i+k) == s2.charAt(j+k)){
                        k++;
                    }
                    if(k>maxK){
                        maxK = k;
                    }
                }
            }
        }
        return maxK;
    }
}
