package org.evolboot.storage;

import org.evolboot.core.i18n.MessageHolder;

/**
 * @author evol
 */
public abstract class StorageI18nMessage {

    public static final String NAMESPACE = "storage";

    public static final String MAX_FILE_SIZE_ERROR = NAMESPACE + ".maxFileSizeError";
    public static final String IMAGE_MAX_FILE_SIZE_ERROR = NAMESPACE + ".imageMaxFileSizeError";
    public static final String CONTENT_TYPE_INTERCEPT_ERROR = NAMESPACE + ".contentTypeInterceptError";

    public static final String maxFileSizeError(String maxFileSize) {
        return MessageHolder.message(MAX_FILE_SIZE_ERROR, "", maxFileSize);
    }

    public static final String imageMaxFileSizeError(String maxFileSize) {
        return MessageHolder.message(IMAGE_MAX_FILE_SIZE_ERROR, "", maxFileSize);
    }

    public static final String contentTypeInterceptError(String filename) {
        return MessageHolder.message(CONTENT_TYPE_INTERCEPT_ERROR, "", filename);
    }

}
