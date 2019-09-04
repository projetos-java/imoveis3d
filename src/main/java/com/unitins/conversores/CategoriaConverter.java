package com.unitins.conversores;

import com.unitins.model.Categoria;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "categoriaConverter")
public class CategoriaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                Categoria categoria = (Categoria) component.getAttributes().get(value);
                return categoria;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != "" & value != null) {
            component.getAttributes().put(String.valueOf(((Categoria) value).getId()), value);
            return String.valueOf(((Categoria) value).getId());
        }
        return null;
    }
}