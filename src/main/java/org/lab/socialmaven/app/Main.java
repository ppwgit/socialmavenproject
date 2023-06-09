package org.lab.socialmaven.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.net.HttpURLConnection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.function.*;
import java.time.Period;


import org.lab.socialmaven.appfunction.UserFunction;
import org.apache.logging.log4j.*;

import org.lab.socialmaven.chat.Chat;
import org.lab.socialmaven.exception.CameraFailedtoConnectException;
import org.lab.socialmaven.exception.LocationNotFoundException;
import org.lab.socialmaven.exception.MessageNotFoundException;
import org.lab.socialmaven.exception.MessageSendingFailedException;
import org.lab.socialmaven.exception.UserNotFoundException;
import org.lab.socialmaven.message.CameraMessage;
import org.lab.socialmaven.message.GifMessage;
import org.lab.socialmaven.message.ImageMessage;
import org.lab.socialmaven.message.Message;
import org.lab.socialmaven.message.TextMessage;
import org.lab.socialmaven.message.VideoCallMessage;
import org.lab.socialmaven.message.VoiceRecordMessage;
import org.lab.socialmaven.messageLinkedlist.MessageLinkedList;
import org.lab.socialmaven.messageLinkedlist.UserLinkedList;
import org.lab.socialmaven.thread.*;
import org.lab.socialmaven.user.User;
import org.lab.socialmaven.user.UserLogin;
import org.lab.socialmaven.utils.Camera;
import org.lab.socialmaven.utils.ChatNotificationType;
import org.lab.socialmaven.utils.PhoneNumberEnum;
import org.lab.socialmaven.utils.RelationshipEnum;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.stream.IntStream;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        logger.debug("Start App");

        // Create a social network with a URL
        SocialNetworkApp socialNetwork = new SocialNetworkApp("https://dechat.com");

        // Create some users
        User user1 = new User(1, "JohnDo", "johndo@dechat.com");
        User user2 = new User(2, "Michael", "michae@dechat.com");
        User user3 = new User(3, "Barbie", "barbie@dechat.com");

        // Add the users to the social network
        socialNetwork.addUser(user1);
        socialNetwork.addUser(user2);
        socialNetwork.addUser(user3);

        // Create a chat room and add some users
        Chat chat1 = new Chat(1, "General Chat");
        chat1.addMember(user1);
        chat1.addMember(user2);

        // Add the chat to the social network
        socialNetwork.createChat(chat1);

        // Send a message from user1 to user2
        Message message1 = new Message(1, "Hello Michael!", user1, user2);
        socialNetwork.sendMessage(message1);

        // Print the URL of the social network
        logger.debug("Social network URL: " + socialNetwork.getUrl());

        // Print information about the users
        logger.debug("Users:");
        for (User user : socialNetwork.getUsers()) {
            logger.debug(user.getId() + " - " + user.getUserName() + " - " + user.getEmail());
        }

        // Print information about the chats
        logger.debug("Chats:");
        for (Chat chat : socialNetwork.getChats()) {
            logger.debug(chat.getId() + " - " + chat.getName() + " - Users: " + chat.getMembers().size());
        }

        // Print information about the messages
        logger.debug("Messages:");
        for (Message message : socialNetwork.getMessages()) {
            Integer messageId = message.getId();
            // check value not null
            logger.debug(message.getId() + " - " + message.getContent() + " - From: " + message.getSender() + " - To: "
                    + message.getReceiver());
        }

        // instantiate objects of implemented classes.

        // get User from User class

        User friendsender1 = new User(1, LocalDate.of(1990, 5, 12), "ponpawee@gmail.com");
        User friendsender2 = new User(2, LocalDate.of(1999, 03, 12), "tae@gmail.com");

        // Print user information

        // logger.debug("Age: " + user1.getAge());
        // logger.debug("Email: " + user1.getEmail());
        logger.debug("Debug Name Logger: " + friendsender1.getUserName());
        logger.info("Info message Age Logger" + friendsender1.getAge());
        logger.info("Info message Email Logger" + friendsender1.getEmail());
        // logger.warn("Warn message");
        // logger.error("Error message");
        // logger.fatal("Fatal message");

        // logger.debug("User 2:");
        logger.info("Name: " + friendsender2.getUserName());
        logger.info("Age: " + friendsender2.getAge());
        logger.info("Email: " + friendsender2.getEmail());

        // User Login
        UserLogin myLogin = new UserLogin("tae@gmail.com", "mypassword");

        // Test login
        myLogin.login();

        // Test logout
        myLogin.logout();

        // Friend
        User friend1 = new User(234, "Tony Ayum", "https://profilepic.com/tony.jpg", true);
        User friend2 = new User(658, "Sugar Hahaa", "https://profilepic.com/sugarhaha.jpg", false);

        // Access and print their properties
        logger.info("ID of friend1: " + friend1.getId());
        logger.info("Name of friend1: " + friend1.getUserName());
        logger.info("Profile picture URL of friend1: " + friend1.getProfilePicUrl());
        logger.info("Is friend1 online? " + friend1.isOnline());

        logger.info("ID of friend2: " + friend2.getId());
        logger.info("Name of friend2: " + friend2.getUserName());
        logger.info("Profile picture URL of friend2: " + friend2.getProfilePicUrl());
        logger.info("Is friend2 online? " + friend2.isOnline());

        // Message
        // Create a User object
        User sender = new User("Tae1");
        // Message content = new Message(sender,"Hello Tae2");

        // Create a Message object
        // error cause of Mesage is abstract class now
        // Message message1 = new Message(sender, "Hello World!");

        // Set the receiver and message type

        // message1.setReceiver(new User("Tae2"));

        // message1.setMessageType(message1.getMessageType());

        // Display the message
        // message1.displayMessage();

        // Create another Message object with a specific ID and timestamp
        // LocalDate sentAt = LocalDate.of(2023, 4, 24, 12, 0);
        // Message message2 = new Message(1, sender, new User("Ponpawee1"), sentAt,
        // false);

        // Display the message
        // message2.displayMessage();
        User sender1 = new User("TaeSender");
        User receiver1 = new User("TaeReceive");
        Message msg = new Message("Content");

        TextMessage textMessage = new TextMessage(sender1, "textMessage");
        textMessage.setText("Hello, Tae!");
        logger.debug(textMessage.getText()); // Output: Hello, Bob!

        TextMessage txtMsg = new TextMessage("text check this one");
        txtMsg.setText("check the text");

        // Get and print the content and text associated with the TextMessageSubclass
        // object
        logger.info("Content: " + txtMsg.getContent());
        logger.info("Text: " + txtMsg.getText());

        // Send the TextMessageSubclass object using the sendMessage() method
        textMessage.sendMessageObj(txtMsg);

        GifMessage gifMsg = new GifMessage(1, "gifmessage", sender1, receiver1, "https://dechat.com/gifFlash.gif");
        gifMsg.sendMessage();
        logger.info("Message sent successfully? " + gifMsg.wasSentSuccessfully());

        // Create a new ImageMessageSubclass object with some content and an image
        ImageMessage imgMsg = new ImageMessage(2, "Imagemessage", sender1, receiver1);
        imgMsg.setImageUrl("https://dechat.com/image.jpg");

        // Get and print the content and image associated with the ImageMessageSubclass
        // object
        logger.debug("Content: " + imgMsg.getContent());
        logger.debug("Image URL: " + imgMsg.getImageUrl());
        imgMsg.sendMessageObj(imgMsg);

        // Create a new VoiceRecordMessageSubclass object with some content and audio
        VoiceRecordMessage videorecordMsg = new VoiceRecordMessage("Hey, check this out!");
        videorecordMsg.setDuration(10);
        videorecordMsg.setAudioFile("/path/to/audio.wav");

        // Send the VoiceRecordMessageSubclass object using the sendMessage() method
        videorecordMsg.sendMessageObj(videorecordMsg);

        /*
         * double latitude = 29.7604; double longitude = 95.3698; LocationMessage
         * locationMessage = new LocationMessage("This is a location message."); try {
         * locationMessage.setLocation(latitude, longitude); String content =
         * locationMessage.getContent(); logger.debug("\"Print Content == " + content);
         * String googleMapsUrl = "https://www.google.com/maps/search/?api=1&query=" +
         * latitude + "," + longitude; logger.debug(googleMapsUrl); } catch (Exception
         * e) { e.printStackTrace(); }
         *
         * try { locationMessage.setLocation(latitude, longitude); String location =
         * locationMessage.getLocation(); logger.debug("Print Location ==" +
         * " location  " + location); String googleMapsUrl =
         * "https://www.google.com/maps/search/?api=1&query=" + latitude + "," +
         * longitude; logger.debug(googleMapsUrl); } catch (Exception e) {
         * e.printStackTrace(); }
         */

        /*--- UserNotFoundException  using try-catch*/
        try {
            throw new UserNotFoundException("User not found");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        /*--- UserNotFoundException with resource*/

        try (Scanner scanner = new Scanner(System.in)) {
            // System.out.print("Enter username: ");
            String username = scanner.nextLine();

            if (!username.equals("Ponpawee")) {
                throw new UserNotFoundException("User not found!");
            } else {
                logger.debug("Welcome, Ponpawee!");
            }
        } catch (UserNotFoundException e) {
            logger.debug("Error: " + e.getMessage());
        } catch (Exception e) {
            logger.debug("Unknown error: " + e.getMessage());
        }

        /*--- MessageSendingFailedException  using try-catch*/

        try {
            throw new MessageSendingFailedException("Failed to send message");
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
        /*--- MessageSendingFailedException with resource*/
        // Handling MessageSendingFailedException using try-catch with resources
        try (Socket socket = new Socket("localhost", 8080);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            logger.info("Hello, Server!");

            String response = in.readLine();

            if (response == null) {
                throw new MessageSendingFailedException("Message sending failed!");
            } else {
                logger.debug("Server response: " + response);
            }
        } catch (MessageSendingFailedException e) {
            logger.debug("Error: " + e.getMessage());
        } catch (IOException e) {
            logger.debug("IO error: " + e.getMessage());
        }

        /*--- MessageNotFoundException  using try-catch*/
        try {
            throw new MessageNotFoundException("Message not found");
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }

        /*--- CameraFailedtoConnectException  using try-catch*/

        try {
            throw new CameraFailedtoConnectException("Camera is disabled or Can't connect to camera");
        } catch (Exception e) {
            logger.debug(e.getMessage());
        }
        /*--- CameraFailedtoConnectException with resource*/
        try (Camera camera = new Camera("192.168.0.100")) {
            camera.connect();
            camera.startStreaming();
        } catch (IOException e) {
            logger.debug("catch block IO for Camera handle");
            e.printStackTrace();
        } catch (CameraFailedtoConnectException e) {

            logger.error("catch block Handle CameraFailedtoConnectException");
            logger.error("Failed to connect to the camera: " + e.getMessage());
        } finally {

        }

        /*--- UserNotFoundException  using try-catch*/

        /*
         * try { Location location = getLocationFromApi(apiUrl); // Do something with
         * the location } catch (IOException e) { // Handle connection errors
         * e.printStackTrace(); } catch (LocationNotFoundException e) { // Handle
         * LocationNotFoundException System.err.println("Location not found: " +
         * e.getMessage()); }
         */

        double latitude = 29.7604;
        double longitude = 95.3698;
        String apiUrl = "https://www.google.com/maps/place/Houston,+TX/@29.8167688,-95.730949,10z/data=!3m1!4b1!4m6!3m5!1s0x8640b8b4488d8501:0xca0d02def365053b!8m2!3d29.7604267!4d-95.3698028!16zL20vMDNsMm4";

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String response = new String();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response += inputLine;
                }
                if (response != null) {
                    logger.error("You get the correct location");

                } else {
                    throw new LocationNotFoundException("Location not found");
                }
            }
        } catch (IOException e) {
            // Handle connection errors
            e.printStackTrace();
        } catch (LocationNotFoundException e) {
            // Handle LocationNotFoundException
            logger.error("Location not found: " + e.getMessage());
        }

        /***
         *
         * Start Collections
         *
         */

        /***
         *
         * Start Set of Message parent class (TextMessage)
         *
         */
        logger.info(apiUrl, receiver1, msg, textMessage, txtMsg, gifMsg, imgMsg, videorecordMsg, apiUrl);
        logger.debug("****Start Set of Message parent class*********");
        Message messageSet = new Message(new User("TaeSender"), new User("PonpaweeReceive"), "you get the messages!");
        messageSet.addMessageSet(
                new CameraMessage(new User("TaeSender"), new User("PonpaweeReceive"), "https://dechat.com/photo.jpg"));
        messageSet
                .addMessageSet(new VideoCallMessage(new User("TaeSender"), new User("PonpaweeReceive"), "Video Call"));
        logger.debug(messageSet.removeMessageSet(
                new CameraMessage(new User("TaeSender"), new User("PonpaweeReceive"), "https://dechat.com/photo.jpg"))); // prints
        // "true"
        logger.debug(messageSet.getMessageSet()); // prints "[Video call from tae to ponpawee]"

        Message messageList = new Message(new User("TaeSender"), new User("PonpaweeReceive"), "you get the messages!");
        messageSet.addMessageList(
                new CameraMessage(new User("TaeSender"), new User("PonpaweeReceive"), "https://dechat.com/photo.jpg"));
        messageSet
                .addMessageList(new VideoCallMessage(new User("TaeSender"), new User("PonpaweeReceive"), "Video Call"));
        logger.debug(messageList.removeMessageList(
                new CameraMessage(new User("TaeSender"), new User("PonpaweeReceive"), "https://dechat.com/photo.jpg"))); // prints
        // "true"
        logger.debug(messageList.getMessageList()); // prints "[Video call from tae to ponpawee]

        Message messageLinkedList = new Message(new User("TaeSender"), new User("PonpaweeReceive"),
                "you get the messages!");
        messageSet.addMessageLinkedList(
                new CameraMessage(new User("TaeSender"), new User("PonpaweeReceive"), "https://dechat.com/photo.jpg"));
        messageSet.addMessageLinkedList(
                new VideoCallMessage(new User("TaeSender"), new User("PonpaweeReceive"), "Video Call"));
        logger.debug(messageLinkedList.removeMessageLinkedList(
                new CameraMessage(new User("TaeSender"), new User("PonpaweeReceive"), "https://dechat.com/photo.jpg"))); // prints
        // "true"
        logger.debug(messageLinkedList.getMessageLinkedList()); // prints "[Video call from tae to ponpawee]

        Message messageMap = new Message(new User("TaeSender"), new User("PonpaweeReceive"), "you get the messages!");
        messageMap.addMessageMap("1",
                new CameraMessage(new User("TaeSender"), new User("PonpaweeReceive"), "https://dechat.com/photo.jpg"));
        messageMap.addMessageMap("2",
                new VideoCallMessage(new User("TaeSender"), new User("PonpaweeReceive"), "Video Call"));
        logger.debug(messageMap.removeMessageMap("1")); // true
        logger.debug(messageMap.getMessageMap());

        Message messageQue = new Message(new User("TaeSender"), new User("PonpaweeReceive"), "you get the messages!");
        messageQue.addMessageQueue(
                new CameraMessage(new User("TaeSender"), new User("PonpaweeReceive"), "https://dechat.com/photo.jpg"));
        messageQue.addMessageQueue(
                new VideoCallMessage(new User("TaeSender"), new User("PonpaweeReceive"), "Video Call"));
        logger.debug(messageQue.removeMessageQueue());
        logger.debug(messageQue.getMessageQueue());

        Message messageDeque = new Message(new User("TaeSender"), new User("PonpaweeReceive"), "you get the messages!");
        messageDeque.addMessageDeque(
                new CameraMessage(new User("TaeSender"), new User("PonpaweeReceive"), "https://dechat.com/photo.jpg"));
        messageDeque.addMessageDeque(
                new VideoCallMessage(new User("TaeSender"), new User("PonpaweeReceive"), "Video Call"));
        logger.debug(messageDeque.removeFirstMessageDeque());
        logger.debug(messageDeque.removeLastMessageDeque());
        logger.debug(messageDeque.getMessageDeque());

        TextMessage textMessageSet = new TextMessage(new User("TaeSender"), "Hello World!");
        TextMessage subMessage1 = new TextMessage(new User("TaeSender"), "This is a sub-message1.");
        TextMessage subMessage2 = new TextMessage(new User("TaeSender"), "This is another sub-message2.");

        textMessageSet.addMessageToSet(subMessage1);
        textMessageSet.addMessageToSet(subMessage2);

        logger.info("Content of TextMessage: " + textMessage.getContent());
        logger.info("Sub-messages in TextMessage:");

        for (Message subMessage : textMessage.getMessageSet()) {
            logger.debug(subMessage.getContent());
        }

        TextMessage txtMessageList = new TextMessage();

        // Create message objects
        Message messageList1 = new Message(new User("TaeSender"), "Hello World!");
        Message messageList2 = new Message(new User("TaeSender"), "Hello World!2");
        Message messageList3 = new Message(new User("TaeSender"), "Hello World!3");

        txtMessageList.addMessageList(messageList1);
        txtMessageList.addMessageList(messageList2);
        txtMessageList.addMessageList(messageList3);

        // Retrieve messages from the list
        // Add messages to the list

        List<Message> messagesList = txtMessageList.getMessageList();

        for (Message message : messagesList) {
            logger.debug(message);
        }

        TextMessage txtMessageLinkedList = new TextMessage(new User("TaeSender"), "Hello, how are you?");
        TextMessage reply1 = new TextMessage(new User("PonpaweeReceive"), "I'm doing well, thanks for asking.");
        TextMessage reply2 = new TextMessage(new User("PonpaweeReceive2"), "I'm not doing so great today.");

        textMessage.addMessageLinkedList(reply1);
        textMessage.addMessageLinkedList(reply2);

        LinkedList<Message> txtMessagesLinkedList = textMessage.getMessageLinkedList();
        for (Message message : txtMessagesLinkedList) {
            logger.debug(message.getSender() + ": " + message.getContent());
        }

        TextMessage txtMessageMap = new TextMessage();
        Message messageMap1 = new Message();
        Message messageMap2 = new Message();

        textMessage.addMessage("message1", messageMap1);
        textMessage.addMessage("message2", messageMap2);

        Message retrievedMessage1 = textMessage.getMessage("message1");
        logger.debug("Retrieved message1: " + retrievedMessage1);

        Message retrievedMessage2 = textMessage.getMessage("message2");
        logger.debug("Retrieved message2: " + retrievedMessage2);

        TextMessage txtMessageQue = new TextMessage();
        Message txtMessageQue1 = new Message();
        Message txtMessageQue2 = new Message();
        Message txtMessageQue3 = new Message();

        txtMessageQue.addMessageToQueue(txtMessageQue1);
        txtMessageQue.addMessageToQueue(txtMessageQue2);
        txtMessageQue.addMessageToQueue(txtMessageQue3);
        logger.debug("Message queue size: " + txtMessageQue.getMessageQueue().size());

        txtMessageQue.removeMessageFromQueue();

        logger.debug("Message queue size after removing one message: " + txtMessageQue.getMessageQueue().size());

        TextMessage txtMessageDeQue = new TextMessage();
        Message txtmessageDeque1 = new Message();
        Message txtmessageDeque2 = new Message();

        // add messages to the deque
        txtMessageDeQue.getMessageDeque().add(txtmessageDeque1);
        txtMessageDeQue.getMessageDeque().add(txtmessageDeque2);

        // remove and print the first message in the deque
        logger.debug(txtMessageDeQue.getMessageDeque().poll());

        /***
         *
         * Implement LinkedList add last and add in to middle 1.add the Message objects
         * to the end of the list 2.add a Message object in the middle of the list
         *
         */
        // create obj
