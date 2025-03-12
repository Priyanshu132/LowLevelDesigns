import java.util.List;

public class ProductFacade {

    private final ProductDao productDao;

    public ProductFacade(){
        productDao = new ProductDao();
    }

    // only GET methods are exposed to client

    public List<Product> getAllProduct(){
        return productDao.getAllProduct();
    }

    public Product getProductById(int id){
        return productDao.getProductById(id);
    }

    public Product getProductByName(String name){
        return productDao.getProductByName(name);
    }
}
