package array;

import java.util.Arrays;
import java.util.logging.Logger;

public class KadanesAlgorithm {

    private static final Logger logger = Logger.getLogger(KadanesAlgorithm.class.getName());
    public static void main(String[] args) {
        int arr[] = {2,1,-3,4,-1,2,1,-5,4};
        logger.info("Max Subarray: " + Arrays.toString(maxSubArray(arr)));
    }
    public static int [] maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int end  = 0;
//        int tempStart = -1; temp start is removed since it may cause index ot of bound exception in line 32 -> ans[i] = nums[j];
        for(int i=0;i<n;i++){

            sum = sum + nums[i];
            if(sum>maxSum){
                maxSum = sum;
                end = i;
            }
            if(sum<0){
                sum =0;
                start = i + 1;
            }
        }
        int ans[] = new int[end - start + 1];
        int j = start;
        for(int i=0;i<(end-start+1);i++){
            ans[i] = nums[j];
            j++;
        }
        return ans;
    }
}
