package com.app.healthcare.healthcare_app.service;

import com.app.healthcare.healthcare_app.model.Provider;
import com.app.healthcare.healthcare_app.request.ProviderPostRequest;

import java.util.List;

public interface ProviderService {
    List<Provider> getAllProviders();

    Provider getProviderById(Long id);

    Provider createProvider(ProviderPostRequest providerReq);

    Provider updateProvider(Long id, Provider provider);

    void deleteProvider(Long id);
}
