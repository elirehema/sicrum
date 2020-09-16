package com.context.springsecurity.patient.service;

import com.context.springsecurity.contacts.domain.ContactsInformation;
import com.context.springsecurity.contacts.services.ContactsInformationService;
import com.context.springsecurity.patient.domain.PatientInformation;
import com.context.springsecurity.patient.repository.PatientInformationRepository;
import com.context.springsecurity.repository.BookRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
@Repository
public class PatientInformationServicesImpl implements PatientInformationServices {
    @Autowired
    private PatientInformationRepository patientInformationRepository;

    @Autowired
    ContactsInformationService contactsInformationService;

    @Override
    public List<PatientInformation> retrieveAllPatients() {
        return patientInformationRepository.findAll();
    }

    @Override
    public PatientInformation createNewPatient(PatientInformation patientInformation) {
        return patientInformationRepository.save(patientInformation);
    }

    @Override
    public List<PatientInformation> createByPatientListIterate(List<PatientInformation> patientInformationList) {
        return patientInformationRepository.saveAll(patientInformationList);
    }

    @Override
    public Optional<PatientInformation> retrievePatientById(Long id) {
        return patientInformationRepository.findById(id);
    }

    @Override
    public ContactsInformation updatePatientContacts(Long patientId, ContactsInformation contactsInformationRequest) {
        return patientInformationRepository.findById(patientId).map(patientInformation -> {
            ContactsInformation contactsInformation = new ContactsInformation();
            contactsInformation = contactsInformationRequest;
            contactsInformation.setPatientInformation(patientInformation);
            contactsInformationService.createNewContact(contactsInformation);

            //patientInformation.setContactsInformation(contactsInformationRequest);
           // patientInformationRepository.save(patientInformation);
           return contactsInformationRequest;
         }).orElseGet(() -> {

            return null;
        });
    }
}
