package allthings.iot.dms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import allthings.iot.common.dto.QueryResult;
import allthings.iot.common.dto.Result;
import allthings.iot.dms.dto.DeviceAlarmDto;
import allthings.iot.dms.service.DeviceAlarmServiceImpl;

import java.util.Arrays;

/**
 * @author :  sylar
 * @FileName :  DeviceAlarmController
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
public class DeviceAlarmController {

    @Autowired
    DeviceAlarmServiceImpl deviceAlarmServiceImpl;

    @RequestMapping(value = "/countOfDeviceAlarm", method = RequestMethod.GET)
    public Result<Long> countOfDeviceAlarm(long beginTime, long endTime) {
        return Result.newSuccess(deviceAlarmServiceImpl.countOfDeviceAlarm(beginTime, endTime));
    }

    @RequestMapping(value = "/countOfDeviceAlarmByDeviceType", method = RequestMethod.GET)
    public Result<Long> countOfDeviceAlarmByDeviceType(String deviceType, long beginTime, long endTime) {
        return Result.newSuccess(deviceAlarmServiceImpl.countOfDeviceAlarmByDeviceType(deviceType, beginTime, endTime));
    }

    @RequestMapping(value = "/countOfDeviceAlarmByDeviceId", method = RequestMethod.GET)
    public Result<Long> countOfDeviceAlarmByDeviceId(String deviceId, long beginTime, long endTime) {
        return Result.newSuccess(deviceAlarmServiceImpl.countOfDeviceAlarmByDeviceId(deviceId, beginTime, endTime));
    }

    @RequestMapping(value = "/getDeviceAlarmsByDeviceId", method = RequestMethod.GET)
    public Result<QueryResult<DeviceAlarmDto>> getDeviceAlarmsByDeviceId(String deviceId, String[] alarmCodes, long beginTime, long endTime,
                                                                         int pageIndex, int pageSize) {
        return  Result.newSuccess(deviceAlarmServiceImpl.getDeviceAlarmsByDeviceId(deviceId, Arrays.asList(alarmCodes)
                , beginTime, endTime, pageIndex, pageSize));
    }

}
