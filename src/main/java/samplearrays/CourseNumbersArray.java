package samplearrays;
import java.util.Arrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        int len = registeredCourses.length;
        int[] updatedCourses = new int[len+1];
        int courseId = 2200, c = 0;

        for(int i = 0; i < len; i++){
            updatedCourses[i] = registeredCourses[i];
        }
        updatedCourses[len] = courseId;
        System.out.println(Arrays.toString(updatedCourses));

        for (int Id : updatedCourses){
            if(courseId == Id){
                System.out.println("The course with Id: "+courseId+" is registered.");
                c++;
                break;
            }
        }
        if (c == 0){
            System.out.println("The course with Id: "+courseId+" is not registered.");
        }
    }
}
