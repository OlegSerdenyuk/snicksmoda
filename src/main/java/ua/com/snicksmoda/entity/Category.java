package ua.com.snicksmoda.entity;

import javax.persistence.*;
import java.util.List;

public enum Category {
    MENS_CLOTHING, WOMENS_CLOTHING, BABY_CLOTHING;


    @Override
    public String toString() {
        return "ROLE_" + name();
    }
}
