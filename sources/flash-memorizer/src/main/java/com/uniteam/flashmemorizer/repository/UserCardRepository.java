package com.uniteam.flashmemorizer.repository;

import com.uniteam.flashmemorizer.entity.UserCard;
import com.uniteam.flashmemorizer.entity.key.UserCardId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCardRepository extends JpaRepository<UserCard, UserCardId> {
}
