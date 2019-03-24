package com.example.onload;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {
    static Map<String, List<String>> map = null ;
    static String input = null;

    /* static boolean checkValid() {

        if(!map.containsKey("S"))
            return false;

        for(String key : map.keySet()) {
            for (String rule :map.get(key) ) {
                if (rule.length() == 2) {
                    if (map.containsKey(rule.charAt(0)) || !map.containsKey(rule.charAt(1))) return false;
                }
            }
        }
        return true;
    } */

   static void  setInput(String input ) {
       Parser.input = input;
   }

    static void initialize ( Map<String, List<String>> map ) throws Exception {
        Parser.map = map;
    }

    static boolean checkNext(String currentState, int index) {

        if(map.containsKey(currentState)) {

            List<String> ruleSet = map.get(currentState);

            if(index == input.length() && ruleSet.contains("#"))
                return true;

            for (String rule : ruleSet) {
               String char0 = String.valueOf(rule.charAt(0));
                if (rule.length() == 2) {

                    String  char1;
                    char1 = String.valueOf(rule.charAt(1));

                    if(char0.equals(String.valueOf(input.charAt(index))) && map.containsKey(char1))
                        if(checkNext(char1, index + 1)) return true;
                }

                if(rule.length() == 1)
                {
                    if(map.containsKey(char0)) {
                        if(checkNext(char0, index )) return true;
                    }
                    else {
                        if(index == input.length()-1 && char0.equals(String.valueOf(input.charAt(index)))) return true;
                    }
                }

            }
        }

        return false;
    }

    static boolean validate() {

        return checkNext("S", 0 );
    }


}
