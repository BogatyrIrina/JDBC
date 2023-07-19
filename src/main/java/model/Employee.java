package model;
import lombok.*;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@ToString

@Table(name="employee")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column (name="last_Name")
    private String lastName;
    @Column
    private String gender;
    private Integer age;
    @Column(name="city_id")
    private int cityId;

    @ManyToOne(cascade = CascadeType.ALL)
    private City city;
}
