package model.domain;

import java.util.ArrayList;

public enum Role {
    admin("admin"), customer("customer");

    Role(String role){

    }

    public static Role getRole(String role){
        Role r;
        switch (role.toLowerCase()){
            case "admin":
                r= Role.admin;
                break;
            default:
                r= Role.customer;
                break;
        }
        return r;
    }
}
