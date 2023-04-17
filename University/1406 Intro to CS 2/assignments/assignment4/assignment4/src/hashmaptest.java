import java.util.HashMap;

public class hashmaptest {
    public static void main(String[] args){
        HashMap<String,Float> test = new HashMap<String, Float>();
        if (!test.containsKey("a")){
            test.putIfAbsent("a",0.25f);
        }else{
            test.put("a",test.get("a")+0.25f);
        }
        test.put("a",test.get("a")+0.25f);


        System.out.print(test.get("a"));
    }
}
