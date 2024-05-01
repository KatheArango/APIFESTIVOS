package apifestivos.apifestivos.controladores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import apifestivos.apifestivos.interfaces.IFestivoServicio;
import apifestivos.apifestivos.vistas.Vista;
import apifestivos.apifestivos.entidades.Festivo;

@RestController
@RequestMapping("/festivos")
public class FestivoControlador {

    @Autowired
    private IFestivoServicio festivoServicio;

    @CrossOrigin(origins = "*")
    @GetMapping("verificar/{year}/{month}/{day}")
    public String verificarFestivo(
            @PathVariable Integer year,
            @PathVariable Integer month,
            @PathVariable Integer day) {

        try {
            String fecha = String.format("%04d/%02d/%02d", year, month, day);

            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
            Date fechaParseada = formatoFecha.parse(fecha);
            return festivoServicio.esFestivo(fechaParseada) ? "Es festivo." : "No es festivo.";

        } catch (NumberFormatException | ParseException e) {
            return "No se puede procesar su solicitud, debe revisar el formato: yyyy/MM/dd";
        }
    }

    @CrossOrigin(origins = "*")
    @JsonView(Vista.SimplifiedView.class)
    @GetMapping("listar/{year}")

    public List<Festivo> listar(@PathVariable Integer year) {

        return festivoServicio.obtenerFestivos(year);
    }

}
