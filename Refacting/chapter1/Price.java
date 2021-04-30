package Refacting.chapter1;

abstract class Price {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);
}

class ChildrensPrice extends Price {
    int getPriceCode() {
        return Movie.CHILDRENS;
    }

    protected double getCharge(int daysRented) {
        double result = 1.5;

        if (daysRented > 3) {
            result += (daysRented - 3) * 1.5;
        }

        return result;
    }
}

class NewReleasePrice extends Price {
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    protected double getCharge(int daysRented) {
        return daysRented * 3;
    }
}

class RegularPrice extends Price {
    int getPriceCode() {
        return Movie.REGULAR;
    }

    protected double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2) {
            result += (daysRented - 2) * 2.5;
        }

        return result;
    }
}
