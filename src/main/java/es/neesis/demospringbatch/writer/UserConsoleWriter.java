package es.neesis.demospringbatch.writer;

import es.neesis.demospringbatch.model.UserEntity;

import org.springframework.batch.item.ItemWriter;

import javax.sql.DataSource;
import java.io.Serializable;
import java.util.List;

public class UserConsoleWriter implements ItemWriter<UserEntity> {

    private DataSource dataSource;

    public UserConsoleWriter(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void write(List<? extends UserEntity> list) throws Exception {
        list.forEach(user -> {
            System.out.println("User: " + user);
        });
    }
}
