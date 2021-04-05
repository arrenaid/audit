package com.rstyle.audit.repository;

import com.rstyle.audit.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity,Integer> {
}

//package ru.msocialproduction.test.zkrtbot.repository;
//
//        import org.springframework.data.jpa.repository.JpaRepository;
//        import ru.msocialproduction.test.zkrtbot.entity.Users;
//
//public interface UsersRepository extends JpaRepository<Users,Integer> {
//    Users findUserByChatId(Integer chatId);
//}