package com.context.springsecurity.contacts.services;

import com.context.springsecurity.contacts.domain.ContactsInformation;
import com.context.springsecurity.contacts.repository.ContactsInformationRepository;
import com.context.springsecurity.patient.domain.PatientInformation;
import com.context.springsecurity.patient.domain.PatientMiscInfo;
import com.context.springsecurity.patient.repository.PatientInformationRepository;
import com.context.springsecurity.patient.service.PatientInformationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@Controller
@Service
public class ContactsInformationServicesImpl implements ContactsInformationService {

    @Autowired
    ContactsInformationRepository contactsInformationRepository;
    @Autowired
    PatientInformationServices patientInformationServices;

    @Override
    public PatientInformation createNewContact(ContactsInformation contactsInformation) {
        Optional<PatientInformation> patientInformationOptional = patientInformationServices.retrievePatientById(contactsInformation.getId());
        PatientInformation patientInformation = patientInformationOptional.get();
        patientInformation.setContactsInformation(contactsInformation);
        patientInformationServices.updatePatientContacts(patientInformation);
        return patientInformation;
    }

    @Override
    public List<ContactsInformation> retrieveAllContactsInformation() {
        return contactsInformationRepository.findAll();
    }

    @Override
    public List<ContactsInformation> createNewContactsByIteration(List<ContactsInformation> contactsInformationList) {
        return contactsInformationRepository.saveAll(contactsInformationList);
    }

}
