package array;

import java.util.Arrays;

public class MoveZeroToEnd {
    public static void main(String[] args) {
        int arr[] = {1,0,2,3,0,4,0,1};
        moveZero(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void moveZero(int arr[]){
        int j = -1;
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                j = i;
                break;
            }
        }
        for(int i=j+1;i<n;i++){
            if(arr[i]!=0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }
}
