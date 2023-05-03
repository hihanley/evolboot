package org.evolboot.im.domain.friend;

import org.evolboot.core.data.Query;
import org.evolboot.core.data.Sort;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import org.evolboot.core.util.ExtendDateUtil;
import org.evolboot.core.util.ExtendObjects;

import java.util.Date;


/**
 * 好友关系
 *
 * @author evol
 * @date 2023-05-03 17:40:14
 */
@Setter
@Getter
public class FriendQuery extends Query {

    private Long id;

    private Date startDate;

    private Date endDate;

    @Builder
    public FriendQuery(Long id, Integer page, Integer limit, Date startDate, Date endDate) {
        super(page, limit);
        this.id = id;
        if (ExtendObjects.nonNull(startDate)) {
            this.startDate = ExtendDateUtil.beginOfDay(startDate);
        }
        if (ExtendObjects.nonNull(endDate)) {
            this.endDate = ExtendDateUtil.endOfDay(endDate);
        }
    }
}