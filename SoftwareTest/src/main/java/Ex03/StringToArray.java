package Ex03;

public class StringToArray {
    public char[] string2Array(String str){
        if(str == null){
            return null;
        }
        return convert(str.getBytes());
    }
    private char[] convert(byte[] bytes){
        char[] chars = new char[bytes.length];
        for(int i = 0; i < bytes.length; i++){
            chars[i] = (char)bytes[i];
        }
        return chars;
    }
}
