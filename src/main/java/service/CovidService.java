package service;

import entity.Booking;
import entity.Capacity;
import entity.User;
import entity.VaccinationCenter;
import exceptions.BookingNotAvailableException;
import exceptions.DuplicateUserException;
import exceptions.InvalidAgeException;
import exceptions.UserNotExistsException;

import java.util.ArrayList;
import java.util.HashMap;

public class CovidService {
public void addUser(String uid,String name,String gender,int age,
                    String state,String district,
                    HashMap<String, User> stringUserHashMap) throws InvalidAgeException {
    if(age<18) {
        throw new InvalidAgeException("age less than 18");
    }
    else{
    User user=new User(uid,name,gender,age,state,district);
    stringUserHashMap.put(uid,user);}

}
public void addcenter(String centerId, String state, String district,
                      HashMap<String,ArrayList<VaccinationCenter>>hashMap)
         {
    VaccinationCenter vaccinationCenter=new VaccinationCenter(centerId,district,state);
    ArrayList<VaccinationCenter> v;
    if(hashMap.containsKey(district)){
    v=hashMap.get(district);}
    else
        v=new ArrayList<>();
    v.add(vaccinationCenter);
    hashMap.put(district,v);

}
public void addcapacity(String centerId, int day, int capacity,
                        HashMap<String,ArrayList<Capacity>> capacityHashMap){
    Capacity capacity1=new Capacity(centerId,capacity,day);
    ArrayList<Capacity> c;
    if(capacityHashMap.containsKey(centerId)) {
        c = capacityHashMap.get(centerId);
    }
    else{
        c = new ArrayList<>();
    }
    c.add(capacity1);
    capacityHashMap.put(centerId,c);

}
public void listcenter(String district,HashMap<String,ArrayList<VaccinationCenter>> centerHashMap,
                       HashMap<String,ArrayList<Capacity>> capacityHashmap){
     ArrayList<VaccinationCenter> centers=centerHashMap.get(district);
     centers.forEach(k->{
            ArrayList<Capacity> arrayList = capacityHashmap.get(k.getCenterId());
            for (int i = 0; i < arrayList.size(); i++) {
                int capacity = arrayList.get(i).getCapacity();
                int day = arrayList.get(i).getDay();
                System.out.println(k.getCenterId() + " " + day + " " + capacity + "");
            }
        });


}
public void bookvaccine(int bookid,String centerId, int day, String userId,
                        HashMap<String,ArrayList<Booking>> userBookingHashMap,
                        HashMap<String,ArrayList<Capacity>>
                        capacityHashmap,HashMap<String, User> stringUserHashMap) throws BookingNotAvailableException, DuplicateUserException {
    String district=stringUserHashMap.get(userId).getDistrict();
    String name=stringUserHashMap.get(userId).getName();

    if(userBookingHashMap.containsKey(centerId)){
        ArrayList<Booking> w=userBookingHashMap.get(centerId);
        for(int i=0;i< w.size();i++){
            if(userId.equalsIgnoreCase(w.get(i).getUsername()))
                throw new DuplicateUserException("user already booked");
        }
    }

            ArrayList<Capacity> c=capacityHashmap.get(centerId);
            int capacity=-1;
            for(int i=0;i<c.size();i++){
                if(c.get(i).getDay()==day){
                    capacity=c.get(i).getCapacity();
                    if(capacity>=1)
                        c.get(i).setCapacity(capacity-1);
                }
            }
            if(capacity<=0) {
                throw new BookingNotAvailableException("No slots left for this day");

            }

            capacityHashmap.put(centerId,c);
        Booking booking=new Booking(bookid,day,userId,centerId,district,name);
        ArrayList<Booking> b;
        if(userBookingHashMap.containsKey(centerId)) {
            b = userBookingHashMap.get(centerId);
        }
        else{
            b = new ArrayList<>();
        }
        b.add(booking);
        userBookingHashMap.put(centerId,b);

}
public void listbooking(String centerId,int day,HashMap<String,ArrayList<Booking>> bookingHashMap){
ArrayList<Booking> b=bookingHashMap.get(centerId);
b.forEach(booking -> {
    System.out.println(booking.getBookId()+" "+booking.getName()+" "+booking.getCenterId()+" "+booking.getDistrict());
});

}
public  void cancelbooking(String centerid,int bookid,String uid,
                           HashMap<String,ArrayList<Booking>> bookingHashMap,
                           HashMap<String,ArrayList<Capacity>>capacityHashmap) throws UserNotExistsException {
    ArrayList<Booking> b=bookingHashMap.get(centerid);
    int day = 0;
    for(int i=0;i<b.size();i++){
        if(b.get(i).getUsername().equalsIgnoreCase(uid)){
            Booking booking=b.get(i);
            day=booking.getDay();
            b.remove(booking);

        }
        else
            throw new UserNotExistsException("user not exists");
    }
    ArrayList<Capacity> c=capacityHashmap.get(centerid);
    for(int i=0;i<c.size();i++){
        if(c.get(i).getDay()==day){
           c.get(i).setCapacity(c.get(i).getCapacity()+1);
        }
    }

}


    public void searchbooking(int day, String district,
                              HashMap<String, ArrayList<Capacity>> capacityHashmap,
                              HashMap<String, ArrayList<VaccinationCenter>> centerHashMap) {
     int maxday=day+3;
     boolean flag=false;
     while(day<=maxday){
         ArrayList<VaccinationCenter> centers=centerHashMap.get(district);
         for(int i=0;i<centers.size();i++){
             String centerId=centers.get(i).getCenterId();
             ArrayList<Capacity> capacities=capacityHashmap.get(centerId);
             for(int j=0;j<capacities.size();j++){
                 if(day==capacities.get(j).getDay()){
                     System.out.println(centerId);
                     flag=true;
                 }
             }
         }
         if(!flag)
             day++;
         else
             return;

     }
     if(!flag)
         System.out.println("No Centers Found");
    }
}
