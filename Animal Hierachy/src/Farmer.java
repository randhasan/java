public class Farmer extends Person implements Workable,Comparable<Farmer>
{
    private int yearsExperience;
    
    public Farmer(String n, int age, int years)
    {
        super(n, age);
        setYearsExperience(years);
    }
    
    @Override
    public String speak()
    {
        return "E-I-E-I-O";
    }

    
    public void characteristics()
    {
        super.characteristics();
        System.out.println("I plant the fields");
    }

    public int compareTo(Farmer other)
    {
        if (yearsExperience>other.getYearsExperience())
            return 1;
        else if (yearsExperience<other.getYearsExperience())
            return -1;
        return super.compareTo(other); //equal
    }
    
    public String toString()
    {
        return super.toString()+" with: "+yearsExperience+" years experience.";
    }

    public int getYearsExperience()
    {
        return yearsExperience;
    }

    public void setYearsExperience(int yearsExperience)
    {
        this.yearsExperience = yearsExperience;
    }
    
    @Override
    public String work()
    {
        return "I'm riding on my tractor, yeah!";
    }
}