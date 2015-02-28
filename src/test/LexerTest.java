package test;

import java.io.IOException;
import java.util.ListIterator;

import exceptions.FormatException;
import logoCompiler.LogoPSCompiler;
import logoCompiler.lexer.*;

public class LexerTest {
public static void main(String[] args){
		
	String path = LogoPSCompiler.inputFile;
	
	try {
		Chunker chunkerTest = new Chunker(path);
		ListIterator<String> chunks = chunkerTest.allChunks().listIterator();
		
		while (chunks.hasNext()){
			System.out.print(chunks.next() + '\t' + '\t');
			System.out.println(Lexer.lex());
		}
	
	} catch (IOException e) {
		System.err.println(e.getMessage());
	} catch (FormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	
}

