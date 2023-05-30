package edu.neu.csye6200.controller;

import com.fasterxml.jackson.databind.JsonNode;
import edu.neu.csye6200.config.AccountFactory;
import edu.neu.csye6200.model.Transaction;
import edu.neu.csye6200.model.account.AccountAPI;
import edu.neu.csye6200.model.response.AccountResponse;
import edu.neu.csye6200.service.AccountService;
import edu.neu.csye6200.util.FileUtil;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

@Controller("/account")
public class AccountController {

    private AccountService accountService;

    private AccountFactory accountFactory;

    public AccountController (AccountService accountService, AccountFactory accountFactory) {
        this.accountService = accountService;
        this.accountFactory = accountFactory;
    }

    @Post(uri = "/add", consumes = MediaType.APPLICATION_JSON)
    public AccountResponse createAccount(@Body JsonNode account){
        return accountService.addAccount(accountFactory.getObject(account));
    }

    @Get(uri = "/get/{type}", consumes = MediaType.APPLICATION_JSON)
    public List<? extends AccountAPI> getAllAccount(String type) {
        return accountService.getAllAccounts(accountFactory.getType(type));

    }

    @Get(uri = "/getCustomerAccounts/{id}", consumes = MediaType.APPLICATION_JSON)
    public List<? extends AccountAPI> getCustomerAccounts(String id) {
        return accountService.getCustomerAccounts(id);

    }

    @Post(uri = "/addTransaction", consumes = MediaType.APPLICATION_JSON)
    public Transaction addTransaction(@Body Transaction transaction){
        return accountService.addTransaction(transaction);
    }

    @Get(value = "/getAccountStatement/{id}", consumes = {MediaType.MULTIPART_FORM_DATA})
    public HttpResponse<byte[]> downLoadFile(String id) throws IOException {

        accountService.generateStatement(id,id+"statement.csv");
        return HttpResponse.ok(Files.readAllBytes(new File(id+"statement.csv").toPath()))
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\""+id+"statement.csv\"");
    }

}
