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

## Logging

This project includes a request logging feature. For every request to the `/spl` and `/erd` endpoints, a log file will be created or appended to.

*   **Log File Location:** The log files are created in the `logs` directory of your Tomcat installation.
*   **Log File Naming:** The log file is named after the deployed WAR file. For example, if you deploy the project as `rest-server.war`, the log file will be `rest-server.log`.
*   **Log File Format:** Each log entry contains the following information:
    *   Start Time
    *   Request Body (in JSON format)
    *   Response Body (in JSON format)
    *   End Time

## Sending Requests with SoapUI

1.  **Open SoapUI.**
2.  Go to **File > New REST Project**.
3.  Enter the URI of your deployed application. For example, if you're running Tomcat on your local machine on port 8080, the URI would be `http://localhost:8080/rest-server`.
4.  SoapUI will create a new project with the specified endpoint.
5.  To send a request to the `/spl` endpoint, create a new `POST` request with the path `/spl`.
6.  Set the **Media Type** to `application/json`.
7.  In the request body, paste the following JSON:
    ```json
    {
      "src_idtr": "string",
      "spl_number": [
        {
          "erd_nr": "123",
          "ctrl_nr": "456"
        },
        {
          "erd_nr": "NEED_ER",
          "ctrl_nr": "789"
        }
      ]
    }
    ```
8.  To send a request to the `/erd` endpoint, create a new `POST` request with the path `/erd`.
9.  Set the **Media Type** to `application/json`.
10. In the request body, paste the following JSON:
    ```json
    {
      "erd_key": {
        "shnr": "string",
        "sornr": "string"
      },
      "cm_name": "string",
      "or_type": "string",
      "ss_ifr": "string",
      "sr_nr": [
        {
          "erd_nr": "ABC",
          "ctrl_nr": "DEF"
        }
      ],
      "details": [
        {
          "inf": "string",
          "code": "string",
          "qty": 1,
          "amnt": "string"
        }
      ]
    }
    ```
