package ua.com.snicksmoda.entity;

public enum Category {
    MENS_CLOTHING, WOMENS_CLOTHING, BABY_CLOTHING;

    @Override
    public String toString() {
        return name();
    }
}
