package org.example;

import javax.naming.NamingException;
import java.util.Map;

public class RomantoInteger {
    public static final Map<Character,Integer> ROMAN_INTEGER = Map.of(
            'I',1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000

            );
    public int solution (String s){
        int sum = 0;
        int i = 0;
        for (i = 0; i <= s.length()-2; i++) {
            sum += checkNextCharacter(s.charAt(i), s.charAt(i + 1));
        }
        sum += RomantoInteger.ROMAN_INTEGER.get(i);
        return sum;
    }
    public int checkNextCharacter (Character currentCharacter, Character nextCharacter){
        if (currentCharacter == 'I' && (nextCharacter == 'V' || nextCharacter ==  'X')){
            return -1;
        }
        else if (currentCharacter == 'X' && (nextCharacter == 'L' || nextCharacter == 'C')){
            return -10;
        }
        else if (currentCharacter == 'C' && (nextCharacter == 'D' || nextCharacter == 'M')){
            return -100;
        }
        else {
            return RomantoInteger.ROMAN_INTEGER.get(currentCharacter);
        }
    }
}
