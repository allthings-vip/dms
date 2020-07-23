package allthings.iot.dms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import allthings.iot.common.dto.QueryResult;
import allthings.iot.common.dto.Result;
import allthings.iot.dms.dto.DeviceConnectionLogDto;
import allthings.iot.dms.service.DeviceConnectionLogServiceImpl;

/**
 * @author :  sylar
 * @FileName :  DeviceConnectionLogController
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
public class DeviceConnectionLogController {

    @Autowired
    DeviceConnectionLogServiceImpl deviceConnectionLogServiceImpl;

    @RequestMapping(value = "/getDeviceConnectionLogsByDeviceId", method = RequestMethod.GET)
    public Result<QueryResult<DeviceConnectionLogDto>> getDeviceConnectionLogsByDeviceId(String deviceId, long beginTime, long endTime, int pageIndex,
                                                                                         int pageSize) {
        return Result.newSuccess(deviceConnectionLogServiceImpl.getDeviceConnectionLogsByDeviceId(deviceId,
                beginTime, endTime, pageIndex, pageSize));
    }

}
