package edu.nwafu.paper.controller;


import edu.nwafu.paper.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/point")
public class pointController {

    @Autowired
    private PointService pointService;

    @GetMapping("/getPoint")
    public Object getPoint(String chapterId){
        Map<String,Object> map = new HashMap<>();
        map.put("data",pointService.getPoint(chapterId));
        return map;
    }
}
