package org.evolboot.configuration;


import org.evolboot.core.i18n.MessageHolder;

/**
 * @author evol
 *
 */
public abstract class ConfigurationI18nMessage {

    public static final String NAMESPACE = "configuration";

    public static final String NOT_FOUND = NAMESPACE + ".notFound";

    public static String notFound() {
        return MessageHolder.message(NOT_FOUND, "NOT_FOUND");
    }


}
