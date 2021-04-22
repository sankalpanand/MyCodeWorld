package Leetcode.Medium;

import java.util.HashMap;
import java.util.Map;

public class DesignFileSystem {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();

        fileSystem.create("/leet", 1); // return true
        fileSystem.create("/leet/code", 2); // return true
        fileSystem.get("/leet/code"); // return 2
        fileSystem.create("/c/d", 1); // return false because the parent path "/c" doesn't exist.
        fileSystem.get("/c"); // return -1 because this path doesn't exist.
    }
}

class FileSystem {
    Map<String, Integer> file = new HashMap<>();

    public FileSystem() {
        file.put("", -1);
    }

    public boolean create(String path, int value)
    {
        int idx = path.lastIndexOf("/");
        String parent = path.substring(0, idx);
        if (!file.containsKey(parent))
        {
            return false;
        }

        return file.putIfAbsent(path, value) == null;
    }

    public int get(String path) {
        return file.getOrDefault(path, -1);
    }
}
