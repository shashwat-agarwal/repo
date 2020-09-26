package agarwal.shashwat.ecommerce.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {
    private ProductRepository repository;
    LiveData<List<Product>> allProducts;
    LiveData<Integer> idForName;
    String name="potato";


    public ProductViewModel(@NonNull Application application) {
        super(application);

        repository=new ProductRepository(application);
        allProducts=repository.getAllProducts();
        idForName=repository.getIngredientsWithNameCount(name);

    }
    public void insert(Product product){
        repository.insert(product);
    }

    public void delete(Product product){
        repository.delete(product);
    }

    public void updateQuantity(String name,long userQuantity,long userPrice){
        repository.updateQuantity(name, userQuantity, userPrice);
    }

    public void update(Product product){
        repository.update(product);
    }

    public void deleteAllProducts(){
        repository.deleteAllProducts();
    }

    public LiveData<List<Product>> getAllProducts() {
        return allProducts;
    }

    public LiveData<Integer> getIdForName() {
        return idForName;
    }
}
