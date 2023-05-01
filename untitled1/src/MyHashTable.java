public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        chainArray = new HashNode[M];
        chainSize = new int[M];
    }

    public MyHashTable(int M) {
    }

    private int hash(K key) {
    }
    private int[] chainSize;

    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> node = chainArray[index];

        if (node == null) {
            chainArray[index] = new HashNode<>(key, value);
            size++;
        } else {
            while (node.next != null) {
                if (node.key.equals(key)) {
                    node.value = value;
                    return;
                }
                node = node.next;
            }
            if (node.key.equals(key)) {
                node.value = value;
            } else {
                node.next = new HashNode<>(key, value);
                size++;
            }
        }
        // Increment the number of elements in the bucket
        chainSize[index]++;

    }

    public V get(K key) {
    }

    public V remove(K key) {
    }

    public boolean contains(V value) {
    }
    public K getKey(V value) {
    }


}
public class HashTableTest {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();

        // Add elements to the table
        table.put(new MyTestingClass("key1"), new Student("John", 25));
        table.put(new MyTestingClass("key2"), new Student("Jane", 30));
        table.put(new MyTestingClass("key3"), new Student("Bob", 40));

        // Retrieve elements from the table
        Student s1 = table.get(new MyTestingClass("key1"));
        Student s2 = table.get(new MyTestingClass("key2"));
        Student s3 = table.get(new MyTestingClass("key3"));

        System.out.println(s1); // should print "Student{name='John', age=25}"
        System.out.println(s2); // should print "Student{name='Jane', age=30}"
        System.out.println(s3); // should print "Student{name='Bob', age=40}"
    }
}
