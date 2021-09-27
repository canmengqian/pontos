package com.zzz.pontons;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.junit.Test;

/**
 * @ClassName Oauth2Test
 * @Description TODO
 * @Author zhengzz
 * Date 2021/2/23
 * @Version 1.0.0
 */
public class Oauth2Test {
    @Test
    public void testOauth() {
        String clientId = "clientId";
        String clientSecret = "clientSecret";
        String accessTokenUrl = "responseCode";
        String redirectUrl = "http://localhost:8081/oauthclient01/server/callbackCode";
        String response_type = "code";
        OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
        String requestUrl = null;
        try {
            //构建oauthd的请求。设置请求服务地址（accessTokenUrl）、clientId、response_type、redirectUrl
            OAuthClientRequest accessTokenRequest = OAuthClientRequest
                    .authorizationLocation(accessTokenUrl)
                    .setResponseType(response_type)
                    .setClientId(clientId)
                    .setRedirectURI(redirectUrl)
                    .buildQueryMessage();
            requestUrl = accessTokenRequest.getLocationUri();
            System.out.println(requestUrl);
        } catch (OAuthSystemException e) {
            e.printStackTrace();

        }
    }
}
