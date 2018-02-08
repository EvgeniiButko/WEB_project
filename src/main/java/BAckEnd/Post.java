package BAckEnd;

public class Post {
    int ID;
    String name;
    String inf;

    public Post(int ID,String name,String i){
        this.ID = ID;
        this.name = name;
        inf = i;
    }

    public int getID(){
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getInf() { return inf; }
}
