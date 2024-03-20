package project.agung.examplelearn.global.security;

import com.nimbusds.jose.JWSAlgorithm;

import com.nimbusds.jose.jwk.OctetSequenceKey;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.crypto.SecretKey;
import java.time.Duration;

@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "app.jwt")
public class AppJwtProperties {


    private SecretKey key;

    private String issuer;

    private JWSAlgorithm algorithm;

    private Duration expiresIn;

    public void setAlgorithm(String algorithm) {
        this.algorithm = JWSAlgorithm.parse(algorithm);
    }

    public void setKey(String key) {
        var jwk = new OctetSequenceKey.Builder(key.getBytes())
                .algorithm(algorithm)
                .build();
        this.key = jwk.toSecretKey();
    }
}
