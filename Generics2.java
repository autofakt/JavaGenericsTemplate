import java.util.*;
import java.util.Scanner;

class Employee implements Comparable<Employee>{
    String name;
    int age;
    
    public Employee(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    public int compareTo(Employee other){
        if (this.age < other.age) {
            return -1;
        }
        if (this.age == other.age) {
            return 0;
        }
        return 1;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public String getName(){
        return this.name;
    }
}

class City implements Comparable<City>{
    String name;
    int pop;
    
    public City(String name, int pop){
        this.name = name;
        this.pop = pop;
    }
    
    public int compareTo(City other){
        if (this.pop < other.pop) {
            return -1;
        }
        if (this.pop == other.pop) {
            return 0;
        }
        return 1;
    }
    
    public int getPop(){
        return this.pop;
    }
    
    public String getName(){
        return this.name;
    }
}


class HighestLowest<T extends Comparable> {
    private T[] e;
    
    public HighestLowest(T[] tArray){
        this.e = tArray;
    }
    
    public T getMin(){
       T min = null;
       if(e.length == 0)
        return null;
       else{
           min = e[0];
       for( int i = 1; i < e.length; i++){
           if(min.compareTo(e[i])==1)
                min = e[i];
            }//for loop
       }//else
       return min;
    }//getMin()
    
    public T getMax(){
       T max = null;
       if(e.length == 0)
        return null;
       else{
           max = e[0];
       for( int i = 1; i < e.length; i++){
           if(max.compareTo(e[i])== -1)
                max = e[i];
            }//for loop
       }//else
       return max;
    }
    
}
public class Generics2
{
	public static void main(String[] args) {
	    Scanner keyboard = new Scanner(System.in);
	    String name;
	    int age;
	    int pop;
		Employee[] eArray = new Employee[3];
		City[] cArray = new City[3];
		

		
		for(int i = 1; i < 4; i++){
		    int index = i-1;
    		System.out.println("\nCollecting Employee" + i +" Information\n");
    		System.out.println("Please enter Employee" +i +" name: ");
    		name = keyboard.nextLine();
    		System.out.println("Please enter Employee" +i +" Age: ");
    		String temp = keyboard.nextLine();
    		age = Integer.parseInt(temp);
    		Employee e = new Employee(name,age);
    		eArray[index] = e;
		}
		
		for(int i = 1; i < 4; i++){
		    int index = i-1;
    		System.out.println("\nCollecting City" + i +" Information\n");
    		System.out.println("Please enter City" +i +" name: ");
    		name = keyboard.nextLine();
    		System.out.println("Please enter City" +i +" population: ");
    		String temp = keyboard.nextLine();
    		pop = Integer.parseInt(temp);
    		City c = new City(name,pop);
    		cArray[index] = c;
		}
		
		HighestLowest<Employee> h = new HighestLowest(eArray);
		
		Employee oldestE = h.getMax();
		System.out.println("The oldest employee is: " + oldestE.getName());
		Employee youngestE = h.getMin();
		System.out.println("The youngest employee: " + youngestE.getName());
		
		HighestLowest<City> c = new HighestLowest(cArray);
		
		City oldestC = c.getMax();
		System.out.println("The city with highest population is: " + oldestC.getName());
		City youngestC = c.getMin();
		System.out.println("The city with lowest population is: " + youngestC.getName());
		
	}
}





