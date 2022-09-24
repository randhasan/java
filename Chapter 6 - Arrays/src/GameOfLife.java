import java.util.*;

/**
 * @author Rand Hasan, Period 11
 * 11/5/2019
 * GameOfLife.java Ch7 Arrays, Game of Life Assignment
 * This is a program of the Game of Life which models a simple world consisting of a 2D plane of cells. User
 * begins game by choosing coordinates for live cells for the 1st day. As the days go on, the creatures are born
 * or die according to the number of neighboring creatures from the previous day.
 */

public class GameOfLife
{
    public static void main(String[] args)
    {
        int life[][] = new int[5][5]; //initializes matrix
        int day = 1; //game starts at day 1
        System.out.println("Enter -1 once you have finished entering the coordinates of live cells.\n"); //loop continues until flag value, -1, is entered
        int row = -2, col = -2; //initializes row and col values which will be entered by user
        while ((row!= -1 || col!=-1)) //while flag value hasn't been enter
        {
            row = getCoordinate('r');
            if (row == -1)
            {
                break;
            }
            col = getCoordinate('c');
            if (col == -1)
            {
                break;
            }
            boolean isValid = isValidCell(row, col, life); //checks if coordinates are within range
            if (isValid == true) //if coordinates entered by user are within the range of the matrix, place a cell in the designated row and column
            {
                life[row][col] = 1;
            }
            System.out.println();
        }
        System.out.println("\n----------------- Day "+day+" -----------------");
        printData(life); //output columnar data
        System.out.println();
        String continue1 = InputMethods.getChoiceYN("Do you wish to continue? "); //asks user if they wish to continue playing the game
        while (continue1.equals("y")) //while user wishes to continue the game
        {
            day++; //days of the game increase
            System.out.println("----------------- Day "+day+" -----------------");
            life = createNewDay(life); //fill matrix with new cells for the new day
            printData(life); //output columnar data of the updated matrix
            System.out.println();
            continue1 = InputMethods.getChoiceYN("Do you wish to continue? ");
        }
        System.out.print("Game over."); //output when the user no longer wishes to continue to play the game      
    }
    
    /**
     * Checks to see if a cell can be placed into the desired row and column inputed by the user
     * @param row the row that the user wishes to place a cell in
     * @param col the column that the user wishes to place a cell in
     * @param matrix the array that stores cells and will hold the cells the user wishes to place in the desired row and column
     * @return true if the cell is within the bounds of the matrix
     */
    public static boolean isValidCell(int row, int col, int[][] matrix)
    {
        
        if ((row>matrix.length-1 || row<0) || (col>matrix.length-1 || col<0)) //if the values entered for the row and the column are greater than 0 and less than 4
        {
            System.out.println("Error: cell with those coordinates is out of bounds."); //print if coordinates are invalid
            return false;
        }
        return true; //coordinates are valid
    }
    
    /**
     * Makes sure that the user enters integers (and not any other data type) for the coordinates of the cell that are within the range of the matrix or are the flag variable
     * @param type determines if the user is entering the row or the column that a cell is in
     * @return the coordinate for the row or column if it is an integer in the range of the matrix or the flag variable
     */
    public static int getCoordinate(char type)
    {
        Scanner input = new Scanner(System.in);
        boolean done = false;
        int num = -2; //initializes the row or column that a cell will be placed in
        do
        {
            try {
                if (type == 'r')
                {
                    System.out.print("Enter the row (0-4) of the cell: ");
                    num = input.nextInt();
                    if (num>= -1 && num<=4) //if row number is within range or flag value, loop will end program can move onto next coordinate
                    {
                        done = true; //loop will end
                    }
                }
                else if (type == 'c')
                {
                    System.out.print("Enter the column (0-4) of the cell: "); 
                    num = input.nextInt();
                    if (num>= -1 && num<=4) //if column number is within range or flag value, loop will end and program can move onto asking coordinates of next living cell
                    {
                        done = true; //loop will end
                    }
                }
            }
            catch (InputMismatchException ex) //user enters data type other than integer
            {
                input.nextLine(); //prevents runtime errors
                System.out.println("Error: Please enter a valid integer."); //tells user to enter a valid integer
            }
                
        } while (!done); //if user didn't enter a valid integer in the range, they will be prompted to do so until they have
        return num; //if user entered a valid coordinate, it will be returned
    }
    /**
     * Loops through the elements in the array called matrix and prints an X if they store a one and 0 if they store a zero
     * @param matrix the array that is looped through to print out columnar data
     */
    public static void printData(int[][] matrix)
    {
        for (int rows = 0; rows<matrix.length; rows++)
        {
            for (int cols = 0; cols<matrix[0].length; cols++)
            {
                if (matrix[rows][cols] == 1) //if the number 1 is stored in a cell in the matrix
                    System.out.printf("%s","X "); //print an X
                else // if the number 0 is stored in a cell in the matrix
                    System.out.printf("%s","0 "); //print a 0
            }
            System.out.println();
        }
    }
    
