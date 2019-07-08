package com.problem.stack.delimiter_match;

//perfect it works :)
public class DelimiterChecker {

    private char[] chars;
    private StackDelimiter stackDelimiter;

    public DelimiterChecker(char[] chars){
        this.chars = chars;
        this.stackDelimiter = null;
    }

    //check given delimeter if it is true - for ex: ({{[]}}) - is true
    public boolean checkIfMatch(){

        stackDelimiter = new StackDelimiter(chars.length);
        boolean match = true;

        for(int i = 0;i < chars.length; i++){
            char ch = chars[i];
            if(ch == '(' || ch == '[' || ch == '{' || ch == '<'){
                stackDelimiter.push(ch);
            }
            else if(ch == ')'){
                char dataFormStack = stackDelimiter.pop();
                if(dataFormStack != '('){
                    match = false;break;
                }
            }
            else if(ch == ']'){
                char dataFormStack = stackDelimiter.pop();
                if(dataFormStack != '['){
                    match = false;break;
                }
            }
            else if(ch == '}'){
                char dataFormStack = stackDelimiter.pop();
                if(dataFormStack != '{'){
                    match = false;break;
                }
            }
            else if(ch == '>'){
                char dataFormStack = stackDelimiter.pop();
                if(dataFormStack != '<'){
                    match = false;break;
                }
            }
            else match = false;
        }
        if(!stackDelimiter.isEmpty()) match = false;
        return match;
    }
}
