package com.pages;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.SubjectTerm;
import org.openqa.selenium.WebDriver;

public class EmailPage {
    private final String host;
    private final String username;
    private final String password;
    private final String inboxFolderName;

    public EmailPage(String host, String username, String password, String inboxFolderName) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.inboxFolderName = inboxFolderName;
    }
    public boolean hasResetLinkEmailArrived(String subjectKeyword) {
      
      try {
    	  Properties properties = System.getProperties();
          properties.setProperty("mail.store.protocol", "imaps");

          Session session = Session.getDefaultInstance(properties, null);
          Store store = session.getStore("imaps");
          store.connect(host, username, password);

          Folder inbox = store.getFolder("INBOX");
          inbox.open(Folder.READ_ONLY);

          // Define the search criteria (email subject)
          SubjectTerm searchTerm = new SubjectTerm("Reset Password Link"); // Replace with your subject

          // Perform the search
          Message[] messages = inbox.search(searchTerm);

          inbox.close(false);
          store.close();
      } catch (Exception e) {
          e.printStackTrace();
      }

      return false;
 
}

    public boolean isResetLinkNotReceived() {
        try {
            Properties properties = System.getProperties();
            properties.setProperty("mail.store.protocol", "imaps");

            Session session = Session.getDefaultInstance(properties, null);
            Store store = session.getStore("imaps");
            store.connect(host, username, password);

            Folder inbox = store.getFolder(inboxFolderName);
            inbox.open(Folder.READ_ONLY);

            // Define the search criteria (email subject)
            SubjectTerm searchTerm = new SubjectTerm("Reset Password Link"); // Replace with your subject

            // Perform the search
            Message[] messages = inbox.search(searchTerm);

            // If no emails with the specified subject are found, return true (link not received)
            return messages.length == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Handle exceptions as needed
        }
    }
}

