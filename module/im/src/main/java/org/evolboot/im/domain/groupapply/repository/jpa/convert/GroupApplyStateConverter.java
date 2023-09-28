package org.evolboot.im.domain.groupapply.repository.jpa.convert;


import org.evolboot.im.domain.groupapply.entity.GroupApplyState;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author evol
 */
@Converter(autoApply = true)
public class GroupApplyStateConverter implements AttributeConverter<GroupApplyState, Integer> {

    @Override
    public Integer convertToDatabaseColumn(GroupApplyState GroupApplyState) {
        return GroupApplyState.getValue();
    }

    @Override
    public GroupApplyState convertToEntityAttribute(Integer value) {
        return GroupApplyState.convertTo(value);
    }

}