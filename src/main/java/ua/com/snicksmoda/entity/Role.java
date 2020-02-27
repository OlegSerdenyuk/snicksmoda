package ua.com.snicksmoda.entity;

public enum Role {
    ADMIN, CLIENT;

    @Override
    public String toString() {
        return "ROLE_" + name();
    }
}
