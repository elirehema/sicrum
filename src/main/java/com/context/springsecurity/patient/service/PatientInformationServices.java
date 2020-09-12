package com.context.springsecurity.patient.service;

import com.context.springsecurity.patient.domain.PatientInformation;
import org.springframework.stereotype.Component;

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
@Component
public interface PatientInformationServices {
    public List<PatientInformation> retrieveAllPatients();

    public PatientInformation createNewPatient(PatientInformation patientInformation);

    public List<PatientInformation> createByPatientListIterate(List<PatientInformation> patientInformationList);

    public Optional<PatientInformation> retrievePatientById(Long id);

    public PatientInformation updatePatientContacts(PatientInformation patientInformation);
}