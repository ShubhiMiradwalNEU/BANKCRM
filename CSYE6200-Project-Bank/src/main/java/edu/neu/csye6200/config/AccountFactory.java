package edu.neu.csye6200.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.neu.csye6200.model.account.AccountAPI;
import edu.neu.csye6200.model.account.CheckingsAccount;
import edu.neu.csye6200.model.account.SavingsAccount;
import io.micronaut.context.annotation.Factory;
import org.jetbrains.annotations.NotNull;

@Factory
public class AccountFactory {

    public AccountAPI getObject(JsonNode account){
        String type = account.get("type").asText("x");
        System.out.println(type);
        ObjectMapper mapper = new ObjectMapper();
        return switch (type) {
            case "Checkings" -> mapper.convertValue(account, CheckingsAccount.class);
            case "Savings" -> mapper.convertValue(account, SavingsAccount.class);
            default -> null;
        };
    }

    public Class<? extends AccountAPI> getType(String type) {
        return switch(type) {
            case "Checkings" -> CheckingsAccount.class;
            case "Savings" -> SavingsAccount.class;
            default -> null;
        };
    }
}
