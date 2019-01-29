package org.book.store.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "USERS")
public class Users {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @NotBlank
    @Size(min = 3, max = 100)
    @Column(length = 100, nullable = false)
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 100)
    @Column(length = 100, nullable = false)
    private String lastName;

    @NotBlank
    @Size(min = 3, max = 100)
    @Email(regexp = "")
    @Column(unique = true, length = 100, nullable = false)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany(mappedBy = "users")
    private List<Book> books;
}
