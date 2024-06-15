package com.stack;

import java.util.Stack;

/**
 * 71. Simplify Path
 */
public class SimplifyPath {
    public static String simplifyPath(String path) {
        String[] folders=path.split("/");
        Stack<String> storage=new Stack<>();
        Stack<String> orderedStorage=new Stack<>();
        StringBuilder sb=new StringBuilder();

        for(String str: folders){
            System.out.println(str);
            if( str.equals("") || str.equals(".") ) continue;

            if(str.equals(".."))
            {
                if(!storage.isEmpty())
                storage.pop();
                continue;
            }
            storage.push(str);
        }

        if(storage.isEmpty()) return "/";
        while(!storage.isEmpty()){
            orderedStorage.push(storage.pop());
        }

        while(!orderedStorage.isEmpty()){
            sb.append("/");
            sb.append(orderedStorage.pop());
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath( "/.../a/../b/c/../d/./"));
    }
}
