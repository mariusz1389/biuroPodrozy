package pl.mazur.omernik.biuropodrozy.model.user;

import org.springframework.security.crypto.password.PasswordEncoder;

public class UserRegistrationDtoToUserBuilder {

    public static Customer rewriteToCustomer(CustomerRegistrationDto dto, PasswordEncoder passwordEncoder) {
        Customer customer = new Customer(); //dodaje dostep do ponizszych
        customer.setFirstName(dto.getFirstName().trim());//tworzy imie na podstawie FirstName z Usera  przypsuje go do customer
        customer.setSurename(dto.getLastName().trim());
        customer.setUsername(dto.getEmail().trim());
        customer.setPasswordHash(passwordEncoder.encode(dto.getPassword().trim()));
        customer.setUserAddress(UserAddress.builder()
                .city(dto.getCity().trim())
                .street(dto.getStreet().trim())
                .zipCode(dto.getZipCode())
                .build()
        );

        return customer;
    }

}
