
public class Chicken extends Animal implements Workable
{
    private int myFriends;
    public Chicken(String n, int numFriends)
    {
        super(n);
        setMyFriends(numFriends);
    }

    @Override
    public String work()
    {
        return "I produce chicken";
    }

    @Override
    public String speak()
    {
        return "cluck cluck!";
    }

    @Override
    public String move()
    {
        return "I walk all around the coop";
    }
    
    public void characteristics()
    {
        super.characteristics();
        System.out.println("I have a ton of feathers.");
    }

    public int getMyFriends()
    {
        return myFriends;
    }

    public void setMyFriends(int myFriends)
    {
        this.myFriends = myFriends;
    }
    
    public String toString()
    {
        return super.toString()+" with "+myFriends+" friends!";
    }
}