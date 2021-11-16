import java.util.InputMismatchException;
import java.util.Scanner;
import java.math.BigDecimal;
import static java.lang.Math.log;
import static java.lang.Math.pow;



public class Calculator {
    static double M_E = 2.71828;

    static double calcuate_01_03( double lambda , double time ) {
        double l = -(lambda*time); // reliability calculation function. User insert lambda and time
        double result = pow(M_E , l); // e power to -(lambda*time)
        result = result*100; // Result is multiplication by 100 and present in %
        return result;
    }

    static double calculate_01_04(double decimal_precentage, int time){
        //The function accepts time and percentage in decimal form for easy calculation
        //Since the reliability of the exponential distribution is given by e to the power minus lambda times time.
        //I transform the formula so that I can calculate lambda, which is the failure rate, and return it as the result
        double lambda = -log(decimal_precentage) / time;
        return lambda;
    }
    static double[] calculate_01_05(double mtbf, double time){
        //Knowing that MTBF is equal to the expression 1/lambda
        double lambda = 1.0/mtbf;
        //In order to calculate the probability, I substitute the time given in the function into the relativity formula
        double result = pow(M_E, -lambda*time);
        return new double[] {lambda, result};

    }

    static double calculate_01_06(double mtbf, double time) {
        //Assuming the exponential model, the hazard rate is
        double hazard_rate = 1.0/mtbf;
        //So I subtract the result of the equation into formula
        double result = pow(M_E, -time * hazard_rate);
        return result;
    }
    static double calculate_03_01(int machines, int allmachines, double time, int sum){
        double alltime = (double) sum +(time * ((double) allmachines-(double) machines)); // half of the formula to calculate failures occurred (adds h failure motors and survived muliply by test h).
        double result = ((double) machines)/alltime;
        return  result;
    }

    //Content of tasks
    static void text1(){ // void function displays the content of the task
        System.out.println("1 - An industrial machine compresses natural gas into an interstate gas pipeline. The compressor is on line 24 hours a day. " +
                "(If the machine is down, a gas field has to be shut down until the natural gas can be compressed, so down time is very expensive.) " +
                "The vendor knows that the compressor has a constant failure rate of X failures/hr. What is the operational reliability after Y hours of continuous service? \n");
    }
    static void text2(){// void function displays the content of the task
        System.out.println("2 - What is the highest failure rate for a product if it is to have a reliability (or probability of survival) of X percent "+
                "at Y hours? Assume that the time to failure follows an exponential distribution.\n");
    }
    static void text3(){// void function displays the content of the task
        System.out.println("3 - Suppose that a component we wish to model has a constant failure rate with a mean time\n"+
                "between failures of X hours? Find:-\n"+
                "(a) The reliability function.\n"+
                "(b) The reliability of the item at Y hours.");
    }
    static void text4(){// void function displays the content of the task
        System.out.println("4 -The equipment in a packaging plant has a MTBF of X hours. What is the probability that the equipment will operate for a "+
                "period of Y hours without failure?");
    }
    static void text5(){// void function displays the content of the task
        System.out.println("5 - X motors were tested for Y h. Q motors failed during the test. The failures occurred after the following "+
                "test times: \nMotor 1  Z h\nMotor 2  R h \nMotor 3 W h ");
    }




    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int machines, allmachines;
        int sum = 0; //variable counter for the sum of the time after which devices have failed.


        int b;// variable B is used to write user data into the array.  The array holds the values provided by the user.
        double decimal_precentage , time, mtbf, lambda;

