package es.neesis.demospringbatch.processor;

import es.neesis.demospringbatch.dto.User;
import es.neesis.demospringbatch.model.Persona;
import org.springframework.batch.item.ItemProcessor;

public class UserPersonProcessor implements ItemProcessor<User, Persona> {

    @Override
    public Persona process(User user) {
        Persona persona = new Persona();
        persona.setIdPersona(Integer.parseInt(user.getId()));
        persona.setNombre(user.getName());
        persona.setApellido(user.getFirstName() + " " + user.getLastName());
        persona.setDni("12345678D");
        return persona;
    }
}
