package Evolution.utils.pojos.products;

public class Store {
    private int id;

    private String title;

    private String address;

    private String storeType;

    private String latitude;

    private String longitude;

    private WorkingHours workingHours;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public String getStoreType() {
        return this.storeType;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setWorkingHours(WorkingHours workingHours) {
        this.workingHours = workingHours;
    }

    public WorkingHours getWorkingHours() {
        return this.workingHours;
    }
}
