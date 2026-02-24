
/**
 * Write a description of class Lab2_PersonStudentStaff here.
 *
 * @author (mulhat)
 * @version (12/2/2026)
 */
// ========= Person Class =========
class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String toString() {
        return "Person[name=" + name + ", address=" + address + "]";
    }
}

// ========= Student Class =========
class Student extends Person {
    private String program;
    private int year;
    private double fee;

    public Student(String name, String address, String program, int year, double fee) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    public String getProgram() { return program; }
    public void setProgram(String program) { this.program = program; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getFee() { return fee; }
    public void setFee(double fee) { this.fee = fee; }

    public String toString() {
        return "Student[" + super.toString() +
                ", program=" + program +
                ", year=" + year +
                ", fee=" + fee + "]";
    }
}

// ========= Staff Class =========
class Staff extends Person {
    private String department;
    private double salary;

    public Staff(String name, String address, String department, double salary) {
        super(name, address);
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String toString() {
        return "Staff[" + super.toString() +
                ", department=" + department +
                ", salary=" + salary + "]";
    }
}

// ========= Main Class =========
public class Lab2_PersonStudentStaff {
    public static void main(String[] args) {

        Person p1 = new Person("Amina Hassan", "Stonetown, Zanzibar");
        Student s1 = new Student("Juma Ali", "Chwaka, Zanzibar", "BITA", 2, 1500000);
        Student s2 = new Student("Fatma Omar", "Mbweni, Zanzibar", "BCS", 1, 1800000);
        Staff staff1 = new Staff("Dr. Khalid Salum", "Vuga, Zanzibar", "SCCMS", 3500000);

        System.out.println(p1);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(staff1);

        // Inheritance example
        System.out.println("Student name: " + s1.getName());
        s1.setAddress("Fumba, Zanzibar");
        System.out.println("After change: " + s1);

        // Polymorphism
        Person[] people = {
                new Person("Bakari Juma", "Mwanakwerekwe"),
                new Student("Zainab Moh'd", "Kiembe Samaki", "BITA", 3, 1500000),
                new Student("Hassan Said", "Amani", "BCS", 1, 1800000),
                new Staff("Prof. Mwanaisha Ali", "Mazizini", "SCCMS", 4500000)
        };

        int studentCount = 0, staffCount = 0;

        for (Person p : people) {
            if (p instanceof Student) {
                Student s = (Student) p;
                System.out.println(s.getName() + " is a Student in " + s.getProgram());
                studentCount++;
            } else if (p instanceof Staff) {
                Staff st = (Staff) p;
                System.out.println(st.getName() + " is Staff in " + st.getDepartment());
                staffCount++;
            } else {
                System.out.println(p.getName() + " is a Person");
            }
        }

        System.out.println("Summary: " + studentCount + " students, " + staffCount + " staff members");
    }
}


