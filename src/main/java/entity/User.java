package entity;

public class User {
    String uId;
    String name;
    String gender;
    int age;
    String state;
    String district;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public User(String uId, String name, String gender, int age, String state, String district) {
        this.uId = uId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.state = state;
        this.district = district;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId='" + uId + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", state='" + state + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}
