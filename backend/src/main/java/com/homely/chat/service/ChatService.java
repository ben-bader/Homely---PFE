package com.homely.chat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.homely.chat.entity.Conversation;
import com.homely.chat.entity.Message;
import com.homely.chat.repository.ConversationRepository;
import com.homely.chat.repository.MessageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ConversationRepository conversationRepository;
    private final MessageRepository messageRepository;

    public List<Conversation> getUserConversations(java.util.UUID userId) {
        return conversationRepository.findByUserAIdOrUserBId(userId, userId);
    }
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
    public List<Conversation> getAllConversations() {
        return conversationRepository.findAll();
    }
    public List<Message> getConversationMessages(java.util.UUID conversationId) {
        return messageRepository.findByConversationIdOrderByIdAsc(conversationId);
    }
    public Conversation createConversation(Conversation c) {
        return conversationRepository.save(c);
    }
    public Conversation getConversationByPropertyAndUser(java.util.UUID propertyId, java.util.UUID userId) {
        return conversationRepository.findByPropertyIdAndUserAId(propertyId, userId)
                .orElse(null);
    }
    public Message sendMessage(Message m) {
        return messageRepository.save(m);
    }
}

