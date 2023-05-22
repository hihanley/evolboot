package org.evolboot.im.domain.groupapply.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.evolboot.core.data.jpa.JpaAbstractEntity;
import org.evolboot.core.domain.AggregateRoot;
import org.evolboot.core.domain.IdGenerate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * 群申请
 *
 * @author evol
 * @date 2023-05-03 17:27:04
 */
@Table(name = "evol_im_group_apply")
@Getter
@Slf4j
@NoArgsConstructor
@Entity
public class GroupApply extends JpaAbstractEntity<Long> implements AggregateRoot<GroupApply> {

    @Id
    private Long id;

    /**
     * 申请的群
     */
    private Long groupId;

    /**
     * 申请用户
     */
    private Long applyUserId;

    /**
     * 申请原因
     */
    private String applyReason;

    /**
     * 状态
     */
    private GroupApplyStatus status;

    /**
     * 未处理到期时间
     */
    private Date expireAt;

    /**
     * 处理人
     */
    private Long handleUserId;

    /**
     * 处理时间
     */
    private Date handleAt;


    private void generateId() {
        this.id = IdGenerate.longId();
    }


    public GroupApply(String name) {
        //   setLocales(locales);
        generateId();
    }

    @Override
    public Long id() {
        return id;
    }

    @Override
    public GroupApply root() {
        return this;
    }
}