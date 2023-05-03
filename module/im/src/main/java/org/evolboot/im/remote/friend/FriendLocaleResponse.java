package org.evolboot.im.remote.friend;

import org.evolboot.im.domain.friend.Friend;
import org.evolboot.im.domain.friend.FriendLocale;

import org.evolboot.core.data.Page;
import org.evolboot.core.data.PageImpl;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author evol
 * @date 2023-05-03 17:40:14
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FriendLocaleResponse {


    private Long id;

    public static FriendLocaleResponse of(Friend row) {
//        FriendLocale locale = row.findLocaleByCurrentLanguage(FriendLocale.class);

        return new FriendLocaleResponse();
    }


    /**
     * 分页
     *
     * @param page
     * @return
     */
    public static Page<FriendLocaleResponse> of(Page<Friend> page) {
        return PageImpl.<FriendLocaleResponse>builder()
                .page(page.getPage())
                .limit(page.getLimit())
                .totalSize(page.getTotalSize())
                .list(of(page.getList()))
                .build();
    }

    /**
     * 列表
     *
     * @param list
     * @return
     */
    public static List<FriendLocaleResponse> of(List<Friend> list) {
        return list.stream().map(FriendLocaleResponse::of).collect(Collectors.toList());
    }

}