        while(true){
            System.out.println("Select number task to calalte:\nX, Y, W, R, Z, Q ETC YOU MUST PROVIDE VALUES THAT MATCH YOUR VERSION OF THE TASK.\n");
            text1();
            text2();
            text3();
            text4();
            text5();
            System.out.println("6 - to exit\nchoose:");
            int task = sc.nextInt();
            switch(task){
                case 1:
                    System.out.println("01.03\n");
                    text1();// void function displays the content of the task
                    System.out.println("Specify the lambda (X):\n");
                    try{
                        lambda= sc.nextDouble();
                    }catch(InputMismatchException e){
                        e.printStackTrace();
                        System.err.println("Entered value is not an double");
                        break;
                    }
                    System.out.println("Specify the time in hours (Y):\n");
                    try {
                        time= sc.nextDouble();
                    }catch(InputMismatchException e){
                        e.printStackTrace();
                        System.err.println("Entered value is not an double");
                        break;
                    }
                    System.out.println("The reliability is "+ calcuate_01_03(lambda, time)+"%\n");
                    break;
                case 2:
                    System.out.println("01.04\n");
                    text2();// void function displays the content of the task
                    System.out.println("Give the probability of survival in decimal form (X)\n");
                    try{
                        decimal_precentage= sc.nextDouble();
                    }catch(InputMismatchException e){
                        e.printStackTrace();
                        System.err.println("Entered value is not an double");
                        break;
                    }
                    System.out.println("Specify the time (Y)\n");
                    try {
                        time= sc.nextDouble();
                    }catch(InputMismatchException e){
                        e.printStackTrace();
                        System.err.println("Entered value is not an double");
                        break;
                    }

                    System.out.println("The highest failure rate for a product if it is to have a reliability (or probability of survival) of "+
                            decimal_precentage +" at "+time+" is equal to " +calculate_01_04(decimal_precentage, (int) time)+"\n");
                    break;
                case 3:
                    System.out.println("01.05\n");
                    text3();// void function displays the content of the task
                    double lambda_from_function,relability;
                    System.out.println("Enter MTBF value (X):\n");
                    try {
                        mtbf = sc.nextDouble();
                    }catch(InputMismatchException e){
                        e.printStackTrace();
                        System.err.println("Entered value is not an double");
                        break;
                    }
                    System.out.println("Specify the time (Y)\n");
                    try {
                        time = sc.nextDouble();
                    }catch(InputMismatchException e){
                        e.printStackTrace();
                        System.err.println("Entered value is not an double");
                        break;
                    }
                    double[] values =  calculate_01_05(mtbf, time);
                    lambda_from_function = values[0];
                    relability = values[1];
                    System.out.println("The reliability function:\nR(t)=e^-(" +lambda_from_function+ "*t)\n");
                    System.out.println("The reliability of the item at " +time  +" hours is equal to " + relability+"\n");
                    break;
                case 4:
                    System.out.println("01.06\n");
                    text4();// void function displays the content of the task
                    System.out.println("Enter MTBF value (X):\n");
                    try {
                        mtbf = sc.nextDouble();
                    }catch(InputMismatchException e){
                        e.printStackTrace();
                        System.err.println("Entered value is not an double");
                        break;
                    }
                    System.out.println("Specify the time without failure (Y)\n");
                    try {
                        time = sc.nextDouble();
                    }catch(InputMismatchException e){
                        e.printStackTrace();
                        System.err.println("Entered value is not an double");
                        break;
                    }
                    System.out.println("If MTBF is equal to "+ mtbf + "\nThe probability that the equipment will operate for a period of " +(int) time +" hours without failure is equal to "+calculate_01_06(mtbf, time)+"\n");
                    break;
                case 5:
                    System.out.println("03.01\n");
                    text5();// void function displays the content of the task
                    System.out.println("Specify the test time in hours (Y):\n");
                    try {
                        time = sc.nextDouble();
                    }catch(InputMismatchException e){
                        e.printStackTrace();
                        System.err.println("Entered value is not an double");
                        break;
                    }
                    System.out.println("How many machines were tested?(X):\n");
                    try {
                        allmachines = sc.nextInt();
                    }catch(InputMismatchException e){
                        e.printStackTrace();
                        System.err.println("Entered value is not an double");
                        break;
                    }
                    System.out.println("How many machines have failed?(Q):\n");
                    try {
                        machines = sc.nextInt();
                    }catch(InputMismatchException e){
                        e.printStackTrace();
                        System.err.println("Entered value is not an double");
                        break;
                    }

                    int[] a = new int[machines];
                    for( int i = 0; i < machines; ++i ) { // for loop to insert values to array
                        System.out.println("enter the time after which the machine "+i+1+" failed:(Z,R,W etc.)");
                        b = sc.nextInt();
                        a[ i ] = b ;
                    }
                    for( int i = 0; i < machines; ++i ) { // a loop for counting sums.
                        sum += a[i];
                    }
                    System.out.println(calculate_03_01(machines, allmachines, time, sum) + " failures/h");
                    break;

                case 6:
                    System.exit(0);
                default:
                    System.out.println("\n");


            }


        }
    }
}