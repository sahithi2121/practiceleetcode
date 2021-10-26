class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        //need to find duplicate and where that duplicate is
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i =0;i<nums.length;i++){
            int curr= nums[i];
            if(map.containsKey(curr) && i - map.get(curr) <= k){
                return true;
            }else {
                map.put(curr,i);
            }
        }
        return false;
    }
}