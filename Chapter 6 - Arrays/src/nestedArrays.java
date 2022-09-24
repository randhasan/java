import java.util.Arrays;

public class nestedArrays {
	public static void main(String[] args)
	{
		int[] numbers = {0,1,2,3,4,5,6};
		int[] numbers1 = {0,1,2,3,4,5,6,7};
		int[][] numbers2 = {{12,3,5},{1,-8,9},{20,15,9},{0,18,-2}};
		int[][] array1 = convert(numbers);
		int[][] array2 = convert(numbers1);
		int[][] array3 = convert1(numbers);
		int[][] array4 = convert1(numbers1);
		int[][] array5 = translate(numbers2);
		System.out.print("Question 1 Odd Length: ");
		for(int[] element: array1)
		{
		    System.out.print(Arrays.toString(element));
		}
		System.out.println("");
		System.out.print("Question 1 Even Length: ");
		for(int[] element: array2)
		{
		    System.out.print(Arrays.toString(element));
		}
		System.out.println("");
		System.out.print("Question 2 Odd Length: ");
		for(int[] element: array3)
		{
		    System.out.print(Arrays.toString(element));
		}
		System.out.println("");
        System.out.print("Question 2 Even Length: ");
        for(int[] element: array4)
        {
            System.out.print(Arrays.toString(element));
        }
        System.out.println("");
        System.out.print("Question 3: ");
        for(int[] element: array5)
        {
            System.out.print(Arrays.toString(element));
        }
	}
	
	public static int[][] convert(int[] numbers)
	{
	    int numbers1[] = new int[numbers.length+1];
		int newArray[][];
		if(numbers.length%2==0)
		{
			newArray = new int [2][numbers.length/2];
		}
		else
		{
		    newArray = new int [2][];
		    newArray[0] = new int[(numbers.length/2)+1];
		    newArray[1] = new int [numbers.length/2];
		}
		int count = 0;
		for(int rows = 0; rows<2; rows++)
		{
			for (int cols = 0; cols<newArray[rows].length; cols++)
			{
			    newArray[rows][cols] = numbers[count];
				count++;
			}
		}
		return newArray;
	}
	
	public static int[][] convert1(int[] numbers)
	{
	    int newArray[][];
        if(numbers.length%2==0)
        {
            newArray = new int [2][numbers.length/2];
        }
        else
        {
            newArray = new int [2][];
            newArray[0] = new int[(numbers.length/2)+1];
            newArray[1] = new int [numbers.length/2];
        }
        int counter = 0;
		for(int rows = 0; rows<2; rows++)
        {
            for (int cols = 0; cols<newArray[rows].length; cols++)
            {
                newArray[rows][cols] = numbers[counter];
                counter+=2;
            }
            counter = 1;
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