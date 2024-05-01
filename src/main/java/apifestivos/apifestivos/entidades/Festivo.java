package apifestivos.apifestivos.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import apifestivos.apifestivos.vistas.Vista;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "Festivo")
public class Festivo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JsonView(Vista.SimplifiedView.class)
    @Column(name = "Nombre", length = 100)
    private String nombre;

    @Column(name = "Día")
    private Integer dia;

    @Column(name = "Mes")
    private Integer mes;

    @Column(name = "Dias_ramos")
    private Integer diasPascua;

    @JsonView(Vista.SimplifiedView.class)
    @JsonFormat(pattern = "yyyy/mm/dd")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idtipo", referencedColumnName = "id")
    private Tipo tipo;

    public Festivo(Date fecha, String nombre, Tipo tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fecha = fecha;
    }
}
