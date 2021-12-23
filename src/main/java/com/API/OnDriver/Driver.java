package com.API.OnDriver;

import java.util.ArrayList;
import java.util.List;

public class Driver extends User implements DriverObserver {
    private String driverLicense;
    private String nationalID;
    private Boolean isVerified = false;
    private List<Area> favouriteAreas;
    private List<Ride> rides;
    private Rating rating;

    public Driver(String username, String mobileNumber, String email, String password, String license, String id) {
        super(username, mobileNumber, email, password, UserStatus.activated);
        driverLicense = license;
        nationalID = id;
        favouriteAreas = new ArrayList<>();
        rides = new ArrayList<>();
        rating = new Rating();
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }
    public String getDriverLicense() {
        return driverLicense;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }
    public String getNationalID() {
        return nationalID;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }
    public Boolean getVerified() {
        return isVerified;
    }

    public void setFavouriteAreas(List<Area> favouriteAreas) {
        this.favouriteAreas = favouriteAreas;
    }
    public List<Area> getFavouriteAreas() {
        return favouriteAreas;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }
    public List<Ride> getRides() {
        return rides;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
    public Rating getRating() {
        return rating;
    }

    public void suggestOffer(int idx, Offer offer) {
        Ride ride = rides.get(idx);
        ride.addOffer(offer);
    }

    public boolean viewRides(int index) {
        boolean flag = false;
        for (int i = 0; i < rides.size(); i++) {
            if (rides.get(i).getSource().equals(favouriteAreas.get(index)) && !rides.get(i).getAccepted()) {
                System.out.println(i + " - " + rides.get(i));
                flag = true;
            }
        }
        return flag;
    }

    public void viewRating() {
        rating.viewAllRating();
    }

    public void addFavArea(Area area) {
        favouriteAreas.add(area);
        area.subscribe(this);
    }

    public boolean listFavouriteAreas() {
        boolean flag = false;
        for (int i = 0; i < favouriteAreas.size(); i++) {
            flag = true;
            System.out.println(i + " - " + favouriteAreas.get(i).getLocation());
        }
        return flag;
    }

    @Override
    public void update(Ride ride) {
        rides.add(ride);
    }

    public Boolean isRideInArea(int ride, int area){
        if(ride >= rides.size() || ride < 0){
            return false;
        }
        Ride r = rides.get(ride);
        Area a = favouriteAreas.get(area);
        if(r.getSource().equals(a) && !r.getAccepted()){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return super.toString ()+"Driver License: "+ getDriverLicense ()+"\n"+"National ID: "+getNationalID ()+"\n";
    }

}