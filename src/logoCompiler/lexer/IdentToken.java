package logoCompiler.lexer;


public class IdentToken extends Token {

	String attr;

	public IdentToken(String chunk) {
		this.attr = chunk;
	}

	public String getAttr() {
		return attr;
	}

	public String toString() {
		return "IdentToken:\"" + attr + "\"" ;
	}

}
