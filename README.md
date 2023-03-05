# Retail_store
Construct a console-based application for a retail store application.

Part I: User Login/ Register

● The application should start by showing two options: (1) Sign In (2) Register  

● In the case of Sign In, ask the user to provide his “username” and “password”. If they match, let her in, not otherwise. 

● In the case of Register, ask the user to provide his “full name”, “username”, and “password”. In the case of a password, echo the asterisk symbol (*) in place of the typed character. E.g., if a user types “1@4”, you should display “***”, but you will store the actual password to match when she logs in again. 
Hint: You can use java.io.Console.readPassword() method. Carefully read its description from the Java 8 docs online.

● In the case of Sign In, provide an option of “Forgot Password”. Ask the user for her name, if it matches, let her set a new password and redirect her to login again with the new password.




Part II: Add Product Information

● After the successful login, you need to make an interface only for an admin account to add product information.

● In which admin will pass the product information like product id, product name, and their status of availability (e.g., In-store, Out-of-Stock, five copies available, discounted price if any,  decide the period of time a customer can return/replace the product). 

● Create an interface to compute the total number of products available at the store. Calculate the maximum profit they can make from the sale of the products.




Part III: Display/Issue/Return Products

● For a customer account, you need to display the catalog for available products after successful login.

● Add membership functionally with abstract methods: Member and Nonmember. (Provide the user an additional discount if they are a member.)

● Then the application should show three options: (1) Purchase product,  (2) Cancel purchased product, (3) Display Profile.

● For the first two options, the customer needs to specify the product id which he wants to issue or return.

● If the product is available, make a child class and its method to store the issue date/return date in the customer’s profile.
And for the third option, the application should display the customer’s profile using the parent class and its methods.




Part IV: Calculate Fine for Late Return

● Make an interface for the admin to calculate the fine for customers.

● If the duration between the issue date and the return date is more than the limits displayed on products, then calculate fine.

● Implement the interface using access modifiers.
