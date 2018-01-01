package com.websocket.chat;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.costuary.util.HTMLFilter;

//import org.apache.juli.logging.Log;
//import org.apache.juli.logging.LogFactory;

@ServerEndpoint(value = "/chat")
public class ChatAnnotation {

//	private Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    private static final String GUEST_PREFIX = "Guest";
    private static final AtomicInteger connectionIds = new AtomicInteger(0);
    private static final Set<ChatAnnotation> connections =
            new CopyOnWriteArraySet<>();

    private final String nickname;
    private Session session;

    public ChatAnnotation() {
        nickname = GUEST_PREFIX + connectionIds.getAndIncrement();
    }

	/**
	 * Callback hook for Connection open events. This method will be invoked
	 * when a client requests for a WebSocket connection.
	 *
	 * @param session
	 *            the session which is opened.
	 */
//	@OnOpen
//	public void onOpen(Session session) {
//		sessions.add(session);
//	}

	/**
	 * Callback hook for Connection close events. This method will be invoked
	 * when a client closes a WebSocket connection.
	 *
	 * @param session
	 *            the session which is opened.
	 */
//	@OnClose
//	public void onClose(Session session) {
//		sessions.remove(session);
//	}

	/**
	 * Callback hook for Message Events. This method will be invoked when a
	 * client send a message.
	 *
	 * @param message
	 *            The text message
	 * @param session
	 *            The session of the client
	 */
//	@OnMessage
//	public void onMessage(String message, Session session) {
//		System.out.println("Message Received: " + message);
//		for (Session remote : sessions) {
//			String sessionId = remote.getId();
//			System.out.println("Sending to " + sessionId);
//			remote.getAsyncRemote().sendText(message + "-" + sessionId);
//		}
//	}

    @OnOpen
    public void start(Session session) {
        this.session = session;
        connections.add(this);
        String message = String.format("* %s %s", nickname, "has joined.");
        broadcast(message);
    }


    @OnClose
    public void end() {
        connections.remove(this);
        String message = String.format("* %s %s",
                nickname, "has disconnected.");
        broadcast(message);
    }


    @OnMessage
    public void incoming(String message) {
        // Never trust the client
        String filteredMessage = String.format("%s: %s",
                nickname, HTMLFilter.filter(message.toString()));
        broadcast(filteredMessage);
    }




    @OnError
    public void onError(Throwable t) throws Throwable {
    	System.out.println("Chat Error: " + t.toString());
    }

    private static void broadcast(String msg) {
        for (ChatAnnotation client : connections) {
            try {
                synchronized (client) {
                    client.session.getBasicRemote().sendText(msg);
                }
            } catch (IOException e) {
            	System.out.println("Chat Error: Failed to send message to client");
                connections.remove(client);
                try {
                    client.session.close();
                } catch (IOException e1) {
                    // Ignore
                }
                String message = String.format("* %s %s",
                        client.nickname, "has been disconnected.");
                broadcast(message);
            }
        }
    }

}
