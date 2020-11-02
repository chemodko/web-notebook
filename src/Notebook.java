import java.io.*;
import java.util.*;

public class Notebook {
    private Map<String, ArrayList<String>> map;
    private Map<String, ArrayList<String>> groups;
    private String filename;

    public Notebook(String filename) throws FileNotFoundException {
        this.filename = filename;
        map = new HashMap<String, ArrayList<String>>();
        groups = new HashMap<String, ArrayList<String>>();

        try (Scanner sc = new Scanner(new FileInputStream(filename))) {
            while (sc.hasNextLine()) {
                String lines = sc.nextLine();
                String[] data = lines.split(" ");
                String name = data[0], phoneNumber = data[2], group = data[1];

                if (!map.containsKey(name)) {
                    map.put(name, new ArrayList<String>());
                    map.get(name).add(phoneNumber);
                } else {
                    map.get(name).add(phoneNumber);
                }
                if (!groups.containsKey(name)) {
                    groups.put(name, new ArrayList<String>());
                    groups.get(name).add(group);
                } else {
                    groups.get(name).add(group);
                }
            }
        }
    }

    public synchronized Map<String, ArrayList<String>> getMap() {
        return map;
    }

    public synchronized Map<String, ArrayList<String>> getGroups() {
        return groups;
    }

    public synchronized void add(String name, String number, String group) throws IOException {
        try(Writer writer = new OutputStreamWriter(new FileOutputStream(filename, true))){
            if (name != null && number != null && group != null) {
                if (!map.containsKey(name)) {
                    map.put(name, new ArrayList<String>()); 
                    groups.put(name, new ArrayList<String>());
                }
                if (!map.get(name).contains(number)) {
                    map.get(name).add(number);
                }
                if (!groups.get(name).contains(group)) {
                    groups.get(name).add(group);
                }
                //writer.write("\n" + name + " " +  group + " " + number);
            }
        }
    }
}