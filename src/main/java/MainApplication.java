import entity.Booking;
import entity.Capacity;
import entity.User;
import entity.VaccinationCenter;
import exceptions.BookingNotAvailableException;
import exceptions.DuplicateUserException;
import exceptions.InvalidAgeException;
import exceptions.UserNotExistsException;
import service.CovidService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) throws InvalidAgeException, BookingNotAvailableException, DuplicateUserException {
        HashMap<String, User> stringUserHashMap=new HashMap<>();
        HashMap<String, ArrayList<VaccinationCenter>> centerHashMap=new HashMap<>();
        HashMap<String, ArrayList<Capacity>> capacityHashmap=new HashMap<>();
        HashMap<String, ArrayList<Booking>> userBookingHashMap=new HashMap<>();

        int bookId=0;
        CovidService covidService=new CovidService();
        Scanner sc=new Scanner(System.in);
        while (true){
            String cmd=sc.next();
            if(cmd.equalsIgnoreCase("ADD_USER")){
                String uid=sc.next();
                String name=sc.next();
                String gender=sc.next();
                int age=sc.nextInt();
                String state=sc.next();
                String district=sc.next();
                try {
                    covidService.addUser(uid,name,gender,age,state,district,stringUserHashMap);
                }
                catch (InvalidAgeException ex){
                    System.out.println(ex.getMessage());
                }

            }
            if(cmd.equalsIgnoreCase("ADD_VACCINATION_CENTER")){
                String state=sc.next();
                String district=sc.next();
                String centerID=sc.next();
                covidService.addcenter(centerID,state,district,centerHashMap);

            }
            if(cmd.equalsIgnoreCase("ADD_CAPACITY")){
                String centerId=sc.next();
                int day=sc.nextInt();
                int capacity=sc.nextInt();
                covidService.addcapacity(centerId,day,capacity,capacityHashmap);
            }
            if(cmd.equalsIgnoreCase("LIST_VACCINATION_CENTERS")){
                String district=sc.next();
                covidService.listcenter(district,centerHashMap,capacityHashmap);
            }
            if(cmd.equalsIgnoreCase("BOOK_VACCINATION")){
                String centerId=sc.next();
                int day=sc.nextInt();
                String userId=sc.next();
                try {
                    covidService.bookvaccine(bookId++,centerId,day,userId,
                            userBookingHashMap,capacityHashmap,stringUserHashMap);
                }
                catch (BookingNotAvailableException|DuplicateUserException ex){
                    System.out.println(ex.getMessage());
                }


            }
            if(cmd.equalsIgnoreCase("LIST_ALL_BOOKINGS")){
                String centerID=sc.next();
                int day=sc.nextInt();
                covidService.listbooking(centerID,day,userBookingHashMap);

            }
            if(cmd.equalsIgnoreCase("CANCEL_BOOKING")){
                String centerId=sc.next();
                String bookid=sc.next();
                String uid=sc.next();
                try{
                    covidService.cancelbooking(centerId,bookId,uid,userBookingHashMap,capacityHashmap);
                } catch (UserNotExistsException e) {
                    System.out.println(e.getMessage());
                }
            }
            if(cmd.equalsIgnoreCase("SEARCH_VACCINATION_CENTER")){
                int day= sc.nextInt();
                String district= sc.next();
                covidService.searchbooking(day,district,capacityHashmap,centerHashMap);
            }



        }




    }
}
