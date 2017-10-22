package others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringProbs {

    public static void main(String[] args) {

        StringProbs obj=new StringProbs();
        List<String> list=obj.prefixSearch("helloworldhello");
        for(String s:list){
     //       System.out.println(s);
        }

        System.out.println("suffix");
        list=obj.suffix("helloworldhello");
        for(String s:list){
     //            System.out.println(s);
        }
        System.out.println(obj.longestRepeatedSubstring("helloworldhello"));
    }

    public List<String> prefixSearch(String x){
        //how to get prefix of string eg. hello- h he hel hell hello
        List<String>list=new ArrayList<>();

        for(int i=1;i<=x.length();i++){
            list.add(x.substring(0,i));
        }
        return list;
    }

    private List<String>suffix(String x){
        //how to get suffix of string eg. hello- hello ello llo lo o
        List<String>list=new ArrayList<>();

        for(int i=0;i<x.length();i++){
            list.add(x.substring(i,x.length()));
        }
        return list;
    }

    public String longestCommonPrefix(String text1,String text2){
        int commonlength=Math.min(text1.length(),text2.length());

       // eg hello & hellook..then we need to consider only hello..so commonlength

        for(int i=0;i<commonlength;i++){
            if(text1.charAt(i)!=text2.charAt(i)){
                return text1.substring(0,i); //can also use text2
            }
        }

        return text1.substring(0,commonlength);
    }

    public String longestRepeatedSubstring(String x){

       // eg. helloworldhello gives hello
        int len=x.length();
        List<String >suffixList=suffix(x);

        Collections.sort(suffixList); //java uses merge sort for ref types & quick sort for primitive types

        System.out.println("printing soted list of suffex");
        for(String h:suffixList){
            System.out.println(h);
        }
        String longestSubstring="";

        for(int i=0;i<len-1;i++){
            String temp=longestCommonPrefix(suffixList.get(i),suffixList.get(i+1));
            if(temp.length()>longestSubstring.length()){
                longestSubstring=temp;
            }
        }
        return longestSubstring;

    }
    public void explaintheory(){
        //longest repeated substring can also be made by brute force
        //get all substrings
        //put in hashmap ..all strings & their freq
        //keep a dummy longest string as ""
        //gothrough hashmap..check if freq is greater then 1 & len is greater than dummy...change dummy


        //better approach is implemented
        //find all suffix of string eg helloworhello...helloworhello..elloworhello....hello...ello...o...
        //sort the list of suffixes
        //find longest common prefix between 2 neighbouring strings from list
    }



}
