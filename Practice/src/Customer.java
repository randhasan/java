
public class Customer
{

    public static void main(String args[])
    {
        
    }
    
    public int compareCustomer(Customer other)
    {
        if (this.getName().equals(other.getName()) && this.getID().equals(other.getID()))
        {
            return 0;
        }
        else if (this.getName().equals(other.getName()))
        {
            return this.getID()-other.getID();
        }
        else
        {
            return this.getName().compareTo(other.getName());
        }
        return 0;
    }
    
    public static void prefixMerge(Customer[] list1, Customer[] list2, Customer[] result)
    {
        int start1 = 0, start2 = 0;
        for (int i = 0; i<result.length; i++)
        {
            int compare = list1[start1].compareCustomer(list2[start2]);
            if (compare == 0)
            {
                result[i] = list1[start1];
                start1 ++;
                start2 ++;
            }
            else if (compare < 0)
            {
                result[i] = list1[start1];
                start1 ++;
            }
            else
            {
                result[i] = list2[start2];
                start2 ++;
            }
           
        }
    }
}