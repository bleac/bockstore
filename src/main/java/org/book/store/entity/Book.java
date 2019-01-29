package org.book.store.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @NotBlank
    @Size(min = 5, max = 200)
    @Column(length = 200, nullable = false)
    private String name;

    @NotBlank
    @Size(min = 3, max = 300)
    @Column(length = 300)
    private String author;

    @Size(max = 3000)
    @Column(length = 3000)
    private String description;

    @NotNull
    @Max(2099)
    @Min(1000)
    private int year;

    @ManyToMany
    @JoinTable(
            name = "USERS_BOOK",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<Users> users;
}
