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
    @Column
    private String first_Name;
    @Column
    private String last_Name;
    @Column
    private String gender;
    private Integer age;
    @Column(name="city_id")
    private int city_Id;
}
