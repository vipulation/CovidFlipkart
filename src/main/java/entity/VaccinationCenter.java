package entity;

public class VaccinationCenter {
    String centerId;
    String district;
    String state;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public VaccinationCenter(String centerId, String district, String state) {
        this.centerId = centerId;
        this.district = district;
        this.state = state;
    }

    @Override
    public String toString() {
        return "VaccinationCenter{" +
                "centerId='" + centerId + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
