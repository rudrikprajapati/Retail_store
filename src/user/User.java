package user;


import products.ProductSale;

import java.util.ArrayList;

public class User {

    private static int lastUid = 0;
    private String username, password,fullName;
    private double points = 99999;
    private final int uid;
    private Membership membership = Membership.NOT_A_MEMBER;
    private final ArrayList<ProductSale> productsBought = new ArrayList<>();
    public ArrayList<ProductSale> getProductsBought() {
        return productsBought;
    }


    // Constructor
    public User() {
        this.uid = ++lastUid;
    }

    // Buy Product
    public boolean buyProduct(ProductSale product) {
       productsBought.add(product);
       return true;
    }

    // Get Quantity Of Product Bought
    public int getProductBoughtSize()
    {
        return productsBought.size();
    }

    public void removeProduct(int index) {
        productsBought.remove(index);
    }

    // Get - FullName
    public String getFullName() {
        return fullName;
    }

    // Set - FullName
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    //Get - UserName
    public String getUsername() {
        return username;
    }

    // Set Username
    public void setUsername(String username) {
        this.username = username;
    }

    // Get - Password
    public String getPassword() {
        return password;
    }

    // Set - Password
    public void setPassword(String password) {
        this.password = password;
    }


    // Get - User Points
    public double getPoints() {
        return points;
    }

    // Set - User Points
    public void setPoints(double points) {
        this.points = points;
    }

    // Get User ID
    public int getUid() {
        return uid;
    }


    // Get Membership
    public Membership getMembership() {
        return membership;
    }

    //Set : Set Membership
    public void setMembership(Membership membership) {
        this.membership = membership;
    }

}


