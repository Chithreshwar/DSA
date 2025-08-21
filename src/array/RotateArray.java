package array;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        int num[] = {1,2,3,4,5,6};
        int rightArray[] = {1,2,3,4,5,6};
        int rightNum[] =  {1,2,3,4,5,6};
        int k = 2;
        System.out.println("printing original array : " + Arrays.toString(arr));
        System.out.println("printing right rotated array : "+ Arrays.toString(rightRotate(rightArray,k)));
        System.out.println("printing right optimised array " + Arrays.toString(rightRotateOptimized(rightNum,k)));
        System.out.println("printing left rotated array : " +Arrays.toString(leftRotate(arr,k)));
        System.out.println("printing left rotated array in optimised way : "+Arrays.toString(leftRotateOptimized(num,k)));
    }
    //rightRotate with extra space
    public static int[] rightRotate(int arr[], int k){
        int n = arr.length;
        if (k > n) {
            k=k%n;
        }
        //copying k elements from last to empty array
        int temp[] = new int[k];
        for(int i=n-k;i<n;i++){
            temp[i-(n-k)] = arr[i];
        }
        //shifting n-k elements
        for (int i = n - k - 1; i >= 0; i--) {
            arr[i + k] = arr[i];
        }
        //copying k elements to the main array
        for(int i=0;i<k;i++){
            arr[i] = temp[i];
        }
        return arr;
    }
    //leftRotate with extra space
    public static int[] leftRotate(int arr[], int k){
        int n = arr.length;
        if(k>n){
            k = k%n;
        }
        //copying k elements to temp array
        int temp[] = new int[k];
        for(int i=0;i<k;i++){
            temp[i] = arr[i];
        }
        //shifting n-k elements
        for (int i = 0; i < n - k; i++) {
            arr[i] = arr[i + k];
        }
        //copying k elements to the main array
        for (int i = n - k; i < n; i++) {
            arr[i] = temp[i - n + k];
        }
        return arr;
    }
    public static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static int[] rightRotateOptimized(int arr[], int k){
        int n  = arr.length;
        //reverse first k elements
        reverse(arr,0,n-k-1);
        reverse(arr,n-k,n-1);
        reverse(arr,0,n-1);
        return arr;
    }

    public static int[] leftRotateOptimized(int arr[], int k){
        int n  = arr.length;
        reverse(arr,0,n-1);
        reverse(arr,0,n-k-1);
        reverse(arr,n-k,n-1);
        return arr;
    }

}
