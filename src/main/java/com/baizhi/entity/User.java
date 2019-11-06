package com.baizhi.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    private String id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String source;
    private String ip;
    private String status;
    private String role;


}
