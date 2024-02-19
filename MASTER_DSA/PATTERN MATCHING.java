/**
Pattern Matching 

1. You are given a string and a pattern. 
2. You've to check if the string is of the same structure as pattern without using any regular expressions.

str: graphtreesgraph
pattern: pep

op : p -> graph, e -> trees, . 
 */



public class Main {

	public static void solution(String str, String pattern, HashMap<Character,String> map, String op){
		
		
		if(pattern.length() == 0){
		    if(str.length() == 0){
		        HashSet<Character> printed = new HashSet<>();
		        
		        for(int i = 0;i<op.length();i++){
		            char ch = op.charAt(i);
		            if(printed.contains(ch)){
		                continue;
		            }
		            System.out.print(ch+" -> "+map.get(ch)+", ");
		            printed.add(ch);
		        }
		        System.out.println(".");
		    }
		    
		    return;
		}
		
		char ch = pattern.charAt(0);
		String rop = pattern.substring(1);
		
		if(map.containsKey(ch)){
		    String prevMapping = map.get(ch);
		    
		    if(str.length()>=prevMapping.length()){
		        String left = str.substring(0,prevMapping.length());
		        String right = str.substring(prevMapping.length());
		        
		        if(prevMapping.equals(left)){
		            solution(right,rop,map,op);
		        }
		    }
		}else{
		    for(int i = 0;i<str.length();i++){
		        String left = str.substring(0,i+1);
		        String right = str.substring(i+1);
		        
		        map.put(ch,left);
		        solution(right,rop,map,op);
		        map.remove(ch);
		    }
		}
		
	}

}