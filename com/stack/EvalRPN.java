package com.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvalRPN {

    Set<String> operators=new HashSet<>();

    public int evalRPN(String[] tokens) {
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        int num1=0;
        int num2=0;
        int val=0;
        Stack<Integer> storage=new Stack<>();
        for(String token: tokens){
            if(isOperator(token)){
                storage.push(evaluate(storage.pop(),storage.pop(),token));
            }else{
                storage.push(Integer.parseInt(token));
            }

        }
        return storage.pop();
    }

    private boolean isOperator(String token){
        if(operators.contains(token))
            return true;
        return false;
    }
    private int evaluate(int num1,int num2, String operator){
        int val=0;
        switch(operator){
            case "+":
                val=num2+num1;
                break;
            case "-":
                val=num2-num1;
                break;
            case "*":
                val=num2*num1;
                break;
            case "/":
                val=num2 / num1;
                break;
        }

        //System.out.println("Num1=>"+num1+" Num2=>"+num2+" val==>"+val);
        return val;
    }

    public static void main(String[] args) {
        EvalRPN evalRPN=new EvalRPN();
       // String[] tokens=new String[]{"2","1","+","3","*"};
        String[] tokens=new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println("Result:=>"+evalRPN.evalRPN(tokens));

    }
}
