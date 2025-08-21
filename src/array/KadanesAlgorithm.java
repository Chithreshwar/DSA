package array;

import java.util.Arrays;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(Arrays.toString(maxSubArray(arr)));
    }
    public static int [] maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = -1;
        int end  = -1;
        int tempStart = -1;
        for(int i=0;i<n;i++){

            sum = sum + nums[i];
            if(sum>maxSum){
                maxSum = sum;
                start = tempStart;
                end = i;
            }
            if(sum<0){
                sum =0;
                tempStart = i + 1;
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
