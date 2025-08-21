package array;

import java.util.Arrays;

public class DutchNationalFlag {
    public static void main(String[] args) {
        //Given an array consisting of only 0s, 1s, and 2s. Write a program to in-place sort the array
        // without using inbuilt sort functions. ( Expected: Single pass-O(N) and constant space)
        int arr[] = {2,0,2,1,1,0};
//        bruteForce(arr);
        dutchNationalFlagAlgo(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void dutchNationalFlagAlgo(int arr[]){
        int n = arr.length;
        int low = 0;
        int mid = 0;
        int high = n-1;
        while(mid<=high){
            if(arr[mid]==0){
                swap(arr,mid,low);
                low++;
                mid++;
                //we are incrementing both low and mid because o to low -1 should be zero. unsorted part should start from mid
                //to high.
            } else if (arr[mid]==1) {
                mid++;
            }else{
                swap(arr,mid,high);
                high--;
                //In this step we will do nothing to the mid pointer because the subarray from mid to high after decrementing high
                //might be unsorted. so we will check the value of mid again in next iteration.
            }
        }
    }
    public static void swap(int arr[],int a, int b){
        int temp = arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public static void bruteForce(int arr[]){
        //This itself a better approach with TC: O(N) + O(N)
        int cnt1=0;
        int cnt2=0;
        int cnt0=0;
        int n= arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                cnt0++;
            }
            else if (arr[i]==1) {
                cnt1++;
            }else {
                cnt2++;
            }
        }
        for(int i=0;i<cnt0;i++){
            arr[i] = 0;
        }
        for(int i=cnt0;i<(cnt0+cnt1);i++){
            arr[i] = 1;
        }
        for(int i=cnt0+cnt1;i<(cnt0+cnt1+cnt2);i++){
            arr[i]=2;
        }
    }
}
