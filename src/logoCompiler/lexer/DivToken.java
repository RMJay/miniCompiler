package logoCompiler.lexer;

public class DivToken extends OperatorToken 
{

	@Override
	public String psOpCode() 
	{
		return "div";
	}

	@Override
	public int precedence() 
	{
		return 3;
	}
	
	public String toString(){
		return "DivToken";
	}

}
