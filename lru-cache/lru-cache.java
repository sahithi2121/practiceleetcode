class LRUCache {  private int capacity;
  Map<Integer, Node> nodeMap;
  Node head;
  Node tail;
    
    class Node{
       int key;
       int val;
       Node prev;
       Node next; 
    }
    
    public LRUCache(int capacity) {
       this.capacity=capacity;
       nodeMap= new HashMap();
       head = new Node();
       tail = new Node();
       head.next=tail;
       tail.prev=head; 
    }
    
    private void add(Node node)
    {
      //head <--> [2,2] <--> tail
      //head <-->  [3,3]<-->  [2,2] <--> tail    
        
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    private void remove(Node node)
    {
      //head <-->  [3,3]<-->  [2,2] <--> tail
      //head <--> [2,2] <--> tail
      Node prevNode = node.prev;
      Node nextNode = node.next;
        
       nextNode.prev = prevNode;
       prevNode.next = nextNode;
    }
    
    private void moveToFirst(Node node)
    {
        remove(node);
        add(node);
    }
        
    public int get(int key) {
      Node matchingNode = nodeMap.get(key);
      if(matchingNode==null)
      {
        return -1;  
      }
      
      moveToFirst(matchingNode); //define this method 
      return matchingNode.val;   
    }
    
    public void put(int key, int value) {
      Node matchingNode = nodeMap.get(key);
      if(matchingNode!=null)
      {
         matchingNode.val=value;
         moveToFirst(matchingNode); 
      }
      else
      {
          if(nodeMap.size()==capacity)
          {
             nodeMap.remove(tail.prev.key);  
             remove(tail.prev); //define this method   
          }
          Node newNode = new Node();
          newNode.key = key;
          newNode.val=value;
          add(newNode);
          nodeMap.put(key, newNode);
      } 
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */