package logoCompiler.lexer;

public class NumToken extends Token {
	public int attr;

	public NumToken(int attr) {
		this.attr = attr;
	}

	public int getAttr() {
		return attr;
	}
	
	public String toString(){
		return "NumToken:\"" + String.valueOf(attr) + "\"";
	}
}