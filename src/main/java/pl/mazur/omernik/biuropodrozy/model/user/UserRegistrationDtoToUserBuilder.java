package pl.mazur.omernik.biuropodrozy.model.user;

import org.springframework.security.crypto.password.PasswordEncoder;

public class UserRegistrationDtoToUserBuilder {

    public static Customer rewriteToCustomer(CustomerRegistrationDto dto, PasswordEncoder passwordEncoder) {
        Customer customer = new Customer();
        customer.setUsername(dto.getUsername().trim());
        customer.setFirstName(dto.getFirstName().trim());
        customer.setSurename(dto.getLastName().trim());
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