//    TextMessage txtMessageHW = new TextMessage("Hello World!");
//    
//    // Adding messages to the end of the list
//    txtMessageHW.addMessageList(new Message("Message 1"));
//    txtMessageHW.addMessageList(new Message("Message 2"));
//    txtMessageHW.addMessageList(new Message("Message 3"));
//
//
//    // Adding a message to the middle of the list
//    txtMessageHW.addMessageLinkedInMiddle(1, new Message("Inserted Message"));
//
//    // Displaying the list of messages
//    LinkedList<Message> messages = txtMessageHW.getMessageLinkedList();
//    for (Message message : messages) {
//        System.out.println(message.getContent());
//    }
//

        // create a LinkedList<Message> object
        LinkedList<Message> hwmessageList = new LinkedList<>();

        // create some Message objects
        TextMessage textMessage1 = new TextMessage("Hello");
        TextMessage textMessage2 = new TextMessage("World");
        TextMessage textMessage3 = new TextMessage("!");

        // add the Message objects to the end of the list
        hwmessageList.addLast(textMessage1);
        hwmessageList.addLast(textMessage2);
        hwmessageList.addLast(textMessage3);

        // print the contents of the list
        logger.debug("LinkedList contents after adding to the end:");
        for (Message message : hwmessageList) {
            logger.debug(message.getMessageList());
        }

        // add a Message object in the middle of the list
        TextMessage textMessage4 = new TextMessage("Java");
        hwmessageList.add(1, textMessage4);

        // print the contents of the list
        logger.debug("LinkedList contents after adding to the middle:");
        for (Message message : hwmessageList) {
            logger.debug(message.getMessageList());
        }

        // Linked

        MessageLinkedList<Message> messages = new MessageLinkedList<Message>();
        messages.add(new TextMessage("Hi text msg1"));
        messages.add(new ImageMessage("image.jpg"));
        messages.add(new GifMessage("gif.gif"));
        messages.add(1, new TextMessage("How are you? text msg2"));
        logger.info(messages.get(2));
        for (int i = 0; i < messages.size(); i++) {
            Message message = messages.get(i);
            if (message instanceof TextMessage) {
                TextMessage txtMsgOwn = (TextMessage) message;
                logger.debug(txtMsgOwn.getText());
            } else if (message instanceof ImageMessage) {
                ImageMessage imageMessage = (ImageMessage) message;
                logger.debug(imageMessage.getImageUrl());
            } else if (message instanceof GifMessage) {
                GifMessage gifMessage = (GifMessage) message;
                logger.debug(gifMessage.getGifUrl());
            }
        }

        // TextMessage LinkedList inherite from Message
        MessageLinkedList<TextMessage> txtGenericList = new MessageLinkedList<TextMessage>();
        txtGenericList.add(new TextMessage("Hi there!"));
        txtGenericList.add(new TextMessage("How are you?"));
        txtGenericList.add(new TextMessage("I'm good, thanks!"));
        // add messages to the end of the list
        txtGenericList.addLast(new TextMessage("Yes The last one"));

        for (int i = 0; i < txtGenericList.size(); i++) {
            TextMessage txtGeneric = txtGenericList.get(i);
            logger.debug(textMessage.getContent());
        }

        // add a message in the middle of the list
        TextMessage txtmsgGeneric4 = new TextMessage("Add in the middle");
        txtGenericList.addMiddle(txtmsgGeneric4, 1);

        // User Linked List

        UserLinkedList<User> userList = new UserLinkedList<>();

        // Adding users to the end of the list
        userList.addLast(new User("John1", "john1@gmail.com"));
        userList.addLast(new User("John2", "john2@gmail.com"));
        userList.addLast(new User("John3", "john3@gmail.com"));

        // Adding a user to the middle of the list
        userList.addMiddle(new User("john4", "john4@gmail.com"), 1);

        //enum ChatNotification
        ChatNotificationType messageNotification = ChatNotificationType.MESSAGE;
        logger.info("Notification Type: " + messageNotification.getDisplayName());
        logger.info("Requires Action: " + messageNotification.requiresAction());
        messageNotification.displayNotification();

        ChatNotificationType typingNotification = ChatNotificationType.TYPING;
        logger.info("Notification Type: " + typingNotification.getDisplayName());
        logger.info("Requires Action: " + typingNotification.requiresAction());
        typingNotification.displayNotification();

        RelationshipEnum myStatus = RelationshipEnum.IN_A_RELATIONSHIP;
        logger.info("Relationship Status: " + myStatus.getDisplayName());

        RelationshipEnum anotherStatus = RelationshipEnum.MARRIED;
        logger.info("Relationship Status: " + anotherStatus.getDisplayName());
        anotherStatus.celebrateAnniversary();

        PhoneNumberEnum usaNumber = PhoneNumberEnum.USA;
        logger.info("Country: " + usaNumber.getCountryName());
        logger.info("Country Code: " + usaNumber.getCountryCode());
        logger.info("City Code: " + usaNumber.getCityCode());


