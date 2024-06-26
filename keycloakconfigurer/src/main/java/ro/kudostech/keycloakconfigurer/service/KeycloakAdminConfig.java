package ro.kudostech.keycloakconfigurer.service;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakAdminConfig {

  @Value("${keycloak.base-url}")
  public String keycloakBaseUrl;

  @Value("${keycloak.admin-user}")
  public String keycloakAdminUser;

  @Value("${keycloak.admin-password}")
  public String keycloakAdminPassword;

  @Bean
  public Keycloak keycloakAdmin() {
    return KeycloakBuilder.builder()
        .serverUrl(keycloakBaseUrl)
        .realm("master")
        .username(keycloakAdminUser)
        .password(keycloakAdminPassword)
        .clientId("admin-cli")
        .build();
  }
}
