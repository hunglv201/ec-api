package com.vn.ec;

import com.vn.ec.common.Constants;
import com.vn.ec.utlis.EncryptAndDecrypt;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

public class EncryptTest {

    @SneakyThrows
    @Test
    void t() {
        var pass = "12345";
        var passNew = EncryptAndDecrypt.encrypt(pass.getBytes(StandardCharsets.UTF_8), Constants.PASSWORD_AIR_WATER_DE);
        System.out.println(passNew);

        var password = EncryptAndDecrypt.decrypt(passNew, Constants.PASSWORD_AIR_WATER_DE);
        System.out.println(password);
    }
}
