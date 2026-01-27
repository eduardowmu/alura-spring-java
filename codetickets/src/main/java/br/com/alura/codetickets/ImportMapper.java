package br.com.alura.codetickets;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ImportMapper implements FieldSetMapper<Import> {
    private DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public Import mapFieldSet(FieldSet fieldSet) throws BindException {
        Import imp = new Import();
        imp.setCpf(fieldSet.readString("cpf"));
        imp.setClient(fieldSet.readString("client"));
        imp.setBirthDate(LocalDate.parse(fieldSet.readString("birthDate"), dateFormater));
        imp.setShow(fieldSet.readString("show"));
        imp.setShowDate(LocalDate.parse(fieldSet.readString("showDate"), dateFormater));
        imp.setTypeEntry(fieldSet.readString("typeEntry"));
        imp.setValue(fieldSet.readDouble("value"));
        imp.setImportRegistry(LocalDateTime.now());
        return imp;
    }
}