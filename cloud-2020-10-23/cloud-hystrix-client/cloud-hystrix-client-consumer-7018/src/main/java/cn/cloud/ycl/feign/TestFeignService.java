package cn.cloud.ycl.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "cloud-hystrix-client-producer-7017",
        fallback = TestFeignFallbackService.class)
public interface TestFeignService {

    @RequestMapping("/ok/{id}")
    String ok(@PathVariable(value = "id") Integer id);

    @RequestMapping("/timeout/{id}")
    String timeout(@PathVariable(value = "id") Integer id);

    @RequestMapping("/error/{id}")
    String error(@PathVariable(value = "id") Integer id);

    @RequestMapping("/circuitBreaker/{id}")
    String circuitBreaker(@PathVariable(value = "id") Integer id);

}
