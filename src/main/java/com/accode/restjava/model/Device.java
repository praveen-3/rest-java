package com.accode.restjava.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "device")
@Data
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "imei",nullable = false)
    private long imei;

    @Column(name = "status")
    private int status;

    @Column(name = "password")
    private String password;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "user_id",nullable = false)
    private long userId;

}
