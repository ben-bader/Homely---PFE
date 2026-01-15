package com.homely.chat.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homely.chat.entity.Conversation;

public interface ConversationRepository extends JpaRepository<Conversation, UUID> {
    List<Conversation> findByUserAIdOrUserBId(UUID userA, UUID userB);

    Optional<Conversation> findByPropertyIdAndUserAId(UUID propertyId, UUID userId);

}
