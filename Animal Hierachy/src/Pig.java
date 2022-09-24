
public class Pig extends Animal implements Workable
{
    public Pig(String n)
    {
        super(n);
    }

    @Override
    public String work()
    {
        return "Makin' bacon for the farm";
    }

    @Override
    public String speak()
    {
        return "oink!";
    }

    @Override
    public String move()
    {
        return "I just roll in the mud all day long";
    }
    
    public void characteristics()
    {
        super.characteristics();
        System.out.println("I am a dirty beast");
    }
}