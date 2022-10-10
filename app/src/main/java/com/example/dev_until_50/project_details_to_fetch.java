package com.example.dev_until_50;

public class project_details_to_fetch {
    String projectname,shortdesc,city,state,startdate,enddate,country;

    public project_details_to_fetch(){

    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public project_details_to_fetch(String projectname, String shortdesc, String city, String state, String country) {
        this.projectname = projectname;
        this.shortdesc = shortdesc;
        this.city = city;
        this.state = state;
        this.startdate = startdate;
        this.enddate = enddate;
        this.country = country;
    }
}
