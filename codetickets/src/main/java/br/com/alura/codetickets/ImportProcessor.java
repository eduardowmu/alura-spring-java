package br.com.alura.codetickets;

import org.springframework.batch.item.ItemProcessor;

public class ImportProcessor implements ItemProcessor<Import, Import> {

    @Override
    public Import process(Import item) throws Exception {
        if(item.getTypeEntry().equalsIgnoreCase("vip")) {
            item.setAdmTax(130.0);
        } else if(item.getTypeEntry().equalsIgnoreCase("camarote")) {
            item.setAdmTax(80.0);
        } else {
            item.setAdmTax(50.0);
        }
        return item;
    }
}