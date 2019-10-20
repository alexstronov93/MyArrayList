import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyArrayList<T> implements Iterable<T>{
    private static final int initialCapacity = 10;
    private static int size;
    private static int index;
    private Object list[] = {};

    public MyArrayList(Object[] list) {
        this.list = list;
    }

    public MyArrayList() {
        list = new Object[initialCapacity];
    }

    public void add(T element) {
        if (size == list.length - 1) {
            addCapacity();
        }
        list[size++] = element;
    }


    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + size);
        }
        if (index > list.length - 1) {
            addCapacity();

        }
        if (index < size) {
            for (int tmp = size + 1; tmp > index; tmp--) {
                list[tmp] = list[tmp - 1];
            }
            list[index] = element;
            size++;
        } else {
            list[size++] = element;
        }
    }


    private void addCapacity() {
        int newCapacity = list.length * 2;
        Object[] newList = new Object[newCapacity];
        list = Arrays.copyOf(list, newCapacity);
    }


    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + size);
        }
        Object removeElement = list[index];
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        size--;
        return (T) removeElement;
    }


    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }
        return (T) list[index];
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            list[i] = null;
        }
        size = 0;
    }

    public void display() {
        System.out.print("Displaying list : ");
        for (int i = 0; i < size; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "MyArrayList" +
                "list=" + Arrays.toString(list);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArrayList<?> that = (MyArrayList<?>) o;
        return Arrays.equals(list, that.list);
    }


    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && list[currentIndex] != null;
            }

            @Override
            public T next() {
                return (T) list[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}


