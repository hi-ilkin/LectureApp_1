package com.mobileapplecture.ilkin.lectureapp_1;

/**
 * Created by Ilkin on 04-Apr-17.
 */

class Locations {

    private String name;
    private String phone;
    private String email;
    private String location;

    Locations(String n, String p, String e, String l)
    {
        name = n;
        phone = p;
        email = e;
        location = l;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
