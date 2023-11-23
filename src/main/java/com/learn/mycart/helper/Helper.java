
package com.learn.mycart.helper;


public class Helper {
    public static String getSomeFirstWords(String desc)
    {
        final int nbWord =5;
        String[] strs = desc.split("[\\s\t\\n]+");
        
        if(strs.length>nbWord)
        {
            String res="";
            for(int i=0;i<nbWord;i++)
            {
                res=res+strs[i]+" ";
            }
            return (res+"...");
        }else
        {
            
            return desc;
        }
        
    }
    public static boolean getDisplayTooltype(String desc){
        String truncate = Helper.getSomeFirstWords(desc); 
        return !truncate.equals(desc); 
    }
}
