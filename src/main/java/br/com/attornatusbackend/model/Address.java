package br.com.attornatusbackend.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Table(name = "tb_address", schema = "attornatus")
public class Address {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id_address")
    private UUID id;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "number")
    private String number;

    @Column(name = "city")
    private String city;

    @ManyToOne
    @JoinColumn(name = "id_person")
    private Person person;

}
