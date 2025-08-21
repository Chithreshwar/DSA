package array;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {2, 6, 5, 8, 11};
        int target = 14;
        int[] ans = twoSum(n, arr, target);
        System.out.println("This is the answer for variant 2: [" + ans[0] + ", "
                + ans[1] + "]");
    }
    public static int[] twoSum(int n, int [] arr, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans[] = new int[2];

        for(int i=0;i<n;i++){
            if(map.containsKey(target - arr[i])){
                ans[0] = map.get(target - arr[i]);
                ans[1] = i;
            }else{
                map.put(arr[i],i);
            }
        }
        return ans;
    }
}
