package org.evolboot.im.domain.conversation;

import org.evolboot.core.data.Page;
import org.springframework.transaction.annotation.Transactional;
import org.evolboot.im.domain.conversation.service.ConversationCreateFactory;
import org.evolboot.im.domain.conversation.service.ConversationUpdateService;

import java.util.List;

/**
 * 会话
 *
 * @author evol
 * @date 2023-05-02 21:43:03
 */
public interface ConversationAppService {

    Conversation findById(Long id);

    Conversation create(ConversationCreateFactory.Request request);

    Conversation addPeople(Long id, int quantityOfPeople);
    Conversation reductionPeople(Long id, int quantityOfPeople);

    void update(Long id, ConversationUpdateService.Request request);

    void delete(Long id);

    List<Conversation> findAll();

    List<Conversation> findAll(ConversationQuery query);

    Page<Conversation> page(ConversationQuery query);


}