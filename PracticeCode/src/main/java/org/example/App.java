package org.example;

import org.example.entity.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
//Function.identity() is a method reference provided in Java’s Function interface.
// It returns a function that takes a value and returns that same value without modifying it.
// So, for any input x, Function.identity().apply(x) simply returns x.
/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        int a[]= { 1,4,2,8,7 };


        int arr[] = { 7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9 };

        Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).
                entrySet().stream().sorted((s1,s2)->-s1.getValue().compareTo(s2.getValue()))
                .limit(5).collect(Collectors.toList()).forEach((k)->System.out.println(k.getKey()));
        System.out.println("------");

        int b[] = topKFrequent(arr,5);
        Arrays.stream(b).forEach(System.out::println);

        String str = "ASDSSDAA";
        List<Character> charStr = new ArrayList<>();
        for(int i=0;i<str.length();i++)
            charStr.add(str.charAt(i));

        Arrays.stream(str.split("")).sorted().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().forEach(System.out::println);

        System.out.println(Arrays.stream(str.split("")).skip(1));

        System.out.println(charStr.stream().collect(Collectors.toList()).get(1));

        //System.out.println(charStr.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));


        //System.out.println(Arrays.stream(a).boxed().sorted((s1,s2)->-s1.compareTo(s2)).skip(1).findFirst().get());
//System.out.println(Arrays.stream(a).boxed().sorted((s1,s2)->-s1.compareTo(s2)).collect(Collectors.toList()).get(1));
//        System.out.println("2nd Highest: "+Arrays.stream(a).sorted().skip(a.length-2).findFirst().getAsInt());
       /*for(int i=0;i< a.length;i++)
       {
           for(int j=1;j< a.length-i;j++)
            {
               if(a[j-1]>a[j]){
                    int temp=a[j-1];
                  a[j-1]=a[j];
                  a[j]=temp;
              }
         }
       }
       Arrays.stream(a).forEach(System.out::println);*/
