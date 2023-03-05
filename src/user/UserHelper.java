package user;

import products.ProductSale;

import java.util.ArrayList;
import java.util.HashMap;

import static utils.Utils.*;

public class UserHelper{

    //Forget Password - Just Checking If Name Is Same As Old Or Not , If Yes We Change The Password , Else We Return False
    public boolean forgetPassword(HashMap<String, User> users) {
        String userName,password;
        userName = userInputString("Username");
        password = hashedPassword();

        boolean userNameCheck = users.containsKey(userName);

        if (userNameCheck) {
            users.get(userName).setPassword(password);
            return true;
        } else {
            return false;
        }
    }

    public boolean registerUser(HashMap<String, User> users)
    {
        String userName,password,fullName,isMember;
        boolean isRegistered = false;
        fullName = userInputString("Full name");
        userName = userInputString("Username");
        isMember = userInputString("Membership Status , 'Yes' Or 'NO' ");
        password = hashedPassword();


        if(fullName.isEmpty() || userName.isEmpty() || isMember.isEmpty() || password.isEmpty())
        {
            print("Please Enter Some Data !xD");
        }
        else
        {
            //Checking If Username Already Exists - Not Permitting Multiple Users With Same Username
            boolean allowUser = users.containsKey(userName);

            if (!allowUser) {
                User createUser = new User();

                createUser.setFullName(fullName);
                createUser.setUsername(userName);
                createUser.setPassword(password);

                if(isMember.equalsIgnoreCase("yes"))
                {
                    createUser.setMembership(Membership.IS_MEMBER);
                }

                users.put(userName, createUser);
                isRegistered = true;
            }
        }
        return  isRegistered;
    }

    public User loginUser(HashMap<String,User> users)
    {
        String userName,password;
        User loggedUser = null;
        userName = userInputString("Username");
        boolean userNameCheck = users.containsKey(userName);

        if (userNameCheck) {
            password = hashedPassword();

            String userPass = users.get(userName).getPassword();

            if (userPass.equals(password)) {
                loggedUser = users.get(userName);
            }
        }

        return loggedUser;
    }

    public void displayUserProfile(User user) {
        print("--------------------------- USER PROFILE-------------------------------- ");
        print("ID : " + user.getUid());
        print("FullName : " + user.getFullName());
        print("Username : " + user.getUsername());
        print("Points : " + user.getPoints());
        print("Membership : " + user.getMembership());

        ArrayList<ProductSale> productsBought = user.getProductsBought();

        if(productsBought.size() == 0)
        {
            print("You Have Not Bought Any Product");
        }
        else
        {
            print("Product Bought : ");

            if (user.getMembership() == Membership.IS_MEMBER)
           {

               System.out.println("Index\t| Product Name\t| Product Price(Discounted)\t| Product Bought On");
               for (int i = 0; i < productsBought.size(); i++) {
                   System.out.println((i+1) + "\t| " + productsBought.get(i).getProduct().getProductName() + "\t| " + productsBought.get(i).getProduct().getDiscountedPrice() + "\t\t\t| " + productsBought.get(i).getDateBought());
               }
           }
           else
           {

               System.out.println("Index\t| Product Name\t| Product Price\t| Product Bought On");
               for (int i = 0; i < productsBought.size(); i++) {
                   System.out.println((i+1) + "\t| " + productsBought.get(i).getProduct().getProductName() + "\t| " + productsBought.get(i).getProduct().getDiscountedPrice() + "\t\t\t| " + productsBought.get(i).getDateBought());
               }
           }
        }
        print("----------------------END OF USER PROFILE-------------------------------- ");

    }

}
