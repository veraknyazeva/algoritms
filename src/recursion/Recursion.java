package recursion;

import java.util.ArrayList;
import java.util.List;

public class Recursion {
    public static void main(String[] args) {
        //System.out.println(number(5));
        //System.out.println(values(15,5));
        //System.out.println(sum(4));
        Box box = new Box();
        Box box1 = new Box();
        Box box2 = new Box();
        Box box3 = new Box();
        Box box4 = new Box();
        Box box5 = new Box();
        List<Box> boxes12 = new ArrayList<>();
        boxes12.add(box1);
        boxes12.add(box2);
        List<Box> boxes3 = new ArrayList<>();
        boxes3.add(box3);
        List<Box> boxes45 = new ArrayList<>();
        boxes45.add(box4);
        boxes45.add(box5);

        box.setBoxes(boxes12);
        box1.setBoxes(boxes3);
        box2.setBoxes(boxes45);
        box4.setKey("key");


        lookForKey(box);


    }

    public static void lookForKey(Box box) {
        List<Box> boxes = box.getBoxes();
        if (boxes != null && !boxes.isEmpty()) {
            for (Box boxx : boxes) {
                lookForKey(boxx);
            }
        } else {
            if (box.isKeyPresent()) {
                System.out.println("Нашли ключ");
            } else {
                return;
            }
        }
    }

    public static int sum(int x) { //Сумма цифр числа
        if (x == 0 || x == 1) {
            return 1;
        }
        x = x + sum(x - 1);
        return x;
    }

    /*Даны два целых числа A и В (каждое в отдельной строке).
    Выведите все числа от A до B включительно, в порядке возрастания, если A < B,
    или в порядке убывания в противном случае.*/

    public static String values(int a, int b) {
        if (a > b) {
            if (a == b) {
                return Integer.toString(a);
            }
            return a + " " + values(a - 1, b);
        } else {
            if (a == b) {
                return Integer.toString(a);
            }
            return a + " " + values(a + 1, b);
        }
    }

    public static String number(int n) { //Дано натуральное число n. Выведите все числа от 1 до n.
        /*for(int i = 1; i <= n;i++) {
            System.out.println(i);
        }*/
        int result = 1;
        if (n == 1 || n == 0) {
            return "1";
        }
        return number(n - 1) + " " + n;
    }

    public static int fact(int n) { //факториал
        int result = 1;
        if (n == 1 || n == 0) {
            return result;
        }
        result = n * fact(n - 1);
        return result;
    }
}
