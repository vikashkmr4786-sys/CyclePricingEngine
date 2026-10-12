public class Cycle {
    
    private int id;
    private String componentName;
    private double currentPrice;

    public Cycle(int id, String componentName, double currentPrice)
    {
        this.id = id;
        this.componentName = componentName;
        this.currentPrice = currentPrice;
    }
    // Getters

public int getId() {
    return id;
}

public String getComponentName() {
    return componentName;
}

public double getCurrentPrice() {
    return currentPrice;
}

// Setters

public void setId(int id) {
    this.id = id;
}

public void setComponentName(String componentName) {
    this.componentName = componentName;
}

public void setCurrentPrice(double currentPrice) {
    this.currentPrice = currentPrice;
}

public void display()
{
    System.out.println("id : " + id +"  " + " componentName :"+ "  " +componentName + " Rs. " + "  " +" currentPrice : "+"  " + currentPrice);
}

}
