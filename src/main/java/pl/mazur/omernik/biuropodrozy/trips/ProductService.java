package pl.mazur.omernik.biuropodrozy.trips;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository<Product> productRepository;

    @Autowired
    private ProductToProductDTOBuilder productToProductDTOBuilder;

    public void createNewProduct(String tripDestination, String continent, String country, String airport, String hotel, LocalDate timeOfDeparture, LocalDate timeOfArrival,int numberOfDays) {
        Product product = new Product();
        product.setTripDestination(tripDestination);
        product.setContinent(continent);
        product.setCountry(country);
        product.setAirport(airport);
        product.setHotel(hotel);
        product.setTimeOfDeparture(timeOfDeparture);
        product.setTimeOfArrival(timeOfArrival);
        product.setNumberOfDays(numberOfDays);

        productRepository.save(product);
    }

    public void updateProduct(ProductDTO productDTO){
        Product s = productToProductDTOBuilder.buildEntity(productDTO);
        productRepository.save(s);
    }

    public Optional<Product> findProducts(Long id){
        return productRepository.findProductById(id);
    }


}
