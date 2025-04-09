package es.neesis.demospringbatch.writer;

import es.neesis.demospringbatch.model.Persona;
import org.springframework.batch.item.ItemWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class PersonCsvWriter implements ItemWriter<Persona> {

    private final String filePath;
    private boolean headerWritten = false;

    public PersonCsvWriter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void write(List<? extends Persona> personas) throws Exception {
        File file = new File(filePath);
        boolean fileExists = file.exists();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {

            if (!fileExists || !headerWritten) {
                writer.write("idPersona,nombre,apellido,dni");
                writer.newLine();
                headerWritten = true;
            }

            for (Persona p : personas) {
                writer.write(String.format(
                        "%d,%s,%s,%s",
                        p.getIdPersona(),
                        p.getNombre(),
                        p.getApellido(),
                        p.getDni()
                ));
                writer.newLine();
            }
        }
    }
}
