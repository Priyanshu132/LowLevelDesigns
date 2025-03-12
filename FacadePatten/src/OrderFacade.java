import java.util.List;

public class OrderFacade {

    private final ProductDao productDao;
    private final Order order;
    private final Payment payment;
    private final SendNotification sendNotification;

    public OrderFacade(){
        productDao = new ProductDao();
        order = new Order();
        payment = new Payment();
        sendNotification = new SendNotification();
    }

    public String createOrder(String name){  // steps to create order in facade, so in future if anything change client is not bothered about
        List<Product> productList = productDao.getAllProduct();
        boolean isOrderPlaced = order.placeOrder(productList.stream().filter(product -> product.getName().equalsIgnoreCase(name)).findFirst().orElse(new Product(0,"Null Product")));
        if(!isOrderPlaced)
            return "Some Error Occurred While Placing Order of Product "+name;
        payment.makePayment();
        sendNotification.notifyCustomer();
        return "Order Placed";
    }
}
