import java.util.ArrayList;
public class CycleServiceImplementation {
    
    private ArrayList<Cycle> components = new ArrayList<>();

    public CycleServiceImplementation()
    {
        components.add(new Cycle(1, "Frame", 1500));
        components.add(new Cycle(2, "Brake", 350));
        components.add(new Cycle(3, "Tyre", 600));
        components.add(new Cycle(4, "Seat", 400));
        components.add(new Cycle(5, "Handle", 300));
        components.add(new Cycle(6, "Wheel", 800));
        components.add(new Cycle(7, "Gear", 1200));
        components.add(new Cycle(8, "Bell", 100));
        components.add(new Cycle(9, "Mudguard", 250));
        components.add(new Cycle(10, "Carrier", 450));
    }

    public void displayAllComponent()
    {
        System.out.println("show all component details");
        System.out.println("ID | Component | Current Price");

        for(Cycle component : components)
        {
            component.display();
        }
    }

    //Update component price.

    public void updateComponentPrice(int id, double newPrice)
    {
        for(Cycle component : components)
        {
            if(component.getId() == id)
            {
                component.setCurrentPrice(newPrice);
                System.out.println("Price updated successfully!");
                System.out.println("Updated Component Details:");
                component.display();
                return;
            }
        }
        System.out.println("Component Id is not found");
    }

    //Add new Component data
    public void addNewComponentData(int newId, String newName,double newPrice)
    {
        for(Cycle component : components)
        {
            if(component.getId() == newId)
            {
                System.out.println("Id exist, please enter new Id !");
                return;
            }
           
        }

        if(newName.isEmpty() || newName == null)
        {
             System.out.println("Component name cannot be empty!");
             return;
        }

        if (newPrice <= 0) {
        System.out.println("Price must be greater than zero!");
        return;
    }

        components.add(new Cycle(newId,newName,newPrice));

        System.out.println("Component added successfully!");
    }

    //Delete component
    public void deleteComponent(int id)
    {
        for(Cycle component : components)
        {
            if(component.getId() == id)
            {
                components.remove(component);
                System.out.println("Component deleted successfully!");
                return;
            }
        }
        System.out.println("Component ID not found!");
    }

    // Get component price using component ID
   
public Cycle getComponentPriceById(int id) {

    for (Cycle component : components) {

        if (component.getId() == id) {
            
            return component;
        }
    }

    return null;
}

}
