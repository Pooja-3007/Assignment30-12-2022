package Assignment;
import java.util.Scanner;


class InvalidAgeException extends Exception
{
	InvalidAgeException(String message)
	{
		super(message);
	}
}

public class AgeVote {
	public static void main(String args[])
	{
		int age;
		Scanner in=new Scanner(System.in);
		try
		{
			System.out.println("Enter Age");
			age=in.nextInt();
			if(age<18)
			{
				throw new InvalidAgeException("not");
			}		
		
		}
		catch(InvalidAgeException e)
		{
			System.out.println("Age Is Not Correct");
			System.out.println(e.getMessage());
		}
		finally
		{
			System.out.println("You are Eligible to vote");
		}
		
	}
}
