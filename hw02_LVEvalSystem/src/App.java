public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("CODE: NAME");

        StudentIn student1 = new StudentIn("Bob");
        System.out.println(student1);
        StudentIn student2 = new StudentIn("Fred");
        System.out.println(student2);
        StudentIn student3 = new StudentIn("Eve");
        System.out.println(student3);

        int len = 100000;
        StudentIn students[] = new StudentIn[len];
        for (int i=0; i<len; i++) {
            students[i] = new StudentIn("Student" + i);
            System.out.println(students[i]);
        }
    }
}
