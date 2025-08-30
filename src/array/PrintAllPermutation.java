package array;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PrintAllPermutation {
    private static final Logger logger = Logger.getLogger(PrintAllPermutation.class.getName());

    public static void recurPerumutateAll(int nums[],List<Integer> ds,List<List<Integer>> ans,boolean track[]){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds)); // wea re copying this in new arraylist then adding it to result because to avoid reference issue
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!track[i]){
                track[i] = true;
                ds.add(nums[i]);
                recurPerumutateAll(nums,ds,ans,track);
                ds.remove(ds.size()-1);
                track[i]= false;
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3};
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean track[] = new boolean[nums.length];
        recurPerumutateAll(nums,ds,ans,track);
        for (List<Integer> list : ans) {
            logger.info("Permutation: {}"+ list);
        }

    }
}
/* recursion tree diagram
        ├── [1]
        │   ├── [1,2]
        │   │   └── [1,2,3]
        │   └── [1,3]
        │       └── [1,3,2]
        ├── [2]
        │   ├── [2,1]
        │   │   └── [2,1,3]
        │   └── [2,3]
        │       └── [2,3,1]
        └── [3]
        ├── [3,1]
        │   └── [3,1,2]
        └── [3,2]
        └── [3,2,1]
*/