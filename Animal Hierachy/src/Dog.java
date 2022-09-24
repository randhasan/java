
public class Dog extends Animal implements Workable
{
    public Dog(String n)
    {
        super(n);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String work()
    {
        return "I herd the cows in the pasture";
    }

    @Override
    public String speak()
    {
        return "woof woof!";
    }

    @Override
    public String move()
    {
        return "Run boy run";
    }
    
    public void characteristics()
    {
        super.characteristics();
        System.out.println("I am furry and a man's best friend");
    }
}