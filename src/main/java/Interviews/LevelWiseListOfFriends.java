package Interviews;

import java.util.*;

public class LevelWiseListOfFriends {
    /*
    graph = {
        "Alice": ["Bob", "Claire"],
        "Bob": ["Alice", "Dan", "Eve"],
        "Claire": ["Alice", "Fay"],
        "Dan": ["Bob"],
        "Eve": ["Bob"],
        "Fay": ["Claire"]
    }
     */


    public static void main(String[] args) {
        Person alice = new Person("Alice");
        Person bob = new Person("Bob");
        Person claire = new Person("Claire");
        Person dan = new Person("Dan");
        Person eve = new Person("Eve");
        Person fay = new Person("Fay");

        alice.addFriend(bob); alice.addFriend(claire);
        bob.addFriend(alice); bob.addFriend(dan); bob.addFriend(eve);
        claire.addFriend(alice); claire.addFriend(fay);
        dan.addFriend(bob);
        eve.addFriend(bob);
        fay.addFriend(claire);

        List<Person> personList = new ArrayList<>();
        personList.add(alice);
        personList.add(bob);
        personList.add(claire);
        personList.add(dan);
        personList.add(eve);
        personList.add(fay);

        LevelWiseListOfFriends obj = new LevelWiseListOfFriends();
        obj.findFriendshipLevel(personList, alice);
    }

    public void findFriendshipLevel(List<Person> personList, Person start) {

        Queue<Person> queue = new LinkedList<>();
        queue.add(start);
        int level = 0;
        Map<Integer, List<String>> result = new HashMap<>();
        Map<Person, Boolean> visited = new HashMap<>();
        visited.put(start, true);

        while (!queue.isEmpty()) {
            level++;
            int sizeAtThisLevel = queue.size();
            for(int i=0; i<sizeAtThisLevel; i++) {
                Person person = queue.poll();
                for(Person friend : person.friends) {
                    if(!visited.getOrDefault(friend, false)) {
                        visited.put(friend, true);
                        List<String> friendList = result.getOrDefault(level, new ArrayList<>());
                        friendList.add(friend.name);
                        result.put(level, friendList);
                        queue.add(friend);
                    }
                }
            }
        }

        System.out.println();
    }
}

class Person {
    String name;
    List<Person> friends = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public void addFriend(Person p) {
        this.friends.add(p);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
