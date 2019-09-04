package com.unitins.conversores;

import com.unitins.model.Imobiliaria;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "imobiliariaConverter")
public class ImobiliariaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                Imobiliaria imobiliaria = (Imobiliaria) component.getAttributes().get(value);
                return imobiliaria;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != "" & value != null) {
            component.getAttributes().put(String.valueOf(((Imobiliaria) value).getId()), value);
            return String.valueOf(((Imobiliaria) value).getId());
        }
        return null;
    }
}