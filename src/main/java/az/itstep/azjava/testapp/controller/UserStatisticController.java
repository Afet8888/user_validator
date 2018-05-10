package az.itstep.azjava.testapp.controller;

import az.itstep.azjava.testapp.service.UserStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/statistics")
public class UserStatisticController {

    UserStatisticService userStatisticService;

    @GetMapping("/mid")
    public Integer midLength(){
        return userStatisticService.midLength();
    }

    @GetMapping("/percent")
    public double percentOfFirstnameNulls() {
        return userStatisticService.percentOfFirstnameNulls();
    }

    @Autowired
    public void setUserStatisticService(UserStatisticService userStatisticService) {
        this.userStatisticService = userStatisticService;
    }
}
