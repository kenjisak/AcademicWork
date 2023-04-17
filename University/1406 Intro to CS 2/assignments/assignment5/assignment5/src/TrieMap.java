//Note: All of your TrieMapInterface method implementations must function recursively
//I have left the method signatures from my own solution, which may be useful hints in how to approach the problem
//You are free to change/remove/etc. any of the methods, as long as your class still supports the TrieMapInterface

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TrieMap implements TrieMapInterface {
  TrieMapNode root;//root letter,make the key the root
  
  public TrieMap(){
    root = new TrieMapNode();
  }
  
  //Indirectly recursive method to meet definition of interface
  //Adds the key/value pair to the TrieMap
  public void put(String key, String value){
    put(root,key,value);
  }
  
  //Recursive method
  //Note: arguments are only a suggestion, you may use your own if you devise a different recursive solution
  public void put(TrieMapNode current, String curKey, String value){
    if (curKey.equals("")){
      current.setValue(value);
    }else if (current.getChildren().containsKey(curKey.charAt(0))){
      TrieMapNode node = current.getChildren().get(curKey.charAt(0));
      put(node, curKey.substring(1), value);
    }else{
      TrieMapNode newnode = new TrieMapNode();
      String sub = curKey.substring(1);
      current.getChildren().put(curKey.charAt(0), newnode);
      put(newnode,sub, value);
    }
  }
  
  //Indirectly recursive method to meet definition of interface
  //Returns the object value associated with the given key
  //If the key is not present in the TrieMap, returns null
  public String get(String key){
    return get(root,key);
  }
  
  //Recursive method
  //Note: arguments are only a suggestion, you may use your own if you devise a different recursive solution
  public String get(TrieMapNode current, String curKey){
    if (current.getChildren().get(curKey.charAt(0))==null){
      return null;
    }else{
      if(curKey.length() == 1){
        return current.getChildren().get(curKey.charAt(0)).getValue();
      }else{
        return get(current.getChildren().get(curKey.charAt(0)),curKey.substring(1));
      }
    }
  }
  
  //Indirectly recursive method to meet definition of interface
  //Returns true if key is in the TrieMap, false otherwise
  public boolean containsKey(String key){
    return containsKey(root,key);
  }
  
  //Recursive method
  //Note: arguments are only a suggestion, you may use your own if you devise a different recursive solution
  public boolean containsKey(TrieMapNode current, String curKey){
    if (current == null){
      return false;
    }else if (current.getChildren().get(curKey.charAt(0))==null){
      return false;
    }else if (curKey.length() == 1){
      return current.getChildren().get(curKey.charAt(0)).getValue() != null;
    }
    return containsKey(current.getChildren().get(curKey.charAt(0)),curKey.substring(1));
  }
  
  //Indirectly recursive method to meet definition of interface
  //Returns an ArrayList of objects containing all keys that start with prefix
  public ArrayList<String> getKeysForPrefix(String prefix){

    return getSubtreeKeys(findNode(root,prefix));
  }
  
  //Recursive helper function to find node that matches a prefix
  //Note: only a suggestion, you may solve the problem is any recursive manner
  public TrieMapNode findNode(TrieMapNode current, String curKey){
    if(current == null){
      return null;
    }else if(current.getChildren().get(curKey.charAt(0))==null){
      return null;
    }else if(curKey.length()==1){
      return current.getChildren().get(curKey.charAt(0));
    }
    return findNode(current.getChildren().get(curKey.charAt(0)),curKey.substring(1));
  }
  
  //Recursive helper function to get all keys in a node's subtree
  //Note: only a suggestion, you may solve the problem is any recursive manner
  public ArrayList<String> getSubtreeKeys(TrieMapNode current){
    ArrayList<String> subtreekeys = new ArrayList<>();
    if (current != null) {
      if (current.getValue() != null) {
        subtreekeys.add(current.getValue());
      }
      Collection<TrieMapNode> values = current.getChildren().values();
      Iterator<TrieMapNode> itr = values.iterator();
      while(itr.hasNext()){
        TrieMapNode next = itr.next();
        subtreekeys.addAll(getSubtreeKeys(next));
      }
    }
    return subtreekeys;
  }
  
  //Indirectly recursive method to meet definition of interface
  public void print(){
    print(root);
  }
  
  //Recursive method to print values in tree
  public void print(TrieMapNode current){
    //get children first
    //then get keys of children
    //iterate through that and print
    //then set the root as children so itll look through childrens children?
    Collection<TrieMapNode> values = current.getChildren().values();
    Iterator<TrieMapNode> itr = values.iterator();
    while(itr.hasNext()){
      TrieMapNode next = itr.next();
      print(next);
      if(next.getValue() != null){
        System.out.println(next.getValue());
      }
    }

  }
  
  public static void main(String[] args){
    //You can add some code in here to test out your TrieMap initially
    //The TrieMapTester includes a more detailed test
    TrieMapInterface map = new TrieMap();
    map.put("KEY","KEY");
  }
}