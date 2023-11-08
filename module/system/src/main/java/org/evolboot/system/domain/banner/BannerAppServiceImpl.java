package org.evolboot.system.domain.banner;

import lombok.extern.slf4j.Slf4j;
import org.evolboot.core.data.Page;
import org.evolboot.system.domain.banner.entity.Banner;
import org.evolboot.system.domain.banner.repository.BannerRepository;
import org.evolboot.system.domain.banner.service.BannerCreateFactory;
import org.evolboot.system.domain.banner.service.BannerQuery;
import org.evolboot.system.domain.banner.service.BannerSupportService;
import org.evolboot.system.domain.banner.service.BannerUpdateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * banner
 *
 * @author evol
 */
@Slf4j
@Service
public class BannerAppServiceImpl implements BannerAppService {


    private final BannerCreateFactory factory;
    private final BannerUpdateService updateService;

    private final BannerRepository repository;

    private final BannerSupportService supportService;

    protected BannerAppServiceImpl(BannerRepository repository, BannerCreateFactory factory, BannerUpdateService updateService, BannerSupportService supportService) {
        this.factory = factory;
        this.updateService = updateService;
        this.repository = repository;
        this.supportService = supportService;
    }

    @Override
    public Banner findById(Long id) {
        return supportService.findById(id);
    }

    @Override
    @Transactional
    public Banner create(BannerCreateFactory.Request request) {
        return factory.execute(request);
    }


    @Override
    @Transactional
    public void update(BannerUpdateService.Request request) {
        updateService.execute(request);
    }


    @Override
    @Transactional
    public void delete(Long id) {
        supportService.findById(id);
        repository.deleteById(id);
    }


    @Override
    public List<Banner> findAll() {
        return repository.findAll();
    }


    @Override
    public List<Banner> findAll(BannerQuery query) {
        return repository.findAll(query);
    }

    @Override
    public Page<Banner> page(BannerQuery query) {
        return repository.page(query);
    }


    @Override
    public Optional<Banner> findOne(BannerQuery query) {
        return repository.findOne(query);
    }

}