    /**
     * Loops through the array, matrix, and applies rules to each cell to determine in they will be alive or dead on the following day
     * @param matrix the array that is looped through in order to apply the rules to each cell to create the array for the next day
     * @return the array holding cells for the following day
     */
    public static int[][] createNewDay(int[][] matrix)
    {
        int nextMatrix[][] = new int[5][5]; //initializes matrix that will hold cells for the following day
        for (int row = 0; row<matrix.length; row++)
        {
            for (int col = 0; col<matrix[0].length; col++)
            {
                int neighbors = findNumNeighbors(matrix, row, col); //calculate the number of cells that hold a one and are neighboring the cell
                if (matrix[row][col] == 1) //if cell was alive on the previous day
                {
                    if (neighbors == 2 || neighbors == 3) //if num of neighbors was 2 or 3
                        nextMatrix[row][col] = 1; //cell remains alive
                    else
                        nextMatrix[row][col] = 0; //cell dies
                }
                else if (matrix[row][col] == 0) //if cell was not alive on the previous day
                {
                    if (neighbors == 3) //if number of neighbors was exactly 3
                        nextMatrix[row][col] = 1; //cell becomes alive
                    else
                        nextMatrix[row][col] = 0; //cell remains dead
                }
            }
        }
        for (int row = 0; row<matrix.length; row++)
        {
            for (int col = 0; col<matrix[0].length; col++)
            {
                matrix[row][col] = nextMatrix[row][col]; //the value in each cell in the matrix for the following day is stored in the corresponding cell in the matrix for the current day
            }
        }
        return matrix; //return matrix with values for the current day
    }
    
    /**
     * Calculates the number of cells that store the number one and adjoin the cell in the row and column that were called either horizontally, vertically, or diagonally
     * @param matrix the array that stores all of the cells in the game
     * @param row the row of the cell in the matrix whose number of neighbors is being calculated
     * @param col the column of the cell in the matrix whose number of neighbors is being calculated 
     * @return the number of cells that store the number one and are neighboring the cell in the row and column that were called
     */
    
    public static int findNumNeighbors(int[][] matrix, int row, int col)
    {
        int num = 0; //number of neighbors
        if (row != 0 && col != 0 && row != 4 && col != 4) //if cell is not located in any of the outer rows or columns
        {
            if (matrix[row+1][col+1] == 1)
                num ++;
            if (matrix[row+1][col] == 1)
                num ++;
            if (matrix[row+1][col-1] == 1)
                num ++;
            if (matrix[row][col-1] == 1)
                num ++;
            if (matrix[row-1][col-1] == 1)
                num ++;
            if (matrix[row-1][col] == 1)
                num ++;
            if (matrix[row-1][col+1] == 1)
                num ++;
            if (matrix[row][col+1] == 1)
                num ++;
        }
        else if (row != 0 && row != 4 && (col==0||col==4)) //if cell is not located on any of the outer rows but is in one of the outer columns
        {
            if (col == 0) //if cell is located in the first column
            {
                if (matrix[row-1][col] == 1)
                    num ++;
                if (matrix[row-1][col+1] == 1)
                    num ++;
                if (matrix[row][col+1] == 1)
                    num ++;
                if (matrix[row+1][col+1] == 1)
                    num ++;
                if (matrix[row+1][col] == 1)
                    num ++;
            }
            else if (col == 4) //if cell is located in the last column
            {
                if (matrix[row-1][col] == 1)
                    num ++;
                if (matrix[row-1][col-1] == 1)
                    num ++;
                if (matrix[row][col-1] == 1)
                    num ++;
                if (matrix[row+1][col-1] == 1)
                    num ++;
                if (matrix[row+1][col] == 1)
                    num ++;
            }
        }
        else if (row == 0 || row == 4) //if cell is located in any of the outer rows
        {
            if (row == 0) //if cell is located in the first row
            {
                if (col == 0) //if cell is in the upper left-hand corner
                {
                    if (matrix[row+1][col] == 1)
                        num ++;
                    if (matrix[row+1][col+1] == 1)
                        num ++;
                    if (matrix[row][col+1] == 1)
                        num ++;
                }
                else if (col == 4) //if cell is in the upper right-hand corner
                {
                    if (matrix[row][col-1] == 1)
                        num ++;
                    if (matrix[row+1][col-1] == 1)
                        num ++;
                    if (matrix[row+1][col] == 1)
                        num ++;
                }
                else if (col>0 && col<4) //if cell is in neither of the corners in the first row
                {
                    if (matrix[row][col-1] == 1)
                        num ++;
                    if (matrix[row][col+1] == 1)
                        num ++;
                    if (matrix[row+1][col] == 1)
                        num ++;
                    if (matrix[row+1][col+1] == 1)
                        num ++;
                    if (matrix[row+1][col-1] == 1)
                        num ++;
                }
            }
            else if (row == 4) //if cell is located in the last row
            {
                if (col == 0) //if cell is in the lower left-hand corner
                {
                    if (matrix[row-1][col] == 1)
                        num ++;
                    if (matrix[row][col+1] == 1)
                        num ++;
                    if (matrix[row-1][col+1] == 1)
                        num ++;
                }
                else if (col == 4) //if cell is in the lower right-hand corner
                {
                    if (matrix[row-1][col] == 1)
                        num ++;
                    if (matrix[row][col-1] == 1)
                        num ++;
                    if (matrix[row-1][col-1] == 1)
                        num ++;
                }
                else if (col>0 && col<4) //if cell is in neither of the corners in the last row
                {
                    if (matrix[row][col-1] == 1)
                        num ++;
                    if (matrix[row-1][col-1] == 1)
                        num ++;
                    if (matrix[row-1][col] == 1)
                        num ++;
                    if (matrix[row-1][col+1] == 1)
                        num ++;
                    if (matrix[row][col+1] == 1)
                        num ++;
                }
            }
        }
        return num; //return the number of neighboring cells that store the number one
    }
}