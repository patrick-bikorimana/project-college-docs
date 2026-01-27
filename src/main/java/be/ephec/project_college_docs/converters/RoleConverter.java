package be.ephec.project_college_docs.converters;

import be.ephec.project_college_docs.enumerations.Authority;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Authority, String>{
    @Override
    public String convertToDatabaseColumn(Authority authority) {
        if(authority == null){
            return null;
        }
        return authority.getValue();
    }

    @Override
    public Authority convertToEntityAttribute(String permissions) {
        if(permissions == null){
            return  null;
        }
        return Stream.of(Authority.values())
                .filter(authority -> authority.getValue().equals(permissions))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
