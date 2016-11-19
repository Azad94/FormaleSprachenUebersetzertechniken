package main;

import recDescent.*;

public class TestRecLexer {
	public static void main(String[] args) {
		
		//Lexer lexer = new RecDesLexer("dummy = 44 - 33\n + i9");
		Lexer lexer = new RecDesLexer("5 + (10 - 23)");
		Token t = lexer.nextToken();
        while ( t.type != Lexer.EOF_TYPE ) {
            System.out.println(t);
            t = lexer.nextToken();
        }
	}
}