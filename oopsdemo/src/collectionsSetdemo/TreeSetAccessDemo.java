package collectionsSetdemo;

//accessing elements of a treeset
import java.util.TreeSet;

public class TreeSetAccessDemo {

	public static void main(String[] args) {
		// it will sort ignoring the upper and lower case characters
		TreeSet<String> students = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        students.add("Julia");
        students.add("Robert");
        students.add("Mark");
        students.add("Steven");
        students.add("mike");

        System.out.println("Students TreeSet : " + students);

        // Finding the size of a TreeSet
        System.out.println("Number of elements in the TreeSet : " + students.size());

        // Check if an element exists in the TreeSet
        String name = "Julia";
        if(students.contains(name)) {
            System.out.println("TreeSet contains the element : " + name);
        } else {
            System.out.println("TreeSet does not contain the element : " + name);
        }

        // Navigating through the TreeSet
        System.out.println("First element : " + students.first());
        System.out.println("Last element : " + students.last());

        //it will check for the higher and lower element from the name mentioned
        name = "Robert";
        System.out.println("Element just greater than "  + name + " : " + students.higher(name));
        System.out.println("Element just lower than "  + name + " : " + students.lower(name));


	}

}
