public class Main {
    public static void main(String[] args) {
       // To Hide complexity/methods from Client

        ProductFacade productFacade = new ProductFacade();
        productFacade.getAllProduct().forEach(pdt-> System.out.println(pdt.getId()+" "+pdt.getName()));
        System.out.println(productFacade.getProductByName("banana").getId());
        System.out.println(productFacade.getProductById(1).getName());


       // 1. can hide unnecessary methods or define exact steps to perform task

        OrderFacade orderFacade = new OrderFacade();
        System.out.println(orderFacade.createOrder("Banana"));

    }
}