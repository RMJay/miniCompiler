package logoCompiler.lexer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Chunker {

	BufferedReader reader;
	//String outputFilePath = "outputs/chunker.t";

	public Chunker(String path) throws FileNotFoundException {
		this.reader = new BufferedReader(new FileReader(path));
	}

	public List<String> allChunks() throws IOException {

		List<String> allChunks = new ArrayList<String>();
		int ascii = reader.read();
		int prev = -1;
		StringBuilder chunkBuilder = new StringBuilder(99);
		String chunk;
		
		while (ascii != -1){ //-1 means end of file
			char ch = (char) ascii;
			
			//skip the white space
			while (ch == ' ' || ch == '\n'|| ch == '\t') { 
				ascii = reader.read();
				if (ascii != -1) {
					ch = (char)ascii;
				} else {
					break;
				}
			}
			
			//build a chunk of characters and turn them into a string
			if (ascii != -1) { //-1 means end of file
				do {
					chunkBuilder.append(ch); //start forming the chunk<String> by adding chars
					prev = ascii;
					ascii = reader.read();
					if (ascii == -1) { //if end of file reached
						break;
					}
					ch = (char)ascii;
				} while (!delimiter(ascii, prev)); //the end of a chunk is signified by a delimiter
				chunk = chunkBuilder.toString(); 
				chunkBuilder.setLength(0); //reset the chunk builder ready for next time
				allChunks.add(chunk); //add the chunk to the list of allChunks
			}
		}
		chunk = "END_OF_FILE";
		allChunks.add(chunk); //the last chunk is "END_OF_FILE"
		reader.close();
		return allChunks;
	}

	//rules for whether a character is a delimiter, sometimes this depends on the previous character eg "!="
	public boolean delimiter(int ascii, int prev) { 
		boolean result = true;
		if (prev == -1) {	//-1 means there is not a previous character in the chunk
			if (letterOrNum(ascii)	|| ascii == 61 || ascii == 33 || ascii == 60 || ascii == 62) { 
				result = false; 
			}
		} else {
			if (letterOrNum(ascii)) { 
				result = false; 
			}
			if (!letterOrNum(prev)) { 
				if(letterOrNum(ascii)) { 
					result = true;
				}
			}
			if (prev == 61 || prev == 33 || prev == 60 || prev == 62) { // if prev is '=', '!', '<', '>'
				if (ascii == 61) { //and current is '='
					result = false;
				}
			}
		}
		return result;
	}  

	public boolean letterOrNum(int ascii) {	//returns true if a char is a letter or number
		boolean result;
		if ((ascii >= 65 && ascii <= 90) // 'A'...'Z'
			|| (ascii >= 97 && ascii <= 122) // 'a'...'z'
		  	|| (ascii >= 48 && ascii <= 57)) {  // '0'...'9'
		  	result = true; 
		} else {
			result = false;
		}
		return result;
	} 
	
}

