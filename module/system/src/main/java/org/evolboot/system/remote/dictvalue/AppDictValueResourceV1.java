package org.evolboot.system.remote.dictvalue;

import org.evolboot.core.annotation.ApiClient;
import org.evolboot.core.annotation.OperationLog;
import org.evolboot.core.remote.DomainId;
import org.evolboot.core.remote.ResponseModel;
import org.evolboot.system.domain.dictvalue.DictValue;
import org.evolboot.system.domain.dictvalue.DictValueAppService;
import org.evolboot.system.domain.dictvalue.DefaultDictValueAppService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.evolboot.core.data.Page;
import org.evolboot.system.domain.dictvalue.DictValueQuery;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * 字典Value
 *
 * @author evol
 * @date 2023-05-07 12:55:06
 */
@Slf4j
@RestController
@RequestMapping("/v1/api/system/dict-value")
@Tag(name = "字典Value", description = "字典Value")
@ApiClient
public class AppDictValueResourceV1 {

    private final DictValueAppService service;

    public AppDictValueResourceV1(DictValueAppService service) {
        this.service = service;
    }

    @Operation(summary = "根据Key查询字典Value")
    @GetMapping("/{dictKey}")
    public ResponseModel<List<DictValueAppResponse>> findByDictKey(
            @PathVariable("dictKey") String dictKey
    ) {

        return ResponseModel.ok(DictValueAppResponse.of(service.findByDictKey(dictKey)));
    }

    /*

    @Operation(summary = "查询字典Value")
    @GetMapping("")
    public ResponseModel<List<DictValueLocaleResponse>> findAll(
    ) {
        List<DictValue> result = service.findAll();
        return ResponseModel.ok(DictValueLocaleResponse.of(result));
    }

    @Operation(summary = "查询字典Value")
    @GetMapping("")
    public ResponseModel<Page<DictValueLocaleResponse>> page(
       @RequestParam(name = "page", defaultValue = "1") Integer page,
       @RequestParam(name = "limit", defaultValue = "20") Integer limit
    ) {
       DictValueQuery query = DictValueQuery
                .builder()
                .page(page)
                .limit(limit)
                .build();
        Page<DictValue> result = service.page(query);
        return ResponseModel.ok(DictValueLocaleResponse.of(result));
    }

    */

}