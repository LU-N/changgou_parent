package com.changgou.oauth;

import org.junit.Test;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;

public class ParseJwtTest {
    /***
     * 校验令牌 */
    @Test
    public void testParseToken() {
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb2xlcyI6IlJPTEVfVklQLFJPTEVfVVNFUiIsIm5hbWUiOiJpdGhlaW1hIiwiaWQiOiIxIn0.H4Qd8dhIcT78X9g3hhqxaxobW8hXGcgValK7shBgHtLmVPdH_uFiCvUP1_qpEHTyWzhIPGBJis-XxI9-3c5fWt48iPn5DHty4fc2UbVUJOEW-y_tWKYL9yidQ2zoHQYnpJY2hCLWceMBCEzo0vIXBDbhyAgM-ixYOxSLKkHbI60yTV71ubE6p4_7FEdkB5z7w3e-glPai4GRU892Bx9wL-NJ-3WSzr3FiQGvSz4VscB0DIjYrCWm2Wf5R30n6qVbq7kk3m9m6x3QDVwBCtdYfreIXoG0VMMOAY_drklfiqbEyvU8fYCGxakwhqnyIg_CD33JlUBVqCC-hivRNAyp4w";
        String publickey = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvfSobsmqhDshLiR+5E/J9Sh8mxritvCUEKveytTlKnkblZdhWKXHMyN20ORBm/Jy/VzXH0dZNPo/jXYbhY7xMZanmAQXufZwXCc5Q0iY5rKwTd9ltHD7MRdiH1OEkEjrVrOU0F4yxoWFUqdau/mnRVo4EyRmn1CUbBLWkto1wCmYHYczFHdu2Exl8/9miimZgGD9p8pIvZ2z3pPpzRiGXlcvymLSy3HbYEtwQV2EIREwoJB1yr5fnH/VDdOYlZ0T/7RORUB16HgfU7GBEWEgN3eYEJzkTn9anR0x7tjTGX3RAd6Lquw3Eqx4yJSmSVQjZHlIgOde+bSS6rjF4FqA9wIDAQAB-----END PUBLIC KEY-----";
        Jwt jwt = JwtHelper.decodeAndVerify(token, new RsaVerifier(publickey));

        //获取Jwt原始内容
        String claims = jwt.getClaims();
        System.out.println(claims);
        //jwt令牌
        String encoded = jwt.getEncoded();
        System.out.println(encoded);
    }
}
