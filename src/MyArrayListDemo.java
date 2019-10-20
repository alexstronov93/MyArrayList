import java.awt.*;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class MyArrayListDemo {
    public static void main(String[] args) {
        MyArrayList<Integer> myList = new MyArrayList<>();
        myList.add(15);
        myList.add(13);
        myList.add(5);
        myList.add(22);
        myList.add(1);
        myList.add(19);
        myList.display();

        myList.add(6, 18);
        myList.display();

        myList.add(7, 1);
        myList.add(8, 15);
        myList.add(9, 23);
        myList.add(10, 54);
        myList.add(6, 2);

        myList.display();

        System.out.println("Size of list is: " + myList.size());
        System.out.println(myList.get(11));
        System.out.println();

        Iterable<Integer> iterable = myList;
        Iterator<Integer> iterator = myList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();

        myList.clear();
        myList.display();


    }
}
