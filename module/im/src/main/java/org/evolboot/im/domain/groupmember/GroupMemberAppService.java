package org.evolboot.im.domain.groupmember;

import org.evolboot.core.data.Page;
import org.evolboot.im.domain.groupmember.entity.GroupMember;
import org.evolboot.im.domain.groupmember.service.GroupMemberCreateFactory;
import org.evolboot.im.domain.groupmember.service.GroupMemberQuery;
import org.evolboot.im.domain.groupmember.service.GroupMemberUpdateService;

import java.util.List;
import java.util.Optional;

/**
 * 群成员
 *
 * @author evol
 * @date 2023-05-03 16:20:09
 */
public interface GroupMemberAppService {



    GroupMember create(GroupMemberCreateFactory.Request request);

    /**
     * 禁言
     */


    /**
     * 解禁
     */

    /**
     * 踢除
     */


    void update(GroupMemberUpdateService.Request request);

    void delete(Long id);



}
