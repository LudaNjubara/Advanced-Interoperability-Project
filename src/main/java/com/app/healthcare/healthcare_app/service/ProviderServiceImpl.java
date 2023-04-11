package com.app.healthcare.healthcare_app.service;

import com.app.healthcare.healthcare_app.model.Provider;
import com.app.healthcare.healthcare_app.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderServiceImpl implements ProviderService {
    private final ProviderRepository providerRepository;

    @Autowired
    public ProviderServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    @Override
    public Provider getProviderById(Long id) {
        Optional<Provider> optionalProvider = providerRepository.findById(id);
        if (optionalProvider.isPresent()) {
            return optionalProvider.get();
        } else {
            throw new RuntimeException("Provider not found with id: " + id);
        }
    }

    @Override
    public Provider createProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    @Override
    public Provider updateProvider(Long id, Provider provider) {
        Optional<Provider> optionalProvider = providerRepository.findById(id);
        if (optionalProvider.isPresent()) {
            Provider providerToUpdate = optionalProvider.get();

            providerToUpdate.setFirstName(provider.getFirstName());
            providerToUpdate.setLastName(provider.getLastName());
            providerToUpdate.setAddress(provider.getAddress());
            providerToUpdate.setPhoneNumber(provider.getPhoneNumber());
            providerToUpdate.setFacility(provider.getFacility());
            providerToUpdate.setOib(provider.getOib());
            providerToUpdate.setEmail(provider.getEmail());
            providerToUpdate.setImageUrl(provider.getImageUrl());

            return providerRepository.save(providerToUpdate);
        } else {
            throw new RuntimeException("Provider not found with id: " + id);
        }
    }

    @Override
    public void deleteProvider(Long id) {
        providerRepository.deleteById(id);
    }
}
