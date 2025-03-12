import java.util.Arrays;
import java.util.List;

public class ProductDao {

    List<Product> products = Arrays.asList(new Product(1,"Apple"),new Product(2,"Banana"));

    public void insert(){

    }

    public List<Product> getAllProduct(){
        return products;
    }

    public Product getProductById(int id){
        return products.stream().filter(product -> product.getId() == id).findFirst().orElse(new Product(0,"Null Product"));
    }

    public Product getProductByName(String name){
        return products.stream().filter(product -> product.getName().equalsIgnoreCase(name)).findFirst().orElse(new Product(0,"Null Product"));
    }

    public void updateProductById(int id){

    }

    public void deleteProductById(int id){

    }
}
