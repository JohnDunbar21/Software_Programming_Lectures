package Week_2.Single_and_Multidimensional_Arrays;

import java.util.ArrayList;

public class Arrays6 {

    public static void display(ArrayList<String> items, String header) {
        System.out.printf(header); // display header

        // display each element in items
        for (String item : items) {
            System.out.printf(" %s", item);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // create a new ArrayList of Strings with an initial capacity of 10
        ArrayList<String> items = new ArrayList<String>();

        items.add("red"); // append an item to the list
        items.add(0, "yellow"); // insert "yellow" at index 0

        // header
        System.out.print("Display list contents with counter-controlled loop:");

        // display the colours in the list
        for (int i = 0; i < items.size(); i++) {
            System.out.printf(" %s", items.get(i));
        }

        // display colours using enhanced for-loop in the display method
        display(items, "%nDisplay list contents with enhanced for-loop:");

        items.add("green"); // append "green" to the end of the list
        items.add("yellow"); // append "yellow" to the end of the list
        display(items, "List with two new elements:");

        items.remove("yellow"); // removes the first instance of "yellow", which is index 0
        display(items, "Remove first instance of yellow:");

        items.remove(1); // remove item at index 1
        display(items, "Remove second list element (green):");

        // check if a value is in the list
        System.out.printf("\"red\" is %s in the list%n", items.contains("red") ? "": "not");

        // display number of elements in the list
        System.out.printf("Size: %s%n", items.size());
    }
}
