package array;

import java.util.HashMap;
import java.util.Map;

public class MooreVotingAlgorithm {
    public static void main(String[] args) {
        //Given an array of N integers, write a program to return an element that occurs more than N/2 times
        // in the given array. You may consider that such an element always exists in the array.
        int arr[] ={2,2,1,1,1,2,2};
        System.out.println(mooreVotingAlgo(arr));
        System.out.println(betterApproach(arr));
    }
    public static int betterApproach(int arr[]){
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int value = map.getOrDefault(arr[i],0);
            map.put(arr[i],value+1);
        }
        for(Map.Entry<Integer,Integer> it : map.entrySet()){
            if(it.getValue() > (n/2)){
                return it.getKey();
            }
        }
        return -1;
    }
    public static int mooreVotingAlgo(int arr[]){
        int n = arr.length;
        int ele = 0;
        int count = 0;
        for(int i=0;i<n;i++){
            if(count == 0){
                count=1;
                ele = arr[i];
            }else if(ele == arr[i]){
                count++;
            }else{
                count--;
            }
        }
        //checking if element is more than n/2 times.
        int countElement = 0;
        for(int i=0;i<n;i++){
            if(arr[i] == ele) countElement++;
        }
        if(countElement > (n/2)) return ele;
        return -1;
    }
}
