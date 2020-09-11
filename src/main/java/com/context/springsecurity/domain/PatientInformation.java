package com.context.springsecurity.domain;

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
@Table(name = ModelNames.PATIENT_INFO_TABLE)
public class PatientInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 20)
    private String first_name;

    @NotBlank
    @Column(length = 20)
    private String middle_name;

    @NotBlank
    @Column(length = 20)
    private String last_name;

    @NotBlank
    @Column(length = 20)
    private String suffix;

    @NotBlank
    @Column(length = 20)
    private String ethnicity;

    @NotBlank
    @Column(length = 50)
    private String DOB;

    @NotBlank
    @Column(length = 5)
    private String gender;

    @NotBlank
    @Column(length = 20)
    private String ssn;

    @NotBlank
    @Column(length = 20)
    private String mdn;

    @NotBlank
    @Column(length = 200)
    private String principal_tribe;

    @NotBlank
    @Column(length = 20)
    private String country;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(	name = ModelNames.CONTACTS_INFO_TABLE,
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id"))
    private ContactsInformation roles = new ContactsInformation();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(	name = ModelNames.MISC_INFO_TABLE,
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "misc_id"))
    private PatientMiscInfo patientMiscInfo = new PatientMiscInfo();


    public PatientInformation(){}
    public PatientInformation(String first_name, String middle_name, String last_name, String suffix, String ethnicity,  String DOB,  String gender, String ssn,  String MDN, String principal_tribe) {
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.suffix = suffix;
        this.ethnicity = ethnicity;
        this.DOB = DOB;
        this.gender = gender;
        this.ssn = ssn;
        this.mdn = MDN;
        this.principal_tribe = principal_tribe;
    }

}
