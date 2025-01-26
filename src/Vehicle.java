public abstract class Vehicle implements Fixable{
    private int fixTime;
    protected String name;



    public Vehicle(int fixTime,String name){
        setFixTime(fixTime);
        setName(name);
    }

    public abstract int getFixTime();

    private void setFixTime(int fixTime){
        if(fixTime <= 0){
            return;
        }
        this.fixTime = fixTime;
    }
    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name == null || name.equals("")){
            return;
        }
        this.name = name;
    }
}
