
public class SelfDivisor
{

    public static void main(String args[])
    {
        int[] nums = firstNumSelfDivisors(10,3);
        for (int i:nums)
        {
            System.out.println(i);
        }
    }
    
    public static boolean isSelfDivisor(int number)
    {
        int digit = 0;
        int count1 = 0;
        int count2 = 0;
        while (number!=0)
        {
            digit = number % 10;
            if (digit == 0)
                return false;
            else if (number%digit == 0)
                count2++;
            count1++;
            number /= 10;
        }
        if (count1 == count2)
            return true;
        return false;
    }
    
    public static int[] firstNumSelfDivisors(int start, int num)
    {
        int[] nums = new int[num];
        for (int i = 0; i<num; i++)
        {
            boolean isSelf = false;
            while (isSelf == false)
            {
                isSelf = isSelfDivisor(start);
                if (isSelf == false)
                    start ++;
            }
            nums[i] = start;
            start++;
        }
        return nums;
    }
}
