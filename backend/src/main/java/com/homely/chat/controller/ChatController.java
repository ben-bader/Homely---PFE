package com.homely.chat.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homely.chat.entity.Conversation;
import com.homely.chat.entity.Message;
import com.homely.chat.service.ChatService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/conversation")
    public Conversation create(@RequestBody Conversation c) {
        return chatService.createConversation(c);
    }

    @GetMapping("/conversations")
    public List<Conversation> getUserConversations(@RequestParam UUID userId) {
        return chatService.getUserConversations(userId);
    }
    
    @GetMapping("/messages")
    public List<Message> getConversationMessages(@RequestParam UUID conversationId) {
        return chatService.getConversationMessages(conversationId);
    }
    
    @PostMapping("/message")
    public Message send(@RequestBody Message m) {
        return chatService.sendMessage(m);
    }

    @GetMapping("/messages/all")
    public List<Message> getAllMessages() {
        return chatService.getAllMessages();
    }
    @GetMapping("/conversations/all")
    public List<Conversation> getAllConversations() {
        return chatService.getAllConversations();
    
    }
    
}

