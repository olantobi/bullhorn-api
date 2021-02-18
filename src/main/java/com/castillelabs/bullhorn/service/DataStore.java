package com.castillelabs.bullhorn.service;

import com.castillelabs.bullhorn.model.AuthParam;
import lombok.Getter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Getter
public class DataStore {
    private final Map<String, AuthParam> mapStore = new ConcurrentHashMap<>();
}
