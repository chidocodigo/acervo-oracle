package mx.uaemex.fi.acervooracle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private String tabla;
    private String columna;
    private Object valor;

    public ResourceNotFoundException( String tabla, String columna, Object valor) {
        super(String.format("%s inexistente con %s : '%s'", tabla, columna, valor));
        this.tabla = tabla;
        this.columna = columna;
        this.valor = valor;
    }

    public String getTabla() {
        return tabla;
    }

    public String getColumna() {
        return columna;
    }

    public Object getValor() {
        return valor;
    }
}