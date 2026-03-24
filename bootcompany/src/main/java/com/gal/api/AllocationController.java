package com.gal.api;

import com.gal.model.AllocationData;
import com.gal.model.CabAllocation;
import com.gal.service.AllocationServiceImp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/allocation")
public class AllocationController {

    private static final Logger log = LoggerFactory.getLogger(AllocationController.class);

    @Autowired
    private AllocationServiceImp allocationService;
    @PostMapping(
            path = "/allocate",
            produces = "application/json",
            consumes = "application/json"
    )
    public List<CabAllocation> allocate(@RequestBody AllocationData allocationData) {

        log.info("Request received: {}", allocationData);
        return allocationService.allocate(allocationData);
    }
    @GetMapping("/cab/{cabId}/date/{date}")
    public List<CabAllocation> getByCabAndDate(
            @PathVariable int cabId,
            @PathVariable String date) {

        Date sqlDate = Date.valueOf(date);

        return allocationService.getByCabAndDate(cabId, sqlDate);
    }
}