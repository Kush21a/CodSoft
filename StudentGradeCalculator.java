import java.util.*;
public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of subject: ");
        int numSubject=sc.nextInt();
        int []marks=new int[numSubject];
        int totalMark=0;
        for(int i=0;i<numSubject;i++){
            System.out.println("Enter marks obtained in subject "+(i+1)+"(out of 100: )");
            marks[i]=sc.nextInt();
            totalMark+=marks[i];
        }
        double averagePercentage=(double)totalMark/numSubject;
        String grade;
        if(averagePercentage>=90){
            grade="A+";
        }else if(averagePercentage>=80){
            grade="A";
        }else if(averagePercentage>=70){
            grade="B";
        }else if(averagePercentage>=60){
            grade="C";
        }else{
            grade="D";
        }
        System.out.println("\nResults");
        System.out.println("Total Marks: "+totalMark);
        System.out.println("Average percentage: "+averagePercentage+"%");
        System.out.println("Grade: "+grade);
        sc.close();


    }
    
}
