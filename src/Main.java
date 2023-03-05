import admin.AdminHelper;
import products.Availability;
import products.Product;
import products.ProductHelper;
import products.ProductSale;
import user.Membership;
import user.User;
import user.UserHelper;

import java.util.Date;
import java.util.HashMap;

import static java.lang.System.exit;
import static utils.Utils.*;

public class Main {
    //Note  : Please Compile And Run Code In Terminal As We Have Used Console (For Password) , Which Only Works In Terminal
    public static void main(String[] args) {
        boolean isRegistered = false, isLoggedIn = false;
        HashMap<String, User> users = new HashMap<>();
        UserHelper userHelper = new UserHelper();
        AdminHelper adminHelper = new AdminHelper();
        ProductHelper productHelper = new ProductHelper();
        User loggedUser = null;
        int choice;

        while (true)
        {
            while (!isLoggedIn || !isRegistered) {
                print("Enter 1 For Registering");
                print("Enter 2 For Login");
                print("Enter 3 For Admin Console");
                print("Enter 4 For Forget Password");
                print("Enter 5 For Clearing Screen");

                choice = userInputInt("Enter Your Choice");

                switch (choice) {
                    case 1 -> {
                       isRegistered = userHelper.registerUser(users);
                       if (!isRegistered)
                       {
                           print("Username Already Exists");
                       }
                    }
                    case 2 -> {
                        if (isRegistered) {
                            loggedUser = userHelper.loginUser(users);
                            if(loggedUser == null)
                            {
                                print("Wrong username or Password");
                            }
                            else
                            {
                                isLoggedIn=true;
                            }
                        } else {
                            print("Please Register Before Trying To Login");
                        }
                    }
                    case 3 -> adminHelper.showAdminMenu(productHelper);
                    case 4 -> {
                        if (isRegistered) {
                            boolean passChangeStatus = userHelper.forgetPassword(users);
                            if (passChangeStatus) {
                                print("Password Changed Successfully");
                            } else {
                                print("Oops Wrong Username");
                            }
                        } else {
                            print("You Must Register Before , If You Wanna Change Password");
                        }
                    }
                    case 5 -> clearTerminal();
                    default -> print("Wrong Choice...");
                }
            }


            while (true)
            {
                productHelper.showProducts();
                print("Enter 1 For User Profile");
                print("Enter 2 For Buying The Product");
                print("Enter 3 For Returning The Product");
                print("Enter 4 For Logout");
                print("Enter 5 For Closing The App");
                print("Enter 6 For Clearing Screen");

                choice = userInputInt("Enter Your Choice");

                switch (choice)
                {
                    case 1 -> userHelper.displayUserProfile(loggedUser);
                    case 2 ->
                    {
                        choice = userInputInt("Enter Product ID");
                        choice=choice-1; // 0 Base Indexing
                        if (choice >= 0 && choice < productHelper.getProductLength())
                        {
                            Product pd = productHelper.getSpecificProduct(choice);
                            double userPoints = loggedUser.getPoints();
                            double productPrice = loggedUser.getMembership() == Membership.IS_MEMBER ? pd.getDiscountedPrice() : pd.getPrice();

                            if (pd.getAvailability() == Availability.IN_STORE && userPoints >= productPrice) {
                                //Getting CurrDate
                                Date currentDate = new Date();
                                //Product Sold Data
                                ProductSale productBought = new ProductSale(pd,currentDate);
                                //Status Is Completed
                                boolean isCompleted = loggedUser.buyProduct(productBought);
                                //Changing Points
                                loggedUser.setPoints(userPoints - productPrice);
                                //Decrease Quantity
                                productHelper.decreaseProductQuantity(choice);
                                if (isCompleted) {
                                   print("--------------------------- Transaction Status -------------------------------- ");
                                    print("Product Bought");
                                   print("--------------------------- Transaction Status -------------------------------- ");

                                    userHelper.displayUserProfile(loggedUser);
                                }
                            } else {
                               print("--------------------------- Transaction Status -------------------------------- ");
                                print("The Product Is Not Available To Buy Or You Have Less Points Kindly Check");
                               print("--------------------------- Transaction Status -------------------------------- ");
                            }
                        }
                        else
                        {
                            print("Enter Valid Product ID");
                        }
                    }
                    case 3 ->
                    {

                        userHelper.displayUserProfile(loggedUser);

                        if(loggedUser.getProductBoughtSize() <= 0)
                        {
                            print("You Must Buy Something , Inorder To Sell !!");
                        }
                        else
                        {
                            choice=userInputInt("Enter ID");
                            choice=choice-1; // 0 Based Indexing

                            Date date = loggedUser.getProductsBought().get(choice).getDateBought();
                            clearTerminal();
                            print("--------------------------- IMP Note -------------------------------- ");

                            print("Product Name : " + loggedUser.getProductsBought().get(choice).getProduct().getProductName());
                            print("You Have Bought The Product On : " + date );
                            print("Please Enter After How  Many Days You Are Returning The Product (Eg 1,2)");
                            print("Note : If You Return Within 5 Days Of Purchase You Will Not Be Charged Any Fine");
                            print("Adding Negative Value Means We'll Consider It After 5 Days And Start Charging Fine");

                            print("--------------------------- IMP Note Ends -------------------------------- ");
                            print("");

                            double userPoints = loggedUser.getPoints();

                            if (choice >= 0 && choice < loggedUser.getProductBoughtSize())
                            {

                                int askUserReturn = userInputInt("Enter Extra Days : ");

                                //Getting Specific Product
                                Product pd = productHelper.getSpecificProduct(choice);
                                //Increasing Product As It Being Returned
                                productHelper.increaseProductQuantity(choice);
                                //Removing Product From User's Account
                                loggedUser.removeProduct(choice);
                                // Return Price
                                double returnPrice = loggedUser.getMembership() == Membership.IS_MEMBER ? pd.getDiscountedPrice() : pd.getPrice();

                                //Deducting Fine
                                int fineDeduct = productHelper.calculateFine(askUserReturn);
                                returnPrice = returnPrice - fineDeduct;

                                //Setting User Points
                                loggedUser.setPoints(userPoints+returnPrice);

                               print("--------------------------- Transaction Status -------------------------------- ");
                               print("Fine Charged $ " +fineDeduct);
                               print("Product Sold At $ "+returnPrice);
                               print("--------------------------- Transaction Status -------------------------------- ");
                            }
                            else
                            {
                               print("--------------------------- Transaction Status -------------------------------- ");
                                print("Check The Index While Entering");
                               print("--------------------------- Transaction Status -------------------------------- ");
                            }
                        }
                    }
                    case 5 ->
                    {
                        print("Bye Bye");
                        exit(1);
                    }
                    case 6 -> clearTerminal();
                    default -> print("Enter Valid Choice");
                }

                if(choice == 4)
                {
                    print("Good Bye , Hope You Had A Good Time");
                    loggedUser=null;
                    isLoggedIn=false;
                    break;
                }

            }

        }


    }
}