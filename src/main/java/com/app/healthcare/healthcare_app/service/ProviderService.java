package com.app.healthcare.healthcare_app.service;

import com.app.healthcare.healthcare_app.model.Provider;

import java.util.List;

public interface ProviderService {
    List<Provider> getAllProviders();

    Provider getProviderById(Long id);

    Provider createProvider(Provider provider);

    Provider updateProvider(Long id, Provider provider);

    void deleteProvider(Long id);
}
