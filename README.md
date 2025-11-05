# Java REST Server for Tomcat 10

This project is a simple Java REST server designed to run on a Tomcat 10 server. It includes two endpoints, `/spl` and `/erd`, that process JSON requests and return JSON responses.

## Prerequisites

*   **Java Development Kit (JDK) 11 or higher:** Make sure you have a compatible JDK installed and configured on your system.
*   **Apache Maven:** The project is built with Maven, so you'll need it installed and available in your system's PATH.
*   **Eclipse IDE:** The following instructions are for the Eclipse IDE for Java EE Developers.
*   **m2e (Maven for Eclipse) Plugin:** This plugin is included by default in most modern Eclipse distributions. If you don't have it, you can install it from the Eclipse Marketplace.

## Importing and Building in Eclipse

1.  **Open Eclipse.**
2.  Go to **File > Import...**.
3.  In the import wizard, expand the **Maven** folder and select **Existing Maven Projects**. Click **Next**.
4.  Click the **Browse...** button and navigate to the root directory of this project.
5.  Eclipse should automatically detect the `pom.xml` file. Make sure the project is selected in the **Projects** list.
6.  Click **Finish**. Eclipse will import the project and download the necessary dependencies.
7.  To build the project, right-click on the project in the **Package Explorer** and go to **Run As > Maven build...**.
8.  In the **Goals** field, type `clean install` and click **Run**.
9.  This will compile the project and create a `rest-server.war` file in the `target` directory.

You can then deploy the `rest-server.war` file to your Tomcat 10 server.
