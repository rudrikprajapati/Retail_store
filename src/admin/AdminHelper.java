package admin;

import products.Availability;
import products.Product;
import products.ProductHelper;

import static utils.Utils.*;

public class AdminHelper {

    boolean isLogged = false;
    Admin admin = new Admin();

    public void showAdminMenu(ProductHelper productHelper)
    {
        while (true)
        {
            while (!isLogged)
            {
                print("Enter 1 For Login");
                print("Enter 2 For Exit");

                int ch = userInputInt("Enter Your Choice :");

                switch (ch)
                {
                    case 1 ->
                    {
                        String uname = userInputString("username");
                        String password = hashedPassword();

                        if(uname.equals("admin") && password.equals("daiict"))
                        {
                            isLogged=true;
                        }
                        else
                        {
                            print("Oops Wrong Password / Username");
                        }
                    }
                    case 2->
                    {
                        return;
                    }
                    default -> print("Enter Correct Choice");
                }

                while (true)
                {
                    print("Enter 1 For Adding Product");
                    print("Enter 2 For Getting Total Products(Quantity)");
                    print("Enter 3 For Getting Max Profit After Selling All Products");
                    print("Enter 4 Going Back To Main Screen");
                    print("Enter 5 For Clearing Screen");


                    ch = userInputInt("Enter Your Choice :");

                    switch (ch)
                    {
                        case 1->
                        {
                            //Add Product
                            String productName = userInputString("Product Name");
                            int quantityLeft = userInputInt("Enter Quantity Left :");
                            double price = userInputDouble("Enter Price :") ;
                            double discountedPrice = userInputDouble("Enter Discounted Price");

                            if(price < 0 && quantityLeft < 0 && discountedPrice < 0)
                            {
                                print("Please Enter Correct Information , (In Terms Of Price,Quantity Left,Discounted Price)");
                                print("These Values Cant Be Less Than 0");
                            }
                            else
                            {
                                Product product = new Product(productName,price,quantityLeft,Availability.IN_STORE,discountedPrice);
                                admin.addProducts(product,productHelper);
                                print("Product Added In System");
                            }
                        }
                        case 2-> print("The Total Quantity Available Is " + admin.getTotalProducts(productHelper));
                        case 3-> print("The Total Profit We Will Make After Selling All Goods Is " + admin.getMaxProfit(productHelper));
                        case 4->
                        {
                           return;
                        }
                        case 5-> clearTerminal();
                        default -> print("Incorrect input");
                    }

                }
            }
        }
    }

}
