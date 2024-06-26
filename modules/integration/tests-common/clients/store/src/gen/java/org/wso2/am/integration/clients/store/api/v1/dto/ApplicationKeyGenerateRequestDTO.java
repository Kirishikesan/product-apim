/*
 * WSO2 API Manager - Developer Portal
 * This document specifies a **RESTful API** for WSO2 **API Manager** - **Developer Portal**. Please see [full OpenAPI Specification](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.7.206/components/apimgt/org.wso2.carbon.apimgt.rest.api.store.v1/src/main/resources/devportal-api.yaml) of the API which is written using [OAS 3.0](http://swagger.io/) specification.  # Authentication The Developer Portal REST API is protected using OAuth2 and access control is achieved through scopes. Before you start invoking the API, you need to obtain an access token with the required scopes. This guide will walk you through the steps that you will need to follow to obtain an access token. First you need to obtain the consumer key/secret key pair by calling the dynamic client registration (DCR) endpoint. You can add your preferred grant types in the payload. A Sample payload is shown below. ```   {   \"callbackUrl\":\"www.google.lk\",   \"clientName\":\"rest_api_devportal\",   \"owner\":\"admin\",   \"grantType\":\"client_credentials password refresh_token\",   \"saasApp\":true   } ``` Create a file (payload.json) with the above sample payload, and use the cURL shown below to invoke the DCR endpoint. Authorization header of this should contain the base64 encoded admin username and password. **Format of the request** ```   curl -X POST -H \"Authorization: Basic Base64(admin_username:admin_password)\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://<host>:<servlet_port>/client-registration/v0.17/register ``` **Sample request** ```   curl -X POST -H \"Authorization: Basic YWRtaW46YWRtaW4=\" -H \"Content-Type: application/json\"   \\ -d @payload.json https://localhost:9443/client-registration/v0.17/register ``` Following is a sample response after invoking the above curl. ``` { \"clientId\": \"fOCi4vNJ59PpHucC2CAYfYuADdMa\", \"clientName\": \"rest_api_devportal\", \"callBackURL\": \"www.google.lk\", \"clientSecret\": \"a4FwHlq0iCIKVs2MPIIDnepZnYMa\", \"isSaasApplication\": true, \"appOwner\": \"admin\", \"jsonString\": \"{\\\"grant_types\\\":\\\"client_credentials password refresh_token\\\",\\\"redirect_uris\\\":\\\"www.google.lk\\\",\\\"client_name\\\":\\\"rest_api_devportal\\\"}\", \"jsonAppAttribute\": \"{}\", \"tokenType\": null } ``` Next you must use the above client id and secret to obtain the access token. We will be using the password grant type for this, you can use any grant type you desire. You also need to add the proper **scope** when getting the access token. All possible scopes for devportal REST API can be viewed in **OAuth2 Security** section of this document and scope for each resource is given in **authorization** section of resource documentation. Following is the format of the request if you are using the password grant type. ``` curl -k -d \"grant_type=password&username=<admin_username>&password=<admin_password>&scope=<scopes separated by space>\" \\ -H \"Authorization: Basic base64(cliet_id:client_secret)\" \\ https://<host>:<servlet_port>/oauth2/token ``` **Sample request** ``` curl https://localhost:9443/oauth2/token -k \\ -H \"Authorization: Basic Zk9DaTR2Tko1OVBwSHVjQzJDQVlmWXVBRGRNYTphNEZ3SGxxMGlDSUtWczJNUElJRG5lcFpuWU1h\" \\ -d \"grant_type=password&username=admin&password=admin&scope=apim:subscribe apim:api_key\" ``` Shown below is a sample response to the above request. ``` { \"access_token\": \"e79bda48-3406-3178-acce-f6e4dbdcbb12\", \"refresh_token\": \"a757795d-e69f-38b8-bd85-9aded677a97c\", \"scope\": \"apim:subscribe apim:api_key\", \"token_type\": \"Bearer\", \"expires_in\": 3600 } ``` Now you have a valid access token, which you can use to invoke an API. Navigate through the API descriptions to find the required API, obtain an access token as described above and invoke the API with the authentication header. If you use a different authentication mechanism, this process may change.  # Try out in Postman If you want to try-out the embedded postman collection with \"Run in Postman\" option, please follow the guidelines listed below. * All of the OAuth2 secured endpoints have been configured with an Authorization Bearer header with a parameterized access token. Before invoking any REST API resource make sure you run the `Register DCR Application` and `Generate Access Token` requests to fetch an access token with all required scopes. * Make sure you have an API Manager instance up and running. * Update the `basepath` parameter to match the hostname and port of the APIM instance.  [![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/5bc0161b8aa7e701d7bf) 
 *
 * The version of the OpenAPI document: v3
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.wso2.am.integration.clients.store.api.v1.dto;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonCreator;
/**
* ApplicationKeyGenerateRequestDTO
*/

