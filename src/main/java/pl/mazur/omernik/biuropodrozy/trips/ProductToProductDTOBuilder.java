package pl.mazur.omernik.biuropodrozy.trips;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductToProductDTOBuilder {

    @Autowired
    private ProductRepository<Product> productProductRepository;

    public ProductDTO buildDto(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .tripDestination(product.getTripDestination())
                .continenId(Optional.ofNullable(product.getContinent()).map(e -> e.getId()).orElse(null))
                .countryId(Optional.ofNullable(product.getContinent()).map(e -> e.getId()).orElse(null))
                .airportId(Optional.ofNullable(product.getContinent()).map(e -> e.getId()).orElse(null))
                .hotelId(Optional.ofNullable(product.getContinent()).map(e -> e.getId()).orElse(null))
                .timeOfDeparture(product.getTimeOfDeparture())
                .timeOfArrival(product.getTimeOfArrival())
                .numberOfDays(product.getNumberOfDays())
                .build();
    }
}
