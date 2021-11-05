class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        //Every element of nums1 is in nums2 so first process nums2 and store next greater elements
        // in this way we will have next greater of all elements of nums1 and if we see that for any
        //element of nums1 we don't have next Greater stored in map it means it does not have NGE    
        //T.C : O(n + m) n denotes nums1 size and m denotes nums2 size
        Stack<Integer> st = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num : nums2){
             while(st.size() > 0 && st.peek() < num){ //pop all previous smaller elements than num 
                 map.put(st.pop(),num); // next greater for all these(popped elements) is num
             }
            st.push(num); //push current element
        }
        
        int [] ans = new int[nums1.length];
        
        for(int i = 0;i<nums1.length;i++){
            ans[i] = map.getOrDefault(nums1[i], - 1);
        }
        
        return ans;
    }
}