package lexer;

import java.util.List;
import java.util.ArrayList;

public class Tokenizer {

    public static List<Token> tokenize(String source){
        ArrayList<Token> tokens = new ArrayList<>();
        String buffer = "";
        for(int i = 0; i < source.length(); i++){
            char cur = source.charAt(i);
            if(cur == '\''){
                int index = 1;
                if(i+index < source.length() && source.charAt(i+index) == '\\'){
                    index++;
                }
                index++;
                if(i+index >= source.length() || source.charAt(i+index) != '\''){
                    throw new RuntimeException("Unterminated char literal at " + i);
                }
                tokens.add(new Token(TokenType.CHR_LIT, source.substring(i+1,i+index)));
                i+=index;
            }else if (cur == '\"'){ // FOR REVIEW
                int openCount = 1;
                int index = 1;
                depthcheck:
                while(true){
                    if(i+index >= source.length()){
                        throw new RuntimeException("Unterminated string at " + i);
                    }
                    char stringCur = source.charAt(i+index);
                    if(stringCur == '\\'){
                        index++; 
                    }else if(stringCur == '\"'){
                        openCount--;
                        if(openCount == 0){
                            break depthcheck;
                        }
                    }
                    index++;
                }
                tokens.add(new Token(TokenType.STR_LIT,source.substring(i+1,i+index)));
                i+=index;
            }
        }
        return tokens;
    }



    public static boolean tokenIsNumber(String scope){
        for(int i = 0; i < scope.length(); i++){
            if(!Character.isDigit(scope.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean isDelimiter(char c){
        if(c == ';'){
            return true;
        }else if (c == ' '){
            return true;
        }
        return false;
    }

}
