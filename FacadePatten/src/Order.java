public class Order {

    public boolean placeOrder(Product product){
        return product.getId() > 0;
    }
}
