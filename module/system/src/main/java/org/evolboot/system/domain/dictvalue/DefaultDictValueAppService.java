package org.evolboot.system.domain.dictvalue;

import org.evolboot.core.data.Page;
import org.evolboot.system.domain.dictkey.DictKeyAppService;
import org.evolboot.system.domain.dictvalue.repository.DictValueRepository;
import org.evolboot.system.domain.dictvalue.service.DictValueCreateFactory;
import org.evolboot.system.domain.dictvalue.service.DictValueSupportService;
import org.evolboot.system.domain.dictvalue.service.DictValueUpdateService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 字典Value
 *
 * @author evol
 * @date 2023-05-07 12:55:06
 */
@Slf4j
@Service
public class DefaultDictValueAppService extends DictValueSupportService implements DictValueAppService {


    private final DictValueCreateFactory factory;
    private final DictValueUpdateService updateService;

    private final DictKeyAppService dictKeyAppService;

    protected DefaultDictValueAppService(DictValueRepository repository, DictValueCreateFactory factory, DictValueUpdateService updateService, DictKeyAppService dictKeyAppService) {
        super(repository);
        this.factory = factory;
        this.updateService = updateService;
        this.dictKeyAppService = dictKeyAppService;
    }

    @Override
    @Transactional
    public DictValue create(DictValueCreateFactory.Request request) {
        return factory.execute(request);
    }


    @Override
    @Transactional
    public void update(Long id, DictValueUpdateService.Request request) {
        updateService.execute(id, request);
    }


    @Override
    @Transactional
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByDictKeyId(Long dictKeyId) {
        repository.deleteByDictKeyId(dictKeyId);
    }

    public List<DictValue> findByDictKey(String dictKey) {
        return repository.findByDictKeyId(dictKeyAppService.findByKey(dictKey).id());
    }



    @Override
    public List<DictValue> findAll() {
        return repository.findAll();
    }


    @Override
    public List<DictValue> findAll(DictValueQuery query) {
        return repository.findAll(query);
    }

    @Override
    public Page<DictValue> page(DictValueQuery query) {
        return repository.page(query);
    }

}