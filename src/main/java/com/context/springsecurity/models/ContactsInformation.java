package com.context.springsecurity.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
@Entity
@Table(name = ModelNames.CONTACTS_INFO_TABLE)
public class ContactsInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2)
    private String isReachable;

    @NotBlank
    @Column(length = 50)
    private String email_address;


    @Column(length = 20)
    private String ZIP_CODE;

    @Column(length = 20)
    private String city;

    @Column(length = 100)
    private String state;


    @Column(length = 200)
    private String physical_address;

    @Column(length = 50)
    private String home_phone_no;

    @Column(length = 20)
    private String work_phone_number;

    public ContactsInformation(){}
    public ContactsInformation(String isReachable, @NotBlank String email_address, String ZIP_CODE, String city, String state, String physical_address, String home_phone_no, String work_phone_number) {
        this.isReachable = isReachable;
        this.email_address = email_address;
        this.ZIP_CODE = ZIP_CODE;
        this.city = city;
        this.state = state;
        this.physical_address = physical_address;
        this.home_phone_no = home_phone_no;
        this.work_phone_number = work_phone_number;
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getEmail_address() {
        return email_address;
    }

    public String getIsReachable() {
        return isReachable;
    }

    public String getHome_phone_no() {
        return home_phone_no;
    }

    public String getPhysical_address() {
        return physical_address;
    }

    public String getState() {
        return state;
    }

    public String getZIP_CODE() {
        return ZIP_CODE;
    }

    public String getWork_phone_number() {
        return work_phone_number;
    }
}
