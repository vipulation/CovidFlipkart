package entity;

public class Capacity {
String centerId;
int capacity;

int day;

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Capacity(String centerId, int capacity, int day) {
        this.centerId = centerId;
        this.capacity = capacity;
        this.day = day;
    }

    @Override
    public String toString() {
        return "Capacity{" +
                "centerId='" + centerId + '\'' +
                ", capacity=" + capacity +
                ", day=" + day +
                '}';
    }
}
