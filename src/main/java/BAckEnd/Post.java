package BAckEnd;

public class Post {
    int ID;
    String name;

    public Post(int ID,String name){
        this.ID = ID;
        this.name = name;
    }

    public int getID(){
        return ID;
    }

    public String getName() {
        return name;
    }
}
