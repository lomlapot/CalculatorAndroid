package com.example.myapplication;
import java.util.ArrayList;

class Parser {
static String []count(String no){
    
    no =no.replace("0(","0×(") ;
    no =no.replace(  "1(","1×(");
    no =no.replace( "2(","2×(");
    no =no.replace("3(","3×(") ;
    no =no.replace("4(","4×(");
    no =no.replace("5(","5×(");
    no =no.replace("6(","6×(");
    no =no.replace("7(","7×(");
    no =no.replace("8(","8×(");
    no =no.replace("9(","9×(") ;
    String nom =no.replace(")(",")×(") ;
    
    ArrayList <String >list = new ArrayList<>();
    char [] charNom = nom.toCharArray();
    String nomchar ="";
    for(int i=0;i<charNom.length;i++){
      if(isNom(charNom[i])){ 
        nomchar ="";
        while(isNom(charNom[i])){
          nomchar+=nom.charAt(i);
          i++;
          if(i>charNom.length-1)
            break; 
        }      
        i--;       
      }
      else{
        nomchar =String.valueOf(nom.charAt(i));  
      } 
      list.add(nomchar);
      }  
     
   
    int i=0 ;
    int c=0;
 
    while(c<list.size()-1){
      i=c;
      if(list.get(i).equals("-")&
        i==0){
        list.add(i,"(");
        i++;
        list.add(i,"0");
        i=i+2;   
        if(list.get(i).equals("(")){
          i++;
          while(!list.get(i).equals(")"))
            i++;
        }
       i++;
       list.add(i,")"); 
      }
      if(list.get(i).equals("(")|
       list.get(i).equals("^")|
       list.get(i).equals("×")| 
       list.get(i).equals("/") ){
          i++;
          if(list.get(i).equals("-")){
            list.add(i,"(");
            i++;
            list.add(i,"0");
            i=i+2;
            if(list.get(i).equals("(")){
          i++;
          while(!list.get(i).equals(")"))
            i++;
        }
        i++;
            list.add(i,")");
       // System.out.println("2c="+i);
          }   
      } 
      c++;
      i=0;
  }  
     
    
    String [] arrOut = new String [list.size()];
    arrOut = list.toArray(arrOut);
    //System.out.println(list);
       return arrOut;
  }
  static boolean isNom(char ch){
            if(Character.isDigit(ch)|
            ch=='.')
        return true;
        else
            return false;
        }		
}
