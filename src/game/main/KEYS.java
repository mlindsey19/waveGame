package game.main;

public enum KEYS {
    UP(0), DOWN(1), LEFT(2), RIGHT(3);

    private int value;
    private KEYS(int value){
        this.value = value;
    }

    public int asInt(){
        return value;
    }
}
