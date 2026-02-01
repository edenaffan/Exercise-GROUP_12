
/**
 * Write a description of class Course here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Course {
    private String courseCode;
    private String courseName;
    private String instructorName;
    private int creditHours;
    private int maxCapacity;
    private int enrolledStudents;
    private boolean isActive;

    public Course() {
        this.courseCode = "";
        this.courseName = "";
        this.instructorName = "";
        this.creditHours = 3;
        this.maxCapacity = 30;
        this.enrolledStudents = 0;
        this.isActive = true;
    }

    public Course(String courseCode, String courseName, int creditHours, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = 0;
        this.isActive = true;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public void setCreditHours(int creditHours) {
        if (creditHours >= 1 && creditHours <= 6) {
            this.creditHours = creditHours;
        }
    }

    public void setMaxCapacity(int maxCapacity) {
        if (maxCapacity > 0) {
            this.maxCapacity = maxCapacity;
        }
    }

    public void assignInstructor(String name) {
        this.instructorName = name;
    }

    public boolean enrollStudent() {
        if (enrolledStudents < maxCapacity && isActive) {
            enrolledStudents++;
            return true;
        }
        return false;
    }

    public boolean dropStudent() {
        if (enrolledStudents > 0) {
            enrolledStudents--;
            return true;
        }
        return false;
    }

    public int getAvailableSeats() {
        return maxCapacity - enrolledStudents;
    }

    public boolean isFull() {
        return enrolledStudents >= maxCapacity;
    }

    public boolean cancelCourse() {
        if (enrolledStudents == 0) {
            isActive = false;
            return true;
        }
        return false;
    }

    public void displayCourseInfo() {
        System.out.println("Course Code: " + courseCode);
        System.out.println("Course Name: " + courseName);
        System.out.println("Instructor: " + (instructorName != null && !instructorName.isEmpty() ? instructorName : "Not assigned"));
        System.out.println("Credit Hours: " + creditHours);
        System.out.println("Capacity: " + enrolledStudents + "/" + maxCapacity);
        System.out.println("Available Seats: " + getAvailableSeats());
        System.out.println("Status: " + (isActive ? "Active" : "Cancelled"));
        System.out.println("Full: " + (isFull() ? "Yes" : "No"));
        System.out.println();
    }

    public static void main(String[] args) {
        Course course1 = new Course("PT821", "Object-Oriented Programming", 3, 25);
        course1.assignInstructor("Dr. Smith");
        
        System.out.println("=== Course 1 Initial Info ===");
        course1.displayCourseInfo();
        
        System.out.println("Enrolling students...");
        for (int i = 0; i < 20; i++) {
            course1.enrollStudent();
        }
        course1.displayCourseInfo();
        
        System.out.println("Dropping 5 students...");
        for (int i = 0; i < 5; i++) {
            course1.dropStudent();
        }
        course1.displayCourseInfo();

        Course course2 = new Course("CS101", "Introduction to Computer Science", 4, 30);
        course2.assignInstructor("Prof. Johnson");
        
        System.out.println("=== Course 2 Initial Info ===");
        course2.displayCourseInfo();
        
        System.out.println("Filling course to capacity...");
        for (int i = 0; i < 30; i++) {
            if (!course2.enrollStudent()) {
                System.out.println("Failed to enroll student " + (i + 1));
            }
        }
        course2.displayCourseInfo();
        
        System.out.println("Attempting to enroll one more student...");
        if (course2.enrollStudent()) {
            System.out.println("Enrollment successful");
        } else {
            System.out.println("Enrollment failed - course is full");
        }
        
        Course course3 = new Course("MATH201", "Calculus II", 4, 20);
        System.out.println("\n=== Course 3 - Testing Cancellation ===");
        course3.displayCourseInfo();
        
        System.out.println("Attempting to cancel course with no students...");
        if (course3.cancelCourse()) {
            System.out.println("Course cancelled successfully");
        } else {
            System.out.println("Cannot cancel course");
        }
        course3.displayCourseInfo();
    }
}