package jsl.com.coins;

import jsl.com.coins.service.CoinsDataService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartUp implements ApplicationListener<ApplicationReadyEvent> {
    private final CoinsDataService coinsDataService;

    public ApplicationStartUp(CoinsDataService coinsDataService) {
        this.coinsDataService = coinsDataService;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
//        coinsDataService.fetchCoins();
//        coinsDataService.fetchCoinHistory();
    }
}
