package apifestivos.apifestivos.interfaces;

import apifestivos.apifestivos.entidades.Festivo;
import java.util.Date;
import java.util.List;

public interface IFestivoServicio {
    public List<Festivo> obtenerFestivos(Integer año);

    public boolean esFestivo(Date Fecha);

}
