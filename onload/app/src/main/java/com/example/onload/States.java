package com.example.onload;
//To define grammar with description


import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.Editable;

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
  static  Map<String,String> map = new HashMap<String, String>();
    public  static void set(String state, String rule)
    {
      if(!map.containsKey(state)) {
        map.put(state, rule);
      } else {
          String update = map.get(state);
          update += (" | "+rule);
          map.replace(state, update);
      }
    }

    public static String get()
    {
        String grammar = "";

        grammar += "S -> " + map.get("S");

        for(String i : map.keySet()) {
            if(!i.equals("S")) {
                grammar += "\n" + i + " -> " + map.get(i);
            }
        }

        return grammar;
    }

}
