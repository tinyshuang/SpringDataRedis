package hxk;

import java.net.URLClassLoader;
import java.util.Arrays;

/**
 * @author hxk
 * @description
 *2015年12月4日  下午2:34:03
 */
public class Main {
    public static void main(String[] args) {
        URLClassLoader classLoader = (URLClassLoader)Main.class.getClassLoader();
        System.out.println(Arrays.toString(classLoader.getURLs()));
    }
}
