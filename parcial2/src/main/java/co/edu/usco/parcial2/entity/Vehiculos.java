package co.edu.usco.parcial2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table( name = "vehiculos")
public class Vehiculos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NotNull
    @Size(max = 6)
    @Pattern(message = "Sólo valores alfanuméricos", regexp = "^[a-zA-Z0-9-]+$")
    @Column(name = "veh_placas")
    private String name;

    @NotNull
    @Min(1)
    @Max(24)
    @Column(name = "veh_horaEntrada")
    private Float horaEntrada;


    @Min(1)
    @Max(24)
    @Column(name = "veh_horaSalida")
    private Float horaSalida;

    @NotNull
    @Pattern(message = "Sólo valores alfanuméricos", regexp = "^[a-zA-Z0-9-]+$")
    @Column(name = "veh_ubicacion")
    private String ubicacion;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.EAGER)
    @JoinColumn(name = "tipos_id")
    private Tipos tipos;






}
