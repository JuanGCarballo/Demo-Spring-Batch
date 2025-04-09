package es.neesis.demospringbatch.processor;

import es.neesis.demospringbatch.dto.User;
import es.neesis.demospringbatch.model.UserEntity;
import org.springframework.batch.item.ItemProcessor;

public class UserEditProcessor implements ItemProcessor<User, UserEntity> {

    @Override
    public UserEntity process(User user) {

        return UserEntity.builder()
                .id(Integer.parseInt(user.getId()))
                .username(user.getUsername() + "EDITED")
                .fullName(user.getName() +  " " + user.getFirstName()+ " " + user.getLastName() + "EDITED")
                .password(user.getPassword() + "EDITED")
                .email(user.getEmail() + "EDITED")
                .build();
    }
}
