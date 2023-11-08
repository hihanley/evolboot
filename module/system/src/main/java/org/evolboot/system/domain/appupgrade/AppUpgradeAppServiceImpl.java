package org.evolboot.system.domain.appupgrade;

import lombok.extern.slf4j.Slf4j;
import org.evolboot.core.data.Page;
import org.evolboot.system.domain.appupgrade.entity.AppUpgrade;
import org.evolboot.system.domain.appupgrade.entity.ClientType;
import org.evolboot.system.domain.appupgrade.repository.AppUpgradeRepository;
import org.evolboot.system.domain.appupgrade.service.AppUpgradeCreateFactory;
import org.evolboot.system.domain.appupgrade.service.AppUpgradeQuery;
import org.evolboot.system.domain.appupgrade.service.AppUpgradeSupportService;
import org.evolboot.system.domain.appupgrade.service.AppUpgradeUpdateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * APP更新
 *
 * @author evol
 */
@Slf4j
@Service
public class AppUpgradeAppServiceImpl  implements AppUpgradeAppService {


    private final AppUpgradeCreateFactory factory;
    private final AppUpgradeUpdateService updateService;

    private final AppUpgradeRepository repository;

    private final AppUpgradeSupportService supportService;

    protected AppUpgradeAppServiceImpl(AppUpgradeRepository repository, AppUpgradeCreateFactory factory, AppUpgradeUpdateService updateService, AppUpgradeSupportService supportService) {
        this.factory = factory;
        this.updateService = updateService;
        this.repository = repository;
        this.supportService = supportService;
    }

    @Override
    public AppUpgrade findById(Long id) {
        return supportService.findById(id);
    }

    @Override
    @Transactional
    public AppUpgrade create(AppUpgradeCreateFactory.Request request) {
        return factory.execute(request);
    }


    @Override
    @Transactional
    public void update(AppUpgradeUpdateService.Request request) {
        updateService.execute(request);
    }


    @Override
    @Transactional
    public void delete(Long id) {
        supportService.findById(id);
        repository.deleteById(id);
    }


    @Override
    public List<AppUpgrade> findAll() {
        return repository.findAll();
    }


    @Override
    public List<AppUpgrade> findAll(AppUpgradeQuery query) {
        return repository.findAll(query);
    }

    @Override
    public Page<AppUpgrade> page(AppUpgradeQuery query) {
        return repository.page(query);
    }



    @Override
    public AppUpgrade check(ClientType clientType) {
        return repository.findFirstByClientTypeOrderByAppVersionDesc(clientType);
    }


    @Override
    public Optional<AppUpgrade> findOne(AppUpgradeQuery query) {
        return repository.findOne(query);
    }

}
