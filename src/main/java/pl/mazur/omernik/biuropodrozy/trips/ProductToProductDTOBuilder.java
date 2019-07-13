package pl.mazur.omernik.biuropodrozy.trips;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mazur.omernik.biuropodrozy.reposityory.AirportRepository;
import pl.mazur.omernik.biuropodrozy.reposityory.ContinentRepository;
import pl.mazur.omernik.biuropodrozy.reposityory.CountryRepository;
import pl.mazur.omernik.biuropodrozy.reposityory.HotelRepository;

import java.util.Optional;

@Service
public class ProductToProductDTOBuilder {

    @Autowired
    private ContinentRepository continentRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private ProductRepository<Product> productRepository;

    public ProductDTO buildDto(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .tripDestination(product.getTripDestination())
//                .continenId(Optional.ofNullable(product.getContinent()).map(e -> e.getId()).orElse(null))
//                .countryId(Optional.ofNullable(product.getContinent()).map(e -> e.getId()).orElse(null))
//                .airportId(Optional.ofNullable(product.getContinent()).map(e -> e.getId()).orElse(null))
//                .hotelId(Optional.ofNullable(product.getContinent()).map(e -> e.getId()).orElse(null))
                .timeOfDeparture(product.getTimeOfDeparture())
                .timeOfArrival(product.getTimeOfArrival())
                .numberOfDays(product.getNumberOfDays())
                .build();
    }//buildDto

    public Product buildEntity(ProductDTO dto) {
        Product product;
        if (dto.getId() == null) {
            product = new Product();
        } else {
            product = productRepository.getOne(dto.getId());
        }

        product.setTripDestination(dto.getTripDestination());
//        product.setContinent(Optional.ofNullable(dto.getContinenId())
//                .map(continentRepository::getOne).orElse(null));
//        product.setCountry(Optional.ofNullable(dto.getCountryId())
//                .map(countryRepository::getOne).orElse(null));
//        product.setAirport(Optional.ofNullable(dto.getAirportId())
//                .map(airportRepository::getOne).orElse(null));
//        product.setHotel(Optional.ofNullable(dto.getHotelId())
//                .map(hotelRepository::getOne).orElse(null));
        product.setTimeOfDeparture(dto.getTimeOfDeparture());
        product.setTimeOfArrival(dto.getTimeOfArrival());
        product.setNumberOfDays(dto.getNumberOfDays());
        return product;
    }

}
