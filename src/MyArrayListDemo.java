public class MyArrayListDemo {
    public static void main(String[] args) {
        MyArrayList<Integer> myList=new MyArrayList<>();
        myList.add(15);
        myList.add(13);
        myList.add(5);
        myList.add(22);
        myList.add(1);
        myList.add(19);
        myList.display();

        myList.add(6,18);
        myList.display();

        myList.add(7,1);
        myList.display();

        myList.add(5,3);
        myList.display();

        myList.remove(3);
        myList.display();

        System.out.println("Size of list is: "+myList.size());
        System.out.println(myList.get(7));

        myList.clear();
        myList.display();
    }
}
