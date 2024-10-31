package com.xd_pxrt.projectgrpcgradleuser.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("usero")
public class User {

    @Id
    private UUID id;

    private String username;

    private String password;

    private String email;

    private LocalDate birthday;

}
