package com.openlearnhub.ptit.config;

import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.*;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.authorization.ResourcePermissionRepresentation;
import org.keycloak.representations.idm.authorization.ResourceRepresentation;
import org.keycloak.representations.idm.authorization.RolePolicyRepresentation;
import org.keycloak.representations.idm.authorization.ScopeRepresentation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class KeycloakAdminClientExample {

    private final Keycloak keycloak;

    public void create() {
        // Configure Keycloak client

        // Access the realm
//        RealmResource realmResource = keycloak.realm("OpenLearnHub");
//        ClientsResource clientsResource = realmResource.clients();
//        System.out.println(clientsResource.toString());
//        List<ClientRepresentation> clientRepresentations = clientsResource.findByClientId("open-learn-hub");
//        ClientResource clientResource = clientsResource.get(clientRepresentations.get(0).getId());
//
//        // Create a resource
//        ResourceRepresentation resource = new ResourceRepresentation();
//        resource.setName("Example Resource");
//        resource.setType("http://example.com/resource");
//
//        // Create a scope
//        ScopeRepresentation scope = new ScopeRepresentation();
//        scope.setName("example-scope");
//
//        // Create a role-based policy
//        RolePolicyRepresentation policy = new RolePolicyRepresentation();
//        policy.setName("Example Policy Role");
//        policy.addRole("role-name"); // Ensure the role-name is correctly specified
//
//        // Create a permission
//        ResourcePermissionRepresentation permission = new ResourcePermissionRepresentation();
//        permission.setName("Example Permission");
//        permission.addResource(resource.getName());
//        permission.addPolicy(policy.getName());
//
//        // Obtain authorization resource and create the items
//        AuthorizationResource authorization = clientResource.authorization();
//        authorization.resources().create(resource);
//        authorization.scopes().create(scope);
//        authorization.policies().role().create(policy);
//        authorization.permissions().resource().create(permission);
//
//        System.out.println("Resource, scope, policy, and permission have been created.");

        RealmResource realmResource = keycloak.realm("OpenLearnHub");
        ClientsResource clientsResource = realmResource.clients();
        System.out.println(clientsResource.toString());
        List<ClientRepresentation> clientRepresentations = clientsResource.findByClientId("open-learn-hub");
        ClientResource clientResource = clientsResource.get(clientRepresentations.get(0).getId());

        // Create a new role
        RolesResource rolesResource = realmResource.roles();
        RoleRepresentation newRole = new RoleRepresentation();
        newRole.setName("new-role");
        rolesResource.create(newRole);

        // Create a resource
        ResourceRepresentation resource = new ResourceRepresentation();
        resource.setName("My resource");
        resource.setType("http://example.com/resource");

        // Create a scope
        ScopeRepresentation scope = new ScopeRepresentation();
        scope.setName("my-scope");

        // Create a role-based policy
        RolePolicyRepresentation policy = new RolePolicyRepresentation();
        policy.setName("My Policy Role");
        policy.addRole("role-name");  // Existing role
        policy.addRole("new-role");   // Newly created role

        // Create a permission
        ResourcePermissionRepresentation permission = new ResourcePermissionRepresentation();
        permission.setName("My Permission");
        permission.addResource(resource.getName());
        permission.addPolicy(policy.getName());

        // Obtain authorization resource and create the items
        AuthorizationResource authorization = clientResource.authorization();
        authorization.resources().create(resource);
        authorization.scopes().create(scope);
        authorization.policies().role().create(policy);
        authorization.permissions().resource().create(permission);

        System.out.println("Resource, scope, policy, and permission have been created.");
    }

}
