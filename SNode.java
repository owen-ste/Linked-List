public class SNode{
    private String name = "";
    private int age = -1;
    private SNode next = null;

    public SNode(){
        name = "";
        age  = -1;
        next = null;
    }

    public SNode(String n, int a){
        name = n;
        age  = a;
    }

    public void setName(String n){
        name = n;
    }

    public void setAge(int a){
        age = a;
    }

    public void setNext(SNode n){
        next = n;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public SNode getNext(){
        return next;
    }

    public String toString(){
        return "Name: " + name + "\nAge : " + age + "\n";
    }
}