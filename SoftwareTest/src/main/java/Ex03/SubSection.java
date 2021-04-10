package Ex03;

public class SubSection {
    public int sign(int val) {
        return Integer.compare(val, 0);
    }
    public int getValue(int val){
        if(val < -2){
            return -val;
        }
        else if (val == 0){
            return 100;
        }
        else if(val < 2){
            return val*val;
        }
        else{
            return val*val*val;
        }
    }
}
