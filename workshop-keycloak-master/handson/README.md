# Do it yourself!
There is never a better way of learning a new technology than doing it handson. Thus the intention of this workshop is to get an idea of how Keycloak works by trying it out. Follow the tasks provided in this Documentation to get an experience with how Keycloak works. 

You are asked to do it yourself whenever the following sign occurs:
> This is a task!

## Setup
Download the latest Keycloak version (at the time of writing this is Keycloak 4.7.0) and start it locally using the standalone version
```
/bin/standalone.sh -b 0.0.0.0
```
Assign an admin account. This is possible using the local interface or by running the `add-user.sh` script.

## Create and manage a realm
The master realm is used for local adminstration tasks. It should never be used for production purposes. 

> Create the realm _Production_

> Login to the realm. Which user is allowed to do this?

> Create an admin user dedicated for the _Production_ realm.

> Create an admin user that has restricted access, e.g. is only allowed to configure user attributes.

## The first application

Keycloak comes with the _Account_ Application. This is an OIDC Client that is used to allow a User to change its attribute in a self-service manner.

> Create a User who is only allowed to access the Account Application - not to login into the Admin Console.

> Prohibit that a new User by default is allowed to Login to the Account application.

> Require the User to change the password at the next login.

## Grouping

> Delete all created Users.

> This was a critical action. How to know who deleted the users and when it was done?

> Create an _Admin_ Group. Create to Users that both get equal admin rights.

> Add one user to the User group and allow to access the Account application. 

> As an administrator Impersonate the User to login into the Account app.

## Extended Usage

> Allow Users to self-register for the app. How to prevent that they have full access?

> Change the way a new registration happens. e.g. do not force a User to validate the Profile Information.

> Force a new User to Verify the eMail Address.

## Login