//
//        System.out.println("2nd Highests: "+a[1]);

        //bubbleSort(a);
        duplicateElementsFromArray(a);
        //getSecondHighestFromList();
        //sortOnTheBasisOnKey();
        //sortOnTheBasisOnValue();
        //findTheyAreAnagramOrnot();
        //CommonElementsBetweenTwoArrays();
        //city - pune, sal>30000, dept=IT  (dept is another object)
        List<Employee> listEmp = new ArrayList<>();
        listEmp = Arrays.asList(new Employee(1,"Sandeep",20000,new Department("Information Tech"),new Designation("Junior"),"Mumbai")
                ,new Employee(2,"Amiy",2000,new Department("IT"),new Designation("Senior"),"Pune")
                ,new Employee(3,"Mandeep",24000,new Department("IT"),new Designation("Senior"),"Pune")
                ,new Employee(4,"saurabh",28000,new Department("IT"),new Designation("Senior"),"Pune")
                ,new Employee(5,"anushri",30000,new Department("IT"),new Designation("Senior"),"Pune")
                ,new Employee(6,"bhiravi",66000,new Department("HR"),new Designation("Senior"),"Pune")
                ,new Employee(6,"bhiravi",50000,new Department("HR"),new Designation("Senior"),"Pune")
        );

        System.out.println("n n hihg::"+listEmp.stream().filter(s->s.getDepartment().getDeptName().equalsIgnoreCase("HR")).map(Employee::getSalary).distinct()
                        //.sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst());
                .sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null));
        //getEmpCitySalDept(listEmp);

        listEmp.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.maxBy(Comparator.comparingLong(Employee::getSalary)))).forEach((s,k)->System.out.println(s.getDeptName()+":group max salaty:"+k.orElse(null)));

      Long longSal =  listEmp.stream().map(Employee::getSalary).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null) ;

        listEmp.stream().filter(s->s.getSalary()==longSal).forEach(System.out::println);
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
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));

        //findlistofstudentswhosefirstnamestartswithalphabetA(list);
        //groupTheStudentByDepartmentNames(list);
        //findTheTotalCountofStudentu singstream(list);
        //findThemaxageofstudent(list);
        //Findalldepartmentsnames(list);
        //Findthecountofstudentineachdepartment(list);
        //Findthelistofstudentswhoseageislessthan30(list);
        //Findthelistofstudentswhoserankisinbetween50and100(list);
        //FindtheaverageAgeofmaleandfemalestudents(list);
        //Find_the_department_who_is_having_maximum_number_of_students(list);
        //Find_the_Students_who_stays_in_Delhi_and_sort_them_by_their_names(list);
        //Find_the_average_rank_in_all_departments(list);
        //Find_the_highest_rank_in_each_department(list);
        //Find_the_list_of_students_and_sort_them_by_their_rank(list);
        //Find_the_student_who_has_second_rank(list);
        //listIteratorExample();
        //replaceEveryArrayElementWithTheProductOfEveryOtherElement();
        //givenAnUnsortedIntegerArrayFindAPairWithTheGivenSumInIt();
       // mergeTwoArraysBySatisfyingGivenConstraints();
        //findMajorityElement();
      //arrFindMissingNum();
        //linkedlistImpl();
        //removeDupFromArray();
        //callThread1To10Print();
       //functionInterfaceToGetSecondLastDigitFromString(); //write a function functional interface to get second last digit from string
       // sortSecondMapOnValuesFromFirstMapKey();
        //findLongestNonRepetiveChar();
        //binSearchResult();
       //// postNegPairFind();
       // mapUsingThirdHighMarks();
       // findPairCount();
       // findSmallestPositive();
       // ArraySplitIntoChunk();
       // calculateStockPrice();
     // findNextGreaterElements();
        anagramsListGroup();
    }

    private static void functionInterfaceToGetSecondLastDigitFromString() {
        String str="Aabcd123nhcj345ab67";
        System.out.println("functionInterfaceToGetSecondLastDigitFromString:: ");
        List<String> list = Arrays.stream(str.split("")).map(s->s.replaceAll("[a-zA-Z]","")).filter(s->!s.equals("")).collect(Collectors.toList());
        System.out.println("list contains :"+list+" using stream :"+list.get(list.size()-2));

        System.out.println("using functional interface");
        Function<String,Integer> get2ndDigit = a->{
          String getStr  = a.replaceAll("[a-z]","");
          int get2nd =  Integer.parseInt(""+getStr.charAt(getStr.length()-2)); return get2nd;};
        System.out.println(get2ndDigit.apply(str));

  //   String getStr = str.replaceAll("[a-zA-Z]","");
   //   System.out.println(getStr.charAt(getStr.length()-2));
    }

        public static void findMajorityElement(){

            int b[]={2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2};
        int n=b.length;
        System.out.println(Arrays.stream(b).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet()
                .stream().filter(s->s.getValue()>n/2).map(Map.Entry::getKey).findFirst());

    }


    public static void mergeTwoArraysBySatisfyingGivenConstraints() {
        int x[] = {0, 2, 0, 3, 0, 5, 6, 0, 0};
        int y[] = {1, 8, 9, 10, 15};
        int c = 0;
        for (int i = 0; i < x.length; i++) {

            if (x[i] == 0) {
               // System.out.println(x[i]+":y:"+y[c]+"::"+c+":i:"+i);
                x[i] = y[c];
                c++;
            }
        }
        Arrays.stream(x).forEach(s->System.out.print(" "+s));

        //Arrays.stream(x).sorted().forEach(s->System.out.print(" "+s));
    }

    public static void givenAnUnsortedIntegerArrayFindAPairWithTheGivenSumInIt(){
        /*For Example:
        Input:
        nums = [8, 7, 2, 5, 3, 1]
        target = 10

        Output:
        Pair found (8, 2)
        or
        Pair found (7, 3)

        Input:
        nums = [5, 2, 6, 8, 1, 9]
        target = 12

        Output: Pair not found*/

        int num[]= {8, 7, 2, 5, 3, 1};
        int target=9;

        for (int i:num) {
            for(int j=i+1;j< num.length;j++) {

                if(num[i]+num[j]==target)
                {
                    System.out.println(num[i]+":pair found:"+num[j]);
                }else{

                }

            }
        }

    }

    public static void replaceEveryArrayElementWithTheProductOfEveryOtherElement() {
        //Replace every array element with the product of every other element
        // Given an integer array, replace each element with the product of every other element without using the division operator.
        // For example:
        // Input:  { 1, 2, 3, 4, 5 }
        // Output: { 120, 60, 40, 30, 24 }
        // Input:  { 5, 3, 4, 2, 6, 8 }

        int arr[]={ 1, 2, 3, 4, 5 };
        //int arr[] = {5, 3, 4, 2, 6, 8};
        int output[] = new int[arr.length];
        int sumProd = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sumProd = sumProd * arr[j];
            }
            for (int k = 0; k < i; k++) {
                sumProd = sumProd * arr[k];
            }

            output[i] = sumProd;
            sumProd = 1;
        }

        Arrays.stream(output).forEach(System.out::println);
    }

    public static void listIteratorExample() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Iterator it1 = list.iterator();
        while (it1.hasNext())
            System.out.print(it1.next()+",");

        System.out.println();

        ListIterator forwardDir=list.listIterator();
        while(forwardDir.hasNext())
            System.out.print(forwardDir.next()+",");

        System.out.println();

        System.out.println("Backward Traversal : ");
        while(forwardDir.hasPrevious())
            System.out.print(forwardDir.previous()+",");
    }

    private static void Find_the_student_who_has_second_rank(List<Student> list) {
        System.out.println( list.stream().sorted(Comparator.comparingInt(Student::getRank)).collect(Collectors.toList()).get(1));
        //System.out.println(list.stream().sorted(Comparator.comparingInt(Student::getRank)).collect(Collectors.toList()).get(1));
    }

    private static void Find_the_list_of_students_and_sort_them_by_their_rank(List<Student> list) {
        list.stream().sorted(Comparator.comparingInt(Student::getRank)).collect(Collectors.toList()).forEach(System.out::println);
    }

    private static void Find_the_highest_rank_in_each_department(List<Student> list) {
        list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.minBy(Comparator.comparingInt(Student::getRank)))).entrySet().forEach(System.out::println);
       // System.out.println(list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.minBy(Comparator.comparingInt(Student::getRank)))));
    }

    private static void Find_the_average_rank_in_all_departments(List<Student> list) {
        list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.averagingInt(Student::getRank))).entrySet().forEach(System.out::println);
    }

    private static void Find_the_Students_who_stays_in_Karnataka_and_sort_them_by_their_names(List<Student> list) {
        list.stream().filter(s1 -> s1.getCity().equalsIgnoreCase("Karnataka")).sorted(Comparator.comparing(Student::getFirstName)).forEach(System.out::println);
    }

    private static void Find_the_department_who_is_having_maximum_number_of_students(List<Student> list) {
        //System.out.println( list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get());
        //System.out.println(list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting())).entrySet().stream().sorted((s1, s2) -> -s1.getValue().compareTo(s2.getValue())).collect(Collectors.toList()).get(0));

        System.out.println(list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting())).entrySet().stream().sorted((s1,s2)-> -s1.getValue().compareTo(s2.getValue())).collect(Collectors.toList()).get(0));
    }

    private static void FindtheaverageAgeofmaleandfemalestudents(List<Student> list) {
        list.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge))).entrySet().forEach(System.out::println);
    }

    private static void Findthelistofstudentswhoserankisinbetween50and100(List<Student> list) {
        System.out.println(list.stream().filter(s -> s.getRank() >= 50 && s.getRank() <= 100).collect(Collectors.toList()));
    }

    public static void findlistofstudentswhosefirstnamestartswithalphabetA(List<Student> list) {
        list.stream().filter(s -> s.getFirstName().startsWith("A")).collect(Collectors.toList()).forEach(System.out::print);
    }

    public static void groupTheStudentByDepartmentNames(List<Student> list) {
        list.stream().collect(Collectors.groupingBy(Student::getDepartmantName)).entrySet().forEach(System.out::println);
    }

    public static void findThemaxageofstudent(List<Student> list) {
       // Optional<Integer> max = list.stream().map(Student::getAge).max();
       // int max1 = max.get();
       // list.stream().filter(s -> s.getAge() == ((max1))).forEach(System.out::println);

        //System.out.println(list.stream().sorted(Comparator.comparingInt(Student::getAge)).collect(Collectors.toList()).get(list.size()-1));
       //list.stream().filter(s1->s1.getAge()==list.stream().mapToInt(Student::getAge).max().getAsInt()).collect(Collectors.toList()).forEach(System.out::println);


    }

    public static void Findalldepartmentsnames(List<Student> list) {
        //list.stream().map(s1 -> s1.getDepartmantName()).distinct().forEach(System.out::println);
        list.stream().map(s1->s1.getDepartmantName()).distinct().collect(Collectors.toList()).forEach(System.out::println);
    }

    public static void findTheTotalCountofStudentusingstream(List<Student> list) {
        System.out.println(list.stream().count());
    }

    public static void Findthecountofstudentineachdepartment(List<Student> list) {
        System.out.println(list.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting())));
    }

    public static void Findthelistofstudentswhoseageislessthan30(List<Student> list) {
        System.out.println(list.stream().filter(s -> s.getAge() < 30).collect(Collectors.toList()));
    }

    private static void findTheyAreAnagramOrnot() {
        String s1 = "silent";
        String s2 = "listenf";

        List<String> l1 = Arrays.asList(s1.split(""));
        List<String> l2 = Arrays.asList(s2.split(""));

        int containssize = l1.stream().filter(l2::contains).collect(Collectors.toList()).size();

        if (s1.length() == s2.length() && containssize == s1.length() && containssize == s2.length()) {
            System.out.println("they are anagram");
        } else {
            System.out.println("they are not an anagram");
        }

    }

    private static void sortOnTheBasisOnValue() {
        HashMap<String, Integer> m1 = new HashMap<>();
        m1.put("Maths", 45);
        m1.put("Physics", 57);
        m1.put("Chemistry", 52);
        m1.put("History", 41);

        m1.entrySet().stream().sorted((s1, s2) -> s1.getValue().compareTo(s2.getValue())).forEach(System.out::println);
    }

    private static void sortOnTheBasisOnKey() {
        HashMap<String, Integer> m1 = new HashMap<>();
        m1.put("Maths", 45);
        m1.put("Physics", 57);
        m1.put("Chemistry", 52);
        m1.put("History", 41);

        m1.entrySet().stream().sorted((s1, s2) -> s1.getKey().compareTo(s2.getKey())).forEach(System.out::println);
    }

    private static void getSecondHighestFromList() {
        List<Integer> l1 = Arrays.asList(3, 6, 7, 1, 4, 9, 3, 6, null, 7, 1);

        System.out.println(l1.stream().filter(s -> s != null).sorted((s1, s2) -> -s1.compareTo(s2)).collect(Collectors.toList()).get(1));
        List<Integer> l2 = Arrays.asList(3, 6, 7, 1, 4, 9, 3, 6, 7, 1);
        System.out.println("---------------");
        l2.stream().sorted((s1,s2)->-s1.compareTo(s2)).collect(Collectors.toList()).stream().limit(3).forEach(System.out::println);


        String s="sandeepabcc";
        HashMap<Character,Integer> hmapcount= new HashMap<>();
        int c=0;
        for (int i=0;i<s.length();i++){
            hmapcount.put(s.charAt(i),hmapcount.get(s.charAt(i))==null?1:hmapcount.get(s.charAt(i))+1);
        }
        hmapcount.entrySet().forEach(System.out::println);
    }

    private static void CommonElementsBetweenTwoArrays() {
        List<Integer> l1 = Arrays.asList(3, 6, 7, 1, 4, 9);
        List<Integer> l2 = Arrays.asList(13, 6, 17, 11, 4, 19);

        l1.stream().filter(l2::contains).forEach(System.out::println);
        l1.stream().filter(l2::contains).forEach(System.out::println);
    }

    private static void duplicateElementsFromArray(int[] a) {
        HashSet<Integer> s1 = new HashSet();
        HashSet<Integer> s2 = new HashSet();
        Arrays.stream(a).filter(s -> !s1.add(s)).forEach(e -> System.out.println("duplicate element:" + e));

        List<Integer> l1 = Arrays.asList(3, 6, 7, 1, 4, 9, 3, 6, 7, 1);
        //l1.stream().filter(s->!s2.add(s)).collect(Collectors.toList()).forEach(System.out::println);
        l1.stream().filter(s -> !s2.add(s)).forEach(System.out::println);

    }

    public static int[] bubbleSort(int a[]) {

        Arrays.stream(a).sorted().forEach(System.out::println); // comparable sort

        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (a[j - 1] > a[j]) {
                    int temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        Arrays.stream(a).forEach(System.out::println);
        return a;
    }

    //city - pune, sal>30000, dept=IT  (dept is another object)
    public static void getEmpCitySalDept(List<Employee> list){
        list.stream().filter(s->s.getSalary() > 500 && s.getDepartment().getDeptName().equals("IT") && s.getCity().equals("Pune")).
                collect(Collectors.toList()).forEach(System.out::println);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // 1. Count the frequency of each element in the input list
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.get(num)==null?1:counts.get(num)+1);
        }

        // 2. Sort in descending order based on the counts
        List<Map.Entry<Integer, Integer>> countsList = new ArrayList<>(counts.entrySet());
        countsList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // 3. Slice the first k elements to build the result list
        Map<Integer, Integer> sortedCounts = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : countsList.subList(0, k)) {
            sortedCounts.put(entry.getKey(), entry.getValue());
        }

        return sortedCounts.keySet().stream().mapToInt(Integer::intValue).toArray();
    }
	
	public static void findPair() {
        int target = 5;
        int[] a={7,3,2,4,6,1};
        findPairCount();
        // HashMap to store the elements and their indices
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            int complement = target - a[i];

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                System.out.println("Pair found: " + complement + ", " + a[i]);
                return;
            }

            // Add the current element to the map
            map.put(a[i], i);
        }

        // If no pair is found
        System.out.println("No pair found with the given target.");
    }

    public static void findPairCount() {
        int target = 6;
        //int[] a={7,3,2,4,6,1};
int[] a={1, 5, 7, -1, 5};
        // HashMap to store the elements and their indices
        HashMap<Integer, Integer> map = new HashMap<>();
int count=0;
        for (int i = 0; i < a.length; i++) {
            int complement = target - a[i];

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
               //System.out.println("Pair found: " + map.get(complement) + ", " + a[i]);
               // System.out.println("Pair found: " + map.get(complement) + ", " + i);
               // return;
                //count++;
            }

            // Add the current element to the map
            map.put(a[i], i);
        }
        if(count>0)
            System.out.println("pair count"+count);

        // If no pair is found
        System.out.println("No pair found with the given target.");
    }
    public static int[] add2NumberSum(int[] a ,int target) {
        int[] result = new int[a.length];

        for (int i = 0; i < a.length; i++) {

            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == target) {
                    result[0] = a[i];
                    result[1] = a[j];
                }
            }
        }
        return result;
    }

    public static void arrFindMissingNum() {
        int a[] = {2, 8, 10, 20};
        int min = a[0];
        int max = a[a.length - 1];

        HashSet<Integer> al = new HashSet<Integer>();

        for (int num : a) {
            al.add(num);
        }

        for (int i = min; i < max; i++) {
            if (!al.contains(i)) {
                System.out.print(i + " ");
            }
        }

    }

    public static void removeDupFromArray(){
      Integer  arr[] = {1, 2, 2,2, 3, 4, 4 };
      int j=0;
      for(int i=1;i<arr.length;i++){
          if(arr[j] != arr[i])
          {
              j++;
            arr[j]=arr[i];
          }
      }

        // Fill the rest of the array with null
        for (int i = j + 1; i < arr.length; i++) {
            arr[i] = null;
        }

      Arrays.stream(arr).forEach(System.out::println);
    }

  /*  public static void linkedlistImpl() {
        LinkedList listN = new LinkedList();
        listN.insert(10);
        listN.insert(20);
        listN.insert(30);

        System.out.println("LinkedList after insertion:");
        listN.display(); // Output: 10 -> 20 -> 30 -> null

        System.out.println("LinkedList after deletion:");
        listN.delete(20);

        listN.display(); // Output: 10 -> 30 -> null

        listN.delete(40); // Output: Value not found in the list.

    }

   */

    public static void callThread1To10Print(){
        int[] array = {0,0,1,9,9,7,0};
        //Arrays.stream(array).boxed().distinct().collect(Collectors.toList()).forEach(System.out::println);
       Printer printer = new Printer();
        Thread oddThread = new Thread(()-> {
            try {
                printer.printNumber(false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Odd Thread");
        Thread evenThread = new Thread(()-> {
            try {
                printer.printNumber(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Even Thread");

        oddThread.start();
        evenThread.start();

        System.out.println("shit array");
       // arryShiftElement();
        removeRepeatedShiftElement();
        sortArrayFrequenceyElement();
    }

    public static void arryShiftElement(){
        int[] array = {0,0,1,9,9,7,0};
        //expected output array={1,9,9,7,0,0,0};
        int c=0;
        for(int i=0;i<array.length;i++){
           if(array[i] !=0)
               array[c++] = array[i];
        }

        for(int i=c;i<array.length;i++){
            array[i]=0;
        }
        Arrays.stream(array).forEach(System.out::println);
    }

    public static void removeRepeatedShiftElement(){
        int[] array = {0,0,1,9,9,7,0};
        //expected output array={1,9,9,7,0,0,0};
        int c=0;
        for(int i=1;i<array.length;i++){
            if(array[c] != array[i]) {
               c++;
                array[c] = array[i];
            }
        }

        for(int i=c;i<array.length;i++){
            array[i]=0;
        }
        Arrays.stream(array).forEach(System.out::println);
        int[] nums = {0,0,1,9,9,7,0};
        int num=   Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(s->s.getValue()> nums.length/2).map(Map.Entry::getKey).findFirst().get();
    }

    public static void sortArrayFrequenceyElement(){
        int	arr[] = {2, 5, 2, 8, 5, 6, 8, 8};
        //Output: arr[] = {8, 8, 8, 2, 2, 5, 5, 6}
        int arr2[]=new int[arr.length];

        HashMap<Integer, Long> hmap = new HashMap<>();
       hmap = (HashMap<Integer, Long>) Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().
                stream().sorted((k,v)->-k.getValue().compareTo(v.getValue())).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(x,y)->x,LinkedHashMap::new));// merge function to resolve collision btwn values with same key

        int c=0;
        for (Map.Entry<Integer,Long> entry : hmap.entrySet()){
            for(int i=0;i< entry.getValue();i++){
                arr2[c]= entry.getKey();
                c++;
            }
        }
        for (int i=0;i<arr2.length;i++)
            System.out.print(" "+arr2[i]);
    }

    public static void removeDupChar(){
        System.out.println();
        System.out.println("remove dup char from string");
        String str = "japan";

        LinkedHashMap<Character,Integer> hmap = new LinkedHashMap<>();

        for(int i=0;i<str.length();i++)
        {
            hmap.put(str.charAt(i),hmap.get(str.charAt(i))==null?1:hmap.get(str.charAt(i))+1);
        }

        String result="";
        for(Map.Entry<Character,Integer> hmapIter : hmap.entrySet())
        {

            if(hmapIter.getValue()<2)
            {
                result = result+hmapIter.getKey();
            }
        }

        System.out.println(result);

    }

    public static void groupByCategoryAndSumSales() {
        List<Order> orders =Arrays.asList(

                new Order("Laptop", "Electronics", new BigDecimal("1200.00")),

                new Order("Smartphone", "Electronics", new BigDecimal("800.00")),

                new Order("Shoes", "Footwear", new BigDecimal("150.00")),

                new Order("T-shirt", "Apparel", new BigDecimal("25.00")),

                new Order("Headphones", "Electronics", new BigDecimal("300.00")),

                new Order("Socks", "Footwear", new BigDecimal("10.00"))

        );
        orders.stream().filter(s->!s.getProdName().equals("Smartphone")).collect(Collectors.groupingBy(Order::getProdCategory,Collectors.mapping(Order::getProdAmount, Collectors.reducing(BigDecimal.ZERO,BigDecimal::add)))).entrySet().forEach(System.out::println);

        anagramsListGroup();
    }



    private static class Order {
        public Order(String prodName, String prodCategory, BigDecimal prodAmount) {
            this.prodName = prodName;
            this.prodCategory = prodCategory;
            this.prodAmount = prodAmount;
        }

        private String prodName;
        private  String prodCategory;
        private BigDecimal prodAmount;

        public String getProdName() {
            return prodName;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "prodName='" + prodName + '\'' +
                    ", prodCategory='" + prodCategory + '\'' +
                    ", prodAmount=" + prodAmount +
                    '}';
        }

        public String getProdCategory() {
            return prodCategory;
        }

        public BigDecimal getProdAmount() {
            return prodAmount;
        }
    }

    public static void anagramsListGroup(){

        String[] a ={"eat", "tea", "tan", "ate", "nat", "bat"};

        HashMap<String,List<String>> anagrams = new HashMap<>();

        for(String word : a){
            char[] arrayChar = word.toCharArray();
            Arrays.sort(arrayChar);
            String sortedWord = new String(arrayChar);

            anagrams.putIfAbsent(sortedWord,new ArrayList<>());
            anagrams.get(sortedWord).add(sortedWord);
        }
            List<List<String>> result = new ArrayList<>(anagrams.values());
        System.out.println(result);

    }

    public static void sortSecondMapOnValuesFromFirstMapKey(){
        System.out.println("sortSecondMapOnValuesFromFirstMapKey");
        /*	Map 1 : 5,Sandeep 7, Devi 9,Kanaujiya

		Map 2: Sandeep,45000 Devi 47000 Kanaujiya 25000

		Sort the second map based on values in descending order and map keys from first map

		Output : 7,47000 5,45000 9,25000 */

        HashMap<String,String> hmap = new HashMap<>();
        hmap.put("5","Sandeep");
        hmap.put("7","Devi");
        hmap.put("9", "Kanaujiya");

        HashMap<String,String> secondhMap = new HashMap<>();
        LinkedHashMap<String,String> secondhMapTh = new LinkedHashMap<>();
        Map<String,String> secondhMapThSorted = new LinkedHashMap<>();
        secondhMap.put("Sandeep","45000");
        secondhMap.put("Devi","47000");
        secondhMap.put("Kanaujiya","25000");

        List<String> list = new ArrayList<>();

        secondhMapThSorted=secondhMap.entrySet().stream().sorted((k,v)->-k.getValue().compareTo(v.getValue())).collect(Collectors.toMap(Entry::getKey, Entry::getValue,(x, y)->x,LinkedHashMap::new));

        secondhMapThSorted.entrySet().stream().collect(
                Collectors.toMap(
                        e->hmap.entrySet().stream().filter(h->h.getValue().equals(e.getKey())).map(Entry::getKey).findFirst().orElse(""),
                        Entry::getValue, (x,y)->x,LinkedHashMap::new)
        ).entrySet().forEach(System.out::println);

		/*for(Entry<String, String> secondhMap1 : secondhMapThSorted.entrySet()) {

				for(Entry<String, String> hmapNew : hmap.entrySet()) {
						if(secondhMap1.getKey().equals(hmapNew.getValue())) {
							secondhMapTh.put(hmapNew.getKey(), secondhMap1.getValue());
						}
				}

		}*/
       // secondhMapTh.entrySet().forEach(System.out::println);
    }

    public static void findLongestNonRepetiveChar(){
        String str="TRUEFORTRUTH";
        str="1234661234";
        HashSet<Character> hset = new HashSet<>();
        int left=0; int maxlength=0;
        for(int right=0;right<str.length();right++){

            while(hset.contains(str.charAt(right))){
                hset.remove(str.charAt(left));
                left++;
            }
            hset.add(str.charAt(right));
            maxlength = Math.max(maxlength,right-left+1);
        }
        System.out.println(hset+":lo str:"+maxlength);
    }

    public static void findPrime() {

        List<Integer> list = new ArrayList<Integer>();
        list = Arrays.asList(1,2,3,4,5,10,34,23,51,67,45);

        list.stream().filter(s->{
            if(s==1)
                return false;

            for(int j=2;j<=Math.sqrt(s);j++) {
                if(s%j==0)
                    return false;
            }

            return true;
        }).collect(Collectors.toList()).forEach(System.out::println);;

    }

    public static void binSearchResult(){
        int a[]={1,2,4,6,8};
        System.out.println("result:"+binSearchTree(a,0,a.length-1,9));
    }

    public static int binSearchTree(int a[],int left,int right,int target){
      while(left<=right){
       // int mid = left + right /2;
          int mid = left + (right - left) / 2; //// Correct formula to prevent integer overflow
        if(a[mid] == target)
           return  mid;

        if( a[mid] < target)
            left  = mid + 1;
        else
            right = mid - 1;
      }
      return  -1;


    }

    public static void postNegPairFind(){
         int a[]={3,1,-2,-5,2,-4};
         int result[] = {3,-2,1,-5,2,-4};

         List<Integer> posList = Arrays.stream(a).boxed().filter(s->s>0).collect(Collectors.toList());
        List<Integer> negList = Arrays.stream(a).boxed().filter(s->s<0).collect(Collectors.toList());
        LinkedHashMap<Integer,List<Integer>> map = new LinkedHashMap();
        if(posList.size()==negList.size()){

            for(int i=0;i<posList.size();i++){
                List<Integer> listo = new LinkedList<>();
                listo.add(posList.get(i));
                listo.add(negList.get(i));
                map.put(i,listo);
            }
        }
        map.values().stream().flatMap(s->s.stream()).forEach((k)->System.out.print(" "+k+","));
    }

    public static void mapUsingThirdHighMarks(){
        System.out.println("based on value sort");
        HashMap<Student,Integer> hmap = new HashMap<>();
        hmap.put(new Student(101,"Sandeep","kanaujiya",20,"M","HR",1994,"dombili",5),400);
        hmap.put(new Student(103,"rohit","kanaujiya",24,"M","HR",1994,"dombili",5),100);
        hmap.put(new Student(102,"suresh","kanaujiya",50,"M","HR",1994,"dombili",5),500);
        hmap.put(new Student(106,"pushpa","kanaujiya",60,"M","HR",1994,"dombili",5),200);

        hmap.entrySet().stream().sorted((k,v)->-k.getValue().compareTo(v.getValue())).collect(Collectors.toList()).stream()
                .limit(3).
                forEach(k->System.out.println(k.getKey().getFirstName()+":"+k.getValue()));

        /*ArrayList<Integer> list = (ArrayList<Integer>) hmap.values().stream().sorted((k, v)->-k.compareTo(v)).collect(Collectors.toList()).stream().limit(3).collect(Collectors.toList());

        for(int i=0;i<list.size();i++){
            for(Map.Entry<Student,Integer> hmapRes: hmap.entrySet()){
                if(list.get(i).equals(hmapRes.getValue())){
                    System.out.println(hmapRes.getKey().getFirstName()+":"+hmapRes.getValue());
                }
            }
        } */

        List<Integer> listR = Arrays.asList(10,20,30);
        System.out.println(listR.stream().reduce(1,(a,b) -> a*b));
    }

    public static void findSmallestPositive(){
       // i.e Input array -500,-300,0,1,2,5000 output - 3

        int a[]={-500,-300,0,1,2,5000};
        int smallest=1;
        for(int i=0;i<a.length;i++){
            if(smallest == a[i]){
                smallest++;
            }
            else {
                if(a[i] > smallest)
                    break;
            }
        }
        System.out.println(smallest);

    }

    public static void ArraySplitIntoChunk(){
        System.out.println("split array into chunk");
        // i.e Input array -500,-300,0,1,2,5000 output - 3
        int chunkSize=3;
        int a[]={-500,-300,0,1,2,5000,8,9};
        List<int[]> list = new ArrayList<>();

        for(int i=0;i<a.length;i=i+chunkSize){
           list.add(Arrays.copyOfRange(a,i,Math.min(a.length,i+chunkSize)));
        }
        list.stream().forEach(s->System.out.println(Arrays.toString(s)));

    }

    public static void calculateStockPrice() {
        int prices[]= {7,1,5,3,6,7};

        int min = prices[0];
        int temp=0;
        int max=prices[0];
        //int max=0;
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<min) {
                min = prices[i];
            }

            if(prices[i]>max) {
                max = prices[i];
            }

        }
        System.out.println("Stock prices profit:"+(max-min));

    }

    public static void findNextGreaterElements(){
        //int[] a={1,3,2,4}; //{3,4,4,-1}
        int[] a= {4, 3, 2, 1};
        //-1,
        int[] result= new int[a.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=a.length-1;i>=0;i--){ // Iterate from right to left
            while( ! stack.empty() && stack.peek()<=a[i]){
                stack.pop();// Remove elements from stack that are smaller than or equal to arr[i]
            }
            result[i] = stack.isEmpty()?-1:stack.peek(); // If stack is not empty, top element is the next greater
            stack.push(a[i]);// Push current element onto stack

            System.out.println("result: "+Arrays.toString(result));
           // System.out.println("stack: "+stack);
        }
    }

    public static void nonRepeatingNumberSum(){

        int[] ar = {1,1,2,3,3,5,4,4,9};

        Integer listRes = Arrays.stream(ar).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(s->s.getValue()==1).collect(Collectors.summingInt(Map.Entry::getKey));

        System.out.println(listRes);
    }
}







