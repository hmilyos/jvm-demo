package com.hmily.jvmdemo.controller;

import com.hmily.jvmdemo.dto.Metaspace;
import com.hmily.jvmdemo.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName MenoryController
 * @Description 内存溢出
 * @Author ouShiMing
 * @Date 2020/4/6 14:34
 **/
@RestController
@RequestMapping("/memory")
public class MemoryController {

    private List<UserDto> users = new ArrayList<UserDto>();
    /**
     * -Xmx32M -Xms32M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./
     */
    @GetMapping("/heap")
    public String heap(){
        int i = 0;
        while (true){
            users.add(UserDto.builder().id(i++)
                    .name(UUID.randomUUID().toString()).build());
        }
    }

    private List<Class<?>> classs = new ArrayList<Class<?>>();
    /**
     * -XX:MetaspaceSize=32M -XX:MaxMetaspaceSize=32M
     */
    @GetMapping("/nonHeap")
    public String nonHeap(){
        while (true){
            classs.addAll(Metaspace.createClasses());
        }
    }
}
