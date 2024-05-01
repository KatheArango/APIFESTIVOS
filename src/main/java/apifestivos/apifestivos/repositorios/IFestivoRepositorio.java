package apifestivos.apifestivos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import apifestivos.apifestivos.entidades.Festivo;

public interface IFestivoRepositorio extends JpaRepository<Festivo, Integer> {

}
