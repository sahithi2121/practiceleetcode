 // BUT p(n) is out of bounds because there is always (n-1) elements in the previous rows
    // AND on c(0) = p(0) + p(0-1), p(0-1) is out of bounds
    // To handle the edges of the rows, we can add an imaginary zero when out of bounds or pre-add the 1's at the edges
	// Dynamic Programming: we'll memoize the previous rows and use them to solve the next rows
    
   class Solution{
        public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        
        // Base Case
        List<Integer> base1 = new ArrayList<>();
        base1.add(1);
        rows.add(base1);
        if(numRows == 1)
            return rows;
        
        for(int i = 1; i < numRows; i++) {
            List<Integer> prev = rows.get(i-1);
            List<Integer> current = new ArrayList<>();
            
            // Add each element to current row
            for(int j = 0; j < i+1; j++) {

                // Handle edges
                if(j == 0 || j == i)
                    current.add(1);
                else {  // For inner elements: c(j) = p(j) + p(j-1)
                    current.add(prev.get(j) + prev.get(j-1));
                }
            }
            
            rows.add(current);
        }
        
        return rows;
    }
}