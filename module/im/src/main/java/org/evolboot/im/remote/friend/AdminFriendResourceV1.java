package org.evolboot.im.remote.friend;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.evolboot.core.annotation.AdminClient;
import org.evolboot.core.data.Page;
import org.evolboot.core.remote.ResponseModel;
import org.evolboot.im.domain.friend.FriendQueryService;
import org.evolboot.im.domain.friend.entity.Friend;
import org.evolboot.im.domain.friend.FriendAppService;
import org.evolboot.im.domain.friend.service.FriendQuery;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static org.evolboot.im.ImAccessAuthorities.Friend.HAS_PAGE;
import static org.evolboot.im.ImAccessAuthorities.Friend.HAS_SINGLE;
import static org.evolboot.security.api.access.AccessAuthorities.HAS_ROLE_ADMIN;
import static org.evolboot.security.api.access.AccessAuthorities.or;

/**
 * 好友关系
 *
 * @author evol
 * @date 2023-05-03 17:40:14
 */
@Slf4j
@RestController
@RequestMapping("/v1/admin/im/friend")
@Tag(name = "好友关系", description = "好友关系")
@AdminClient
public class AdminFriendResourceV1 {

    private final FriendAppService service;
    private final FriendQueryService queryService;

    public AdminFriendResourceV1(FriendAppService service, FriendQueryService queryService) {
        this.service = service;
        this.queryService = queryService;
    }

//
//    @Operation(summary = "创建好友关系")
//    @OperationLog("创建好友关系")
//    @PostMapping("")
//    @PreAuthorize(HAS_ROLE_ADMIN + or + HAS_CREATE)
//    public ResponseModel<?> create(
//            @RequestBody @Valid
//                    FriendCreateRequest request
//    ) {
//        Friend friend = service.create(request);
//        return ResponseModel.ok(new DomainId(friend.id()));
//    }
//
//
//    @Operation(summary = "删除好友关系")
//    @OperationLog("删除好友关系")
//    @DeleteMapping("/{id}")
//    @PreAuthorize(HAS_ROLE_ADMIN + or + HAS_DELETE)
//    public ResponseModel<?> delete(
//            @PathVariable("id") Long id
//    ) {
//        service.delete(id);
//        return ResponseModel.ok();
//    }
//
//
//    @Operation(summary = "修改好友关系")
//    @OperationLog("修改好友关系")
//    @PutMapping
//    @PreAuthorize(HAS_ROLE_ADMIN + or + HAS_UPDATE)
//    public ResponseModel<?> update(
//            @RequestBody @Valid
//                    FriendUpdateRequest request
//    ) {
//        service.update(request);
//        return ResponseModel.ok();
//    }

    @Operation(summary = "查询好友关系")
    @GetMapping("")
    @PreAuthorize(HAS_ROLE_ADMIN + or + HAS_PAGE)
    public ResponseModel<Page<Friend>> page(
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "limit", defaultValue = "20") Integer limit,
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) Date startDate,
            @RequestParam(required = false) Date endDate
    ) {
        FriendQuery query = FriendQuery
                .builder()
                .id(id)
                .endDate(endDate)
                .page(page)
                .limit(limit)
                .build();
        Page<Friend> response = queryService.page(query);
        return ResponseModel.ok(response);
    }


    @Operation(summary = "查询单个好友关系")
    @GetMapping("/{id}")
    @PreAuthorize(HAS_ROLE_ADMIN + or + HAS_SINGLE)
    public ResponseModel<Friend> get(
            @PathVariable("id") Long id
    ) {
        return ResponseModel.ok(queryService.findById(id));
    }

}
