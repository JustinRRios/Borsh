package lexer;

public enum TokenType {
    //Decleration keywords
    INT,        //java int
    DBL,        //java double
    CHR,        //java char
    STR,        //java String
    BOL,        //java boolean

    //Literal keywords
    INT_LIT,    //java integer literal
    DBL_LIT,    //java double literal
    CHR_LIT,    //java char literal
    STR_LIT,    //java string literal
    BOL_LIT,    //java boolean literal

    //operator keyworlds
    EQUALS,     // =
    PLUS,       // +
    MINUS,      // -
    MULTIPLY,   // *
    DIVIDE,     // /
    SEMICOLIN,  // ;
    
    //boolean operator keywords
    GREATER_THAN,    // >
    GREATER_THAN_OE, // >=
    EQUALS_EQUALS,   // ==
    LESS_THAN_OE,    // <=
    LESS_THAN,       // <
    AND,             // &&
    OR
    
}
