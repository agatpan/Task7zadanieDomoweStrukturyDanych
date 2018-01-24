package domain;

public class Permission implements  Comparable<Permission>{
    private String name;

    public String getName() {
        return name;
    }

    public Permission setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Permission o) {
        return name.compareTo(o.getName());
    }
}
