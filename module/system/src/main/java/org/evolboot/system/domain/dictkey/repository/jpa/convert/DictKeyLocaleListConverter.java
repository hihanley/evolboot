package org.evolboot.system.domain.dictkey.repository.jpa.convert;

import org.evolboot.system.domain.dictkey.DictKeyLocale;
import org.evolboot.core.util.ExtendObjects;
import org.evolboot.core.util.JsonUtil;
import com.google.common.collect.Lists;
import org.springframework.util.StringUtils;

import javax.persistence.AttributeConverter;
import java.util.List;

/**
 * @author evol
 * @date 2023-05-07 12:29:33
 */
public class DictKeyLocaleListConverter implements AttributeConverter<List<DictKeyLocale>, String> {

    @Override
    public String convertToDatabaseColumn(List<DictKeyLocale> attribute) {
        return ExtendObjects.isNull(attribute) ? null : JsonUtil.stringify(attribute);
    }

    @Override
    public List<DictKeyLocale> convertToEntityAttribute(String dbData) {
        return StringUtils.isEmpty(dbData) ? Lists.newArrayList() : JsonUtil.parse(dbData, List.class, DictKeyLocale.class);
    }
}