package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest = students[0];
        for (Student stud : students){
            if (oldest.getAge() > stud.getAge()){
                oldest = stud;
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count = 0;
        for (Student stud : students){
            if (stud.isAdult()){
                count++;
            }
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        double average = 0;
        for (Student stud : students){
            average += stud.getGrade();
        }
        average /= students.length;
        return average;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (Student stud : students){
            if (stud.getName() == name){
                return stud;
            }
        }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        boolean swapped = false;
        for (int i = 0; i < students.length-1; i++){
            for (int j = 0; j < students.length-i-1; j++){
                if (students[j].getGrade() < students[j+1].getGrade()){
                    Student temp = students[j];
                    students[j] = students[j+1];
                    students[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for (Student stud : students){
            if (stud.getGrade() >= 15){
                System.out.println(stud.getName()+" ");
            }
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (Student stud : students){
            if (stud.getId() == id){
                stud.setGrade(newGrade);
            }
        }
        return true;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        String[] names = {" "};
        for (Student stud : students){
            for (String name: names){
                if (stud.getName().equals(name)){
                    System.out.println("Duplicates found");
                    return true;
                }
            }
            names[names.length-1] =  stud.getName();
        }
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        int len = students.length;
        Student[] newStudents = new Student[len+1];
        for (int i = 0; i < len ;i++){
            newStudents[i] = students[i];
        }
        newStudents[len] = newStudent;
        return newStudents;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = new Student[5];
        arr[0] = new Student(14,"Khadija", 19,14);
        arr[1] = new Student(13, "Alae", 19,19);
        arr[2] = new Student(12,"Karima", 20,14);
        arr[3] = new Student(22,"Maroua", 17,17);
        arr[4] = new Student(7,"Abdo",14,14);

        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println(findOldest(arr).toString());

        // 3) Count adults
        System.out.println("The number of Adults: "+countAdults(arr));

        // 4) Average grade
        System.out.println("The average grade is: "+ averageGrade(arr));

        // 5) Find by name
        System.out.println(findStudentByName(arr,"Khadija").toString());

        // 6) Sort by grade desc
        sortByGradeDesc(arr);
        // sort function
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        boolean updated = updateGrade(arr,4,12);
        // function
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        hasDuplicateNames(arr);

        // 10) Append new student
         Student[] newList = appendStudent(arr, new Student(2,"Hiba"));
        System.out.println("== All Students ==");
        for (Student s : newList) System.out.println(s);
    }
}

