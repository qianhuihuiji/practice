package Refacting.chapter1;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;
    private Price _price;

    public Movie(String _title, int _priceCode) throws IllegalAccessException {
        this._title = _title;
        setPriceCode(_priceCode);
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int arg) throws IllegalAccessException {
        switch (arg) {
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalAccessException("Incorrect Price Code");
        }
    }

    public String getTitle() {
        return _title;
    }

    protected double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }

    protected int getFrequentRenterPoints(int daysRented) {
        if ((getPriceCode() == Movie.NEW_RELEASE) &&
                daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
