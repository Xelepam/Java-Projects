package datastructure;

import jdk.nashorn.internal.objects.annotations.Setter;

public class OneDArray {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        numbers[0] = 20;
        numbers[1] = 5;
        numbers[2] = 10;
        numbers[3] = 6;
        numbers[4] = 11;

        for(int i=0; i<numbers.length; i++)
            System.out.println(numbers[i]);

        Student[] students = new Student[4];
        students[0] = new Student("Omar", 24);
        students[1] = new Student("Hector", 25);
        students[2] = new Student("David", 25);
        students[3] = new Student("Karina", 22);

        for(int i=0; i<students.length; i++)
            System.out.println("Name: "+students[i].name+","+" Age: "+students[i].age);
    }
}
