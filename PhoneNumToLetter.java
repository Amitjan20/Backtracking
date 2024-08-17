package com.ebay.ocs.dal.sese.interactioninfo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class PhoneNumToLetter {
    Map<Character, String> phone = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    char[] digitsArr;
    List<String> res = new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        digitsArr = digits.toCharArray();
        //Base case
        if(digitsArr.length != 0){
            dfs(0, new StringBuilder());
        }
        return res;
    }
    private void dfs(int index, StringBuilder sb){
        //Base case
        if(index == digitsArr.length) {
            res.add(sb.toString());
            return;
        }
        String characters = phone.get(digitsArr[index]);
        for(char curChar : characters.toCharArray()){
            sb.append(curChar);
            dfs(index + 1, sb);
            sb.setLength(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        PhoneNumToLetter sol = new PhoneNumToLetter();
        List<String> list = sol.letterCombinations("23");
        list.stream().forEach(System.out::println);

    }
}