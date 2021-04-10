import java.util.Scanner;

public class P331 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println(isValidSerialization(name));
    }

    public static boolean isValidSerialization(String preorder) {
        String[] node = preorder.split(",");
        int index = -1;
        int array[] = new int[node.length];
        for(int i = 0; i < node.length; i++){
            array[i] = 0;
        }
        for(int i = 0; i < node.length; i++){
            if(node[i].equals("#")){
                array[index]--;
                if(array[index] < 0){
                    return false;
                }
                else if(array[index] == 0){
                    while (array[index] == 0){
                        if(index==0){
                            if(i != node.length-1){
                                return false;
                            }
                            else{
                                return true;
                            }
                        }
                        else{
                            index--;
                            array[index]--;
                        }
                    }
                }
            }
            else{
                array[++index] = 2;
            }
        }
        for(int i = 0; i < node.length; i++){
            if(array[i] != 0){
                return false;
            }
        }
        return true;
    }
}
