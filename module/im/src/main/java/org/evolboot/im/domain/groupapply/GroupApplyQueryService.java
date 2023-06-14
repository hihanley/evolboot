package org.evolboot.im.domain.groupapply;

import org.evolboot.core.data.Page;
import org.evolboot.im.domain.groupapply.entity.GroupApply;
import org.evolboot.im.domain.groupapply.service.GroupApplyQuery;

import java.util.Optional;
import java.util.List;

/**
 * 查询服务 群申请
 *
 * @author evol
 * @date 2023-06-14 20:04:27
 */
public interface GroupApplyQueryService {

    GroupApply findById(Long id);

    List<GroupApply> findAll();

    List<GroupApply> findAll(GroupApplyQuery query);

    Page<GroupApply> page(GroupApplyQuery query);


    /**
     * 根据条件查询单个
     *
     * @param query
     * @return
     */
    Optional<GroupApply> findOne(GroupApplyQuery query);


}
