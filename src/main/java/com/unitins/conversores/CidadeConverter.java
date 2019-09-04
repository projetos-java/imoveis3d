package com.unitins.conversores;

import com.unitins.model.Cidade;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "cidadeConverter")
public class CidadeConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                Cidade cidade = (Cidade) component.getAttributes().get(value);
                return cidade;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != "" & value != null) {
            component.getAttributes().put(String.valueOf(((Cidade) value).getId()), value);
            return String.valueOf(((Cidade) value).getId());
        }
        return null;
    }
}