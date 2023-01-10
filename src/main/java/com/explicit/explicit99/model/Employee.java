package com.explicit.explicit99.model;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@Entity
@Table(name = "employees")
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(name = "firstname", nullable = false)
    private String firstName;
@Column(name="lastname")
    private  String lastName;
@Column(name = "email")
    private String email;
}
