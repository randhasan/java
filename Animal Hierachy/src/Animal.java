
public abstract class Animal
{
    private String name;
    
    public Animal(String n)
    {
        setName(n);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    
    public String toString()
    {
        return "My name is "+name+" and I am a(n) "+this.getClass().getSimpleName();
    }
    
    public void characteristics()
    {
        System.out.println("Ah ah ah ah....Staying Alive");
    }
    
    //Abstract methods
    public abstract String speak();
    public abstract String move();
}