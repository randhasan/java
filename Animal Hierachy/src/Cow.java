
public class Cow extends Animal implements Workable
{
    public Cow(String n)
    {
        super(n);
    }

    @Override
    public String work()
    {
        return "I produce milk for the farm";
    }

    @Override
    public String speak()
    {
        return "moo!";
    }

    @Override
    public String move()
    {
        return "I'm a strollin' with my herd!";
    }
    
    public void characteristics()
    {
        super.characteristics();
        System.out.println("I make beef in my body");
    }
}