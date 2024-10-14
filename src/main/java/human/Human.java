package human;

public abstract class Human {
    private String name;
    private String lastName;
    private String fathersName;
    private boolean male;

    public Human() {}
    public void setName(String name) { this.name = name; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }
    public void setMale(boolean male) { this.male = male; }
    public String sayHello() {
        return new String(lastName + " " + name + " " + fathersName);
    }
}
