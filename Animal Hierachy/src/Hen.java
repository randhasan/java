
public class Hen extends Chicken implements Workable
{
    private int hangoutTime;
    
    public Hen(String n, int numFriends, int time)
    {
        super(n, numFriends);
        setHangoutTime(time);
    }

    public int getHangoutTime()
    {
        return hangoutTime;
    }

    public void setHangoutTime(int hangoutTime)
    {
        this.hangoutTime = hangoutTime;
    }
    
    @Override
    public String speak()
    {
        return "coo coo!";
    }

    @Override
    public void characteristics()
    {
        super.characteristics();
        System.out.println("I lay eggs daily.");
    }

    public String toString()
    {
        return super.toString()+" I see my friends for "+hangoutTime+" hours a day.";
    }

    @Override
    public String work()
    {
        return "I hangout with my friends everyday!";
    }
}