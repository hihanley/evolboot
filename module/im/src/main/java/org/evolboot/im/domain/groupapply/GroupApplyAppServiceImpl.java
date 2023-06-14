package org.evolboot.im.domain.groupapply;

import lombok.extern.slf4j.Slf4j;
import org.evolboot.core.data.Page;
import org.evolboot.im.domain.groupapply.entity.GroupApply;
import org.evolboot.im.domain.groupapply.repository.GroupApplyRepository;
import org.evolboot.im.domain.groupapply.service.GroupApplyCreateFactory;
import org.evolboot.im.domain.groupapply.service.GroupApplyQuery;
import org.evolboot.im.domain.groupapply.service.GroupApplySupportService;
import org.evolboot.im.domain.groupapply.service.GroupApplyUpdateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 群申请
 *
 * @author evol
 * @date 2023-05-03 17:27:04
 */
@Slf4j
@Service
public class GroupApplyAppServiceImpl extends GroupApplySupportService implements GroupApplyAppService {


    private final GroupApplyCreateFactory factory;
    private final GroupApplyUpdateService updateService;

    protected GroupApplyAppServiceImpl(GroupApplyRepository repository, GroupApplyCreateFactory factory, GroupApplyUpdateService updateService) {
        super(repository);
        this.factory = factory;
        this.updateService = updateService;
    }

    @Override
    @Transactional
    public GroupApply create(GroupApplyCreateFactory.Request request) {
        return factory.execute(request);
    }


    @Override
    @Transactional
    public void update(GroupApplyUpdateService.Request request) {
        updateService.execute(request);
    }


    @Override
    @Transactional
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }


}
