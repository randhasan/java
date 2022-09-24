
public class Person extends Animal
{
    
    private int myAge;
   

    public Person(String n, int age)
    {
        super(n);
        setMyAge(age);
    }
    
    @Override
    public String speak()
    {
        return "I speak words in English with my mouth";
    }

    @Override
    public String move()
    {
        return "I walk on two legs";
    }
    
    public void characteristics()
    {
        super.characteristics();
        System.out.println("I am a student at PRHS");
    }

    public int compareTo(Person other)
    {
        if (myAge>other.getMyAge())
            return 1;
        else if (myAge<other.getMyAge())
            return -1;
        return 0; //equal
    }

    public int getMyAge()
    {
        return myAge;
    }

    public void setMyAge(int myAge)
    {
        this.myAge = myAge;
    }
    
    public String toString()
    {
        return super.toString()+" age: "+myAge;
    }
}