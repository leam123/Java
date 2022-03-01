public class Product{
    private int code;
    private String name;
    private float cost;
    private int stock;
    private static int counter=1;
    
    public Product(){}
    public Product(String name, float cost, int stock){
        this.name = name;
        this.cost = cost;
        this.stock = stock;
    }
    public int getCode(){
        return code;
    }
    public String getName(){
        return name;
    }
    public float getCost(){
        return cost;
    }
    public int getStock(){
        return stock;
    }
    public void setCode(int code){
        this.code = getCounter();
    }
    public void setName(String name){
        this.name = name;
    }
    public void setCost(float cost){
        this.cost = cost;
    }
    public void setStock(int stock){
        this.stock = stock;
    }
    public int getCounter(){
        return counter++;
    }
    public boolean sell(int count){
        boolean result;
        if(count<=getStock()){
            result = true;
        }
        else{
            result = false;
        }
        return result;
    }
    public int purchase(int count){
        return count = getStock() + count;
    }
    public float priceIncrease(float rate){
        return rate = (getCost()*rate) + getCost();
    }
    public String toString(){
        return "Product Code: "+getCode()+"\nProduct Name: "+getName()+"\nProduct Cost: "+getCost()+"\nNumber of stocks: "+getStock();
    }
}