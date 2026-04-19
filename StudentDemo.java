class Student {

    int rollno, sem;   // Instance variables
    String name, address;

    void getdata(int r, int s, String n, String a) {
        rollno = r;
        sem = s;
        name = n;
        address = a;
    }

    void putdata() {
        System.out.println(rollno + "\t" + name + "\t" + sem + "\t" + address);
    }
}

public class StudentDemo {

    public static void main(String[] args) {

        Student s1 = new Student();
        Student s2 = new Student();

        s1.getdata(111, 7, "abc", "bangalore");
        s2.getdata(222, 7, "xyz", "kolar");

        s1.putdata();
        s2.putdata();
    }
}

