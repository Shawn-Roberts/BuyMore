package com.BuyMore.UserServices.Mapper;

import com.BuyMore.UserServices.DTO.ApplicationUserDTO;
import com.BuyMore.UserServices.Entity.ApplicationUser;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-21T22:28:37-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.jar, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class ApplicationUserMapperImpl implements ApplicationUserMapper {

    @Override
    public ApplicationUser applicationUserDTOToApplicationUser(ApplicationUserDTO entity) {
        if ( entity == null ) {
            return null;
        }

        ApplicationUser applicationUser = new ApplicationUser();

        applicationUser.setMetaClass( entity.getMetaClass() );
        applicationUser.setFirstName( entity.getFirstName() );
        applicationUser.setLastName( entity.getLastName() );
        applicationUser.setEmail( entity.getEmail() );

        return applicationUser;
    }

    @Override
    public void updateApplicationUserFromDTO(ApplicationUserDTO dto, ApplicationUser entity) {
        if ( dto == null ) {
            return;
        }

        entity.setMetaClass( dto.getMetaClass() );
        entity.setFirstName( dto.getFirstName() );
        entity.setLastName( dto.getLastName() );
        entity.setEmail( dto.getEmail() );
    }

    @Override
    public ApplicationUserDTO applicationUserToApplicationUserDTO(ApplicationUser entity) {
        if ( entity == null ) {
            return null;
        }

        ApplicationUserDTO applicationUserDTO = new ApplicationUserDTO();

        applicationUserDTO.setMetaClass( entity.getMetaClass() );
        applicationUserDTO.setUserID( entity.getUserID() );
        applicationUserDTO.setFirstName( entity.getFirstName() );
        applicationUserDTO.setLastName( entity.getLastName() );
        applicationUserDTO.setEmail( entity.getEmail() );

        return applicationUserDTO;
    }
}
