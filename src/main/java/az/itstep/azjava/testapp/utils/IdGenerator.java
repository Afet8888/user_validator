package az.itstep.azjava.testapp.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class IdGenerator {

    private AtomicInteger idValue;

    public int getNextId() {
        return idValue.getAndIncrement();
    }

    @Autowired
    public void setIdValue(AtomicInteger idValue) {
        this.idValue = idValue;
    }
}
