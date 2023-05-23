import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static int x = 1;
    public static void main(String[] args) {
        Main main = new Main();
        main.func(x);
        System.out.println(x);
    }
    public void func(int x){
        Main.x = 10;
    }
}
