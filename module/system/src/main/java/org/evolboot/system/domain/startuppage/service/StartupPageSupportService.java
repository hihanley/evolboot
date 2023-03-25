package org.evolboot.system.domain.startuppage.service;

import lombok.extern.slf4j.Slf4j;
import org.evolboot.system.SystemI18nMessage;
import org.evolboot.system.domain.startuppage.StartupPage;
import org.evolboot.system.domain.startuppage.repository.StartupPageRepository;
import org.evolboot.core.exception.DomainNotFoundException;

/**
 * 启动页
 *
 * @author evol
 * 
 */
@Slf4j
public abstract class StartupPageSupportService {

    protected final StartupPageRepository repository;

    protected StartupPageSupportService(StartupPageRepository repository) {
        this.repository = repository;
    }

    public StartupPage findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new DomainNotFoundException(SystemI18nMessage.StartupPage.notFound()));
    }

}