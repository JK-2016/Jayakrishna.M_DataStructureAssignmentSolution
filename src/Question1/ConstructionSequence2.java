package Question1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class ConstructionSequence2 {
    public static void main(String[] args) {
        int numFloors, day = 1, floorSize;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no.of Floors");
        numFloors = sc.nextInt();
        ArrayList<Integer> arr_Input = new ArrayList<>();
        ArrayList<Integer> arr_Stack = new ArrayList<>();


        while (day <= numFloors) {
            System.out.println("enter the floor size given on day :" + day);
            floorSize = sc.nextInt();
            if (!arr_Stack.contains(floorSize)) {
                arr_Stack.add(floorSize);
                arr_Input.add(floorSize);
            } else {
                System.out.println("Invalid Input");
                break;
            }
            day++;
        }
        //End of Input//
        //Sort the array
        arr_Stack.sort(Collections.reverseOrder());

        if (arr_Stack.size() == numFloors) {
            System.out.println("The order of construction is as follows");
            constructionOrder(numFloors, arr_Stack, arr_Input);
        }
    }

    private static void constructionOrder(int numFloors, ArrayList<Integer> arr_Stack,
                                          ArrayList<Integer> arr_Input) {
        int day = 1, reqFloorSize, sizeP =0;
        HashSet<Integer> trackSet = new HashSet<>();

        reqFloorSize = arr_Stack.get(sizeP);
        while(day<=numFloors){

            System.out.println("Day: "+day);

            trackSet.add(arr_Input.get(day-1));

                while (trackSet.contains(reqFloorSize)){
                    System.out.print(reqFloorSize+" ");
                    trackSet.remove(reqFloorSize);
                    if(sizeP <numFloors-1) {
                        reqFloorSize = arr_Stack.get(++sizeP);
                    }
                }


            System.out.println("");
            day++;
        }
    }

}