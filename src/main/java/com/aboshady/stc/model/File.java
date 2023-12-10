package com.aboshady.stc.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "FILES")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;


    @Lob
    @JsonIgnore
    private byte[] binary;

    @OneToOne(optional = false, mappedBy = "file", fetch = FetchType.LAZY)
    @JsonIgnore
    private Item item;
}
