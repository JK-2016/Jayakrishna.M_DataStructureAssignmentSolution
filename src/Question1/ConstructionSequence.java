package Question1;

import java.util.ArrayList;
import java.util.Scanner;


public class ConstructionSequence {
    public static void main(String[] args) {
        int numFloors, day = 1,floorSize;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no.of Floors");
        numFloors = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        while (day <= numFloors) {
            System.out.println("enter the floor size given on day :" + day);
            floorSize =sc.nextInt();
            if(floorSize<=numFloors && !arr.contains(floorSize)){
                arr.add(floorSize);
            }
            else{
                System.out.println("Invalid Input");
                break;
            }
            day++;
        }
        if(arr.size()==numFloors) {
            System.out.println("The order of construction is as follows");
            constructionOrder(numFloors, arr);
        }
    }

    private static void constructionOrder(int max, ArrayList<Integer> arr) {
        int day =1, reqFloorSize;
        reqFloorSize = max;
        while(day<=max){
            System.out.println("Day: "+day);
            while(arr.subList(0,day).contains(reqFloorSize)){
                System.out.print(reqFloorSize-- +" " );
            }
            System.out.println("");
            day++;
        }
    }

}
