import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Valerie Klosky
 * -demonstrates use of Workable and Comparable interfaces
 * -utilizes abstract class of animals
 * -notice use of instanceof operator
 * -notice use of Arrays.asList when instantiating the workers ArrayList
 *
 */
public class OldMacDonaldDriver 
{

    public static void main(String[] args)
    {
        Farmer om = new Farmer("Old MacDonald", 34, 15);
        Farmer bob = new Farmer("Bob", 54, 15);
        Farmer brown = new Farmer("Brown", 45, 10);
        Farmer maggie = new Farmer("Maggie", 30, 5);
        Farmer kevin = new Farmer("Kevin", 20, 4);
        Farmer kyle = new Farmer("Kyle", 21, 5);
        Dog d = new Dog("Rover");
        Cow c = new Cow("Bessie");
        Pig p = new Pig("Wilbur");
        Chicken ch = new Chicken("Andy",3);
        Chicken h = new Hen("Cathy", 5, 12);
        
        ArrayList<Animal> animals=new ArrayList<Animal>(Arrays.asList(om,d,c,p,ch,h));
        ArrayList<Farmer>farmers = new ArrayList<Farmer>(Arrays.asList(om,bob,brown,maggie,kevin,kyle));
        
        //output info about each animal (a fun little song)
        for(Animal a:animals)
        {
            System.out.println(a);
            System.out.println(a.move());
            a.characteristics();
            
            if(a instanceof Farmer)
                System.out.println(a.getName() + ": \n"  + ((Farmer)a).work() + "\n" + a.speak() + "\n");
            else 
            {
                System.out.println(a.getName() + ": "  + ((Workable)a).work() + "\nwith a " + a.speak() + " " + a.speak() + " here,");
                System.out.println("and a " + a.speak() + " " + a.speak() + " there,");
                System.out.println("Here a " + a.speak() + " there a " + a.speak() + " everywhere a " + a.speak() + " "+a.speak() + "\n");
                System.out.println(om.getName()  + ": \n" + ((Workable)om).work() + "\n" + om.speak() + "\n");
            
            }
        }
        
        //output unsorted farmer information
        System.out.println("The farmers in the county include:");
        for(Farmer f:farmers)
            System.out.println(f);
    
        //farmers sort using compareTo() - sort by experience and then by age
        Collections.sort(farmers);
        
        
        System.out.println("\n\nLow to high farming experience");
        for (Farmer f:farmers)
            System.out.println(f);
            
        System.out.println(farmers.get(farmers.size()-1).getName() + " is the veteran farmer!");


    }

}