package entity;

public class Booking {
int bookId;
int day;
String username;
String centerId;
String district;
String name;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Booking(int bookId, int day, String username, String centerId, String district, String name) {
        this.bookId = bookId;
        this.day = day;
        this.username = username;
        this.centerId = centerId;
        this.district = district;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookId=" + bookId +
                ", day=" + day +
                ", username='" + username + '\'' +
                ", centerId='" + centerId + '\'' +
                ", district='" + district + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
