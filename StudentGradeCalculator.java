import java.util.ArrayList;
import java.util.Scanner;

public  class StudentGradeCalculator {

    public static ArrayList getMarks(int n, ArrayList Array){
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < n ;i++){
            System.out.println("Enter Marks of Subject "+(i+1));
            Array.add(sc.nextInt());
        }
        return Array;
    }

    public static int getAddition(ArrayList<Integer> array){
        int sum = 0;
        for (Integer i : array) {
            sum += i;
        }
        return sum;
    }

    public static double  getAvg(int TotalSum , int numSubject){

        return ( (double) TotalSum / numSubject);

    }

    public static void main(String[] args) {
        ArrayList <Integer>Array= new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Number of Subjects");
        int n = scan.nextInt();

        getMarks(n,Array);

        int Total =  getAddition(Array);
        double Average = getAvg(Total,n);
        String Grade = Average>=90 ? "Grade A" :(Average <90 && Average >=85) ? "Grade B" : (Average<85 && Average >= 75) ? "Grade C" :(Average<75 && Average>=35)?"Grade D" : "Failed" ;

        System.out.println("Total Marks = "+Total);
        System.out.println("Average Percentage = "+Average);
        System.out.println("Grade = "+Grade);
        scan.close();
    }
}
