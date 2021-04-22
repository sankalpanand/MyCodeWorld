package JavaConcepts;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Sorting {


    public static void main(String[] args) {
//        sortMapByKey();
//        sortMapByValueJava8();
//        sortByValue();


    }


    public void arraysSort() {
        String[] months = {"January","February","March","April","May","June","July","August","September","October","December"};

        Arrays.sort(months, Comparator.comparingInt(String::length));
        Arrays.sort(months, (String a, String b) -> a.length() - b.length());
        Arrays.sort(months, (a, b) -> a.length() - b.length());
    }

    public void collectionsSort() {
        ArrayList<String> al = new ArrayList<String>();
        al.add("Geeks For Geeks");
        al.add("Friends");
        al.add("Dear");
        al.add("Is");
        al.add("Superb");


        Collections.sort(al);

        // Sort Descending */
        Collections.sort(al, Collections.reverseOrder());
    }

    public void sortCustomComparator() {
        ArrayList<Student> ar = new ArrayList<Student>();
        ar.add(new Student(111, "bbbb", "london"));
        ar.add(new Student(131, "aaaa", "nyc"));
        ar.add(new Student(121, "cccc", "jaipur"));

        System.out.println("Unsorted");

        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));

        Collections.sort(ar, new MyCustomComparator());

        System.out.println("\nSorted by rollno");
        for (int i=0; i<ar.size(); i++)
            System.out.println(ar.get(i));
    }

    class Student
    {
        int rollno;
        String name, address;

        // Constructor
        public Student(int rollno, String name,
                       String address)
        {
            this.rollno = rollno;
            this.name = name;
            this.address = address;
        }

        // Used to print student details in main()
        public String toString()
        {
            return this.rollno + " " + this.name +
                    " " + this.address;
        }
    }

    class MyCustomComparator implements Comparator<Student>
    {
        // Used for sorting in ascending order of
        // roll number
        public int compare(Student a, Student b)
        {
            int result = a.rollno - b.rollno;
            if(result == 0) {
                result = a.name.compareTo(b.name);
            }
            return result;
        }
    }

    // Sort Map
    public static void sortMapByKey() {

        Map<String, Integer> map = getUnSortedMap();

        System.out.println("Before sorting");
        for (String str : map.keySet()) {
            System.out.println(str);
        }

        System.out.println("After sorting");
        Map<String, Integer> treeMap = new TreeMap<>(map);
        for (String str : treeMap.keySet()) {
            System.out.println(str);
        }
    }

//    public void sortMapByValue() {
//        List<Entry<K, V>> list = new ArrayList<Entry<K, V>>(map.entrySet());
//        list.sort(Entry.comparingByValue());
//
//        Map<K, V> result = new LinkedHashMap<>();
//        for (Entry<K, V> entry : list) {
//            result.put(entry.getKey(), entry.getValue());
//        }
//
//        return result;
//
//    }

    public static void sortMapByValueJava8() {
        Map<String, Integer> unSortedMap = getUnSortedMap();

        System.out.println("Unsorted Map : " + unSortedMap);

        //LinkedHashMap preserve the ordering of elements in which they are inserted
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

        unSortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        // Descending
        // unSortedMap.entrySet()
        //    .stream()
        //    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        //    .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        System.out.println("Sorted Map   : " + sortedMap);

    }

    // function to sort hashmap by values
    public static Map<String, Integer> sortByValue()
    {
        Map<String, Integer> unSortedMap = getUnSortedMap();
        System.out.println("Unsorted Map : " + unSortedMap);

        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unSortedMap.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        Map<String, Integer> sortedMap = new LinkedHashMap<>();

        for (Map.Entry<String, Integer> aa : list) {
            sortedMap.put(aa.getKey(), aa.getValue());
        }

        System.out.println("Sorted Map   : " + sortedMap);

        return sortedMap;
    }

    public static Map<String, Integer> getUnSortedMap() {
        Map<String, Integer> map = new HashMap<>();

        map.put("alex", 1);
        map.put("david", 2);
        map.put("elle", 3);
        map.put("charles", 4);
        map.put("brian", 5);

        return map;
    }

    // Refer this
    // https://stackoverflow.com/questions/27029296/java-how-can-i-sort-an-array-of-objects-and-break-ties-between-two-objects/27029378
}


