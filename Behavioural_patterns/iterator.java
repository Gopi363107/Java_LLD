public class iterator {
    public static void main(String[] args) {
        Collection<String> collection = new NameCollection();
        Iterator<String> iterator = collection.createIterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

// iterator interface
interface Iterator<T>{
    boolean hasNext();
    T next();
}

//Aggregate interface
interface Collection<T>{
    Iterator<T> createIterator();
}

// concrete Aggregate
class NameCollection implements Collection<String>{
    private String[] names = {"Alice" , "Bob" , "Charlie"};

    public Iterator<String> createIterator(){
        return new NameIterator();
    }

    private class NameIterator implements Iterator<String> {
        int index = 0;

        public boolean hasNext(){
            return index < names.length;
        }

        public String next(){
            return names[index++];
        }
    }
}
