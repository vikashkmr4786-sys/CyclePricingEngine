import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CycleServiceImplementation service = new CycleServiceImplementation();
                

        boolean applicationRunning = true;
        while(applicationRunning)
        {
        System.out.println("1. Admin Login");
        System.out.println("2. Salesman Login");
        System.out.println("3. Exit");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
             // Admin section which is open with a unique Password.
            case 1:
                sc.nextLine();

                System.out.print("Enter Admin Password: ");
                String password = sc.nextLine();

                String adminPassword = "Hero@123";

                if (password.equals(adminPassword)) {

                    System.out.println("Admin Login Successful!");

                    boolean adminRunning = true;

                    while(adminRunning)
                    {
                    System.out.println("1. Update Price");
                    System.out.println("2. Add Component");
                    System.out.println("3. Delete Component");
                    System.out.println("4. Logout");

                    System.out.println("Enter admin choice");
                     int adminChoice = sc.nextInt();
                     switch(adminChoice)
                     {
                        case 1 :service.displayAllComponent(); // Display all component data.

                        System.out.println("Enter component Id");
                        int id = sc.nextInt();

                        System.out.println("Enter component Price");
                        double price = sc.nextDouble();

                        if(price > 0)
                        {
                            service.updateComponentPrice(id,price); // Update Component price.
                        }
                        else{
                            System.out.println("Price must be greater than zero ");
                        }
                        break;

                        case 2 : System.out.println("display all data.");
                        service.displayAllComponent();
                        System.out.println("enter Component  new Id ");
                        int newId = sc.nextInt();
                        sc.nextLine();

                        System.out.println("enter Component  Name ");
                        String newName = sc.nextLine();

                        System.out.println("enter Component  new price ");
                        double newPrice = sc.nextDouble();

                        service.addNewComponentData(newId, newName,newPrice);
                        break;

                        case 3: System.out.println("Enter Id for delete component");
                        int deleteId = sc.nextInt();
                        sc.nextLine();
                        service.deleteComponent(deleteId);// Delete component
                        break;

                        case 4: 
                        System.out.println("Admin Logged Out!");// Logout
                        adminRunning = false;
                         break;

                        default:
                                 System.out.println("Invalid Admin Choice!");
                     }
                    }

                } else {
                    System.out.println("Incorrect Password! Access Denied.");
                }
                break;

            case 2: 
                System.out.println("Salesman Login Successful");// sales man login
                boolean salesRunning = true;
                while(salesRunning)
                {
                System.out.println("enter 1 for display all data.");
                System.out.println("enter 2 for getting component data from id");
                System.out.println("enter 3 for getting total component price from id");
                 System.out.println("4. Logout");
                System.out.print("Enter your choice: ");
                int salesManChoice = sc.nextInt();
                switch(salesManChoice)
                {
                    case 1 :
                         service.displayAllComponent(); //display all data
                         break;

                         case 2: 
                System.out.println("Enter Id for getting details for this id");
                int idDetails = sc.nextInt();


                Cycle componentData = service.getComponentPriceById( idDetails);//getting component by id
                if(componentData != null)
                {
                    System.out.println("Id :"+componentData.getId());
                    System.out.println("Name :"+componentData.getComponentName());
                    System.out.println("Price :"+componentData.getCurrentPrice());
                }
                 
                 else {
                      System.out.println("Component ID does not exist!");
                        }

                        break;
                        case 3 :System.out.println("Enter number of components");
                        int count = sc.nextInt();
                        if(count <= 0)
                        {
                            System.out.println("Number of component must be greater than zero");
                            break;
                        }

                        double totalPrice = 0;
                        for(int i = 1;i<=count;i++)
                        {
                            System.out.println("enter component id "+ i +" : ");
                            int componentId = sc.nextInt();

                            Cycle component = service.getComponentPriceById(componentId);
                            if(component != null)
                            {
                                totalPrice = totalPrice + component.getCurrentPrice();
                            }
                            else{
                                System.out.println("Invalid Component ID! Please try again.");
                                 i--;
                            }
                        }
                        System.out.println("Total Cycle Price: Rs. " + totalPrice);

                            break;

                            case 4 : System.out.println("Sales man Logout");
                            salesRunning = false;
                            break;
                            default:
                                 System.out.println("Invalid Salesman Choice!");
                    }
                    }
                break;

            case 3:
                System.out.println("Application Closed");
                applicationRunning = false;
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }

        sc.close();
    }
}