package allthings.iot.dms.controller;

import allthings.iot.dms.service.DasConnectionLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import allthings.iot.common.dto.QueryResult;
import allthings.iot.common.dto.Result;
import allthings.iot.dms.dto.DasConnectionLogDto;

/**
 * @author :  sylar
 * @FileName :  DasConnectionLogController
 * @CreateDate :  2017/11/08
 * @Description :
 * @ReviewedBy :
 * @ReviewedOn :
 * @VersionHistory :
 * @ModifiedBy :
 * @ModifiedDate :
 * @Comments :
 * @CopyRight : COPYRIGHT(c) iot.tf56.com All Rights Reserved
 * *******************************************************************************************
 */
@RestController
@RequestMapping("/deviceManagerService/dms")
public class DasConnectionLogController {

    @Autowired
    DasConnectionLogServiceImpl dasConnectionLogServiceImpl;

    @RequestMapping(value = "/getDasConnectionLogsByNodeId", method = RequestMethod.GET)
    public Result<QueryResult<DasConnectionLogDto>> getDasConnectionLogsByNodeId(String nodeId, long beginTime, long endTime, int pageIndex, int
            pageSize) {
        return Result.newSuccess(dasConnectionLogServiceImpl.getDasConnectionLogsByNodeId(nodeId, beginTime, endTime,
                pageIndex, pageSize));
    }
}
