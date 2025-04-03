import org.example.entity.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PracticeProgram {

    public static void main(String args[]){
        List<Employee> listEmp = new ArrayList<>();
        listEmp = Arrays.asList(new Employee(1,"Sandeep",20000,new Department("Information Tech"),new Designation("Junior"),"Mumbai")
                ,new Employee(2,"Amiy",2000,new Department("IT"),new Designation("Senior"),"Pune")
                ,new Employee(3,"Mandeep",24000,new Department("IT"),new Designation("Senior"),"Pune")
                ,new Employee(4,"saurabh",28000,new Department("IT"),new Designation("Senior"),"Pune")
                ,new Employee(5,"anushri",30000,new Department("IT"),new Designation("Senior"),"Pune")
                ,new Employee(6,"bhiravi",66000,new Department("HR"),new Designation("Senior"),"Pune")
                ,new Employee(7,"bhravi",50000,new Department("HR"),new Designation("Senior"),"Pune")
        );

        System.out.println(listEmp.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).distinct().skip(1).findFirst().orElse(null));
        //System.out.println(listEmp.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList()).get(1));
        System.out.println("2 hr highest empl");
        System.out.println(listEmp.stream().filter(s->s.getDepartment().getDeptName().equals("HR")).sorted(Comparator.comparingLong(Employee::getSalary).reversed()).distinct().skip(1).findFirst().orElse(null));
        listEmp.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparing(Employee::getSalary)))).entrySet().forEach(System.out::println);

        List<Student> list = Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "1Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));

        findlistofstudentswhosefirstnamestartswithalphabetA(list);
       //findTheTotalCountofStudentusingstream(list);
        functionInterfaceToGetSecondLastDigitFromString();
        findGoupOfChar();
        int arr[] = { 7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9 };
        duplicateElementsFromArray(arr);
        getSecondHighestFromList();
        sortOnTheBasisOnKey();
        CommonElementsBetweenTwoArrays();
        groupTheStudentByDepartmentNames(list);
        groupTheStudentByMaxSalDepartmentNames(list);
        removeDupFromArray();
        findPairOfSum(arr);
        findLongestSubstringCount();
        getDurationDiff();
        findtotalcount(list);
    }

    private static void findPairOfSum(int[] a) {
        System.out.println("pair of target : ");
        int target=17;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<a.length;i++){
            int compliment = target - a[i];

            if(hmap.containsKey(compliment)){
                System.out.println("pair:"+compliment+" "+a[i]);
            }
            hmap.put(a[i],i);
        }
    }

    public static void removeDupFromArray() {
        System.out.println("removeDupFromArray:");
        Integer arr[] = {1, 2, 2, 2, 3, 4, 4};
        int j=0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[j]!=arr[i]) {
                j++;
                arr[j] = arr[i];

            }
        }
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("aafter");
        for (int i=j+1;i<arr.length;i++){
            arr[i]=null;
        }

        Arrays.stream(arr).forEach(System.out::println);

    }

    public static void groupTheStudentByMaxSalDepartmentNames(List<Student> list){
        System.out.println("group wise max age student");
        list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.maxBy(Comparator.comparing(Student::getAge)))).entrySet().forEach(s->System.out.println(s.getKey()+""+s.getValue()));
    }


    private static void Findalldepartmentsnames(List<Student> list) {
        System.out.println("Findalldepartmentsnames");
        list.stream().map(Student::getDepartmantName).distinct().forEach(System.out::println);
    }

    private static void groupTheStudentByDepartmentNames(List<Student> list) {
        System.out.println("groupTheStudentByDepartmentNames");
        list.stream().collect(Collectors.groupingBy(Student::getDepartmantName)).entrySet().forEach((s)->System.out.println(s.getKey()+":"+s.getValue()));
    }

    private static void CommonElementsBetweenTwoArrays() {
        System.out.println("CommonElementsBetweenTwoArrays");
        List<Integer> l1 = Arrays.asList(3, 6, 7, 1, 4, 9);
        List<Integer> l2 = Arrays.asList(13, 6, 17, 11, 4, 19);

        l1.stream().filter(l2::contains).forEach(System.out::println);
    }

    private static void sortOnTheBasisOnKey() {
        System.out.println("sortOnTheBasisOnKey");
        HashMap<String, Integer> m1 = new HashMap<>();
        m1.put("Maths", 45);
        m1.put("Physics", 57);
        m1.put("Chemistry", 52);
        m1.put("History", 41);

        m1.entrySet().stream().sorted((k,v)->-k.getValue().compareTo(v.getValue())).forEach(System.out::println);

    }

    private static void getSecondHighestFromList() {
        List<Integer> l1 = Arrays.asList(3, 6, 7, 1, 4, 9, 3, 6, null, 7, 1);
        System.out.println("getSecondHighestFromList");
        System.out.println(l1.stream()
                .filter(s->s !=null).
               ////.filter(Objects::nonNull).
                        sorted((s,v)->-s.compareTo(v)).skip(1).findFirst().get());
    }
   public static void duplicateElementsFromArray(int a[]){
       System.out.println("   public static void duplicateElementsFromArray : ");
       HashSet<Integer> hset = new HashSet<>();
       Arrays.stream(a).boxed().filter(s->!hset.add(s)).forEach(System.out::println);
    }
    private static void findGoupOfChar() {
        String str="Sandeep";

        Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().forEach(s->System.out.println(s.getKey()+"::"+s.getValue()));
    }

    private static void functionInterfaceToGetSecondLastDigitFromString() {
        String str="Aabcd123nhcj345ab6m7";

        Function<String,Integer> str2gig= s->{
            s = s.replaceAll("a-z","");
            return s.indexOf(s.length()-2);

        };
        System.out.println(str2gig.apply(str));

    }

    private static void findtotalcount(List<Student> list){
        list.stream().distinct().count();
        System.out.println("jpn find out");
        String str="japan";
        System.out.println( Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(s->s.getValue()<2).map(s->s.getKey()).collect(Collectors.toList()).get(0));
        //.forEach(System.out::print);
    }

    private static void findlistofstudentswhosefirstnamestartswithalphabetA(List<Student> list) {
        //list.stream().filter(s->s.getFirstName().startsWith("A")).forEach(System.out::println);
        System.out.println("filet");
        list.stream().filter(s->s.getFirstName().matches("^[A-Z].*")).forEach(System.out::println);
    }

    public static void findLongestSubstringCount() {
        String str="TRUEFORTRUTH";
        HashSet<Character> hset = new HashSet<Character>();
        int left=0;int maxlength=0,start=0;
        for(int right=0;right<str.length();right++){
            while(hset.contains(str.charAt(right)))
            {
                hset.remove(str.charAt(left));
                left++;
            }
            hset.add(str.charAt(right));
            maxlength = Math.max(maxlength,right-left+1);
        /*    if (right - left + 1 > maxlength) {
                maxlength = right - left + 1;
                start = left;  // Save start index of longest substring
            }
            */
        }
        System.out.println(str.substring(start,start+maxlength)+" length : " +maxlength);
    }

    public static void getDurationDiff(){
        int dob=1994;
        int currentYear= LocalDate.now().getYear();

        long periodDiff = ChronoUnit.YEARS.between(LocalDate.of(dob,1,1),LocalDate.now());
        System.out.println("count"+periodDiff);

        LinkedListCustomPractice lmp = new LinkedListCustomPractice();
        lmp.insert(10);
        lmp.insert(17);
        lmp.insert(30);
        lmp.display();
        lmp.delete(17);
        lmp.display();
    }
}


