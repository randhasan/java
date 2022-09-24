
public class Worksheet
{
    
    public static void main(String[] args)
    {
        int[] nums = {3,6,5,1,9,2,4,0,8,7};
        insertionSort(nums);
    }
    
    public static void insertionSort(int[] arr)
    {
        int j = 0;
        for (int i = 1; i<arr.length; i++)
        {
            int value = arr[i];
            j=i;
            while(j > 0 && arr[j-1] >= value)
            {
                System.out.println(Integer.toString(i)+" "+Integer.toString(value)+" "+Integer.toString(j));
                //System.out.println(toString(arr));
                arr[j] = arr[j-1];
                j--;
                
            }
            arr[j] = value;
        }
    }
    
    public static String toString(int arr[])
    {
        String str = "";
        for (int i = 0; i<arr.length; i++)
        {
            str+= arr[i]+" ";
        }
        return str;
    }
}
