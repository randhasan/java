import java.util.Arrays;

public class nestedArrays {
	public static void main(String[] args)
	{
		int[] numbers = {1,2,3,4,5,6,7,8};
		String array1 = Arrays.toString(convert(numbers));
		String array2 = Arrays.toString(convert1(numbers));
		System.out.println(array1);
		System.out.println(array2);
		
	}
	
	public static int[][] convert(int[] numbers)
	{
		int numrows = 2;
		int numcols = 0;
		if(numbers.length%2==0)
		{
			numcols = numbers.length/2;
		}
		else
		{
			numcols = (numbers.length+1)/2;
		}
		int newArray[][] = new int[numrows][numcols];
		for(int rows = 0; rows<numrows; rows++)
		{
			for (int cols = 0; cols<numcols; cols++)
			{
				newArray[rows][cols] = numbers[cols+rows];
			}
		}
	return newArray;
	}
	
	public static int[][] convert1(int[] numbers)
	{
		int numcols = 2;
		int numrows = 0;
		if (numbers.length%2==0)
		{
			numrows = numbers.length/2;
		}
		else
		{
			numrows = (numbers.length+1)/2;
		}
		int newArray[][] = new int[numcols][numrows];
		int counter = 0;
		for (int rows = 0; rows<numrows; rows+=2)
		{
			newArray[0][counter] = numbers[rows];
			counter++;
		}
		counter = 0;
		for (int rows = 1; rows<numrows; rows+=2)
		{
			newArray[1][counter] = numbers[rows];
			counter++;
		}
		return newArray;
	}
	
	public static int[][] translate(int[][] numbers)
	{
		int numrows = numbers.length;
		int numcols = numbers[0].length;
		int newArray[][] = new int[numcols][numrows];
		for (int rows = 0; rows<numrows; rows++)
		{
			for (int cols = 0; cols<numcols; cols++)
			{
				newArray[cols][rows] = numbers[rows][cols];
			}
		}
		return newArray;
	}
}

