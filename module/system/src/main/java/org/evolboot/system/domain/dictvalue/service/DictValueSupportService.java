package org.evolboot.system.domain.dictvalue.service;

import org.evolboot.system.domain.dictvalue.repository.DictValueRepository;
import org.evolboot.system.domain.dictvalue.DictValue;
import org.evolboot.core.exception.DomainNotFoundException;
import org.evolboot.core.i18n.I18NMessageHolder;
import org.evolboot.system.SystemI18nMessage;
import lombok.extern.slf4j.Slf4j;

/**
 * 字典Value
 *
 * @author evol
 * @date 2023-05-07 12:55:06
 */
@Slf4j
public abstract class DictValueSupportService {

    protected final DictValueRepository repository;

    protected DictValueSupportService(DictValueRepository repository) {
        this.repository = repository;
    }

    public DictValue findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new DomainNotFoundException(I18NMessageHolder.message(SystemI18nMessage.DictValue.NOT_FOUND)));
    }

}