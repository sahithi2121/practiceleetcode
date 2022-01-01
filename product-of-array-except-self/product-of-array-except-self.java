class Solution {
    public int[] productExceptSelf(int[] nums) {
     if(nums.length==1) return nums;
      // if(nums==null)  return int[]{};
       int result[] = new int[nums.length];
        for(int i= 0, mul=1; i<nums.length;i++){
            result[i] = mul;
            mul=mul*nums[i];
        }
        for(int j= nums.length-1,mul=1; j>=0;j--){
            result[j] = result[j]*mul;
            mul = mul*nums[j];
        }
        return result;
    }
}