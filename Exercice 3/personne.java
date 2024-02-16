import java.io.*;
class personne implements Serializable{
    private int age;
    private String name;
    private int id;

    personne(int _age, String _name){
        age = _age;
        name = _name;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    public void setId(int _id){
        id = _id;
        System.out.println("id: " + id);
    }
}