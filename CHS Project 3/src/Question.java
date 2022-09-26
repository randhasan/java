public class Question
{
	private String Q;
	private String A;
	
	public Question(String ques, String ans)
	{
		Q = new String(ques);
		A = new String(ans);
	}
	
	public String getQ()
	{
		return Q;
	}
	
	public String getA()
	{
		return A;
	}
	
	public boolean equals(Question rhs)
	{
		return (Q.equals(rhs.Q) &&
		        A.equals(rhs.A));
	}
}
