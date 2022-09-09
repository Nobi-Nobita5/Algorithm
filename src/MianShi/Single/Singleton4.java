package MianShi.Single;
/*
懒汉式，延迟创建对象
 */
public class Singleton4 {
    private static Singleton4 INSTANCE;
    private Singleton4(){

    }
    public static Singleton4 getINSTANCE(){
        if (INSTANCE!=null) {
            synchronized (Singleton4.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton4();
                }
            }
        }
        return INSTANCE;
    }
    public void test(){

    }
}
