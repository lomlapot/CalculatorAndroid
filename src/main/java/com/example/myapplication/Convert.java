package com.example.myapplication;
import java.util.ArrayList;
import java.util.Stack;

class Convert {
 static String [] convertArr(String [] arrIn){
 
  Stack<String> stack =new Stack<>();
      
  ArrayList <String >listOut = new ArrayList<>();
      
   int stackPrior =0;
   for(int i=0;i<arrIn.length;i++){ 
     if(isNum(arrIn[i])){
      listOut.add(arrIn[i]);
    }
    else{
      if(arrIn[i].equals("(")){
         stack.push(arrIn[i]);
         stackPrior =0;
      	}
      	else if(arrIn[i].equals(")")){
        String temp=")";
          while(!temp.equals("(")){  
            if(stack.empty())break;
              temp = stack.lastElement();                  
               listOut.add(stack.pop());  
          }
          stackPrior=0;
          listOut.remove("(");              
       }
       else if(prior(arrIn[i])>stackPrior ){     
         stack.push(arrIn[i]);
         stackPrior =prior(stack.lastElement());
         }else if(prior(arrIn[i])<=stackPrior){
              
            while(prior(arrIn[i])<=stackPrior){
               listOut.add(stack.pop());
       					     if(stack.empty()) break;
        	 			      stackPrior = prior(stack.lastElement());
          }     
          stack.push(arrIn[i]);
          stackPrior = prior(stack.lastElement());
             
         	}
      }
    }     
   while(!stack.empty())
     listOut.add(stack.pop());
    	String [] arrOut = new String[listOut.size()];
    	arrOut = listOut.toArray(arrOut);
   
    return arrOut;
  }
   
   
  static  int prior(String token){
    switch(token){
       case"^":
         return 3;     
       case"×":      
       case"/":
         return 2;
       case"-":
       case"+":
         return 1;
        case"(":
        case")":
          return 0;
         
     }
        return 0;
  }
    
    
 static  boolean isNum(String i){
   try{
     Double.parseDouble(i);
     return true;
   }        
   catch(NumberFormatException e){
    return false ; 
   }
 }
}
