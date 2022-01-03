class Solution {
    public int[] productExceptSelf(int[] nums) {
  if(nums==null)
        {
           return new int[]{}; 
        }
        
         if(nums.length==1)
        {
           return nums; 
        }
        
        //input -- [1,2,3,4]
        // output -- [0,0,0,0]
        int[] result = new int[nums.length];
        
        // [1,0,0,0] and mul=1, 
        // [1,1,0,0] and mul=2
        // [1,1,2,0] and mul=6
        // [1,1,2,6] and mul=XXXX
        for(int i=0, mul=1; i<nums.length; i++)
        {
            result[i] = mul;
            mul = mul * nums[i];
        }
        
        //[1,1,2,6] and mul = 4
        //[1,1,8,6] and mul = 12
        //[1,12,8,6] and mul = 24
        //[24,12,8,6] and mul = xxx
         for(int j=nums.length-1, mul=1; j>=0; j--)
        {
            result[j] = result[j] * mul;
            mul = mul * nums[j];
        }
        
        return result;
    }
}