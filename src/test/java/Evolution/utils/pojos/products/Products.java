package Evolution.utils.pojos.products;

import java.util.List;

public class Products {
    private int id;

    private String title;

    private String code;

    private String article;

    private double rating;

    private List<Images> images;

    private Price price;

    private List<Availabilities> availabilities;

    private List<Availability> availability;

    private String availableType;

    private int sectionId;

    private int inBasket;

    private int inWishList;

    private List<String> quantityInWishLists;

    private int multiple;

    private boolean is24;

    private boolean isNoticeReceiptExist;

    private List<String> nameplates;

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

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getArticle() {
        return this.article;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return this.rating;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public List<Images> getImages() {
        return this.images;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Price getPrice() {
        return this.price;
    }

    public void setAvailabilities(List<Availabilities> availabilities) {
        this.availabilities = availabilities;
    }

    public List<Availabilities> getAvailabilities() {
        return this.availabilities;
    }

    public void setAvailability(List<Availability> availability) {
        this.availability = availability;
    }

    public List<Availability> getAvailability() {
        return this.availability;
    }

    public void setAvailableType(String availableType) {
        this.availableType = availableType;
    }

    public String getAvailableType() {
        return this.availableType;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getSectionId() {
        return this.sectionId;
    }

    public void setInBasket(int inBasket) {
        this.inBasket = inBasket;
    }

    public int getInBasket() {
        return this.inBasket;
    }

    public void setInWishList(int inWishList) {
        this.inWishList = inWishList;
    }

    public int getInWishList() {
        return this.inWishList;
    }

    public void setQuantityInWishLists(List<String> quantityInWishLists) {
        this.quantityInWishLists = quantityInWishLists;
    }

    public List<String> getQuantityInWishLists() {
        return this.quantityInWishLists;
    }

    public void setMultiple(int multiple) {
        this.multiple = multiple;
    }

    public int getMultiple() {
        return this.multiple;
    }

    public void setIs24(boolean is24) {
        this.is24 = is24;
    }

    public boolean getIs24() {
        return this.is24;
    }

    public void setIsNoticeReceiptExist(boolean isNoticeReceiptExist) {
        this.isNoticeReceiptExist = isNoticeReceiptExist;
    }

    public boolean getIsNoticeReceiptExist() {
        return this.isNoticeReceiptExist;
    }

    public void setNameplates(List<String> nameplates) {
        this.nameplates = nameplates;
    }

    public List<String> getNameplates() {
        return this.nameplates;
    }
}