// Create some users

        User userlamb1 = new User("Java", "JavaFirstName", 27, "java@gmail.com", "Male");
        User userlamb2 = new User("Nangnoi", "NangNoiFirstName", 17, "jnanna@gmail.com", "Female");

        Predicate<User> isAdult = userInfo -> userlamb1.getAgeFunc() >= 18;
        Function<User, String> getEmail = User::getEmail;
        Consumer<User> printName = userInfo -> logger.info(userlamb2.getFirstName());
        Supplier<User> createUserInfo = () -> new User("Jan", "JanFirstName", 15, "jan@gmail.com", "Female");
        BinaryOperator<Integer> sumAges = (age1, age2) -> userlamb1.getAgeFunc() + userlamb1.getAgeFunc();


        User nangNoiInfo = createUserInfo.get();
        logger.info("Email: " + getEmail.apply(nangNoiInfo));
        logger.info("Is Adult: " + isAdult.test(nangNoiInfo));
        printName.accept(nangNoiInfo);
        logger.info("Sum of ages: " + sumAges.apply(27, 17));


        Function<LocalDate, Integer> calculateAge = birthDate -> {
            LocalDate currentDate = LocalDate.now();
            Period period = Period.between(birthDate, currentDate);
            return period.getYears();
        };

        LocalDate dateOfBirth = LocalDate.of(1997, 12, 11);
        User user = new User("Papa John", dateOfBirth);
        int age = calculateAge.apply(dateOfBirth);
        logger.info("Age: " + age);

        // Custom lambda functions with generics
        UserFunction<User, Boolean> isAdultCustom = userProfile -> userProfile.getAge() >= 18;
        UserFunction<User, String> getFirstName = User::getFirstName;
        UserFunction<User, Void> printUsername = userProfile -> {
            logger.info(userProfile.getFirstName());
            return null;
        };

        // Testing the custom lambda functions
        User nanaprofile = new User("Nanana", "NananFirstName", 17, "anna@gmail.com", "Female");
        logger.info("Is Adult Custom: " + isAdultCustom.Action(nanaprofile));
        logger.info("Username: " + getFirstName.Action(nanaprofile));
        printUsername.Action(nanaprofile);

		//Stream
		List<Message> messagesStream = new ArrayList<>();
		messagesStream.add(new TextMessage("Hello Text msg!"));
		messagesStream.add(new GifMessage("Gift Msg!", "https://deechat.com/gif"));
		messagesStream.add(new CameraMessage("Photo Msg", "https://deechat.com/photo"));

		//print text
		messagesStream.stream()
				.filter(TextMessage.class::isInstance)
				.map(TextMessage.class::cast)
				.forEach(textMessageStream -> logger.info(textMessageStream.getContent()));

		// mapping
		List<String> gifturlsStream = messagesStream.stream()
				.filter(GifMessage.class::isInstance)
				.map(GifMessage.class::cast)
				.map(GifMessage::getGifFilePath)
				.toList();
        logger.info("GIF URLs: " + gifturlsStream);

		// counting
		long cameraMessageCount = messagesStream.stream()
				.filter(CameraMessage.class::isInstance)
				.count();
        logger.info("CameraMessage count: " + cameraMessageCount);


        // Reflection User Class
        Class<User> userClass = User.class;

        Field[] fields = userClass.getDeclaredFields();
        for (Field field : fields) {
            logger.info("Field Name: " + field.getName());
            logger.info("Field Type: " + field.getType().getSimpleName());
            logger.info("Field Modifiers: " + field.getModifiers());
        }

        Constructor<?>[] constructors = userClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            logger.info("Constructor Name: " + constructor.getName());
            logger.info("Constructor Parameter Count: " + constructor.getParameterCount());
            logger.info("Constructor Modifiers: " + constructor.getModifiers());
        }

        Method[] methods = userClass.getDeclaredMethods();
        for (Method method : methods) {
            logger.info("Method Name: " + method.getName());
            logger.info("Method Return Type: " + method.getReturnType().getSimpleName());
            logger.info("Method Parameter Count: " + method.getParameterCount());
            logger.info("Method Modifiers: " + method.getModifiers());
        }
        Constructor<User> constructor = userClass.getDeclaredConstructor(String.class, String.class, Integer.class, String.class, String.class);
        constructor.setAccessible(true);
        User userProfile = constructor.newInstance("consructureUserNameInstant", "consructureNameFirstName", 12, "consructureName@gmail.com", "Male");

        Method method = userClass.getDeclaredMethod("displayUserProfile");
        method.setAccessible(true);
        method.invoke(userProfile);

        //Thread
        //1. Create 2 Threads using Runnable and Thread.
        User userThread = new User("ThreadUserName", "ThreadFirstName", 50, "threadm@gmail.com", "N/A");
        Thread runnableThread = new Thread(new UserProfileRunnable(userThread));
        runnableThread.start();

        Thread threadThread = new UserProfileThread(userThread);
        threadThread.start();



        //2.Create Connection Pool. Use collection from java.util.concurrent package. Connection class may be mocked. The pool should be threadsafe and lazy initialized.

        ConnectionPool connectionPool = ConnectionPool.getInstance();

        Connection connection1 = connectionPool.getConnection();
        Connection connection2 = connectionPool.getConnection();
        connectionPool.releaseConnection(connection1);
        connectionPool.releaseConnection(connection2);



        //3. Initialize Connection Pool object of size 5. Load Connection Pool using single threads and Java Thread Pool (7 threads in total). 5 threads should be able to get the connection. 2 Threads should wait for the next available connection. The program should wait as well.

        ConnectionPoolFixSize connectionPoolFixSize = ConnectionPoolFixSize.getInstance();

        ExecutorService executorService = Executors.newFixedThreadPool(7);

        for (int i = 0; i < 5; i++) {
            executorService.execute(new ConnectionTask(connectionPoolFixSize));
        }

        Thread.sleep(2000);

        for (int i = 0; i < 2; i++) {
            executorService.execute(new ConnectionTask(connectionPoolFixSize));
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);


        //4.Implement previous point but with interfaces Future and CompletableStage.

        List<CompletableFuture<Connection>> completableFutureList = new ArrayList<>();

        IntStream.range(0, 5)
                .forEach(i -> completableFutureList.add(CompletableFuture.supplyAsync(connectionPool::getConnection, executorService)));

        Thread.sleep(2000);
        IntStream.range(0, 2)
                .forEach(i -> completableFutureList.add(CompletableFuture.supplyAsync(connectionPool::getConnection, executorService)));

        completableFutureList.forEach(completableFuture -> {
            completableFuture.thenAccept(connection -> {
                if (connection != null) {
                    connection.connect();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    connection.disconnect();
                    connectionPool.releaseConnection(connection);
                } else {
                    logger.info("full connection,Wait");
                }
            });
        });

        CompletableFuture<Void> allTasksCompleted = CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0]));
        allTasksCompleted.join();

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

    }

    }



