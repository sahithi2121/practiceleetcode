public class Solution {
   public boolean isValid(String s) {
   // Stack to store left symbols
      Stack<Character> stack = new Stack<>();
        // Loop for each character of the string
      for(char c : s.toCharArray()){
            // If left symbol is encountered
        if (c == '(' || c == '{' || c == '[') {
             stack.push(c);
        }
        else if(c == ')' && !stack.isEmpty() && stack.peek()== '('){
            stack.pop();
        }  else if(c == '}' && !stack.isEmpty() && stack.peek()== '{'){
            stack.pop();
        }
          else if(c == ']' && !stack.isEmpty() && stack.peek()== '['){
            stack.pop();
          }
          else 
              return false;
      }return stack.isEmpty();  
    }
}