public class ApplicationKeyGenerateRequestDTO {
            /**
* Gets or Sets keyType
*/
    @JsonAdapter(KeyTypeEnum.Adapter.class)
public enum KeyTypeEnum {
        PRODUCTION("PRODUCTION"),
        
        SANDBOX("SANDBOX");

private String value;

KeyTypeEnum(String value) {
this.value = value;
}

public String getValue() {
return value;
}

@Override
public String toString() {
return String.valueOf(value);
}

public static KeyTypeEnum fromValue(String value) {
    for (KeyTypeEnum b : KeyTypeEnum.values()) {
    if (b.name().equals(value)) {
        return b;
    }
}
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
}

    public static class Adapter extends TypeAdapter<KeyTypeEnum> {
    @Override
    public void write(final JsonWriter jsonWriter, final KeyTypeEnum enumeration) throws IOException {
    jsonWriter.value(enumeration.getValue());
    }

    @Override
    public KeyTypeEnum read(final JsonReader jsonReader) throws IOException {
    String value =  jsonReader.nextString();
    return KeyTypeEnum.fromValue(value);
    }
    }
}

        public static final String SERIALIZED_NAME_KEY_TYPE = "keyType";
        @SerializedName(SERIALIZED_NAME_KEY_TYPE)
            private KeyTypeEnum keyType;

        public static final String SERIALIZED_NAME_KEY_MANAGER = "keyManager";
        @SerializedName(SERIALIZED_NAME_KEY_MANAGER)
            private String keyManager;

        public static final String SERIALIZED_NAME_GRANT_TYPES_TO_BE_SUPPORTED = "grantTypesToBeSupported";
        @SerializedName(SERIALIZED_NAME_GRANT_TYPES_TO_BE_SUPPORTED)
            private List<String> grantTypesToBeSupported = new ArrayList<String>();

        public static final String SERIALIZED_NAME_CALLBACK_URL = "callbackUrl";
        @SerializedName(SERIALIZED_NAME_CALLBACK_URL)
            private String callbackUrl;

        public static final String SERIALIZED_NAME_SCOPES = "scopes";
        @SerializedName(SERIALIZED_NAME_SCOPES)
            private List<String> scopes = null;

        public static final String SERIALIZED_NAME_VALIDITY_TIME = "validityTime";
        @SerializedName(SERIALIZED_NAME_VALIDITY_TIME)
            private String validityTime;

        public static final String SERIALIZED_NAME_CLIENT_ID = "clientId";
        @SerializedName(SERIALIZED_NAME_CLIENT_ID)
            private String clientId;

        public static final String SERIALIZED_NAME_CLIENT_SECRET = "clientSecret";
        @SerializedName(SERIALIZED_NAME_CLIENT_SECRET)
            private String clientSecret;

        public static final String SERIALIZED_NAME_ADDITIONAL_PROPERTIES = "additionalProperties";
        @SerializedName(SERIALIZED_NAME_ADDITIONAL_PROPERTIES)
            private Object additionalProperties;


        public ApplicationKeyGenerateRequestDTO keyType(KeyTypeEnum keyType) {
        
        this.keyType = keyType;
        return this;
        }

    /**
        * Get keyType
    * @return keyType
    **/
      @ApiModelProperty(required = true, value = "")
    
    public KeyTypeEnum getKeyType() {
        return keyType;
    }


    public void setKeyType(KeyTypeEnum keyType) {
        this.keyType = keyType;
    }


        public ApplicationKeyGenerateRequestDTO keyManager(String keyManager) {
        
        this.keyManager = keyManager;
        return this;
        }

    /**
        * key Manager to Generate Keys
    * @return keyManager
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "Resident Key Manager", value = "key Manager to Generate Keys")
    
    public String getKeyManager() {
        return keyManager;
    }


    public void setKeyManager(String keyManager) {
        this.keyManager = keyManager;
    }


        public ApplicationKeyGenerateRequestDTO grantTypesToBeSupported(List<String> grantTypesToBeSupported) {
        
        this.grantTypesToBeSupported = grantTypesToBeSupported;
        return this;
        }

    /**
        * Grant types that should be supported by the application
    * @return grantTypesToBeSupported
    **/
      @ApiModelProperty(example = "[\"password\",\"client_credentials\"]", required = true, value = "Grant types that should be supported by the application")
    
    public List<String> getGrantTypesToBeSupported() {
        return grantTypesToBeSupported;
    }


    public void setGrantTypesToBeSupported(List<String> grantTypesToBeSupported) {
        this.grantTypesToBeSupported = grantTypesToBeSupported;
    }


