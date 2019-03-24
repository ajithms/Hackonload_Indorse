package com.example.onload;
//To define grammar with description


import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Vector;

public class States {
    static boolean check = false;
    static String grammar = "";
   static Map<String, List<String>> map = new HashMap<String, List<String>>();


   //Static Method used to set State and the Rule in the HashMap
    public  static void set(String state, String rule)
    {
        //If the State doesn't already exist in the HashMap, then add it.
        if (!map.containsKey(state))
            map.put(state, new ArrayList<String>());
        else
            //If the rule is also defined earlier, return without any changes
            if(map.get(state).contains(rule)) return;

        map.get(state).add(rule);   //Add New Rule 'rule' to the 'state'

    }


    //Method that returns Rule string, that is added to the Output String Grammar
    static String printRule(List<String> lst)
    {
        String str = lst.get(0);    //First Rule

        for(int i=1; i<lst.size(); i++)
            str += " | " + lst.get(i);  //Remaining Rules delimited by ' | '

        return str ;
    }


    public static String get()
    {
        grammar = "";

        if(!map.containsKey("S"))
            throw new NullPointerException("Start State Should be 'S'");

        grammar += "S -> " + printRule(map.get("S")) + "\n";
        for(String i : map.keySet()) {
            if(!i.equals("S")) {
                grammar += ""+i + " -> " +( printRule(map.get(i)) + "\n" ) ;

            }
        }

        return grammar;
    }

}