        public ApplicationKeyGenerateRequestDTO callbackUrl(String callbackUrl) {
        
        this.callbackUrl = callbackUrl;
        return this;
        }

    /**
        * Callback URL
    * @return callbackUrl
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "http://sample.com/callback/url", value = "Callback URL")
    
    public String getCallbackUrl() {
        return callbackUrl;
    }


    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }


        public ApplicationKeyGenerateRequestDTO scopes(List<String> scopes) {
        
        this.scopes = scopes;
        return this;
        }

    /**
        * Allowed scopes for the access token
    * @return scopes
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "[\"am_application_scope\",\"default\"]", value = "Allowed scopes for the access token")
    
    public List<String> getScopes() {
        return scopes;
    }


    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }


        public ApplicationKeyGenerateRequestDTO validityTime(String validityTime) {
        
        this.validityTime = validityTime;
        return this;
        }

    /**
        * Get validityTime
    * @return validityTime
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "3600", value = "")
    
    public String getValidityTime() {
        return validityTime;
    }


    public void setValidityTime(String validityTime) {
        this.validityTime = validityTime;
    }


        public ApplicationKeyGenerateRequestDTO clientId(String clientId) {
        
        this.clientId = clientId;
        return this;
        }

    /**
        * Client ID for generating access token.
    * @return clientId
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "sZzoeSCI_vL2cjSXZQmsmV8JEyga", value = "Client ID for generating access token.")
    
    public String getClientId() {
        return clientId;
    }


    public void setClientId(String clientId) {
        this.clientId = clientId;
    }


        public ApplicationKeyGenerateRequestDTO clientSecret(String clientSecret) {
        
        this.clientSecret = clientSecret;
        return this;
        }

    /**
        * Client secret for generating access token. This is given together with the client Id.
    * @return clientSecret
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "nrs3YAP4htxnz_DqpvGhf9Um04oa", value = "Client secret for generating access token. This is given together with the client Id.")
    
    public String getClientSecret() {
        return clientSecret;
    }


    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }


        public ApplicationKeyGenerateRequestDTO additionalProperties(Object additionalProperties) {
        
        this.additionalProperties = additionalProperties;
        return this;
        }

    /**
        * Additional properties needed.
    * @return additionalProperties
    **/
        @javax.annotation.Nullable
      @ApiModelProperty(example = "{}", value = "Additional properties needed.")
    
    public Object getAdditionalProperties() {
        return additionalProperties;
    }


    public void setAdditionalProperties(Object additionalProperties) {
        this.additionalProperties = additionalProperties;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
        return true;
        }
        if (o == null || getClass() != o.getClass()) {
        return false;
        }
            ApplicationKeyGenerateRequestDTO applicationKeyGenerateRequest = (ApplicationKeyGenerateRequestDTO) o;
            return Objects.equals(this.keyType, applicationKeyGenerateRequest.keyType) &&
            Objects.equals(this.keyManager, applicationKeyGenerateRequest.keyManager) &&
            Objects.equals(this.grantTypesToBeSupported, applicationKeyGenerateRequest.grantTypesToBeSupported) &&
            Objects.equals(this.callbackUrl, applicationKeyGenerateRequest.callbackUrl) &&
            Objects.equals(this.scopes, applicationKeyGenerateRequest.scopes) &&
            Objects.equals(this.validityTime, applicationKeyGenerateRequest.validityTime) &&
            Objects.equals(this.clientId, applicationKeyGenerateRequest.clientId) &&
            Objects.equals(this.clientSecret, applicationKeyGenerateRequest.clientSecret) &&
            Objects.equals(this.additionalProperties, applicationKeyGenerateRequest.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyType, keyManager, grantTypesToBeSupported, callbackUrl, scopes, validityTime, clientId, clientSecret, additionalProperties);
    }


@Override
public String toString() {
StringBuilder sb = new StringBuilder();
sb.append("class ApplicationKeyGenerateRequestDTO {\n");
    sb.append("    keyType: ").append(toIndentedString(keyType)).append("\n");
    sb.append("    keyManager: ").append(toIndentedString(keyManager)).append("\n");
    sb.append("    grantTypesToBeSupported: ").append(toIndentedString(grantTypesToBeSupported)).append("\n");
    sb.append("    callbackUrl: ").append(toIndentedString(callbackUrl)).append("\n");
    sb.append("    scopes: ").append(toIndentedString(scopes)).append("\n");
    sb.append("    validityTime: ").append(toIndentedString(validityTime)).append("\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    clientSecret: ").append(toIndentedString(clientSecret)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
sb.append("}");
return sb.toString();
}

/**
* Convert the given object to string with each line indented by 4 spaces
* (except the first line).
*/
private String toIndentedString(Object o) {
if (o == null) {
return "null";
}
return o.toString().replace("\n", "\n    ");
}

}

